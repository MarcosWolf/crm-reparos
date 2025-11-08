package com.marcoswolf.crm.reparos.business.cliente.filtro.strategy;

import com.marcoswolf.crm.reparos.infrastructure.entities.Cliente;

public class FiltroNome implements ClienteFiltroStrategy {
    private final String nome;

    public FiltroNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean aplicar(Cliente cliente) {
        if (nome == null || nome.isBlank()) return true;
        return cliente.getNome() != null && cliente.getNome().toLowerCase().contains(nome.toLowerCase().trim());
    }
}
