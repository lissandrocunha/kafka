package br.com.lissandrocunha.kafka.strconsumer.listener

import br.com.lissandrocunha.kafka.strconsumer.custom.StrConsumerCustomListener
import org.apache.logging.log4j.LogManager
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import java.lang.IllegalArgumentException

@Component
class StrConsumerListener {

    private val logger = LogManager.getLogger()

    @StrConsumerCustomListener(groupId = "group-1")
    fun listener(message: String){
        logger.info("LISTENER ::: Receive message {}", message)
    }

    @StrConsumerCustomListener(groupId = "group-1")
    fun log(message: String){
        logger.info("LOG ::: Receive message {}", message)
        throw IllegalArgumentException("EXCEPTION...")
    }

    @KafkaListener(
        topics = ["str-topic"],
        groupId = "group-2",
        containerFactory = "validMessageContainerFactory")
    fun history(message: String){
        logger.info("HISTORY ::: Receive message {}", message)
    }
}