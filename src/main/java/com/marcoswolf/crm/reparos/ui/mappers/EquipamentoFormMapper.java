package com.marcoswolf.crm.reparos.ui.mappers;

import com.marcoswolf.crm.reparos.infrastructure.entities.Cliente;
import com.marcoswolf.crm.reparos.infrastructure.entities.Equipamento;
import com.marcoswolf.crm.reparos.infrastructure.entities.TipoEquipamento;
import org.springframework.stereotype.Component;

@Component
public class EquipamentoFormMapper {
    public Equipamento toEntity(TipoEquipamento tipoEquipamento, String marca,
                                String modelo, String numeroSerie,
                                Cliente cliente) {

        Equipamento equipamento = new Equipamento();
        equipamento.setTipoEquipamento(tipoEquipamento);
        equipamento.setMarca(marca);
        equipamento.setModelo(modelo);
        equipamento.setNumeroSerie(numeroSerie);
        equipamento.setCliente(cliente);

        return equipamento;
    }
}
