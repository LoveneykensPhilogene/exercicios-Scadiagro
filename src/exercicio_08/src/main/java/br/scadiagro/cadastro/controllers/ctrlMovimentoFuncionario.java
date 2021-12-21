package br.scadiagro.cadastro.controllers;

import br.scadiagro.cadastro.CadastroApplication;
import br.scadiagro.cadastro.MovimentoAplication;
import br.scadiagro.cadastro.model.Funcionario;
import br.scadiagro.cadastro.util.lFuncionarioRepository;
import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class cltrMovimentoFuncionario implements Initializable {

    private List<Funcionario> todosFuncionario = new ArrayList<>();
    public TableView<Funcionario> tbFUncionarios = new TableView<>();
    public TableColumn<Funcionario, Long> tbColunaCodigo = new TableColumn<>();
    public TableColumn<Funcionario, String> tbColunaNome = new TableColumn<>();
    public TableColumn<Funcionario, BigDecimal> tbColunaSalario = new TableColumn<>();
    public TableColumn<Funcionario, LocalDate> tbColunaData = new TableColumn<>();
    public ObservableList<Funcionario> observableList = FXCollections.observableArrayList();

    public cltrMovimentoFuncionario() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            DefinirTabela();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    @FXML
    public void BtnSair(ActionEvent event) throws IOException {
       /* MovimentoAplication oMovimentoApplication=new MovimentoAplication();
       oMovimentoApplication.start(new Stage());
       Node node= (Node) event.getSource();
       oMovimentoApplication.stage= (Stage) node.getScene().getWindow();*/

    }

    @FXML
    public void BtnNovo(ActionEvent event) throws Exception{
        cltrCadasFuncionario cadasFuncionario=new cltrCadasFuncionario();
        CadastroApplication c=new CadastroApplication();
       c.start(new Stage());
       c.stage.show();

    }

    @FXML
    public void MenuRelatorio(ActionEvent event){
        try {
            DefinirTabela();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void DefinirTabela() throws Exception {
        lFuncionarioRepository repository=new lFuncionarioRepository();
        todosFuncionario=repository.BuscarTodosOsFuncionarios("","Funcionario.dat");
        tbColunaCodigo.setCellValueFactory(cod->new SimpleObjectProperty(cod.getValue().getnCodFuncionario().longValue()));
        tbColunaNome.setCellValueFactory(nome->new SimpleStringProperty(nome.getValue().getsNome()));
        tbColunaSalario.setCellValueFactory(salario->new SimpleObjectProperty(salario.getValue().getnSalario()));
        tbColunaData.setCellValueFactory(data-> new SimpleObjectProperty(data.getValue().getdData()));
        observableList.setAll( todosFuncionario);
        tbFUncionarios.setItems(observableList);


    }



}
