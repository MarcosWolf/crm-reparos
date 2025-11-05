package com.marcoswolf.crm.reparos.business;

import com.marcoswolf.crm.reparos.infrastructure.entities.Cliente;
import com.marcoswolf.crm.reparos.infrastructure.entities.TipoEquipamento;
import com.marcoswolf.crm.reparos.infrastructure.repositories.TipoEquipamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoEquipamentoService {
    private final TipoEquipamentoRepository repository;

    public TipoEquipamentoService(TipoEquipamentoRepository repository) {
        this.repository = repository;
    }

    public void salvarTipoEquipamento(TipoEquipamento tipoEquipamento) {
        repository.saveAndFlush(tipoEquipamento);
    }

    public List<TipoEquipamento> buscarPorNome(String nome) {
        var tipoEquipamentos = repository.findByNomeContainingIgnoreCase(nome);

        if (tipoEquipamentos.isEmpty()) {
            throw new RuntimeException("Nenhum Tipo de Equipamento encontrado");
        }

        return tipoEquipamentos;
    }
}
