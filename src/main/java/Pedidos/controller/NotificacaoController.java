package Pedidos.controller;

import Pedidos.model.NotificacaoModel;
import Pedidos.repository.NotificacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/notificacoes")
@RequiredArgsConstructor
public class NotificacaoController {

    private final NotificacaoRepository notificacaoRepository;

    @GetMapping
    public ResponseEntity<List<NotificacaoModel>> listar() {
        return ResponseEntity.ok(notificacaoRepository.findAll());
    }
}
