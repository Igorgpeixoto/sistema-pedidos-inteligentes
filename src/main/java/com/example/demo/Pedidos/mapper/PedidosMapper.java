package com.example.demo.Pedidos.mapper;

import com.example.demo.Pedidos.dto.PedidosDTO;
import com.example.demo.Pedidos.model.PedidosModel;
import org.springframework.stereotype.Component;

@Component
public class PedidosMapper {
    public PedidosModel map(PedidosDTO pedidosDTO){
        PedidosModel pedidosModel = new PedidosModel();
        pedidosModel.setId(pedidosDTO.getId());
        pedidosModel.setPreco(pedidosDTO.getPreco());
        pedidosModel.setProduto(pedidosDTO.getProduto());
        pedidosModel.setQuantidade(pedidosDTO.getQuantidade());
        pedidosModel.setCliente(pedidosDTO.getCliente());

        return pedidosModel;
    }
    public PedidosDTO map(PedidosModel pedidosModel){
        PedidosDTO pedidosDTO = new PedidosDTO();
        pedidosDTO.setId(pedidosModel.getId());
        pedidosDTO.setPreco(pedidosModel.getPreco());
        pedidosDTO.setProduto(pedidosModel.getProduto());
        pedidosDTO.setQuantidade(pedidosModel.getQuantidade());
        pedidosDTO.setCliente(pedidosModel.getCliente());

        return pedidosDTO;
    }

}

