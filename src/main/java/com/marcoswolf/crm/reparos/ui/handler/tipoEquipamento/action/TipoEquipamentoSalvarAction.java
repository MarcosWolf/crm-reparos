package com.marcoswolf.crm.reparos.ui.handler.tipoEquipamento;

import com.marcoswolf.crm.reparos.business.tipoEquipamento.TipoEquipamentoComandoService;
import com.marcoswolf.crm.reparos.infrastructure.entities.TipoEquipamento;
import com.marcoswolf.crm.reparos.ui.utils.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TipoEquipamentoSalvarAction implements TipoEquipamentoAction {
    private final TipoEquipamentoFormNormalizer normalizer;
    private final TipoEquipamentoComandoService tipoEquipamentoComandoService;
    private final TipoEquipamentoFormToEntityMapper mapper;
    private final TipoEquipamentoValidator validator;
    private final AlertService alertService;

    @Override
    public boolean execute(TipoEquipamento novoTipoEquipamento, TipoEquipamentoFormData data) {
        try {
            TipoEquipamentoFormData normalized = normalizer.normalize(data);
            validator.validar(normalized, novoTipoEquipamento);

            TipoEquipamento tipoEquipamento = mapper.map(normalized, novoTipoEquipamento);
            tipoEquipamentoComandoService.salvar(tipoEquipamento);

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
