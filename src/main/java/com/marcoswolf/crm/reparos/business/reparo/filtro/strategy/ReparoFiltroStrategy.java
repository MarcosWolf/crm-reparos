package com.marcoswolf.crm.reparos.business.reparo.filtro.strategy;

import com.marcoswolf.crm.reparos.infrastructure.entities.Reparo;

public interface ReparoFiltroStrategy {
    boolean aplicar(Reparo reparo);
}
