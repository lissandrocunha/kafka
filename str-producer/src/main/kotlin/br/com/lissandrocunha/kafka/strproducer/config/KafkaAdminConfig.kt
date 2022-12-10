package br.com.lissandrocunha.kafka.strproducer.config

import lombok.RequiredArgsConstructor
import org.apache.kafka.clients.admin.Admin
import org.apache.kafka.clients.admin.AdminClientConfig
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder
import org.springframework.kafka.core.KafkaAdmin
import org.springframework.kafka.core.KafkaAdmin.NewTopics

@RequiredArgsConstructor
@Configuration
class KafkaAdminConfig(val properties: KafkaProperties) {

    @Bean
    fun kafkaAdmin(): KafkaAdmin {
        val configs = HashMap<String, Any>()
        configs[AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG] = properties.bootstrapServers
        return KafkaAdmin(configs)
    }

    @Bean
    fun topics(): NewTopics {
        return NewTopics(
            TopicBuilder.name("str-topic").partitions(2).replicas(1).build()
        )
    }
}