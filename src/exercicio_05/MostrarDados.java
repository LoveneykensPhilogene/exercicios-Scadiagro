package exercicio_05;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MostrarDados {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        List<Funcionario> todosOsFuncionarios = new ArrayList<>();
        List<BigDecimal> todosSalarios = new ArrayList<>();
        BigDecimal maiorValor = new BigDecimal(0d);
        BigDecimal menorValor = new BigDecimal(0d);
        double valorConvertido = 0d;

        BigDecimal somaDetodosSalarios = new BigDecimal(0d);
        BigDecimal mediaDosSalario = new BigDecimal(0d);

        todosOsFuncionarios.add(new Funcionario(12, "Jose", new BigDecimal(1500), LocalDate.parse("02/09/21", DateTimeFormatter.ofPattern("dd/MM/yy"))));
        todosOsFuncionarios.add(new Funcionario(13, "Analdo", new BigDecimal(6000), LocalDate.parse("20/10/21", DateTimeFormatter.ofPattern("dd/MM/yy"))));
        todosOsFuncionarios.add(new Funcionario(14, "Joe", new BigDecimal(2500), LocalDate.parse("20/01/21", DateTimeFormatter.ofPattern("dd/MM/yy"))));
        todosOsFuncionarios.add(new Funcionario(1, "Joseph", new BigDecimal(20000), LocalDate.parse("03/12/21", DateTimeFormatter.ofPattern("dd/MM/yy"))));
        Funcionario funcionario = new Funcionario();

        try (s) {

            while (todosOsFuncionarios.size() != 0) {

                System.out.println("Informe o codigo do funcionario : \n");
                int codigo = Integer.parseInt(s.nextLine());

                if (codigo != 0) {


                    List<Funcionario> listaDeBuscar = todosOsFuncionarios.stream().map(funcionario1 -> funcionario1).filter(funcionario1 -> funcionario1.getCod_funcionario() == codigo).toList();
                    if (listaDeBuscar.size() != 0) {
                        for (Funcionario funcionariosDaLista : listaDeBuscar) {
                            funcionario = funcionariosDaLista;
                            System.out.println(funcionario + "\n");
                        }
                    } else {
                        funcionario = new Funcionario(codigo);
                        System.out.println("N??o existe funcionario com esse nome : " + codigo + "\n");
                    }

                } else {
                    System.out.println("====Lista dos funcionarios====\n");


                    for (Funcionario funcionarioDeTodos : todosOsFuncionarios) {
                        valorConvertido = funcionarioDeTodos.getValorSalario().doubleValue();
                        todosSalarios.add(BigDecimal.valueOf(valorConvertido).setScale(2, RoundingMode.DOWN));

                        System.out.println(funcionarioDeTodos + "\n");
                    }

                    menorValor = todosSalarios.get(0);

                    for (BigDecimal valorDoFuncionario : todosSalarios) {
                        somaDetodosSalarios = somaDetodosSalarios.add(valorDoFuncionario);
                        mediaDosSalario = somaDetodosSalarios.divide(new BigDecimal(todosSalarios.size()));
                    }
                    for (int indiceDeCadaSalario = 0; indiceDeCadaSalario < todosSalarios.size(); indiceDeCadaSalario++) {
                        if (todosSalarios.get(indiceDeCadaSalario).doubleValue() > maiorValor.doubleValue()) {
                            maiorValor = todosSalarios.get(indiceDeCadaSalario);
                        }

                        if (todosSalarios.get(indiceDeCadaSalario).doubleValue() < menorValor.doubleValue()) {
                            menorValor = todosSalarios.get(indiceDeCadaSalario);
                        }

                    }

                    System.out.println("Total de funcionarios: " + todosOsFuncionarios.size() + "\n" +
                            "Soma dos sal??rios : R$" + somaDetodosSalarios + "\n Media dos salarios : " + mediaDosSalario + "\n Maior Valor : " + maiorValor + "\n" + "Menor valor : " + menorValor);
                    break;
                }

            }

        } catch (
                Exception e) {
            System.out.println(e);
        }
    }
}



