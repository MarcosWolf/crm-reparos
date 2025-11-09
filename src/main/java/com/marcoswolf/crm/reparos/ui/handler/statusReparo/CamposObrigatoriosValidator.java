package com.marcoswolf.crm.reparos.ui.handler.statusReparo;

import com.marcoswolf.crm.reparos.infrastructure.entities.StatusReparo;
import com.marcoswolf.crm.reparos.infrastructure.repositories.StatusReparoRepository;
import org.springframework.stereotype.Component;

import static com.marcoswolf.crm.reparos.ui.utils.ValidationUtils.isEmpty;

@Component
public class CamposObrigatoriosValidator implements Validator {

    private final StatusReparoRepository statusReparoRepository;

    public CamposObrigatoriosValidator(StatusReparoRepository statusReparoRepository) {
        this.statusReparoRepository = statusReparoRepository;
    }

    @Override
    public void validar(FormData data, StatusReparo novoStatusReparo) {
        if (isEmpty(data.nome())) {
            throw new IllegalArgumentException("O campo nome é obrigatório.");
        }

        Long id = novoStatusReparo != null ? novoStatusReparo.getId() : null;

        if (!isEmpty(data.nome()) && statusReparoRepository.existsByNomeAndNotId(data.nome(), id)) {
            throw new IllegalArgumentException("Já existe um status de reparo cadastrado com este nome.");
        }
    }
}
