package br.com.lissandrocunha.kafka.paymentservice.service

import br.com.lissandrocunha.kafka.paymentservice.model.Payment

interface PaymentService {
    fun sendPayment(payment: Payment)
}