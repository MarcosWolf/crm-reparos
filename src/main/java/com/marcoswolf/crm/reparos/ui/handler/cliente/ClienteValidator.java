package com.marcoswolf.crm.reparos.ui.handler.cliente;

import com.marcoswolf.crm.reparos.infrastructure.entities.Cliente;

public interface ClienteValidator {
    void validar(ClienteFormData data, Cliente novoCliente);
}