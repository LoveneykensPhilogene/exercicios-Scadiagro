package br.scadiagro.cadastro.controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class CadastroApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
Parent parent=FXMLLoader.load(getClass().getResource("br/scadiagro/cadastro/view/dsCadasFuncionario.fxml"));
Scene scene=new Scene(parent);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}