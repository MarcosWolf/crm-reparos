package com.marcoswolf.crm.reparos.ui.handler.tipoEquipamento;

import com.marcoswolf.crm.reparos.infrastructure.entities.TipoEquipamento;

public interface TipoEquipamentoValidator {
    void validar(TipoEquipamentoFormData data, TipoEquipamento novoTipoEquipamento);
}
