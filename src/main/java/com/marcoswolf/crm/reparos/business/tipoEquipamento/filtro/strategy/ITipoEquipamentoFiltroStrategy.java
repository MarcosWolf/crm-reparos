package com.marcoswolf.crm.reparos.business.tipoEquipamento.filtro.strategy;

import com.marcoswolf.crm.reparos.infrastructure.entities.TipoEquipamento;

public interface ITipoEquipamentoFiltroStrategy {
    boolean aplicar(TipoEquipamento tipoEquipamento);
}
