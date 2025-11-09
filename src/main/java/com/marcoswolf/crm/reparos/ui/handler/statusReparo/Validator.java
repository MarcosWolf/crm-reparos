package com.marcoswolf.crm.reparos.ui.handler.statusReparo;

import com.marcoswolf.crm.reparos.infrastructure.entities.StatusReparo;

public interface Validator {
    void validar(FormData data, StatusReparo novoStatusReparo);
}
