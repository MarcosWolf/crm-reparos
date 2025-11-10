package com.marcoswolf.crm.reparos.business.reparo;

import com.marcoswolf.crm.reparos.infrastructure.entities.Reparo;

import java.util.List;

public interface ReparoConsultaService {
    List<Reparo> listarTodos();
}
