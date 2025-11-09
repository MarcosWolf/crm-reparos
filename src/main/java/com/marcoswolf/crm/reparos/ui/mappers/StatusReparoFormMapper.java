package com.marcoswolf.crm.reparos.ui.mappers;

import com.marcoswolf.crm.reparos.infrastructure.entities.StatusReparo;
import org.springframework.stereotype.Component;

@Component
public class StatusReparoFormMapper {
    public StatusReparo toEntity(String nome) {
        StatusReparo statusReparo = new StatusReparo();
        statusReparo.setNome(nome);

        return statusReparo;
    }
}
