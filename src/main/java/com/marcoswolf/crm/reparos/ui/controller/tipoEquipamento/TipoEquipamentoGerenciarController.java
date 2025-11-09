package com.marcoswolf.crm.reparos.ui.controller.tipoEquipamento;

import com.marcoswolf.crm.reparos.business.tipoEquipamento.TipoEquipamentoService;
import com.marcoswolf.crm.reparos.infrastructure.entities.TipoEquipamento;
import com.marcoswolf.crm.reparos.ui.config.SpringFXMLLoader;
import com.marcoswolf.crm.reparos.ui.controller.MainViewController;
import com.marcoswolf.crm.reparos.ui.handler.tipoEquipamento.TipoEquipamentoBuscarAction;
import com.marcoswolf.crm.reparos.ui.navigation.ViewNavigator;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TipoEquipamentoGerenciarController {
    private final TipoEquipamentoService tipoEquipamentoService;
    private final MainViewController mainViewController;
    private final ViewNavigator navigator;

    @FXML private AnchorPane rootPane;

    private final TipoEquipamentoBuscarAction buscarAction;

    @FXML private TextField txtBuscar;
    @FXML private TableView<TipoEquipamento> tabelaTipoEquipamento;

    @FXML private TableColumn<TipoEquipamento, String> colNome;
    @FXML private TableColumn<TipoEquipamento, Number> colTotalClientes;
    @FXML private TableColumn<TipoEquipamento, Number> colTotalEquipamentos;
    @FXML private TableColumn<TipoEquipamento, Number> colTotalReparos;

    @FXML
    private void initialize() {
        colNome.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getNome()));
        colTotalClientes.setCellValueFactory(c -> new SimpleLongProperty(
                Optional.ofNullable(c.getValue().getTotalClientes()).orElse(0L)
        ));
        colTotalEquipamentos.setCellValueFactory(c -> new SimpleLongProperty(
                Optional.ofNullable(c.getValue().getTotalEquipamentos()).orElse(0L)
        ));
        colTotalReparos.setCellValueFactory(c -> new SimpleLongProperty(
                Optional.ofNullable(c.getValue().getTotalReparos()).orElse(0L)
        ));

        carregarTipoEquipamentos();

        tabelaTipoEquipamento.setRowFactory(tv -> {
            TableRow<TipoEquipamento> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    TipoEquipamento tipoEquipamentoSelecionado = row.getItem();
                    abrirTelaEdicao(tipoEquipamentoSelecionado);
                }
            });
            return row;
        });
    }

    @FXML
    private void onVoltar() {
        ((AnchorPane) rootPane.getParent()).getChildren().remove(rootPane);
    }

    private void carregarTipoEquipamentos() {
        List<TipoEquipamento> tipoEquipamentos = tipoEquipamentoService.listarTodos();

        tipoEquipamentos.forEach(t -> {
            t.setTotalClientes(tipoEquipamentoService.contarClientesPorTipo(t.getId()));
            t.setTotalEquipamentos(tipoEquipamentoService.contarEquipamentosPorTipo(t.getId()));
            t.setTotalReparos(tipoEquipamentoService.contarReparosPorTipo(t.getId()));
        });

        tabelaTipoEquipamento.setItems(FXCollections.observableList(tipoEquipamentos));
    }

    @FXML
    public void onBuscar() {
        var nome = txtBuscar.getText();
        var tipoEquipamentos = buscarAction.executar(nome);
        tabelaTipoEquipamento.setItems(FXCollections.observableList(tipoEquipamentos));
    }

    @FXML
    public void onNovo() {
        navigator.openView("/fxml/tipoEquipamento/tipoEquipamento-form.fxml",
                mainViewController.getContentArea(),
                null);
    }

    @FXML
    public void abrirTelaEdicao(TipoEquipamento tipoEquipamento) {
        navigator.openView("/fxml/tipoEquipamento/tipoEquipamento-form.fxml",
                mainViewController.getContentArea(),
                tipoEquipamento);
    }
}
