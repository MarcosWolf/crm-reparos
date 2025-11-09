package com.marcoswolf.crm.reparos.ui.controller.statusReparo;

import com.marcoswolf.crm.reparos.infrastructure.entities.StatusReparo;
import com.marcoswolf.crm.reparos.ui.handler.statusReparo.ExcluirAction;
import com.marcoswolf.crm.reparos.ui.handler.statusReparo.FormData;
import com.marcoswolf.crm.reparos.ui.handler.statusReparo.SalvarAction;
import com.marcoswolf.crm.reparos.ui.interfaces.DataReceiver;
import com.marcoswolf.crm.reparos.ui.navigation.ViewNavigator;
import com.marcoswolf.crm.reparos.ui.utils.TextFieldUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@RequiredArgsConstructor
public class FormController implements DataReceiver<StatusReparo> {
    private final ViewNavigator navigator;
    private final SalvarAction salvarAction;
    private final ExcluirAction excluirAction;
    private StatusReparo novoStatusReparo;

    @FXML private AnchorPane rootPane;
    @FXML private Label lblTitulo;
    @FXML private TextField txtNome;
    @FXML private Button btnExcluir;

    @FXML
    public void initialize() {
        configurarCampos();
    }

    private void configurarCampos() {
        TextFieldUtils.aplicarLimite(txtNome, 50);
    }

    @Override
    public void setData(StatusReparo statusReparo) {
        this.novoStatusReparo = statusReparo;
        preencherFormulario(statusReparo);
    }

    private void preencherFormulario(StatusReparo statusReparo) {
        if (statusReparo == null) {
            lblTitulo.setText("Cadastrar Status de Reparo");
            btnExcluir.setVisible(false);
            limparCampos();
            return;
        }

        lblTitulo.setText("Editar Status de Reparo");
        btnExcluir.setVisible(true);

        txtNome.setText(statusReparo.getNome());
    }

    @FXML
    private void salvar() {
        var data = new FormData(
                txtNome.getText()
        );

        boolean sucesso = salvarAction.execute(novoStatusReparo, data);
        if (sucesso) voltar();
    }

    @FXML
    private void excluir() {
        boolean sucesso = excluirAction.execute(novoStatusReparo, null);
        if (sucesso) voltar();
    }

    @FXML
    private void voltar() {
        navigator.openViewRootPane("/fxml/statusReparo/statusReparo-gerenciar.fxml", rootPane, null);
    }

    private void limparCampos() {
        txtNome.clear();
    }
}
