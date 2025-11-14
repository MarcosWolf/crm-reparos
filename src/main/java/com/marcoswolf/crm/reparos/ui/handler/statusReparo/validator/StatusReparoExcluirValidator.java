package com.marcoswolf.crm.reparos.ui.handler.statusReparo.validator;

import com.marcoswolf.crm.reparos.infrastructure.entities.StatusReparo;
import com.marcoswolf.crm.reparos.infrastructure.repositories.ReparoRepository;
import com.marcoswolf.crm.reparos.ui.handler.statusReparo.dto.StatusReparoFormData;
import org.springframework.stereotype.Component;

@Component
public class StatusReparoExcluirValidator implements StatusReparoValidator {
    private final ReparoRepository reparoRepository;

    public StatusReparoExcluirValidator(ReparoRepository reparoRepository) {
        this.reparoRepository = reparoRepository;
    }

    @Override
    public void validar(StatusReparoFormData data, StatusReparo statusReparo) {
        if (reparoRepository.existsByStatus_Id(statusReparo.getId())) {
            throw new IllegalArgumentException(
                    "Não é possível excluir o status de reparo: existe reparo associado."
            );
        }
    }
}
