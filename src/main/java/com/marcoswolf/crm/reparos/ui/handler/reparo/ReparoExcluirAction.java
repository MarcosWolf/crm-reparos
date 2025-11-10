package com.marcoswolf.crm.reparos.ui.handler.reparo;

import com.marcoswolf.crm.reparos.business.reparo.ReparoComandoService;
import com.marcoswolf.crm.reparos.infrastructure.entities.Reparo;
import com.marcoswolf.crm.reparos.ui.utils.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReparoExcluirAction implements ReparoAction {
    private final ReparoComandoService reparoComandoService;
    private final AlertService alertService;

    @Override
    public boolean execute(Reparo reparo, ReparoFormData data) {
        if (reparo == null) return false;

        boolean confirmar = alertService.confirm(
                "Confirmar exclusão",
                "Deseja realmente excluir este reparo?"
        );
        if (!confirmar) return false;

        try {
            reparoComandoService.deletar(reparo.getId());
            alertService.info("Sucesso", "Reparo removido com sucesso!");
            return true;
        } catch (Exception e) {
            alertService.error("Erro ao excluir", e.getMessage());
            return false;
        }
    }
}
