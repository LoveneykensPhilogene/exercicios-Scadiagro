package exercicio_07;

import exercicio_05.Funcionario;
import exercicio_06.ListaEncadeada;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SistemaDePersistencia {

    private static PersistenciaDeDados persistence;

    private static ListaEncadeada listaDosFuncionarios;
    private static Funcionario funcionario;
    private static Funcionario funcionario1;
    private static Funcionario funcionario2;
    private static int chaveDeEntrada;

    public static void main(String[] args) {
        persistence = new PersistenciaDeDados();

        listaDosFuncionarios = new ListaEncadeada();
        funcionario = new Funcionario(12, "Jose", new BigDecimal(1500.00), LocalDate.parse("2021/06/10", DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        funcionario1 = new Funcionario(1, "Carlos", new BigDecimal(1d), LocalDate.parse("2020/08/20", DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        funcionario2 = new Funcionario(13, "Pierre", new BigDecimal(200.56), LocalDate.parse("2019/09/30", DateTimeFormatter.ofPattern("yyyy/MM/dd")));

        listaDosFuncionarios.adicionarElementoNoInicio(funcionario);
        listaDosFuncionarios.adicionarElementoNoInicio(funcionario1);
        listaDosFuncionarios.adicionarElementoNoInicio(funcionario2);

        persistence.setDados(listaDosFuncionarios);

        Scanner entrada = new Scanner(System.in);
        System.out.println("Logado com sucessso!");
        System.out.println("Se você quer adicionar dados nos arquivos , aperta 1 : \n");
        System.out.println("Se você quer adicionar dados nos arquivos , aperta 2 : ");
        try (entrada) {
            chaveDeEntrada=Integer.parseInt(entrada.nextLine());
            if (chaveDeEntrada == 1) {
                persistence.gravarDadosDosFuncionarios(persistence.getDados());
                persistence.gravarDadosOrdenadosPorCodigo(persistence.getDados());
                persistence.gravarDadosOrdenadosPorNome(persistence.getDados());

                if(persistence.getDados()!=null){
                    System.out.println("Dados gravados com sucesso!");
                }else {
                    System.out.println(new Exception("Lista vazia"));
                }
            }

            if (chaveDeEntrada == 2) {
                persistence.lerDadosDosFuncionarios();

                persistence.lerDadosIndexadosPorCodigo();

                persistence.lerDadosIndexadosPorNome();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
