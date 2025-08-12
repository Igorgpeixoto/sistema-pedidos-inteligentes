package com.example.demo.Pedidos.service;

import com.example.demo.Pedidos.dto.PedidosDTO;
import com.example.demo.Pedidos.mapper.PedidosMapper;
import com.example.demo.Pedidos.mensageria.PedidosProdutor;
import com.example.demo.Pedidos.mensageria.RabbitMQConfig;
import com.example.demo.Pedidos.model.PedidosModel;
import com.example.demo.Pedidos.repository.PedidosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidosService {

    private final PedidosMapper pedidosMapper;
    private final PedidosRepository pedidosRepository;
    private final RabbitTemplate rabbitTemplate;

    //Criar Pedidos
    public PedidosDTO criar(PedidosDTO pedidosDTO) {
        PedidosModel pedidos = pedidosMapper.map(pedidosDTO);
        pedidos = pedidosRepository.save(pedidos);
        PedidosDTO salvo = pedidosMapper.map(pedidos);
        rabbitTemplate.convertAndSend(RabbitMQConfig.FILA_PEDIDO_CRIADO, salvo);
        System.out.println("[pedido-service] Pedido criado e enviado para fila: " + salvo.getId());
        return salvo;}

    // Listar Pedidos
    public List<PedidosDTO> listarPedidos() {
        List<PedidosModel> pedidos = pedidosRepository.findAll();
        return pedidos.stream()
                .map(pedidosMapper::map)
                .collect(Collectors.toList());
    }

    // Buscar Pedidos
    public Optional<PedidosDTO> buscarPorId(String id) {
        return pedidosRepository.findById(id).map(pedidosMapper::map);
    }

    // Atualizar Pedidos
    public PedidosDTO atualizarPedido(String id, PedidosDTO pedidosDTO) {
        Optional<PedidosModel> pedidoExistente = pedidosRepository.findById(id);
        if (pedidoExistente.isPresent()) {
            PedidosModel pedidoAtualizado = pedidosMapper.map(pedidosDTO);
            pedidoAtualizado.setPreco(pedidosDTO.getPreco());
            pedidoAtualizado.setProduto(pedidosDTO.getProduto());
            pedidoAtualizado.setQuantidade(pedidosDTO.getQuantidade());
            pedidoAtualizado.setId(id);
            PedidosModel pedidosSalvo = pedidosRepository.save(pedidoAtualizado);
            return pedidosMapper.map(pedidosSalvo);
        }
        return null;
    }

    // Deletar Pedidos
    public void deletarPedido(String id) {
        pedidosRepository.deleteById(id);
    }
}
