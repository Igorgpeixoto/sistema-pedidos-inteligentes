package com.example.demo.Pedidos.service;


import com.example.demo.Pedidos.model.EstoqueModel;
import com.example.demo.Pedidos.repository.EstoqueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EstoqueService {

    private final EstoqueRepository estoqueRepository;

    public EstoqueModel criarEstoque(String produto, int quantidade) {
        if (estoqueRepository.findByProduto(produto).isPresent()) {
            throw new RuntimeException("Produto já existe no estoque");
        }
        EstoqueModel novo = EstoqueModel.builder()
                .produto(produto)
                .quantidade(quantidade)
                .build();

        return estoqueRepository.save(novo);}

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