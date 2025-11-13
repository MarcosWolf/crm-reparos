package com.marcoswolf.crm.reparos.business.cliente;

import com.marcoswolf.crm.reparos.infrastructure.entities.Cliente;
import com.marcoswolf.crm.reparos.infrastructure.repositories.ClienteRepository;
import com.marcoswolf.crm.reparos.infrastructure.repositories.EquipamentoRepository;
import com.marcoswolf.crm.reparos.infrastructure.repositories.ReparoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteConsultaService, IClienteComandoService {
    private final ClienteRepository clienteRepository;
    private final ReparoRepository reparoRepository;
    private final EquipamentoRepository equipamentoRepository;

    public ClienteService(ClienteRepository clienteRepository, ReparoRepository reparoRepository, EquipamentoRepository equipamentoRepository) {
        this.clienteRepository = clienteRepository;
        this.reparoRepository = reparoRepository;
        this.equipamentoRepository = equipamentoRepository;
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public void salvarCliente(Cliente cliente) {
        clienteRepository.saveAndFlush(cliente);
    }

    public void deletarCliente(Long id) {
        var cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado."));

        clienteRepository.delete(cliente);
    }
}
