package com.marcoswolf.crm.reparos.ui.handler.cliente;

import com.marcoswolf.crm.reparos.infrastructure.entities.Estado;
import static com.marcoswolf.crm.reparos.ui.utils.ValidationUtils.isEmpty;
import org.springframework.stereotype.Component;

@Component
public class ClienteCamposObrigatoriosValidator implements ClienteValidator {

    @Override
    public void validar(ClienteFormData data) {
        if (isEmpty(data.nome())) {
            throw new IllegalArgumentException("O campo Nome é obrigatório.");
        }

        if (isEmpty(data.telefone())) {
            throw new IllegalArgumentException("O campo Telefone é obrigatório.");
        }

        if (isEmpty(data.cidade())) {
            throw new IllegalArgumentException("O campo Cidade é obrigatório.");
        }

        Estado estado = data.estadoSelecionado();
        if (estado == null || estado.getId() == 0) {
            throw new IllegalArgumentException("O campo Estado é obrigatório.");
        }
    }
}