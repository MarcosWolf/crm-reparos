package com.marcoswolf.crm.reparos.ui.handler.equipamento;

import com.marcoswolf.crm.reparos.infrastructure.entities.Equipamento;

public interface EquipamentoAction {
    boolean execute(Equipamento equipamento, EquipamentoFormData data);
}
