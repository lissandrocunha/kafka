package br.com.lissandrocunha.kafka.strproducer.services

import org.apache.logging.log4j.LogManager
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Service

@Service
class StringProducerService(val kafkaTemplate: KafkaTemplate<String, String>,) {

    private val logger = LogManager.getLogger()

    fun sendMessage(message: String) {
        kafkaTemplate.send("str-topic", message)
            .thenAccept {
                    success: SendResult<String, String>? ->
                        if(success != null){
                            logger.info("Send message with success {}", message)
                            logger.info("Partition {}",
                                         success.recordMetadata.partition(),
                                         success.recordMetadata.offset())
                        }
            }
            .exceptionally { e: Throwable ->
                logger.error("Error send message {}",e.message)
                null
            }
    }
}