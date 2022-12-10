package br.com.lissandrocunha.kafka.strconsumer.exceptions

import org.apache.logging.log4j.LogManager
import org.springframework.kafka.listener.KafkaListenerErrorHandler
import org.springframework.kafka.listener.ListenerExecutionFailedException
import org.springframework.messaging.Message
import org.springframework.stereotype.Component

@Component
class ErrorCustomHandler: KafkaListenerErrorHandler {

    private val logger = LogManager.getLogger()

    override fun handleError(message: Message<*>, exception: ListenerExecutionFailedException): Any {

        logger.info("EXCEPTION_HANDLER ::: catch the error")
        logger.info("Payload ::: {}", message.payload)
        logger.info("Headers ::: {}", message.headers)
        logger.info("Offset ::: {}", message.headers["kafka_offset"])
        logger.info("Message exception ::: {}", exception.message)

        return exception
    }
}