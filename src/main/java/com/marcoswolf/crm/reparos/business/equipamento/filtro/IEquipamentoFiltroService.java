package com.marcoswolf.crm.reparos.business.equipamento.filtro;

import com.marcoswolf.crm.reparos.infrastructure.entities.Equipamento;

import java.util.List;

public interface IEquipamentoFiltroService {
    List<Equipamento> aplicarFiltros(EquipamentoFiltro filtro);
    List<Equipamento> aplicarFiltros(List<Equipamento> equipamentos, EquipamentoFiltro filtro);
}
