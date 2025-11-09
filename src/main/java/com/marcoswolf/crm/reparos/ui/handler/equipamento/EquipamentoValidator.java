package com.marcoswolf.crm.reparos.ui.handler.equipamento;

import com.marcoswolf.crm.reparos.infrastructure.entities.Equipamento;

public interface EquipamentoValidator {
    void validar(EquipamentoFormData data, Equipamento novoEquipamento);
}
