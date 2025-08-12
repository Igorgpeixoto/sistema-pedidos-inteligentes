package com.example.demo.Pedidos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "pedidos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidosModel {

    @Id
    private String id;
    private String produto;
    private double preco;
    private int quantidade;
    private String cliente;

}
