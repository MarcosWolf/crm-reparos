package com.marcoswolf.crm.reparos.business.statusReparo;

import com.marcoswolf.crm.reparos.infrastructure.entities.StatusReparo;

public interface StatusReparoComandoService {
    void salvar(StatusReparo statusReparo);
    StatusReparo atualizar(Long id, StatusReparo statusReparo);
    void deletar(Long id);
}
