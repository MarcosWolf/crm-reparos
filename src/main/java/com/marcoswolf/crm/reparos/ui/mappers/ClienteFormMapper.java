package com.marcoswolf.crm.reparos.ui.mappers;

import com.marcoswolf.crm.reparos.infrastructure.entities.Cliente;
import com.marcoswolf.crm.reparos.infrastructure.entities.Endereco;
import com.marcoswolf.crm.reparos.infrastructure.entities.Estado;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Component;

@Component
public class ClienteFormMapper {
    public Cliente toEntity(TextField txtNome, TextField txtTelefone, TextField txtEmail,
                            TextField txtCidade, TextField txtBairro, TextField txtCep,
                            TextField txtLogradouro, TextField txtNumero, ComboBox<Estado> comboEstado) {

        Endereco endereco = Endereco.builder()
                .cidade(txtCidade.getText())
                .bairro(txtBairro.getText())
                .logradouro(txtLogradouro.getText())
                .numero(parseInt(txtNumero))
                .cep(txtCep.getText())
                .estado(comboEstado.getValue())
                .build();

        return Cliente.builder()
                .nome(txtNome.getText())
                .telefone(txtTelefone.getText())
                .email(txtEmail.getText())
                .endereco(endereco)
                .build();
    }

    private Integer parseInt(TextField field) {
        try {
            return Integer.parseInt(field.getText());
        } catch (Exception e) {
            return null;
        }
    }
}
