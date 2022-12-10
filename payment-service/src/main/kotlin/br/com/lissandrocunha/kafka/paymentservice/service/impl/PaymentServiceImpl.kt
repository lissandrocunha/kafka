package br.com.lissandrocunha.kafka.paymentservice.service.impl

import br.com.lissandrocunha.kafka.paymentservice.model.Payment
import br.com.lissandrocunha.kafka.paymentservice.service.PaymentService
import org.apache.logging.log4j.LogManager
import org.springframework.stereotype.Service

@Service
class PaymentServiceImpl : PaymentService {

    private val logger= LogManager.getLogger()

    override fun sendPayment(payment: Payment) {
        logger.info("PAYMENT_SERVICE_IMPL ::: Recevied payment {}", payment);
    }
}