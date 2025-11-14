package com.marcoswolf.crm.reparos.ui.handler.cliente.dto;

import java.time.LocalDate;

public record ClienteFiltroDTO(
        String nome,
        boolean pendentes,
        boolean inativos,
        boolean recentes,
        LocalDate dataDesde
) {}