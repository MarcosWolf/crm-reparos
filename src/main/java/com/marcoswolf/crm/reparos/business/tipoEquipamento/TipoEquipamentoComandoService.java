package com.marcoswolf.crm.reparos.business.tipoEquipamento;

import com.marcoswolf.crm.reparos.infrastructure.entities.TipoEquipamento;

public interface ITipoEquipamentoComandoService {
    void salvarTipoEquipamento(TipoEquipamento tipoEquipamento);
    TipoEquipamento atualizarTipoEquipamento(Long id, TipoEquipamento tipoEquipamento);
    void deletarTipoEquipamento(Long id);
}
