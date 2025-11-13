package com.marcoswolf.crm.reparos.business.cliente.filtro;

import com.marcoswolf.crm.reparos.infrastructure.entities.Cliente;

import java.util.List;

public interface ClienteFiltroServiceImpl {
    List<Cliente> aplicarFiltros(ClienteFiltro filtro);
    List<Cliente> aplicarFiltros(List<Cliente> clientes, ClienteFiltro filtro);
}
