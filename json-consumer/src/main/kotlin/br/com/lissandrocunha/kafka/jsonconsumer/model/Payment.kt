package br.com.lissandrocunha.kafka.paymentservice.model

import java.io.Serializable

class Payment : Serializable {
    var id: Long = 0
    var idUser: Long = 0
    var idProduct: Long = 0
    var cardNumber: String = ""
}