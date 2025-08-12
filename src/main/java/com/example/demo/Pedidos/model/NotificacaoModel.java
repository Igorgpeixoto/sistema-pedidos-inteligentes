package com.example.demo.Pedidos.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "notificacoes")
public class NotificacaoModel {

    @Id
    private String id;
    private String pedidoId;
    private boolean sucesso;
    private String mensagem;
    private Instant criadoEm;

}