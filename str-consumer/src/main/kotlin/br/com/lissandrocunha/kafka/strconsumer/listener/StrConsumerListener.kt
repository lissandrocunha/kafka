package br.com.lissandrocunha.kafka.strconsumer.listener

import br.com.lissandrocunha.kafka.strconsumer.custom.StrConsumerCustomListener
import org.apache.logging.log4j.LogManager
import org.springframework.stereotype.Component

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
    }

    @StrConsumerCustomListener(groupId = "group-2")
    fun history(message: String){
        logger.info("HISTORY ::: Receive message {}", message)
    }
}