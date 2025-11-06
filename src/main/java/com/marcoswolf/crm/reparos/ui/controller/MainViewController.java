package com.marcoswolf.crm.reparos.ui.controller;

import com.marcoswolf.crm.reparos.ui.config.SpringFXMLLoader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class MainViewController {
    private final SpringFXMLLoader fxmlLoader;

    @FXML
    private VBox rootVbox;

    @FXML
    private AnchorPane contentArea;

    @FXML
    private MenuItem menuCadastrarCliente;

    @FXML
    public void initialize() {
        menuCadastrarCliente.setOnAction(e -> abrirCadastroCliente());
    }

    private void abrirCadastroCliente() {
        Pane telaCliente = fxmlLoader.load(
                getClass().getResource("/fxml/cliente/cliente-form.fxml")
        );

        contentArea.getChildren().setAll(telaCliente);

        AnchorPane.setTopAnchor(telaCliente, 0.0);
        AnchorPane.setRightAnchor(telaCliente, 0.0);
        AnchorPane.setBottomAnchor(telaCliente, 0.0);
        AnchorPane.setLeftAnchor(telaCliente, 0.0);
    }
}
