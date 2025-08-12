package Pedidos.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "estoque")
public class EstoqueModel {

    @Id
    private String id;        // ID do produto
    private String produto;
    private int quantidade;   // Quantidade disponível no estoque

}