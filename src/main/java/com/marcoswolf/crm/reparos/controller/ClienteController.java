package com.marcoswolf.crm.reparos.controller;

import com.marcoswolf.crm.reparos.business.cliente.ClienteService;
import com.marcoswolf.crm.reparos.business.cliente.IClienteConsultaService;
import com.marcoswolf.crm.reparos.business.cliente.filtro.ClienteFiltro;
import com.marcoswolf.crm.reparos.business.cliente.filtro.ClienteFiltroService;
import com.marcoswolf.crm.reparos.infrastructure.entities.Cliente;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;
    private final IClienteConsultaService clienteConsultaService;
    private final ClienteFiltroService clienteFiltroService;

    // Create
    @PostMapping
    public ResponseEntity<Cliente> salvarCliente(@RequestBody Cliente cliente) {
        clienteService.salvarCliente(cliente);
        return ResponseEntity.ok(cliente);
    }

    // Read
    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodos() {
        List<Cliente> clientes = clienteConsultaService.listarTodos();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/filtrar")
    public ResponseEntity<List<Cliente>> filtrarClientes(ClienteFiltro filtro) {
        List<Cliente> clientes = clienteFiltroService.aplicarFiltros(filtro);
        return ResponseEntity.ok(clientes);
    }

    // Update
    @PutMapping
    public ResponseEntity<Cliente> atualizarCliente(@RequestParam Long id, @RequestBody Cliente cliente) {
        Cliente novoCliente = clienteService.atualizarCliente(id, cliente);
        return ResponseEntity.ok(novoCliente);
    }

    // Delete
    @DeleteMapping
    public ResponseEntity<String> deletarCliente(@RequestParam Long id) {
        try {
            clienteService.deletarCliente(id);
            return ResponseEntity.ok("Cliente deletado com sucesso.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}