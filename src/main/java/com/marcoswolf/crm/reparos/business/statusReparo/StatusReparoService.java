package com.marcoswolf.crm.reparos.business.statusReparo;

import com.marcoswolf.crm.reparos.infrastructure.entities.StatusReparo;
import com.marcoswolf.crm.reparos.infrastructure.repositories.ReparoRepository;
import com.marcoswolf.crm.reparos.infrastructure.repositories.StatusReparoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusReparoService implements StatusReparoConsultaService, StatusReparoComandoService {
    private final StatusReparoRepository statusReparoRepository;
    private final ReparoRepository reparoRepository;

    public StatusReparoService(StatusReparoRepository statusReparoRepository, ReparoRepository reparoRepository) {
        this.statusReparoRepository = statusReparoRepository;
        this.reparoRepository = reparoRepository;
    }

    // Create
    public void salvar(StatusReparo statusReparo) {
        statusReparoRepository.saveAndFlush(statusReparo);
    }

    // Read
    public List<StatusReparo> listarTodos() {
        return statusReparoRepository.findAll();
    }

    public List<StatusReparo> buscarPorNome(String nome) {
        var statusReparos = statusReparoRepository.findByNomeContainingIgnoreCase(nome);

        if (statusReparos.isEmpty()) {
            throw new RuntimeException("Status de Reparo não encontrado.");
        }

        return statusReparos;
    }

    public Long contarReparosPorStatusReparo(Long tipoId) {
        return reparoRepository.countByTipoEquipamentoId(tipoId);
    }

    // Update
    public StatusReparo atualizar(Long id, StatusReparo novoStatusReparo) {
        var statusReparo = statusReparoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Status de Reparo não encontrado."));

        statusReparo.setNome(novoStatusReparo.getNome());

        return statusReparoRepository.saveAndFlush(statusReparo);
    }

    // Delete
    public void deletar(Long id) {
        var statusReparo = statusReparoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Status de Reparo não encontrado."));

        boolean possuiReparo = !reparoRepository.findByStatus_Id(id).isEmpty();

        if (possuiReparo) {
            throw new RuntimeException(("Não é possível excluir o status de reparo: existe reparo associado."));
        }

        statusReparoRepository.delete(statusReparo);
    }
}
