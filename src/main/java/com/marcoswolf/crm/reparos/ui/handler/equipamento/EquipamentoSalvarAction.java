package com.marcoswolf.crm.reparos.ui.handler.equipamento;

import com.marcoswolf.crm.reparos.business.equipamento.EquipamentoComandoService;
import com.marcoswolf.crm.reparos.infrastructure.entities.Equipamento;
import com.marcoswolf.crm.reparos.ui.utils.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EquipamentoSalvarAction implements EquipamentoAction {
    private final EquipamentoFormNormalizer normalizer;
    private final EquipamentoComandoService equipamentoComandoService;
    private final EquipamentoFormToEntityMapper mapper;
    private final EquipamentoValidator validator;
    private final AlertService alertService;

    @Override
    public boolean execute(Equipamento novoEquipamento, EquipamentoFormData data) {
        try {
            EquipamentoFormData normalized = normalizer.normalize(data);
            validator.validar(normalized, novoEquipamento);

            Equipamento equipamento = mapper.map(normalized, novoEquipamento);
            equipamentoComandoService.salvar(equipamento);

            alertService.info("Sucesso", "Equipamento salvo com sucesso!");
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
