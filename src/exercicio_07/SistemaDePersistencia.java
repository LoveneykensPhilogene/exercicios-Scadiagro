package exercicio_07;

import exercicio_05.Funcionario;
import exercicio_06.ListaEncadeada;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SistemaDePersistencia {

    public static void main(String[] args) {
        PersistenciaDeDados persistence = new PersistenciaDeDados();

        ListaEncadeada listaDosFuncionarios = new ListaEncadeada();
        Funcionario funcionario = new Funcionario(12, "Jose", new BigDecimal(1500.00), LocalDate.parse("2021/06/10", DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        Funcionario funcionario1 = new Funcionario(1, "Carlos", new BigDecimal(1d), LocalDate.parse("2020/08/20", DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        Funcionario funcionario2 = new Funcionario(13, "Pierre", new BigDecimal(200.56), LocalDate.parse("2019/09/30", DateTimeFormatter.ofPattern("yyyy/MM/dd")));

        listaDosFuncionarios.adicionarPrimeiroElemento(funcionario);
        listaDosFuncionarios.adicionarPrimeiroElemento(funcionario1);
        listaDosFuncionarios.adicionarPrimeiroElemento(funcionario2);
        persistence.setDados(listaDosFuncionarios);
        persistence.gravarDadosDosFuncionarios(persistence.getDados());

        persistence.lerDadosDosFuncionarios();


    }
}
