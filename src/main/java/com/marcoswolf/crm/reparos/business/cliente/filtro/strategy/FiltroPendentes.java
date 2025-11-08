package com.marcoswolf.crm.reparos.business.cliente.filtro.strategy;

import com.marcoswolf.crm.reparos.infrastructure.entities.Cliente;
import com.marcoswolf.crm.reparos.infrastructure.repositories.ReparoRepository;

public class FiltroPendentes implements ClienteFiltroStrategy {
    private final ReparoRepository reparoRepository;

    public FiltroPendentes(ReparoRepository reparoRepository) {
        this.reparoRepository = reparoRepository;
    }

    @Override
    public boolean aplicar(Cliente cliente) {
        return reparoRepository.existsByEquipamento_Cliente_IdAndPagamento_PagoFalse(cliente.getId());
    }
}
