package com.marcoswolf.crm.reparos.business.cliente;

import com.marcoswolf.crm.reparos.business.cliente.filtro.ClienteFiltro;
import com.marcoswolf.crm.reparos.infrastructure.entities.Cliente;

import java.util.List;

public interface IClienteConsultaService {
    List<Cliente> listarTodos();
}
