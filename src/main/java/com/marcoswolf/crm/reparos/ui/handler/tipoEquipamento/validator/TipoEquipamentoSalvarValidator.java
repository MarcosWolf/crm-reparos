package com.marcoswolf.crm.reparos.ui.handler.tipoEquipamento;

import com.marcoswolf.crm.reparos.infrastructure.entities.TipoEquipamento;
import com.marcoswolf.crm.reparos.infrastructure.repositories.TipoEquipamentoRepository;
import org.springframework.stereotype.Component;

import static com.marcoswolf.crm.reparos.ui.utils.ValidationUtils.isEmpty;

@Component
public class TipoEquipamentoCamposObrigatoriosValidator implements TipoEquipamentoValidator {
    private final TipoEquipamentoRepository tipoEquipamentoRepository;

    public TipoEquipamentoCamposObrigatoriosValidator(TipoEquipamentoRepository tipoEquipamentoRepository) {
        this.tipoEquipamentoRepository = tipoEquipamentoRepository;
    }

    @Override
    public void validar(TipoEquipamentoFormData data, TipoEquipamento novoTipoEquipamento) {
        if (isEmpty(data.nome())) {
            throw new IllegalArgumentException("O campo nome é obrigatório.");
        }

        Long id = novoTipoEquipamento != null ? novoTipoEquipamento.getId() : null;

        if (!isEmpty(data.nome()) && tipoEquipamentoRepository.existsByNomeAndNotId(data.nome(), id)) {
            throw new IllegalArgumentException("Já existe um tipo de equipamento cadastrado com este nome.");
        }
    }
}
