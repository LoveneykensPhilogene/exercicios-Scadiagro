package br.scadiagro.cadastro.controllers;

import br.scadiagro.cadastro.model.Funcionario;
import br.scadiagro.cadastro.util.lFuncionarioRepository;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javafx.application.Platform.exit;

public class ctrlMovimentoFuncionario extends AnchorPane {

    @FXML
    private List<Funcionario> todosFuncionarios = new ArrayList<>();

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

    @FXML
    public Button btnSair;

    @FXML
    private AnchorPane root;

    @FXML
    private MenuButton mnbConsulta;

    @FXML
    private MenuItem mItemCodigo;

    @FXML
    private MenuItem mItemNome;

    @FXML
    private Button tlbNovoCadastro;

    @FXML
    private Button tlbRelatorio;

    @FXML
    private Button tbnSair;

    public TextField teste;

    private Funcionario oFunProcurado;

    public ObservableList<Funcionario> observableList;

    public ctrlMovimentoFuncionario() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/br/scadiagro/cadastro/view/dsListaFuncionario.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        fxmlLoader.load();
        DefinirTabela();
    }

    @FXML
    public void BtnSair(ActionEvent event) throws IOException {
        exit();
    }

    @FXML
    public void BtnNovo(ActionEvent event) throws Exception {
        ctrlCadasFuncionario cadFuncionario = new ctrlCadasFuncionario(this.getScene());
        cadFuncionario.abrir();
        DefinirTabela();
    }

    @FXML
    public void MostrarTelaDeControle(ActionEvent event) throws IOException {
        ctrlControle oCtrlControle = new ctrlControle(this.getScene());
        oCtrlControle.Abrir();
    }

    @FXML
    public void DefinirTabela() throws Exception {
        lFuncionarioRepository oRepository = new lFuncionarioRepository();
        todosFuncionarios = oRepository.BuscarTodosOsFuncionarios("", oRepository.getsArquivoFuncionario());

        tbColunaCodigo.setCellValueFactory(cod -> new SimpleObjectProperty<>(cod.getValue().getnCodFuncionario()));
        tbColunaNome.setCellValueFactory(nome -> new SimpleStringProperty(nome.getValue().getsNome()));
        tbColunaSalario.setCellValueFactory(sal -> new SimpleObjectProperty<>(sal.getValue().getnSalario()));
        tbColunaData.setCellValueFactory(dat -> new SimpleObjectProperty<>(dat.getValue().getdData()));
        observableList = FXCollections.observableArrayList(todosFuncionarios);
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
        observableList = FXCollections.observableArrayList(listPorNome);
        tbRelatorio.setItems(observableList);
        tbRelatorio.setEditable(true);

    }

    @FXML
    public void MenorSalario(ActionEvent actionEvent) {
        lFuncionarioRepository oRepository = new lFuncionarioRepository();
        Funcionario oFuncionario = oRepository.BuscarFuncionarioCOmMenorSalario(oRepository.getsArquivoFuncionario());

        observableList = FXCollections.observableArrayList(oFuncionario);
        tbRelatorio.setItems(observableList);
        tbRelatorio.setEditable(true);
    }

    @FXML
    public void MaiorSalario(ActionEvent actionEvent) {
        lFuncionarioRepository oRepository = new lFuncionarioRepository();
        Funcionario oFuncionario = oRepository.BuscarFuncionarioCOmMaiorSalario(oRepository.getsArquivoFuncionario());

        observableList = FXCollections.observableArrayList(oFuncionario);
        tbRelatorio.setItems(observableList);
        tbRelatorio.setEditable(true);
    }

    @FXML
    public void MenuAtualizarFuncionario(ActionEvent actionEvent) throws Exception {
        ctrlAtualizar oCtrlAtualizar = new ctrlAtualizar(this.getScene());
        oCtrlAtualizar.getStage().setTitle("Atualizar funcionário");
        lFuncionarioRepository oRepository = new lFuncionarioRepository();
        oFunProcurado = new Funcionario();
        oFunProcurado = tbRelatorio.getSelectionModel().getSelectedItem();
        oRepository.CriarArquivo("", "db//update//selectFuncionario.dat", oFunProcurado);
        oCtrlAtualizar.Abrir();

    }

    public void BtnAtualizarFuncionario(String sNome, BigDecimal nSalario) throws Exception {
        lFuncionarioRepository oRepository = new lFuncionarioRepository();
        oFunProcurado = oRepository.BuscarFuncionarioCOmMenorSalario("db//update//selectFuncionario.dat");
        Funcionario oFunAtulizado = oRepository.AtualizarFuncionario(oFunProcurado, new Funcionario(oFunProcurado.getnCodFuncionario(), sNome.toUpperCase()
                , nSalario, oFunProcurado.getdData()));
        observableList = FXCollections.observableArrayList(oFunAtulizado);
        tbRelatorio.setItems(observableList);
        tbRelatorio.setEditable(true);
        tbRelatorio.refresh();
        DefinirTabela();
    }

    @FXML
    public void MenuBuscarFuncionario(ActionEvent actionEvent) throws IOException {
        ctrlBuscarFuncionario oCtrlBuscar = new ctrlBuscarFuncionario(this.getScene());
        oCtrlBuscar.Abrir();
    }

    public void BuscarFunPeloCodigo(Long nCodigo) throws Exception {
        lFuncionarioRepository oRepository = new lFuncionarioRepository();
        Funcionario oFunComCodigo = oRepository.BuscarUmFuncionarioPorCodigo(nCodigo);
        observableList = FXCollections.observableArrayList(oFunComCodigo);
        tbRelatorio.setItems(observableList);
        tbRelatorio.setEditable(true);
        tbRelatorio.refresh();
        DefinirTabela();
    }

    @FXML
    public void BtnEcluirTodos(ActionEvent actionEvent) throws Exception {
        lFuncionarioRepository oRepository = new lFuncionarioRepository();
        oRepository.ExcTodosFuncionarios(oRepository.getsArquivoFuncionario());
        DefinirTabela();
    }

    @FXML
    public void BtnExcFuncionario() throws Exception {
        lFuncionarioRepository oRepository = new lFuncionarioRepository();
        if (tbRelatorio.getSelectionModel().getSelectedItem() != null) {
            Funcionario oFunc = tbRelatorio.getSelectionModel().getSelectedItem();
            oRepository.ExcluirFuncionario(oFunc);
            tbRelatorio.setEditable(true);
            tbRelatorio.refresh();
            DefinirTabela();
        } else {
            Alert oAlert = new Alert(Alert.AlertType.CONFIRMATION, "ERRO!");
            oAlert.setHeaderText("Deve selecionar o funcionário que deseja excluir");
        }
    }

}



