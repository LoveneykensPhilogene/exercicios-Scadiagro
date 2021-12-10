package exercicio_06;

import exercicio_05.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SistemaDeEncadeamento {

    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario(12, "Jose", new BigDecimal(1500), LocalDate.parse("02/09/21", DateTimeFormatter.ofPattern("dd/MM/yy")));
        Funcionario funcionario1 = new Funcionario(1, "Jose", new BigDecimal(3000.5), LocalDate.parse("02/09/21", DateTimeFormatter.ofPattern("dd/MM/yy")));
        Funcionario funcionario2 = new Funcionario(13, "Jose", new BigDecimal(2000.59), LocalDate.parse("02/09/21", DateTimeFormatter.ofPattern("dd/MM/yy")));

        ListaEncadeada listaEncadeada = new ListaEncadeada();
        listaEncadeada.adicionarPrimeiroElemento(funcionario);
        listaEncadeada.adicionarPrimeiroElemento(funcionario1);
        listaEncadeada.adicionarPrimeiroElemento(funcionario2);
         listaEncadeada.ordenarPeloNomeDoElemento();

    }
}
