package com.marcoswolf.crm.reparos.controller;

import com.marcoswolf.crm.reparos.business.statusReparo.StatusReparoService;
import com.marcoswolf.crm.reparos.infrastructure.entities.StatusReparo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status-reparo")
@RequiredArgsConstructor

public class StatusReparoController {
    private final StatusReparoService service;

    // Create
    @PostMapping
    public ResponseEntity<StatusReparo> salvarStatusReparo(@RequestBody StatusReparo statusReparo) {
        service.salvar(statusReparo);
        return ResponseEntity.ok(statusReparo);
    }

    // Read
    @GetMapping
    public ResponseEntity<List<StatusReparo>> buscarStatusReparo(@RequestParam String nome) {
        List<StatusReparo> statusReparos = service.buscarPorNome(nome);
        return ResponseEntity.ok(statusReparos);
    }

    // Update
    @PutMapping
    public ResponseEntity<StatusReparo> atualizarStatusReparo(@RequestParam Long id, @RequestBody StatusReparo statusReparo) {
        StatusReparo novoStatusReparo = service.atualizar(id, statusReparo);
        return ResponseEntity.ok(novoStatusReparo);
    }

    // Delete
    @DeleteMapping
    public ResponseEntity<String> deletarStatusReparo(@RequestParam Long id) {
        try {
            service.deletar(id);
            return ResponseEntity.ok("Status de reparo deletado com sucesso.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}