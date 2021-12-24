package br.scadiagro.cadastro.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ctrlBuscarFuncionario extends AnchorPane {
    @FXML
    private AnchorPane root;

    @FXML
    private HBox hBoxDaosFuncionario;

    @FXML
    private TextField nTxtCodigo;

    @FXML
    private Button BtnAtualizar;

    public ctrlBuscarFuncionario() {
    }

    public ctrlBuscarFuncionario(Scene scene) throws IOException {
        super();
        setOwner(scene);
        getStage().setTitle("Pesquisa");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/scadiagro/cadastro/view/dsBuscarFuncionario.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        fxmlLoader.load();
    }

    public void Abrir() {
        this.getStage().show();
    }

    public void BtnBuscarUmFuncionario(ActionEvent actionEvent) throws Exception {
        ctrlMovimentoFuncionario oCtrlFunc = new ctrlMovimentoFuncionario();

        if (nTxtCodigo != null&&nTxtCodigo.getText()!="") {
            oCtrlFunc.BuscarFunPeloCodigo(Long.parseLong(nTxtCodigo.getText()));
            Stage stage = (Stage) this.getScene().getWindow();
            stage.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro!");
            alert.setHeaderText("Campo não preenchido");
            alert.show();
        }

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

    public TextField getnTxtCodigo() {
        return nTxtCodigo;
    }

    public void setnTxtNome(TextField nTxtCodigo) {
        this.nTxtCodigo = nTxtCodigo;
    }
}
