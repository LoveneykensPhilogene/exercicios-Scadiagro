package exercicio_03;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Emprestimo {

    public static void main(String[] args) {

        final int numeroMaximoDeParcelas = 12;
        double valorDoEmprestimo = 0d;
        int numeroDasParcelas = 0;
        BigDecimal valorDeCadaParcela = new BigDecimal(0d);
        BigDecimal valorTotalDasParcelas = new BigDecimal(0d);
        BigDecimal somaDasParcelas = new BigDecimal(0d);

        DecimalFormat dFormatter = new DecimalFormat("#.00");
        Scanner s = new Scanner(System.in);

        try (s) {
            System.out.println("Digita o valor do emprestimo : ");
            valorDoEmprestimo = s.nextDouble();
            System.out.println("Digita o numero de parcelas: ");
            numeroDasParcelas = s.nextInt();

            if ((valorDoEmprestimo <= 0) && numeroDasParcelas <= 0) {
                System.out.println("Quantidade de parcelas e o valor de emprestimo não podem ser 0.");

            } else {

                if (numeroDasParcelas <= numeroMaximoDeParcelas) {
                    System.out.println("-------------------- \n" + "Parcelas \n" + "--------------------");

                    valorDeCadaParcela = new BigDecimal(valorDoEmprestimo).divide(BigDecimal.valueOf(numeroDasParcelas), 2, RoundingMode.HALF_DOWN);

                    for (int indiceDasParcelas = 1; indiceDasParcelas <= numeroDasParcelas; indiceDasParcelas++) {

                        somaDasParcelas = somaDasParcelas.add(valorDeCadaParcela);

                        if ((indiceDasParcelas == numeroDasParcelas) && (somaDasParcelas.doubleValue() < valorDoEmprestimo)) {
                            BigDecimal restoDoValorDoEmprestimo = new BigDecimal(valorDoEmprestimo).subtract(somaDasParcelas);
                            valorDeCadaParcela = valorDeCadaParcela.add(restoDoValorDoEmprestimo);

                        } else if ((indiceDasParcelas == numeroDasParcelas) && (somaDasParcelas.doubleValue() > valorDoEmprestimo)) {
                            BigDecimal valorAMaisDasomaDasParcelas = somaDasParcelas.subtract(new BigDecimal(valorDoEmprestimo));
                            valorDeCadaParcela = valorDeCadaParcela.subtract(valorAMaisDasomaDasParcelas);

                        } else {
                            valorDeCadaParcela = valorDeCadaParcela;
                        }

                        valorTotalDasParcelas = valorTotalDasParcelas.add(valorDeCadaParcela);
                        System.out.println("Parcela 0" + indiceDasParcelas + ": " + "R$" + valorDeCadaParcela);

                    }

                    System.out.println("-------------------- \n" + "Total .............: R$" + valorTotalDasParcelas);
                } else {
                    System.out.println("O numero maximo de parcelas é 12.");
                }
            }

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage() + "\n" + e.getStackTrace() + "\n" + e.getCause());

        }

    }
}
