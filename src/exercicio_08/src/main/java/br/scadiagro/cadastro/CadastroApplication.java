package br.scadiagro.cadastro;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;



public class CadastroApplication  extends Application {
    public Stage stage;
    public Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage=primaryStage;

            Parent root = FXMLLoader.load(getClass().getResource("view/dsCadasFuncionario.fxml"));
            scene=new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Tela de cadastro");

            stage.show();

    }
    public static void main(String[] args) {

        launch();
    }
}