package Pedidos.service;


import Pedidos.model.EstoqueModel;
import Pedidos.repository.EstoqueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EstoqueService {

    private final EstoqueRepository estoqueRepository;

    public void atualizarEstoque(String produto, int quantidadeVendida) {
        EstoqueModel estoque = estoqueRepository.findByProduto(produto)
                .orElse(EstoqueModel.builder()
                        .produto(produto)
                        .quantidade(0)
                        .build());

        estoque.setQuantidade(estoque.getQuantidade() - quantidadeVendida);
        estoqueRepository.save(estoque);
    }
}