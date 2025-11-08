package com.marcoswolf.crm.reparos.business.cliente.filtro.strategy;

import com.marcoswolf.crm.reparos.infrastructure.entities.Cliente;

public interface ClienteFiltroStrategy {
    boolean aplicar(Cliente cliente);
}
