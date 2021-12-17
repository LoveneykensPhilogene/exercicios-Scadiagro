package br.scadiagro.cadastro;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CadastroApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/dsCadasFuncionario.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Tela de cadastro");

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}