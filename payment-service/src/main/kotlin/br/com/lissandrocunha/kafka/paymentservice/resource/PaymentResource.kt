package br.com.lissandrocunha.kafka.paymentservice.resource

import br.com.lissandrocunha.kafka.paymentservice.model.Payment
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

interface PaymentResource {
    @PostMapping
    fun payment(@RequestBody payment: Payment): ResponseEntity<Payment>
}