package br.scadiagro.cadastro.controllers;

import br.scadiagro.cadastro.CadastroApplication;
import br.scadiagro.cadastro.MovimentoAplication;
import br.scadiagro.cadastro.model.Funcionario;
import br.scadiagro.cadastro.util.lFuncionarioRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.CustomTextField;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class ctrlCadasFuncionario implements Initializable {

    @FXML
    private TextField lTxtCodigo;

    @FXML
    private TextField sTxtNome;

    @FXML
    private TextField nTxtSalario;

    @FXML
    private DatePicker dPData;

    private List<Funcionario> todosFuncionario = new ArrayList<>();

    private lFuncionarioRepository oLFuncionario;

    private boolean isEmpty;

    int pos = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PreencherCampoCodigo();
    }

    @FXML
    public void BtnCadastrar(ActionEvent event) throws Exception {
      /*  event.hashCode();
        if (!((event.hashCode()) != event.hashCode())) {
            ++pos;
        }
*/
        VerificarCamposVazias();
        Funcionario oFuncionario = new Funcionario();
        dPData = new DatePicker();
        oFuncionario.setnCodFuncionario(Long.parseLong(lTxtCodigo.getText()));
        oFuncionario.setsNome(sTxtNome.getText());
        oFuncionario.setnSalario(new BigDecimal(nTxtSalario.getText()));
        oFuncionario.setdData(LocalDate.now());
        todosFuncionario.add(oFuncionario);
        oLFuncionario = new lFuncionarioRepository();
        oLFuncionario.CadastrarFuncionario(todosFuncionario);
        LimparCampos();
        PreencherCampoCodigo();
        System.out.println(todosFuncionario);
    }

    @FXML
    public void BtnFechar(ActionEvent event) throws IOException {
        MovimentoAplication oMovApplication = new MovimentoAplication();
        CadastroApplication ocadastroApplication = new CadastroApplication();
        oMovApplication.start(new Stage());
        oMovApplication.stage.show();

    }

    @FXML
    public void PreencherCampoCodigo() {
        Random r = new Random();
        Long c = Long.valueOf((int) (Math.random() * 100000));
        lTxtCodigo.setText(String.valueOf(c));
    }

    public void LimparCampos() {
        lTxtCodigo.setText("");
        sTxtNome.setText("");
        nTxtSalario.setText("");
        dPData = new DatePicker();
        dPData.setPromptText("");
    }

    public void VerificarCamposVazias() {
        if (sTxtNome.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro!");
            alert.setHeaderText("Campo não preenchido");
            setEmpty(true);
            alert.show();
        }
        if (nTxtSalario.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro!");
            alert.setHeaderText("Campo não preenchido");
            setEmpty(true);
            alert.show();
        }
    }

    public List<Funcionario> getTodosFuncionario() {
        return todosFuncionario;
    }

    public lFuncionarioRepository getoLFuncionario() {
        return oLFuncionario;
    }

    public void setoLFuncionario(lFuncionarioRepository oLFuncionario) {
        this.oLFuncionario = oLFuncionario;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }
}
