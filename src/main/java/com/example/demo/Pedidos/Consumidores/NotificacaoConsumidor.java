package com.example.demo.Pedidos.Consumidores;

import com.example.demo.Pedidos.dto.InventarioResultadoDTO;
import com.example.demo.Pedidos.mensageria.RabbitMQConfig;
import com.example.demo.Pedidos.model.NotificacaoModel;
import com.example.demo.Pedidos.repository.NotificacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
@RequiredArgsConstructor
public class NotificacaoConsumidor {

    private final NotificacaoRepository notificacaoRepository;

    @RabbitListener(queues = RabbitMQConfig.FILA_ESTOQUE_ATUALIZADO)
    public void consumir(InventarioResultadoDTO resultado) {
        System.out.println("[notifier] Recebido resultado estoque para pedido " + resultado.getPedidoId());

        NotificacaoModel n = NotificacaoModel.builder()
                .pedidoId(resultado.getPedidoId())
                .sucesso(resultado.isAtualizado())
                .mensagem(resultado.getMensagem())
                .criadoEm(OffsetDateTime.now().toInstant())
                .build();

        notificacaoRepository.save(n);
        System.out.println("[notifier] Notificação salva para pedido " + resultado.getPedidoId());
    }
}