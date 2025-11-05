package com.marcoswolf.crm.reparos.business;

import com.marcoswolf.crm.reparos.infrastructure.entities.Cliente;
import com.marcoswolf.crm.reparos.infrastructure.entities.Endereco;
import com.marcoswolf.crm.reparos.infrastructure.repositories.ClienteRepository;
import com.marcoswolf.crm.reparos.infrastructure.repositories.ReparoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final ReparoRepository reparoRepository;

    public ClienteService(ClienteRepository clienteRepository, ReparoRepository reparoRepository) {
        this.clienteRepository = clienteRepository;
        this.reparoRepository = reparoRepository;
    }

    public void salvarCliente(Cliente cliente) {
        clienteRepository.saveAndFlush(cliente);
    }

    public List<Cliente> buscarPorNome(String nome) {
        var clientes = clienteRepository.findByNomeContainingIgnoreCase(nome);

        if (clientes.isEmpty()) {
            throw new RuntimeException("Nenhum Cliente encontrado");
        }

        return clientes;
    }

    public Cliente atualizarCliente(Integer id, Cliente clienteAtualizado) {
        var cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encotrado"));

        cliente.setNome(clienteAtualizado.getNome());
        cliente.setTelefone(clienteAtualizado.getTelefone());
        cliente.setEmail(clienteAtualizado.getEmail());

        if (clienteAtualizado.getEndereco() != null) {
            if (cliente.getEndereco() != null) {
                cliente.setEndereco(new Endereco());
            }

            var endereco = cliente.getEndereco();
            var novoEndereco = clienteAtualizado.getEndereco();

            endereco.setCidade(novoEndereco.getCidade());
            endereco.setEstado(novoEndereco.getEstado());
            endereco.setBairro(novoEndereco.getBairro());
            endereco.setLogradouro(novoEndereco.getLogradouro());
            endereco.setNumero(novoEndereco.getNumero());
            endereco.setCep(novoEndereco.getCep());
        }

        return clienteRepository.saveAndFlush(cliente);
    }

    public void deletarClientePorId(Integer id) {
        var cliente = clienteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        boolean possuiReparos = !reparoRepository.findByEquipamento_Cliente_Id(id).isEmpty();

        if (possuiReparos) {
            throw new RuntimeException("Não é possível excluir o cliente: existem reparos associados");
        }

        clienteRepository.delete(cliente);
    }
}
