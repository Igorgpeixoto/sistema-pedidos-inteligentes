package Pedidos.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagamentoResultadoDTO {

    private String pedidoId;
    private boolean aprovado;
    private String pagamentoId;
    private double valor;
}
