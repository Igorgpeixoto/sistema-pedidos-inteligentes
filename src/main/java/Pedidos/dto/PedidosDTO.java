package Pedidos.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidosDTO {


    @Id
    private String id;
    private String produto;
    private double preco;
    private int quantidade;
    private String cliente;

}
