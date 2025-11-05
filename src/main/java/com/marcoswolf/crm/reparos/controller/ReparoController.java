package com.marcoswolf.crm.reparos.controller;

import com.marcoswolf.crm.reparos.business.ReparoService;
import com.marcoswolf.crm.reparos.infrastructure.entities.Reparo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reparo")
@RequiredArgsConstructor

public class ReparoController {
    private final ReparoService service;

    @PostMapping
    public ResponseEntity<Reparo> salvarReparo(@RequestBody Reparo reparo) {
        service.salvarReparo(reparo);
        return ResponseEntity.ok(reparo);
    }

    @GetMapping
    public ResponseEntity<List<Reparo>> buscarPorStatus(@RequestParam String status) {
        List<Reparo> reparos = service.buscarPorStatus(status);
        return ResponseEntity.ok(reparos);
    }
}
