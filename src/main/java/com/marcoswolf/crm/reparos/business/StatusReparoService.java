package com.marcoswolf.crm.reparos.business;

import com.marcoswolf.crm.reparos.infrastructure.entities.StatusReparo;
import com.marcoswolf.crm.reparos.infrastructure.repositories.StatusReparoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusReparoService {
    private final StatusReparoRepository repository;

    public StatusReparoService(StatusReparoRepository repository) {
        this.repository = repository;
    }

    public void salvarStatusReparo(StatusReparo statusReparo) {
        repository.saveAndFlush(statusReparo);
    }

    public List<StatusReparo> buscarPorNome(String nome) {
        var statusReparos = repository.findByNomeContainingIgnoreCase(nome);

        if (statusReparos.isEmpty()) {
            throw new RuntimeException("Nenhum Status de Reparo encontrado");
        }

        return statusReparos;
    }
}
