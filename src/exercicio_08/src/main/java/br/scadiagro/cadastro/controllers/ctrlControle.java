package br.scadiagro.cadastro.controllers;

import br.scadiagro.cadastro.util.lFuncionarioRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ctrlControle implements Initializable {
    @FXML
    private Label lblValorTotal;

    @FXML
    private Label lblValorMedia;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void BuscarSomeDeTodosSalarios(ActionEvent event) {
        lFuncionarioRepository oFunc = new lFuncionarioRepository();

    }

    @FXML
    public void BuscarSalarioMedia(ActionEvent event) {
        lFuncionarioRepository oFunc = new lFuncionarioRepository();

    }
}
