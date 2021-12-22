package br.scadiagro.cadastro.controllers;

import br.scadiagro.cadastro.CadastroApplication;
import br.scadiagro.cadastro.ControleApplication;
import br.scadiagro.cadastro.model.Funcionario;
import br.scadiagro.cadastro.util.lFuncionarioRepository;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ctrlMovimentoFuncionario implements Initializable {

    @FXML
    private List<Funcionario> todosFuncionario = new ArrayList<>();

    @FXML
    public TableView<Funcionario> tbRelatorio = new TableView<>();

    @FXML
    public TableColumn<Funcionario, Long> tbColunaCodigo = new TableColumn<>();

    @FXML
    public TableColumn<Funcionario, String> tbColunaNome = new TableColumn<>();

    @FXML
    public TableColumn<Funcionario, BigDecimal> tbColunaSalario = new TableColumn<>();

    @FXML
    public TableColumn<Funcionario, LocalDate> tbColunaData = new TableColumn<>();

    public ObservableList<Funcionario> observableList;

    @FXML
    public Button btnSair;

    public ctrlMovimentoFuncionario() {
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
        btnSair.getScene().getWindow();
    }

    @FXML
    public void BtnNovo(ActionEvent event) throws Exception {
        ctrlCadasFuncionario cadasFuncionario = new ctrlCadasFuncionario();
        CadastroApplication appCadastro = new CadastroApplication();
        appCadastro.start(new Stage());
        appCadastro.stage.show();

    }

    @FXML
    public void DefinirTabela() throws Exception {
        lFuncionarioRepository oRepository = new lFuncionarioRepository();
        todosFuncionario = oRepository.BuscarTodosOsFuncionarios("", oRepository.getsArquivoFuncionario());

        tbColunaCodigo.setCellValueFactory(cod -> new SimpleObjectProperty<>(cod.getValue().getnCodFuncionario()));
        tbColunaNome.setCellValueFactory(nome -> new SimpleStringProperty(nome.getValue().getsNome()));
        tbColunaSalario.setCellValueFactory(sal -> new SimpleObjectProperty<>(sal.getValue().getnSalario()));
        tbColunaData.setCellValueFactory(dat -> new SimpleObjectProperty<>(dat.getValue().getdData()));
        observableList = FXCollections.observableArrayList(todosFuncionario);
        tbRelatorio.setItems(observableList);
        tbRelatorio.setEditable(true);


    }

    @FXML
    public void ListaOrdenadaPorCodigo(ActionEvent actionEvent) throws Exception {
        lFuncionarioRepository oRepository = new lFuncionarioRepository();
        List<Funcionario> listCodigo = new ArrayList<>();
        tbRelatorio.setEditable(true);
        tbRelatorio.refresh();

        listCodigo = oRepository.BuscarTodosOsFuncionarios("", oRepository.getsArquivoOrdenadoPorCodigo());

        tbColunaCodigo.setCellValueFactory(cod -> new SimpleObjectProperty<>(cod.getValue().getnCodFuncionario()));
        tbColunaNome.setCellValueFactory(nome -> new SimpleStringProperty(nome.getValue().getsNome()));
        tbColunaSalario.setCellValueFactory(sal -> new SimpleObjectProperty<>(sal.getValue().getnSalario()));
        tbColunaData.setCellValueFactory(dat -> new SimpleObjectProperty<>(dat.getValue().getdData()));
        observableList = FXCollections.observableArrayList(listCodigo);
        tbRelatorio.setItems(observableList);
        tbRelatorio.setEditable(true);


    }

    @FXML
    public void ListaOrdenadaPorNome(ActionEvent actionEvent) throws Exception {
        lFuncionarioRepository oRepository = new lFuncionarioRepository();
        List<Funcionario> listPorNome = new ArrayList<>();
        tbRelatorio.setEditable(true);
        tbRelatorio.refresh();

        listPorNome = oRepository.BuscarTodosOsFuncionarios("", oRepository.getsArquivoOrdenadoPorNome());

        tbColunaCodigo.setCellValueFactory(cod -> new SimpleObjectProperty<>(cod.getValue().getnCodFuncionario()));
        tbColunaNome.setCellValueFactory(nome -> new SimpleStringProperty(nome.getValue().getsNome()));
        tbColunaSalario.setCellValueFactory(sal -> new SimpleObjectProperty<>(sal.getValue().getnSalario()));
        tbColunaData.setCellValueFactory(dat -> new SimpleObjectProperty<>(dat.getValue().getdData()));
        observableList = FXCollections.observableArrayList(listPorNome);
        tbRelatorio.setItems(observableList);
        tbRelatorio.setEditable(true);


    }

    @FXML
    public void MenorSalario(ActionEvent actionEvent) {
        lFuncionarioRepository oRepository = new lFuncionarioRepository();
        Funcionario oFuncionario = oRepository.BuscarFuncionarioCOmMenorSalario(oRepository.getsArquivoFuncionario());
        todosFuncionario.clear();

        tbColunaCodigo.setCellValueFactory(cod -> new SimpleObjectProperty<>(cod.getValue().getnCodFuncionario()));
        tbColunaNome.setCellValueFactory(nome -> new SimpleStringProperty(nome.getValue().getsNome()));
        tbColunaSalario.setCellValueFactory(sal -> new SimpleObjectProperty<>(sal.getValue().getnSalario()));
        tbColunaData.setCellValueFactory(dat -> new SimpleObjectProperty<>(dat.getValue().getdData()));
        observableList = FXCollections.observableArrayList(oFuncionario);
        tbRelatorio.setItems(observableList);
        tbRelatorio.setEditable(true);
    }

    @FXML
    public void MaiorSalario(ActionEvent actionEvent) {
        lFuncionarioRepository oRepository = new lFuncionarioRepository();
        Funcionario oFuncionario = oRepository.BuscarFuncionarioCOmMaiorSalario(oRepository.getsArquivoFuncionario());
        todosFuncionario.clear();

        tbColunaCodigo.setCellValueFactory(cod -> new SimpleObjectProperty<>(cod.getValue().getnCodFuncionario()));
        tbColunaNome.setCellValueFactory(nome -> new SimpleStringProperty(nome.getValue().getsNome()));
        tbColunaSalario.setCellValueFactory(sal -> new SimpleObjectProperty<>(sal.getValue().getnSalario()));
        tbColunaData.setCellValueFactory(dat -> new SimpleObjectProperty<>(dat.getValue().getdData()));
        observableList = FXCollections.observableArrayList(oFuncionario);
        tbRelatorio.setItems(observableList);
        tbRelatorio.setEditable(true);
    }

    @FXML
    public void MostrarTelaDeControle(ActionEvent event) throws IOException {
        ControleApplication oAppControle = new ControleApplication();
        oAppControle.start(new Stage());
        oAppControle.stage.show();
    }

    @FXML
    public void BtnEcluirTodos(ActionEvent actionEvent) throws Exception {

    }


}



