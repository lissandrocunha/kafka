package br.com.lissandrocunha.kafka.strconsumer.listener

import org.apache.logging.log4j.LogManager
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class StrConsumerListener {

    private val logger = LogManager.getLogger()

    @KafkaListener(groupId = "group-1", topics = ["str-topic"], containerFactory = "strContainerFactory")
    fun listener(message: String){
        logger.info("Receive message {}", message)
    }

}