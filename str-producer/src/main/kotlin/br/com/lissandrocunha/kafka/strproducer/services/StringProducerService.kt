package br.com.lissandrocunha.kafka.strproducer.services

import lombok.RequiredArgsConstructor
import lombok.extern.log4j.Log4j2
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import kotlin.math.log

@RequiredArgsConstructor
@Service
class StringProducerService(val kafkaTemplate: KafkaTemplate<String, String>) {

    fun sendMessage(message: String) {
        kafkaTemplate.send("str-topic", message)
    }
}