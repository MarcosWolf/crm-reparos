package com.marcoswolf.crm.reparos.ui.handler.cliente;

import com.marcoswolf.crm.reparos.business.cliente.IClienteConsultaService;
import com.marcoswolf.crm.reparos.infrastructure.entities.Cliente;
import com.marcoswolf.crm.reparos.ui.utils.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ClienteBuscarAction {
    private final IClienteConsultaService clienteConsultaService;

    public List<Cliente> executar(String nome) {
        try {
            return clienteConsultaService.buscarPorNome(nome);
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
