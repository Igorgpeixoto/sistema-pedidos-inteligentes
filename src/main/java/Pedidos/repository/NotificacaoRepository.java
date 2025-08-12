package Pedidos.repository;

import Pedidos.model.NotificacaoModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificacaoRepository extends MongoRepository<NotificacaoModel, String> {
}