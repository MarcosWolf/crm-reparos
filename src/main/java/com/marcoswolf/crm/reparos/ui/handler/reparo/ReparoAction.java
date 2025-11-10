package com.marcoswolf.crm.reparos.ui.handler.reparo;

import com.marcoswolf.crm.reparos.infrastructure.entities.Reparo;

public interface ReparoAction {
    boolean execute(Reparo reparo, ReparoFormData data);
}
