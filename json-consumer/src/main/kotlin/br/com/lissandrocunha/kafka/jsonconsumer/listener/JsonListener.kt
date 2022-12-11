package br.com.lissandrocunha.kafka.jsonconsumer.listener

import br.com.lissandrocunha.kafka.paymentservice.model.Payment
import org.apache.logging.log4j.LogManager
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component


@Component
class JsonListener {

    private val logger = LogManager.getLogger()

    @KafkaListener(topics = ["payment-topic"], groupId = "create-group", containerFactory = "jsonContainerFactory")
    fun antiFraud(@Payload payment:Payment){
        logger.info("Received payment {}", payment.toString())
        Thread.sleep(2000)
        logger.info("Anti-fraud validation...")

        Thread.sleep(3000)
        logger.info("Purchase approved...")
        Thread.sleep(2000)
    }

    @KafkaListener(topics = ["payment-topic"], groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    fun pdfGenerator(@Payload payment:Payment){
        logger.info("Generating pdf of product with id {}...", payment.idProduct)
        Thread.sleep(2000)

    }

    @KafkaListener(topics = ["payment-topic"], groupId = "email-group", containerFactory = "jsonContainerFactory")
    fun sendEmail(@Payload payment:Payment){
        logger.info("Sending confirmation email to userId {}...", payment.idUser)
    }
}