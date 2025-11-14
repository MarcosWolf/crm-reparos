package com.marcoswolf.crm.reparos.ui.handler.statusReparo.dto;

import com.marcoswolf.crm.reparos.ui.handler.shared.IFormData;

public record StatusReparoFormData(
        String nome
) implements IFormData {}
