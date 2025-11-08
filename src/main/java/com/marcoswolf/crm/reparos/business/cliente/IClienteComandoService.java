package com.marcoswolf.crm.reparos.business.cliente;

import com.marcoswolf.crm.reparos.infrastructure.entities.Cliente;

public interface IClienteComandoService {
    void salvarCliente(Cliente cliente);
    Cliente atualizarCliente(Long id, Cliente cliente);
    void deletarCliente(Long id);
}
