package br.scadiagro.cadastro.controllers;

import br.scadiagro.cadastro.ControleApplication;
import br.scadiagro.cadastro.MovimentoAplication;
import br.scadiagro.cadastro.util.lFuncionarioRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

public class ctrlControle implements Initializable {
    @FXML
    private Label lblValorTotal;

    @FXML
    private Label lblValorMedia;

    @FXML
    private Button btnVisualizar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    public void BtnVisualizarControle(ActionEvent actionEvent) throws Exception {
        BuscarSomaDeTodosSalarios();
        BuscarSalarioMedia();
    }

    public void BuscarSomaDeTodosSalarios() throws Exception {
        lFuncionarioRepository oFunc = new lFuncionarioRepository();
        BigDecimal nSoma = oFunc.BuscarSomaDeTOdosSalarios(oFunc.getsArquivoFuncionario());
        lblValorTotal.setText("R$ " + String.valueOf(nSoma));
    }

    public void BuscarSalarioMedia() throws Exception {
        lFuncionarioRepository oFunc = new lFuncionarioRepository();
        BigDecimal nMedia = oFunc.BuscarMediaSalarios(oFunc.getsArquivoFuncionario());
        lblValorMedia.setText("R$ " + String.valueOf(nMedia));
    }

    @FXML
    public void BtnFecharControle(ActionEvent actionEvent) throws IOException {
        ControleApplication oControle = new ControleApplication();
        oControle.start(new Stage());
        oControle.stage.close();
        MovimentoAplication oMovimento = new MovimentoAplication();
        oMovimento.start(new Stage());
        oMovimento.stage.show();
    }

}
