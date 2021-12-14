package exercicio_06;

import exercicio_05.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SistemaDeEncadeamento {

    private static ListaEncadeada listaEncadeada;
    // private static PersistenciaDeDados persistencia;
    private static Funcionario funcionario;
    private static Funcionario funcionario1;
    private static Funcionario funcionario2;
    private static Funcionario funcionario3;

    public static void main(String[] args) {
        funcionario = new Funcionario(12, "Jose", new BigDecimal(1500.00), LocalDate.parse("02/09/21", DateTimeFormatter.ofPattern("dd/MM/yy")));
        funcionario1 = new Funcionario(40, "Pierre", new BigDecimal(3000.50), LocalDate.parse("06/09/21", DateTimeFormatter.ofPattern("dd/MM/yy")));
        funcionario2 = new Funcionario(13, "Carie", new BigDecimal(2000.59), LocalDate.parse("07/09/21", DateTimeFormatter.ofPattern("dd/MM/yy")));
        funcionario3 = new Funcionario(16, "Ontoine", new BigDecimal(20.59), LocalDate.parse("03/09/21", DateTimeFormatter.ofPattern("dd/MM/yy")));

        listaEncadeada = new ListaEncadeada();
        listaEncadeada.adicionarElementoNoInicio(funcionario3);
        listaEncadeada.adicionarElementoNoInicio(funcionario);
        listaEncadeada.adicionarElementoNoInicio(funcionario2);
        listaEncadeada.adicionarElementoNoInicio(funcionario1);

        final String authPorNome = "nome";
        final String authPorCodigo = "id";
        String valorDaEntrada_1 = "";
        String valorDaEntrada_2 = "";

        Scanner entradaDeDados = new Scanner(System.in);
        listaEncadeada.instrucao();

        try (entradaDeDados) {

            System.out.println("Iniciar o sistema apertando 1: ");

            if (Integer.parseInt(entradaDeDados.nextLine()) == 1) {
                listaEncadeada.abrirSistema(Integer.parseInt(entradaDeDados.nextLine()));

                System.out.println("Você quer ver a lista de funcionários ordenada por código \n" + "digita *id* : ");
                valorDaEntrada_1 = entradaDeDados.nextLine();

                if (authPorCodigo.equalsIgnoreCase(valorDaEntrada_1)) {
                    listaEncadeada.ordenarPeloCodigoDoElemento();
                } else {
                    listaEncadeada.instrucao();
                }

                System.out.println("\nVocê quer ver a lista de funcionários ordenada por nome \n" + "digita *nome* : ");
                valorDaEntrada_2 = entradaDeDados.nextLine();

                if (authPorNome.equalsIgnoreCase(valorDaEntrada_2)) {
                    listaEncadeada.ordenarPeloNomeElemento();
                } else {
                    listaEncadeada.instrucao();
                }
            } else if (Integer.parseInt(entradaDeDados.nextLine()) == 0) {
                System.out.println(new Exception("Saiu do sistema!"));
            } else {
                listaEncadeada.instrucao();
            }
            entradaDeDados.close();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

    }

    public static ListaEncadeada getListaEncadeada() {
        return listaEncadeada;
    }

    public static Funcionario getFuncionario() {
        return funcionario;
    }

    public static void setFuncionario(Funcionario funcionario) {
        SistemaDeEncadeamento.funcionario = funcionario;
    }

    public static Funcionario getFuncionario1() {
        return funcionario1;
    }

    public static void setFuncionario1(Funcionario funcionario1) {
        SistemaDeEncadeamento.funcionario1 = funcionario1;
    }

    public static Funcionario getFuncionario2() {
        return funcionario2;
    }

    public static void setFuncionario2(Funcionario funcionario2) {
        SistemaDeEncadeamento.funcionario2 = funcionario2;
    }

    public static Funcionario getFuncionario3() {
        return funcionario3;
    }

    public static void setFuncionario3(Funcionario funcionario3) {
        SistemaDeEncadeamento.funcionario3 = funcionario3;
    }
}
