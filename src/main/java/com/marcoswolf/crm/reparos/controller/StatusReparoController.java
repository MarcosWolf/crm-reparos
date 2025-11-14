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

    @PostMapping
    public ResponseEntity<StatusReparo> salvar(@RequestBody StatusReparo statusReparo) {
        service.salvar(statusReparo);
        return ResponseEntity.ok(statusReparo);
    }

    @GetMapping
    public ResponseEntity<List<StatusReparo>> listarTodos() {
        List<StatusReparo> statusReparos = service.listarTodos();
        return ResponseEntity.ok(statusReparos);
    }

    @DeleteMapping
    public ResponseEntity<String> deletar(@RequestParam Long id) {
        try {
            service.deletar(id);
            return ResponseEntity.ok("Status de reparo deletado com sucesso.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}