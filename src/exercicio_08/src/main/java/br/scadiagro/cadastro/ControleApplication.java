package br.scadiagro.cadastro;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ControleApplication extends Application {
    public Stage stage;
    public Scene scene;

    public ControleApplication() {
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage=primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("view/dsSalarioTotal.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Tela de controle");
        stage.show();
    }


}
