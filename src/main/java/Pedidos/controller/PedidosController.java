package Pedidos.controller;

import Pedidos.dto.PedidosDTO;
import Pedidos.service.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {

    @Autowired
    private PedidosService pedidosService;

    @PostMapping
    public PedidosDTO criar(@RequestBody PedidosDTO pedidosDTO) {
        return pedidosService.criar(pedidosDTO);
    }

    @GetMapping
    public List<PedidosDTO> listarTodos() {
        return pedidosService.listarPedidos();
    }

    @GetMapping("/{id}")
    public Optional<PedidosDTO> buscarPorId(@PathVariable String id) {
        return pedidosService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public PedidosDTO atualizarPedido(@PathVariable String id, @RequestBody PedidosDTO pedidoAtualizado) {
        PedidosDTO pedidosDTO = pedidosService.atualizarPedido(id, pedidoAtualizado);
        return pedidosDTO;
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        pedidosService.deletarPedido(id);
    }
}