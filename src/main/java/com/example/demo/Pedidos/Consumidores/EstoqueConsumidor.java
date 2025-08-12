package com.example.demo.Pedidos.Consumidores;

import com.example.demo.Pedidos.dto.InventarioResultadoDTO;
import com.example.demo.Pedidos.mensageria.RabbitMQConfig;
import com.example.demo.Pedidos.service.EstoqueService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EstoqueConsumidor {

    private final EstoqueService estoqueService;
    private final RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = RabbitMQConfig.FILA_PAGAMENTO_CONCLUIDO)
    public void atualizarEstoque(InventarioResultadoDTO pagamento) {
        // Atualiza estoque no banco
        estoqueService.atualizarEstoque(pagamento.getProduto(), pagamento.getQuantidade());

        // Marca como atualizado
        pagamento.setAtualizado(true);
        pagamento.setMensagem("Estoque atualizado com sucesso");

        // Envia evento de estoque atualizado
        rabbitTemplate.convertAndSend(RabbitMQConfig.FILA_ESTOQUE_ATUALIZADO, pagamento);
    }
}

