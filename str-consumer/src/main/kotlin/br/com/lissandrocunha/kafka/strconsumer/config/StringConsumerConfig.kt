package br.com.lissandrocunha.kafka.strconsumer.config

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.logging.log4j.LogManager
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.listener.RecordInterceptor

@Configuration
class StringConsumerConfig(val properties: KafkaProperties) {

    private val logger = LogManager.getLogger()

    @Bean
    fun consumerFactory(): ConsumerFactory<String,String> {
        val configs= HashMap<String, Any>()
        configs[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = properties.bootstrapServers
        configs[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        configs[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        return DefaultKafkaConsumerFactory(configs)
    }

    @Bean
    fun strContainerFactory(
        consumerFactory: ConsumerFactory<String,String>
    ): ConcurrentKafkaListenerContainerFactory<String,String> {
        val factory = ConcurrentKafkaListenerContainerFactory<String,String>()
        factory.consumerFactory = consumerFactory
        return factory
    }

    @Bean
    fun validMessageContainerFactory(
        consumerFactory: ConsumerFactory<String,String>
    ): ConcurrentKafkaListenerContainerFactory<String,String>{
        val factory = ConcurrentKafkaListenerContainerFactory<String,String>()
        factory.consumerFactory = consumerFactory
        factory.setRecordInterceptor(validMessage())
        return factory
    }

    private fun validMessage(): RecordInterceptor<String, String> {
        return RecordInterceptor { record, _ ->
            if (record.value().contains("@")){
                logger.info("Valid message")
                return@RecordInterceptor record
            }
            record
        }
    }
}