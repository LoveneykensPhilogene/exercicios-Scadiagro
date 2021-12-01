package exercicio_03;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Emprestimo {

    public static void main(String[] args) {
        double valorDoEmprestimo = 0d;
        int numeroDasParcelas = 0;
        double valorDeCadaParcela = 0d;
        final int numeroMaximoDeParcelas = 12;
        double valorTotalDasParcelas = 0d;
        int indiceDasParcelas = 1;


        DecimalFormat dFormatter = new DecimalFormat("#.00");
        Scanner s = new Scanner(System.in);
        try (s) {
            System.out.println("Digita o valor do emprestimo : ");
            valorDoEmprestimo = s.nextDouble();
            System.out.println("Digita o numero de parcelas: ");
            numeroDasParcelas = s.nextInt();
            if (numeroDasParcelas <= numeroMaximoDeParcelas) {
                System.out.println("-------------------- \n" + "Parcelas \n" + "--------------------");
                for (indiceDasParcelas = 1; indiceDasParcelas <= numeroDasParcelas; indiceDasParcelas++) {

                    for (int indiceDeCadaValor = 0; indiceDeCadaValor < 1; indiceDeCadaValor++) {

                        valorDeCadaParcela = valorDoEmprestimo / numeroDasParcelas;
                        valorTotalDasParcelas += valorDeCadaParcela;

                    }
                    System.out.println("Parcela 0" + indiceDasParcelas + " :" + dFormatter.format(valorDeCadaParcela));
                }

                System.out.println("-------------------- \n" + "Total .............: R$" + dFormatter.format(valorTotalDasParcelas));


            } else {
                System.out.println("O numero maximo de parcelas é 12.");
            }

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage() + "\n" + e.getStackTrace() + "\n" + e.getCause());

        }

    }
}
