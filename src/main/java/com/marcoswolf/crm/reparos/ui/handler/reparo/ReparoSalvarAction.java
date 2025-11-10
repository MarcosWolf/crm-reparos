package com.marcoswolf.crm.reparos.ui.handler.reparo;

import com.marcoswolf.crm.reparos.business.reparo.ReparoComandoService;
import com.marcoswolf.crm.reparos.infrastructure.entities.Reparo;
import com.marcoswolf.crm.reparos.ui.utils.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReparoSalvarAction implements ReparoAction {
    private final ReparoFormNormalizer normalizer;
    private final ReparoComandoService reparoComandoService;;
    private final ReparoFormToEntityMapper mapper;
    private final ReparoValidator validator;
    private final AlertService alertService;

    @Override
    public boolean execute(Reparo novoReparo, ReparoFormData data) {
        try {
            ReparoFormData normalized = normalizer.normalize(data);
            validator.validar(normalized, novoReparo);

            Reparo reparo = mapper.map(normalized, novoReparo);
            reparoComandoService.salvar(reparo);

            alertService.info("Sucesso", "Reparo salvo com sucesso!");
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