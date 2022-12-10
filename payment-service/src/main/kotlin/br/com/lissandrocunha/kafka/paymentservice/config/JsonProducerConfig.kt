package br.com.lissandrocunha.kafka.paymentservice.config

import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory
import org.springframework.kafka.support.serializer.JsonSerializer
import java.io.Serializable

@Configuration
class JsonProducerConfig(private val properties: KafkaProperties) {

    @Bean
    fun jsonProducerFactory(): ProducerFactory<String,Serializable>{
        val configs = HashMap<String,Any>()
        configs[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = properties.bootstrapServers
        configs[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class
        configs[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = JsonSerializer:: class
        return DefaultKafkaProducerFactory(configs, StringSerializer(), JsonSerializer())
    }

    @Bean
    fun jsonKafkaTemplate(
        jsonProducerFactory: ProducerFactory<String,Serializable>
    ): KafkaTemplate<String, Serializable>{
        return KafkaTemplate(jsonProducerFactory())
    }

}