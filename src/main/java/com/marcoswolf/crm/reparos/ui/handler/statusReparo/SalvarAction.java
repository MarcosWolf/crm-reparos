package com.marcoswolf.crm.reparos.ui.handler.statusReparo;

import com.marcoswolf.crm.reparos.business.statusReparo.StatusReparoComandoService;
import com.marcoswolf.crm.reparos.infrastructure.entities.StatusReparo;
import com.marcoswolf.crm.reparos.ui.utils.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SalvarAction implements Action {
    private final FormNormalizer normalizer;
    private final StatusReparoComandoService statusReparoComandoServicer;
    private final FormToEntityMapper mapper;
    private final Validator validator;
    private final AlertService alertService;

    @Override
    public boolean execute(StatusReparo novoStatusReparo, FormData data) {
        try {
            FormData normalized = normalizer.normalize(data);
            validator.validar(normalized, novoStatusReparo);

            StatusReparo statusReparo = mapper.map(normalized, novoStatusReparo);
            statusReparoComandoServicer.salvar(statusReparo);

            alertService.info("Sucesso", "Tipo de equipamento salvo com sucesso!");
            return true;
        } catch (IllegalArgumentException e) {
            alertService.warn("Campos obrigatórios", e.getMessage());
            return false;
        } catch (Exception e) {
            alertService.error("Erro ao salvar", e.getMessage());
            return false;
        }
    }
}
