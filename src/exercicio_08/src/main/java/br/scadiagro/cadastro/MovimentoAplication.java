package br.scadiagro.cadastro;

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
    public void start(Stage primayStage) throws IOException {
        stage=primayStage;

        Parent root = FXMLLoader.load(getClass().getResource("view/dsListaFuncionario.fxml"));
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Visao geral");
        stage.show();

    }
}
