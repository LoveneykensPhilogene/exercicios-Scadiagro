package br.scadiagro.cadastro.controllers;

import br.scadiagro.cadastro.MovimentoAplication;
import br.scadiagro.cadastro.util.lFuncionarioRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

import static java.nio.file.Files.setOwner;

public class ctrlControle extends AnchorPane implements Initializable {
    @FXML
    private Label lblValorTotal;

    @FXML
    private Label lblValorMedia;

    @FXML
    private Button btnVisualizar;

    public ctrlControle(Scene parentScene) throws IOException {
        super();
        setOwner(parentScene);
        getStage().setTitle("Tela de Controle");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/scadiagro/cadastro/view/dsSalarioTotal.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        fxmlLoader.load();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void Abrir(){
        this.getStage().showAndWait();
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
    public void BtnFecharControle(ActionEvent actionEvent) throws Exception {
        Stage stage = (Stage) this.getScene().getWindow();
        stage.close();
    }

    public Stage getStage() {
        return (Stage) this.getScene().getWindow();
    }

    public void setOwner(Scene parentScene) throws IOException {
        Scene scene = new Scene(this);

        scene.getStylesheets().setAll(parentScene.getStylesheets());

        Stage stage = new Stage();
        stage.initOwner(parentScene.getWindow());
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.setScene(scene);
    }

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }
}
