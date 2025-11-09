package com.marcoswolf.crm.reparos.business.statusReparo.filtro.strategy;

import com.marcoswolf.crm.reparos.infrastructure.entities.StatusReparo;

public class FiltroNome implements FiltroStrategy {
    private final String nome;

    public FiltroNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean aplicar(StatusReparo statusReparo) {
        if (nome == null || nome.isBlank()) return true;
        return statusReparo.getNome() != null && statusReparo.getNome().toLowerCase().contains(nome.toLowerCase().trim());
    }
}
