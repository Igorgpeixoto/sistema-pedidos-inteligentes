package Pedidos.service;

import Pedidos.dto.PedidosDTO;
import Pedidos.mapper.PedidosMapper;
import Pedidos.mensageria.PedidosProdutor;
import Pedidos.model.PedidosModel;
import Pedidos.repository.PedidosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidosService {

    private final PedidosMapper pedidosMapper;
    private final PedidosRepository pedidosRepository;
    private final PedidosProdutor pedidosProdutor;

    //Criar Pedidos
    public PedidosDTO criar (PedidosDTO pedidosDTO) {
        PedidosModel pedidos = pedidosMapper.map(pedidosDTO);
        pedidos = pedidosRepository.save(pedidos);
        return pedidosMapper.map(pedidos);
    }

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
