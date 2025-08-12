package com.example.demo.Pedidos.repository;

import com.example.demo.Pedidos.model.EstoqueModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EstoqueRepository extends MongoRepository<EstoqueModel, String> {
    Optional<EstoqueModel> findByProduto(String produto);
}