package Pedidos.repository;

import Pedidos.model.PedidosModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PedidosRepository extends MongoRepository<PedidosModel, String> {}

