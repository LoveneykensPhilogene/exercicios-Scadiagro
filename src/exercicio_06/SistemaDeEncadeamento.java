package exercicio_06;

import exercicio_05.Funcionario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SistemaDeEncadeamento {

    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario(12, "Jose", "1500", LocalDate.parse("02/09/21", DateTimeFormatter.ofPattern("dd/MM/yy")));
        Funcionario funcionario1 = new Funcionario(1, "Jose", "1500", LocalDate.parse("02/09/21", DateTimeFormatter.ofPattern("dd/MM/yy")));
        Funcionario funcionario2 = new Funcionario(13, "Jose", "1500", LocalDate.parse("02/09/21", DateTimeFormatter.ofPattern("dd/MM/yy")));
        ListaEncadeada listaEncadeada = new ListaEncadeada();
        listaEncadeada.adicionarPrimeiroElemento(funcionario);
        listaEncadeada.adicionarPrimeiroElemento(funcionario1);
        listaEncadeada.adicionarPrimeiroElemento(funcionario2);
        listaEncadeada.adicionarPrimeiroElemento(funcionario1);
        listaEncadeada.listaDosElementos();

    }
}
