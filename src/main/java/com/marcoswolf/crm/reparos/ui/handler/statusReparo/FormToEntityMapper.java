package com.marcoswolf.crm.reparos.ui.handler.statusReparo;

import com.marcoswolf.crm.reparos.infrastructure.entities.StatusReparo;
import com.marcoswolf.crm.reparos.ui.mappers.StatusReparoFormMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FormToEntityMapper {
    private final StatusReparoFormMapper delegate;

    public StatusReparo map(FormData data, StatusReparo novoStatusReparo) {
        StatusReparo statusReparo = delegate.toEntity(
                data.nome()
        );

        if (novoStatusReparo != null) {
            statusReparo.setId(novoStatusReparo.getId());
        }
        return statusReparo;
    }
}
