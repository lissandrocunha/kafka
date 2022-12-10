package br.com.lissandrocunha.kafka.paymentservice.resource.impl

import br.com.lissandrocunha.kafka.paymentservice.model.Payment
import br.com.lissandrocunha.kafka.paymentservice.resource.PaymentResource
import br.com.lissandrocunha.kafka.paymentservice.service.PaymentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/payments"])
class PaymentResourceImpl(private val paymentService: PaymentService) : PaymentResource {

    override fun payment(payment: Payment): ResponseEntity<Payment> {
        paymentService.sendPayment(payment)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }
}