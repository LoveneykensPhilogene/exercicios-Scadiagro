package br.scadiagro.cadastro.controllers;

import br.scadiagro.cadastro.model.Funcionario;
import br.scadiagro.cadastro.util.lFuncionarioRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ctrlCadasFuncionario extends AnchorPane {

    @FXML
    private HBox HBoxCadastro;

    @FXML
    private TextField lTxtCodigo;

    @FXML
    private TextField sTxtNome;

    @FXML
    private TextField nTxtSalario;

    @FXML
    private DatePicker dpData;

    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnFechar;

    private List<Funcionario> todosFuncionario = new ArrayList<>();

    private lFuncionarioRepository oLFuncionario;

    private boolean isEmpty;

    public ctrlCadasFuncionario(Scene parentScene) throws IOException {
        super();
        setOwner(parentScene);
        getStage().setTitle("Tela de cadastro");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/scadiagro/cadastro/view/dsCadasFuncionario.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        fxmlLoader.load();

    }

    public void abrir() throws IOException {
        PreencherCampoCodigo();
        this.getStage().showAndWait();
    }

    @FXML
    public void BtnCadastrar(ActionEvent event) throws Exception {

        VerificarCamposVazios();
        Funcionario oFuncionario = new Funcionario();
        lFuncionarioRepository oRepository = new lFuncionarioRepository();
        todosFuncionario = oRepository.BuscarTodosOsFuncionarios("", oRepository.getsArquivoFuncionario());

        oFuncionario.setnCodFuncionario(Long.parseLong(lTxtCodigo.getText()));
        oFuncionario.setsNome(sTxtNome.getText().toUpperCase());
        oFuncionario.setnSalario(new BigDecimal(nTxtSalario.getText()));

        if (dpData.getTypeSelector() != null&&dpData!=null) {
            oFuncionario.setdData(dpData.getValue());
        } else {
            oFuncionario.setdData(LocalDate.now());
        }

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
        Stage stage = (Stage) this.getScene().getWindow();
        stage.close();
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
        dpData = new DatePicker();
        dpData.getEditor().setText("");
    }

    public void VerificarCamposVazios() {
        if (sTxtNome.getText().equals("")|| dpData.getValue()==null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro!");
            alert.setHeaderText("Campo não preenchido");
            setEmpty(true);
            alert.show();
        } else if (nTxtSalario.getText().equals("")||dpData.getValue()==null) {
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

    public Stage getStage() {
        return (Stage) this.getScene().getWindow();
    }

    public void setOwner(Scene parentScene) {
        Scene scene = new Scene(this);

        scene.getStylesheets().setAll(parentScene.getStylesheets());

        Stage stage = new Stage();
        stage.initOwner(parentScene.getWindow());
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.setScene(scene);
    }

}
