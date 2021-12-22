package br.scadiagro.cadastro.controllers;

import br.scadiagro.cadastro.CadastroApplication;
import br.scadiagro.cadastro.MovimentoAplication;
import br.scadiagro.cadastro.model.Funcionario;
import br.scadiagro.cadastro.util.lFuncionarioRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PreencherCampoCodigo();
    }

    @FXML
    public void BtnCadastrar(ActionEvent event) throws Exception {

        VerificarCamposVazios();
        Funcionario oFuncionario = new Funcionario();
        dPData = new DatePicker();
        lFuncionarioRepository oRepository = new lFuncionarioRepository();
        todosFuncionario = oRepository.BuscarTodosOsFuncionarios("", oRepository.getsArquivoFuncionario());

        oFuncionario.setnCodFuncionario(Long.parseLong(lTxtCodigo.getText()));
        oFuncionario.setsNome(sTxtNome.getText().toUpperCase());
        oFuncionario.setnSalario(new BigDecimal(nTxtSalario.getText()));
        oFuncionario.setdData(LocalDate.now());
        if (todosFuncionario.contains(oFuncionario.getnCodFuncionario()) == true) {
            oFuncionario.setnCodFuncionario(Long.parseLong(String.valueOf((int) Math.random() * 100000)));
        }
        todosFuncionario.add(oFuncionario);
        oLFuncionario = new lFuncionarioRepository();
        oLFuncionario.CadastrarFuncionario(todosFuncionario);

        LimparCampos();
        PreencherCampoCodigo();

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

        Long nValorRandom = Long.valueOf((int) (Math.random() * 100000));
        lTxtCodigo.setText(String.valueOf(nValorRandom));
    }

    public void LimparCampos() {
        lTxtCodigo.setText("");
        sTxtNome.setText("");
        nTxtSalario.setText("");
        dPData = new DatePicker();
        dPData.setPromptText("");
    }

    public void VerificarCamposVazios() {
        if (sTxtNome.getText().equals("")) {
            sTxtNome.setText(null);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro!");
            alert.setHeaderText("Campo não preenchido");
            setEmpty(true);
            alert.show();
        } else if (nTxtSalario.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro!");
            alert.setHeaderText("Campo não preenchido");
            setEmpty(true);
            alert.show();
        } else {

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
