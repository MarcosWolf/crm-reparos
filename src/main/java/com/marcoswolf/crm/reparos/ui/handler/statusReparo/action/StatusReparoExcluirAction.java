package com.marcoswolf.crm.reparos.ui.handler.statusReparo.action;

import com.marcoswolf.crm.reparos.business.statusReparo.StatusReparoComandoService;
import com.marcoswolf.crm.reparos.infrastructure.entities.StatusReparo;
import com.marcoswolf.crm.reparos.ui.handler.statusReparo.dto.StatusReparoFormData;
import com.marcoswolf.crm.reparos.ui.handler.statusReparo.validator.StatusReparoValidator;
import com.marcoswolf.crm.reparos.ui.utils.AlertService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class StatusReparoExcluirAction implements StatusReparoAction {
    private final StatusReparoComandoService statusReparoComandoService;
    private final StatusReparoValidator validator;
    private final AlertService alertService;

    public StatusReparoExcluirAction(
        StatusReparoComandoService statusReparoComandoService,
        @Qualifier("statusReparoExcluirValidator") StatusReparoValidator validator,
        AlertService alertService
    ) {
        this.statusReparoComandoService = statusReparoComandoService;
        this.validator = validator;
        this.alertService = alertService;
    }

    @Override
    public boolean execute(StatusReparo statusReparo, StatusReparoFormData data) {
        if (statusReparo == null) return false;

        boolean confirmar = alertService.confirm(
                "Confirmar exclusão",
                "Deseja realmente excluir este status de reparo?"
        );
        if (!confirmar) return false;

        try {
            validator.validar(data, statusReparo);
            statusReparoComandoService.deletar(statusReparo.getId());
            alertService.info("Sucesso", "Status de reparo removido com sucesso!");
            return true;
        } catch (Exception e) {
            alertService.error("Erro ao excluir", e.getMessage());
            return false;
        }
    }
}