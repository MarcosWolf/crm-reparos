package com.marcoswolf.crm.reparos.ui.handler.reparo;

import com.marcoswolf.crm.reparos.infrastructure.entities.Reparo;

public interface ReparoValidator {
    void validar(ReparoFormData data, Reparo reparo);
}
