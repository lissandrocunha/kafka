package br.com.lissandrocunha.kafka.paymentservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka

@EnableKafka
@SpringBootApplication
class PaymentServiceApplication

fun main(args: Array<String>) {
	runApplication<PaymentServiceApplication>(*args)
}
