package br.scadiagro.cadastro.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

public class ctrlAtualizar extends AnchorPane {
    @FXML
    private AnchorPane root;

    @FXML
    private HBox hBoxDaosFuncionario;

    @FXML
    private Label lblNome;

    @FXML
    private TextField sTxtNome;

    @FXML
    private Label lblSalario;

    @FXML
    private TextField nTxtSalario;

    @FXML
    private Button BtnAtualizar;

    public ctrlAtualizar() {

    }

    public ctrlAtualizar(Scene scene) throws IOException {
        super();
        setOwner(scene);
        getStage().setTitle("Tela de busca");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/scadiagro/cadastro/view/dsAtualizarFuncionario.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        fxmlLoader.load();
    }

    public void Abrir() throws Exception {
        this.getStage().show();
    }

    @FXML
    public void BtnAtualizar(ActionEvent actionEvent) throws Exception {
        ctrlMovimentoFuncionario oCtrlMovimento = new ctrlMovimentoFuncionario();
        VerificarCamposVazios();
        oCtrlMovimento.BtnAtualizarFuncionario(sTxtNome.getText(),new BigDecimal(nTxtSalario.getText()));
        LimparCampos();
        oCtrlMovimento.tbRelatorio.setEditable(true);
        oCtrlMovimento.tbRelatorio.refresh();
        oCtrlMovimento.DefinirTabela();
        Stage stage = (Stage) this.getScene().getWindow();
        stage.close();
    }

    public void LimparCampos() {
        sTxtNome.setText("");
        nTxtSalario.setText("");
    }

    public void VerificarCamposVazios() {
        if (sTxtNome.getText().equals("")) {
            sTxtNome.setText(null);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro!");
            alert.setHeaderText("Campo não preenchido");
            alert.show();
        } else if (nTxtSalario.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro!");
            alert.setHeaderText("Campo não preenchido");
            alert.show();
        } else {

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

}
