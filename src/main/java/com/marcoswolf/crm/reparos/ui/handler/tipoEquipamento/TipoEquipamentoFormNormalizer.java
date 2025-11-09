package com.marcoswolf.crm.reparos.ui.handler.tipoEquipamento;

import com.marcoswolf.crm.reparos.ui.handler.shared.BaseFormNormalizer;
import com.marcoswolf.crm.reparos.ui.handler.shared.FormNormalizer;
import org.springframework.stereotype.Component;

@Component
public class TipoEquipamentoFormNormalizer implements FormNormalizer<TipoEquipamentoFormData> {

    @Override
    public TipoEquipamentoFormData normalize(TipoEquipamentoFormData data) {
        if (data == null) return null;

        String nome = data.nome() == null ? null : data.nome().trim();

        return new TipoEquipamentoFormData(nome);
    }
}
