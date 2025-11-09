package com.marcoswolf.crm.reparos.business.statusReparo;

import com.marcoswolf.crm.reparos.infrastructure.entities.StatusReparo;

import java.util.List;

public interface StatusReparoConsultaService {
    List<StatusReparo> listarTodos();
}
