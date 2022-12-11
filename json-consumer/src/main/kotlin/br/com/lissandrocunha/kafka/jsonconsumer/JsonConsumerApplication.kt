package br.com.lissandrocunha.kafka.jsonconsumer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka

@EnableKafka
@SpringBootApplication
class JsonConsumerApplication

fun main(args: Array<String>) {
	runApplication<JsonConsumerApplication>(*args)
}
