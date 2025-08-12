package com.example.demo.Pedidos.controller;

import com.example.demo.Pedidos.model.EstoqueModel;
import com.example.demo.Pedidos.repository.EstoqueRepository;
import com.example.demo.Pedidos.service.EstoqueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque")
@RequiredArgsConstructor
public class EstoqueController {

        private final EstoqueRepository estoqueRepository;

        @PostMapping
        public ResponseEntity<EstoqueModel> criarEstoque(@RequestBody EstoqueModel dto) {
            EstoqueModel estoque = EstoqueModel.builder()
                    .produto(dto.getProduto())
                    .quantidade(dto.getQuantidade())
                    .build();

            EstoqueModel salvo = estoqueRepository.save(estoque);
            return ResponseEntity.ok(salvo);
        }

        @GetMapping
        public ResponseEntity<List<EstoqueModel>> listarTodos() {
            return ResponseEntity.ok(estoqueRepository.findAll());
        }
    }