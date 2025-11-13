package com.marcoswolf.crm.reparos.ui.handler.cliente.action;

import com.marcoswolf.crm.reparos.infrastructure.entities.Cliente;
import com.marcoswolf.crm.reparos.ui.handler.cliente.dto.ClienteFormData;

public interface ClienteAction {
    boolean execute(Cliente cliente, ClienteFormData data);
}
