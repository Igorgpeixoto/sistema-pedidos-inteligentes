package com.example.demo.Pedidos.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventarioResultadoDTO {


    private String pedidoId;
    private String mensagem;
    private String produto;
    private int quantidade;
    private boolean atualizado;
}