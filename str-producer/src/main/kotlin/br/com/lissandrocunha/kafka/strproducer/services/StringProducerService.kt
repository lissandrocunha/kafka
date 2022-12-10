package br.com.lissandrocunha.kafka.strproducer.services

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class StringProducerService(val kafkaTemplate: KafkaTemplate<String, String>) {

    fun sendMessage(message: String) {
        kafkaTemplate.send("str-topic", message)
    }
}