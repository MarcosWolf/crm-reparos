package com.marcoswolf.crm.reparos.business.reparo;

import com.marcoswolf.crm.reparos.infrastructure.entities.Reparo;

public interface ReparoComandoService {
    void salvar(Reparo reparo);
    Reparo atualizar(Long id, Reparo reparo);
    void deletar(Long id);
}
