package com.marcoswolf.crm.reparos.business.equipamento.filtro.strategy;

import com.marcoswolf.crm.reparos.infrastructure.entities.Equipamento;

public interface EquipamentoFiltroStrategy {
    boolean aplicar(Equipamento equipamento);
}
