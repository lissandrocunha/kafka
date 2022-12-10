package br.com.lissandrocunha.kafka.paymentservice.service.impl

import br.com.lissandrocunha.kafka.paymentservice.model.Payment
import br.com.lissandrocunha.kafka.paymentservice.service.PaymentService
import org.apache.logging.log4j.LogManager
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import java.io.Serializable

@Service
class PaymentServiceImpl(private val kafkaTemplate: KafkaTemplate<String,Serializable>) : PaymentService {

    private val logger= LogManager.getLogger()

    override fun sendPayment(payment: Payment) {
        logger.info("Received payment {}", payment)
        Thread.sleep(1000);

        logger.info("Sending payment...")
        kafkaTemplate.send("payment-topic",payment)
    }
}