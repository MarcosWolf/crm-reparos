package com.marcoswolf.crm.reparos.business.cliente;

import com.marcoswolf.crm.reparos.infrastructure.entities.Cliente;

import java.util.List;

public interface IClienteConsultaService {
    List<Cliente> buscarPorNome(String nome);
    List<Cliente> filtrarClientes(ClienteFiltro filtro);
}
