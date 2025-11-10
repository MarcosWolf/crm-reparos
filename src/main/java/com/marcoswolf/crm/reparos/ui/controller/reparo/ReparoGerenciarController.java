package com.marcoswolf.crm.reparos.ui.controller.reparo;

import com.marcoswolf.crm.reparos.business.reparo.ReparoService;
import com.marcoswolf.crm.reparos.infrastructure.entities.Reparo;
import com.marcoswolf.crm.reparos.ui.controller.MainViewController;
import com.marcoswolf.crm.reparos.ui.handler.reparo.ReparoBuscarAction;
import com.marcoswolf.crm.reparos.ui.navigation.ViewNavigator;
import com.marcoswolf.crm.reparos.ui.utils.TableUtils;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReparoGerenciarController {
    private final ReparoService reparoService;
    private final MainViewController mainViewController;
    private final ViewNavigator navigator;

    @FXML private AnchorPane rootPane;

    private final ReparoBuscarAction buscarAction;

    @FXML private TextField txtBuscar;
    @FXML private TableView<Reparo> tabela;

    @FXML private TableColumn<Reparo, String> colNome;

    private static final String FORM_PATH = "/fxml/reparo/reparo-form.fxml";

    @FXML
    private void initialize() {
        configurarTabela();
    }

    private void configurarTabela() {
        instanciarTabela();
        alimentarTabela();

        TableUtils.setDoubleClickAction(tabela, itemSelecionado -> {
            editar(itemSelecionado);
        });

        //centralizarColunas();
    }

    private void instanciarTabela() {
        colNome.setCellValueFactory(c -> new SimpleStringProperty(
                c.getValue().getEquipamento() != null
                ? c.getValue().getEquipamento().getNome()
                : ""
        ));
    }

    @FXML
    private void voltar() {
        ((AnchorPane) rootPane.getParent()).getChildren().remove(rootPane);
    }

    private void alimentarTabela() {
        List<Reparo> reparos = reparoService.listarTodos();

        tabela.setItems(FXCollections.observableList(reparos));
    }

    private void centralizarColunas() {
        //TableUtils.centralizarColuna(col);
    }

    @FXML
    public void buscar() {
        var nome = txtBuscar.getText();
        var reparos = buscarAction.executar(nome);
        tabela.setItems(FXCollections.observableList(reparos));
    }

    @FXML
    public void cadastrar() {
        navigator.openView(FORM_PATH, mainViewController.getContentArea(), null);
    }

    @FXML
    public void editar(Reparo reparo) {
        navigator.openView(FORM_PATH, mainViewController.getContentArea(), reparo);
    }



}
