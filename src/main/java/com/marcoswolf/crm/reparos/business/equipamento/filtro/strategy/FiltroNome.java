package com.marcoswolf.crm.reparos.business.equipamento.filtro.strategy;

import com.marcoswolf.crm.reparos.infrastructure.entities.Equipamento;

public class FiltroNome implements EquipamentoFiltroStrategy {
    private final String termo;

    public FiltroNome(String termo) {
        this.termo = termo != null ? termo.trim().toLowerCase() : null;
    }

    @Override
    public boolean aplicar(Equipamento equipamento) {
        if (termo == null || termo.isBlank()) return true;

        return (equipamento.getMarca() != null && equipamento.getMarca().toLowerCase().contains(termo))
                || (equipamento.getModelo() != null && equipamento.getModelo().toLowerCase().contains(termo))
                || (equipamento.getNumeroSerie() != null && equipamento.getNumeroSerie().toLowerCase().contains(termo));
    }
}
