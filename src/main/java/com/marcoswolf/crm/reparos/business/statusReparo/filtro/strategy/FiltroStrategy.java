package com.marcoswolf.crm.reparos.business.statusReparo.filtro.strategy;

import com.marcoswolf.crm.reparos.infrastructure.entities.StatusReparo;

public interface FiltroStrategy {
    boolean aplicar(StatusReparo statusReparo);
}
