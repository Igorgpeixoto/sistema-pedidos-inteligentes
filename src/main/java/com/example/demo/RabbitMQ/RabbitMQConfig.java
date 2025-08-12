package com.example.demo.RabbitMQ;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String FILA_PEDIDO_CRIADO = "order.created";

    @Bean
    public Queue queue() {
        return new Queue(FILA_PEDIDO_CRIADO, true); // durable = true (fila permanece ativa mesmo após reinício)
    }
}
