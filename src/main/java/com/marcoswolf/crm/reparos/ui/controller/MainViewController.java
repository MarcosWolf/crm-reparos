package com.marcoswolf.crm.reparos.ui.controller;

import com.marcoswolf.crm.reparos.ui.navigation.ViewNavigator;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainViewController {
    private final ViewNavigator navigator;

    @FXML private VBox rootVbox;
    @FXML private AnchorPane contentArea;

    // Cliente
    @FXML private MenuItem menuCadastrarCliente;
    @FXML private MenuItem menuGerenciarCliente;

    // Equipamento
    @FXML private MenuItem menuCadastrarEquipamento;
    @FXML private MenuItem menuGerenciarEquipamento;
    @FXML private MenuItem menuCadastrarTipoEquipamento;
    @FXML private MenuItem menuGerenciarTipoEquipamento;

    @FXML
    public void initialize() {
        menuCadastrarCliente.setOnAction(e -> open("/fxml/cliente/cliente-form.fxml"));
        menuGerenciarCliente.setOnAction(e -> open("/fxml/cliente/cliente-gerenciar.fxml"));

        menuCadastrarTipoEquipamento.setOnAction(e -> open("/fxml/tipoEquipamento/tipoEquipamento-form.fxml"));
        menuGerenciarTipoEquipamento.setOnAction(e -> open("/fxml/tipoEquipamento/tipoEquipamento-gerenciar.fxml"));
    }

    private void open(String fxmlPath) {
        navigator.openView(fxmlPath, contentArea, null);
    }

    public AnchorPane getContentArea() {
        return contentArea;
    }
}