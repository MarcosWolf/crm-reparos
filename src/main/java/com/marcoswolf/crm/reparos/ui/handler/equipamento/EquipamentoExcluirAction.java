package com.marcoswolf.crm.reparos.ui.handler.equipamento;

import com.marcoswolf.crm.reparos.business.equipamento.EquipamentoComandoService;
import com.marcoswolf.crm.reparos.infrastructure.entities.Equipamento;
import com.marcoswolf.crm.reparos.ui.utils.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EquipamentoExcluirAction implements EquipamentoAction {
    private final EquipamentoComandoService equipamentoComandoService;
    private final AlertService alertService;

    @Override
    public boolean execute(Equipamento equipamento, EquipamentoFormData data) {
        if (equipamento == null) return false;

        boolean confirmar = alertService.confirm(
                "Confirmar exclusão",
                "Deseja realmente excluir este tipo de equipamento?"
        );
        if (!confirmar) return false;

        try {
            equipamentoComandoService.deletar(equipamento.getId());
            alertService.info("Sucesso", "Equipamento removido com sucesso!");
            return true;
        } catch (Exception e) {
            alertService.error("Erro ao excluir", e.getMessage());
            return false;
        }
    }
}
