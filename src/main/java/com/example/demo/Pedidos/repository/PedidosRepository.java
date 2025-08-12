package com.example.demo.Pedidos.repository;

import com.example.demo.Pedidos.model.PedidosModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PedidosRepository extends MongoRepository<PedidosModel, String> {}

