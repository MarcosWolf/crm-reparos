package com.marcoswolf.crm.reparos.ui.controller;

import com.marcoswolf.crm.reparos.business.EstadoService;
import com.marcoswolf.crm.reparos.infrastructure.entities.Estado;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ClienteFormController {
    private final EstadoService estadoService;

    @FXML
    private ComboBox<Estado> comboEstado;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private void initialize() {
        carregarEstados();
    }

    private void carregarEstados() {
        List<Estado> estados = estadoService.listarTodos();

        Estado selecione = new Estado();
        selecione.setId(0L);
        selecione.setNome("Selecione");

        estados.add(0, selecione);

        comboEstado.getItems().setAll(estados);
        comboEstado.getSelectionModel().selectFirst();

        comboEstado.setConverter(new StringConverter<>() {
            @Override
            public String toString(Estado estado) {
                return estado == null ? "" : estado.getNome();
            }

            @Override
            public Estado fromString(String string) {
                return comboEstado.getItems().stream()
                        .filter(e -> e.getNome().equals(string))
                        .findFirst()
                        .orElse(null);
            }
        });
    }

    @FXML
    private void onCancelar() {
        ((AnchorPane) rootPane.getParent()).getChildren().remove(rootPane);
    }

}