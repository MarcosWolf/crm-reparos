package com.marcoswolf.crm.reparos.business.cliente;

import com.marcoswolf.crm.reparos.infrastructure.entities.Cliente;

public interface IClienteComandoService {
    void salvar(Cliente cliente);
    void deletar(Long id);
}
