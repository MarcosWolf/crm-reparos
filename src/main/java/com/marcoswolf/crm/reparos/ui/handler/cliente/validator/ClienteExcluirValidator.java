package com.marcoswolf.crm.reparos.ui.handler.cliente.validator;

import com.marcoswolf.crm.reparos.infrastructure.entities.Cliente;
import com.marcoswolf.crm.reparos.infrastructure.repositories.EquipamentoRepository;
import com.marcoswolf.crm.reparos.infrastructure.repositories.ReparoRepository;
import com.marcoswolf.crm.reparos.ui.handler.cliente.dto.ClienteFormData;
import org.springframework.stereotype.Component;

@Component
public class ClienteExcluirValidator implements ClienteValidator {
    private final ReparoRepository reparoRepository;
    private final EquipamentoRepository equipamentoRepository;

    public ClienteExcluirValidator(ReparoRepository reparoRepository, EquipamentoRepository equipamentoRepository) {
        this.reparoRepository = reparoRepository;
        this.equipamentoRepository = equipamentoRepository;
    }

    @Override
    public void validar(ClienteFormData data, Cliente cliente) {
        if (reparoRepository.existsByEquipamento_Cliente_Id(cliente.getId())) {
            throw new IllegalArgumentException(
                    "Não é possível excluir o cliente: existe reparo associado."
            );
        }

        if (equipamentoRepository.existsByClienteId(cliente.getId())) {
            throw new IllegalArgumentException(
                    "Não é possível excluir o cliente: existe equipamento associado."
            );
        }
    }
}
