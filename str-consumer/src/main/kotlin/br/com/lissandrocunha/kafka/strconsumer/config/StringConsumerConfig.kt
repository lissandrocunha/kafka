package br.com.lissandrocunha.kafka.strconsumer.config

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory

@Configuration
class StringConsumerConfig(val properties: KafkaProperties) {

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

}