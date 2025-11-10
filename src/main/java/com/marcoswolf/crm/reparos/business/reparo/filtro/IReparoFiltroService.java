package com.marcoswolf.crm.reparos.business.reparo.filtro;

import com.marcoswolf.crm.reparos.infrastructure.entities.Reparo;

import java.util.List;

public interface IReparoFiltroService {
    List<Reparo> aplicarFiltros(ReparoFiltro filtro);
    List<Reparo> aplicarFiltros(List<Reparo> reparos, ReparoFiltro filtro);
}
