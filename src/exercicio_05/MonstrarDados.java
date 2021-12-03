package exercicio_05;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MonstrarDados {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        Funcionario funcionario = new Funcionario();
        List<Funcionario> todosOsFuncionarios = new ArrayList<>();

        System.out.println("Digita número 1 para iniciar o programa");
        int programStart = Integer.parseInt(s.nextLine());

        try (s) {

            while (programStart != 0 && funcionario.getCod_funcionario() != 0 || programStart != 0 && funcionario.getCod_funcionario() == 0) {

                System.out.println("Digita o codigo do funcionario : ");
                funcionario.setCod_funcionario(Integer.parseInt(s.nextLine()));
                if (funcionario.getCod_funcionario() != 0) {
                    System.out.println("Digita o nome do funcionario : ");
                    funcionario.setNome(s.nextLine());
                    System.out.println("Digita o salário do funcionario : ");
                    funcionario.setValorSalario(s.nextLine());
                    System.out.println("Digita a data de admissão do funcionario : ");
                    funcionario.setDataAdmissao(LocalDate.parse(s.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yy")));

                    todosOsFuncionarios.add(funcionario);
                } else {
                    break;
                }

            }

            System.out.println("os funcionarios: " + todosOsFuncionarios);

        } catch (
                Exception e) {
            System.out.println(e);
        }
    }
}


