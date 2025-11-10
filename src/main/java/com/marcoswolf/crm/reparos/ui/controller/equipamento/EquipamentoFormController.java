package com.marcoswolf.crm.reparos.ui.controller.equipamento;

import com.marcoswolf.crm.reparos.business.cliente.IClienteConsultaService;
import com.marcoswolf.crm.reparos.business.tipoEquipamento.ITipoEquipamentoConsultaService;
import com.marcoswolf.crm.reparos.infrastructure.entities.Cliente;
import com.marcoswolf.crm.reparos.infrastructure.entities.Equipamento;
import com.marcoswolf.crm.reparos.infrastructure.entities.TipoEquipamento;
import com.marcoswolf.crm.reparos.ui.handler.equipamento.EquipamentoExcluirAction;
import com.marcoswolf.crm.reparos.ui.handler.equipamento.EquipamentoFormData;
import com.marcoswolf.crm.reparos.ui.handler.equipamento.EquipamentoSalvarAction;
import com.marcoswolf.crm.reparos.ui.interfaces.DataReceiver;
import com.marcoswolf.crm.reparos.ui.navigation.ViewNavigator;
import com.marcoswolf.crm.reparos.ui.utils.ComboBoxUtils;
import com.marcoswolf.crm.reparos.ui.utils.TextFieldUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@RequiredArgsConstructor
public class EquipamentoFormController implements DataReceiver<Equipamento> {
    private final ViewNavigator navigator;
    private final EquipamentoSalvarAction salvarAction;
    private final EquipamentoExcluirAction excluirAction;
    private Equipamento novoEquipamento;

    private final IClienteConsultaService clienteConsultaService;
    private final ITipoEquipamentoConsultaService tipoEquipamentoConsultaService;

    @FXML private AnchorPane rootPane;
    @FXML private Label lblTitulo;
    @FXML private TextField txtMarca, txtModelo, txtNumeroSerie;
    @FXML private Button btnExcluir;
    @FXML private ComboBox<TipoEquipamento> comboTipoEquipamento;
    @FXML private ComboBox<Cliente> comboCliente;

    private static final String GERENCIAR_PATH = "/fxml/equipamento/equipamento-gerenciar.fxml";

    @FXML
    public void initialize() {
        configurarCampos();
        alimentarComboBox();
    }

    private void configurarCampos() {
        TextFieldUtils.aplicarLimite(txtMarca, 50);
        TextFieldUtils.aplicarLimite(txtModelo, 50);
        TextFieldUtils.aplicarLimite(txtNumeroSerie, 150);
    }

    private void alimentarComboBox() {
        ComboBoxUtils.carregarCombo(
                comboCliente,
                clienteConsultaService.listarTodos(),
                Cliente::getNome,
                () -> {
                    Cliente c = new Cliente();
                    c.setId(0L);
                    c.setNome("Selecione");
                    return c;
                }
        );

        ComboBoxUtils.carregarCombo(
                comboTipoEquipamento,
                tipoEquipamentoConsultaService.listarTodos(),
                TipoEquipamento::getNome,
                () -> {
                    TipoEquipamento c = new TipoEquipamento();
                    c.setId(0L);
                    c.setNome("Selecione");
                    return c;
                }
        );
    }

    @Override
    public void setData(Equipamento equipamento) {
        this.novoEquipamento = equipamento;
        preencherFormulario(equipamento);
    }

    private void preencherFormulario(Equipamento equipamento) {
        if (equipamento == null) {
            lblTitulo.setText("Cadastrar Equipamento");
            btnExcluir.setVisible(false);
            limparCampos();
            return;
        }

        lblTitulo.setText("Editar Equipamento");
        btnExcluir.setVisible(true);

        comboTipoEquipamento.setValue(equipamento.getTipoEquipamento());
        txtMarca.setText(equipamento.getMarca());
        txtModelo.setText(equipamento.getModelo());
        txtNumeroSerie.setText(equipamento.getNumeroSerie());
        comboCliente.setValue(equipamento.getCliente());
    }

    @FXML
    private void salvar() {
        var data = new EquipamentoFormData(
                comboTipoEquipamento.getValue(), txtMarca.getText(), txtModelo.getText(),
                txtNumeroSerie.getText(), comboCliente.getValue()
        );

        boolean sucesso = salvarAction.execute(novoEquipamento, data);
        if (sucesso) voltar();
    }

    @FXML
    private void excluir() {
        boolean sucesso = excluirAction.execute(novoEquipamento, null);
        if (sucesso) voltar();
    }

    @FXML
    private void voltar() {
        navigator.openViewRootPane(GERENCIAR_PATH , rootPane, null);
    }

    private void limparCampos() {
        comboTipoEquipamento.getSelectionModel().selectFirst();
        txtMarca.clear();
        txtModelo.clear();
        txtNumeroSerie.clear();
        comboCliente.getSelectionModel().selectFirst();
    }

}
