package com.example.demo.Pedidos.Consumidores;

import com.example.demo.Pedidos.dto.InventarioResultadoDTO;
import com.example.demo.Pedidos.dto.PedidosDTO;
import com.example.demo.Pedidos.mensageria.RabbitMQConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PagamentoConsumidor {

    private final RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = RabbitMQConfig.FILA_PEDIDO_CRIADO)
    public void consumirPedidoCriado(PedidosDTO pedido) throws InterruptedException {
        System.out.println("[payment] Processando pagamento do pedido " + pedido.getId());
        Thread.sleep(700); // simula demora

        // Simulação de pagamento aprovado
        InventarioResultadoDTO resultado = InventarioResultadoDTO.builder()
                .pedidoId(pedido.getId())
                .produto(pedido.getProduto())
                .quantidade(pedido.getQuantidade())
                .mensagem("Pagamento aprovado")
                .atualizado(true)
                .build();

        rabbitTemplate.convertAndSend(RabbitMQConfig.FILA_PAGAMENTO_CONCLUIDO, resultado);
        System.out.println("[pagamento] Pagamento aprovado enviado para fila: " + RabbitMQConfig.FILA_PAGAMENTO_CONCLUIDO);
    }
}