package com.marcoswolf.crm.reparos.ui.handler.statusReparo.validator;

import com.marcoswolf.crm.reparos.infrastructure.entities.StatusReparo;
import com.marcoswolf.crm.reparos.ui.handler.statusReparo.dto.StatusReparoFormData;

public interface StatusReparoValidator {
    void validar(StatusReparoFormData data, StatusReparo novoStatusReparo);
}
