package com.marcoswolf.crm.reparos.ui.handler.tipoEquipamento;

import com.marcoswolf.crm.reparos.ui.handler.shared.IFormNormalizer;
import org.springframework.stereotype.Component;

@Component
public class TipoEquipamentoFormNormalizer implements IFormNormalizer<TipoEquipamentoFormData> {

    @Override
    public TipoEquipamentoFormData normalize(TipoEquipamentoFormData data) {
        if (data == null) return null;

        String nome = data.nome() == null ? null : data.nome().trim();

        return new TipoEquipamentoFormData(nome);
    }
}
