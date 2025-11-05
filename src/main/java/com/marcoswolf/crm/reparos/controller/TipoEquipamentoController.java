package com.marcoswolf.crm.reparos.controller;

import com.marcoswolf.crm.reparos.business.TipoEquipamentoService;
import com.marcoswolf.crm.reparos.infrastructure.entities.TipoEquipamento;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo-equipamento")
@RequiredArgsConstructor

public class TipoEquipamentoController {
    private final TipoEquipamentoService tipoEquipamentoService;

    @PostMapping
    public ResponseEntity<TipoEquipamento> salvarTipoEquipamento(@RequestBody TipoEquipamento tipoEquipamento) {
        tipoEquipamentoService.salvarTipoEquipamento(tipoEquipamento);
        return ResponseEntity.ok(tipoEquipamento);
    }

    @GetMapping
    public ResponseEntity<List<TipoEquipamento>> buscarPorNome(@RequestParam String nome) {
        List<TipoEquipamento> equipamentos = tipoEquipamentoService.buscarPorNome(nome);
        return ResponseEntity.ok(equipamentos);
    }
}
