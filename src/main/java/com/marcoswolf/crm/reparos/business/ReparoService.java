package com.marcoswolf.crm.reparos.business;

import com.marcoswolf.crm.reparos.infrastructure.entities.Reparo;
import com.marcoswolf.crm.reparos.infrastructure.repositories.ReparoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReparoService {
    private final ReparoRepository repository;

    public ReparoService(ReparoRepository repository) {
        this.repository = repository;
    }

    public void salvarReparo(Reparo reparo) {
        repository.saveAndFlush(reparo);
    }

    public List<Reparo> buscarPorStatus(String status) {
        var reparos = repository.findByStatus_NomeContainingIgnoreCase(status);

        if (reparos.isEmpty()) {
            throw new RuntimeException("Nenhum Reparo encontrado");
        }

        return reparos;
    }
}
