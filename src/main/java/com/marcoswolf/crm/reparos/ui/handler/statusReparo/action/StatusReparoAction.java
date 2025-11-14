package com.marcoswolf.crm.reparos.ui.handler.statusReparo.action;

import com.marcoswolf.crm.reparos.infrastructure.entities.StatusReparo;
import com.marcoswolf.crm.reparos.ui.handler.statusReparo.dto.StatusReparoFormData;

public interface StatusReparoAction {
    boolean execute(StatusReparo statusReparo, StatusReparoFormData statusReparoFormData);
}
