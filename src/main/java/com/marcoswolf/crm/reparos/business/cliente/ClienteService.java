package com.marcoswolf.crm.reparos.business.cliente;

import com.marcoswolf.crm.reparos.infrastructure.entities.Cliente;
import com.marcoswolf.crm.reparos.infrastructure.entities.Endereco;
import com.marcoswolf.crm.reparos.infrastructure.repositories.ClienteRepository;
import com.marcoswolf.crm.reparos.infrastructure.repositories.ReparoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteConsultaService, IClienteComandoService {
    private final ClienteRepository clienteRepository;
    private final ReparoRepository reparoRepository;

    public ClienteService(ClienteRepository clienteRepository, ReparoRepository reparoRepository) {
        this.clienteRepository = clienteRepository;
        this.reparoRepository = reparoRepository;
    }

    // Create
    public void salvarCliente(Cliente cliente) {
        clienteRepository.saveAndFlush(cliente);
    }

    // Read
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    // Update
    public Cliente atualizarCliente(Long id, Cliente novoCliente) {
        var cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado."));

        cliente.setNome(novoCliente.getNome());
        cliente.setTelefone(novoCliente.getTelefone());
        cliente.setEmail(novoCliente.getEmail());

        if (novoCliente.getEndereco() != null) {
            Endereco endereco = cliente.getEndereco();

            if (endereco == null) {
                endereco = new Endereco();
                cliente.setEndereco(endereco);
            }

            endereco.setCidade(novoCliente.getEndereco().getCidade());
            endereco.setEstado(novoCliente.getEndereco().getEstado());
            endereco.setBairro(novoCliente.getEndereco().getBairro());
            endereco.setLogradouro(novoCliente.getEndereco().getLogradouro());
            endereco.setNumero(novoCliente.getEndereco().getNumero());
            endereco.setCep(novoCliente.getEndereco().getCep());
        }

        return clienteRepository.saveAndFlush(cliente);
    }

    // Delete
    public void deletarCliente(Long id) {
        var cliente = clienteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado."));

        boolean possuiReparos = !reparoRepository.findByEquipamento_Cliente_Id(id).isEmpty();

        if (possuiReparos) {
            throw new RuntimeException("Não é possível excluir o cliente: existe reparo associado.");
        }

        clienteRepository.delete(cliente);
    }
}
