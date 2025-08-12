package com.example.demo.Pedidos.repository;

import com.example.demo.Pedidos.model.NotificacaoModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificacaoRepository extends MongoRepository<NotificacaoModel, String> {
}