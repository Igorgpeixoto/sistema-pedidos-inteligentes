package com.example.demo.Pedidos.mensageria;

import com.example.demo.Pedidos.dto.PedidosDTO;
import com.example.demo.Pedidos.mensageria.RabbitMQConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PedidosProdutor {

    private final RabbitTemplate rabbitTemplate;

    public void publicarPedidoCriado(PedidosDTO dto) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.FILA_PEDIDO_CRIADO, dto);
    }
}