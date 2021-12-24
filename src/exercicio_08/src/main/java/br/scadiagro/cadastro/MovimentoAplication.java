package br.scadiagro.cadastro;

import br.scadiagro.cadastro.controllers.ctrlMovimentoFuncionario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MovimentoAplication extends Application {

    public Stage stage;
    public Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primayStage) throws Exception {
        stage = primayStage;
        ctrlMovimentoFuncionario oForm = new ctrlMovimentoFuncionario();
        scene = new Scene(oForm, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Visao geral");
        stage.show();

    }
}
