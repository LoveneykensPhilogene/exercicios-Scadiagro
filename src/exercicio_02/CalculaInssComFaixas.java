package exercicio_02;

import java.util.Scanner;

public class CalculaInssComFaixas {
    public static void main(String[] args) {
        final double aliquotaDaFaixa1 = 7.5;
        final double aliquotaDaFaixa2 = 9;
        final double aliqqotaDaFaixa3 = 12;
        final double aliquotaDaFaixa4 = 14;
        final double salarioMaximumDaFaixa1 = 1100;
        final double salarioMaximumDaFaixa2 = 2203.48;
        final double salarioMaximumDaFaixa3 = 3305.22;
        final double salarioMaximumDaFaixa4 = 6433.57;
        double inssDaFaixa1 = 0d;
        double inssDaFaixa2 = 0d;
        double inssDaFaixa3 = 0d;
        double inssDaFaixa4 = 0d;
        double salario = 0d;

        double inssTotalDasFaixas = 0d;
        Scanner s = new Scanner(System.in);
        try (s) {
            System.out.println(("Digite o salario do colaborador : "));

            salario = s.nextDouble();

            if (salario <= salarioMaximumDaFaixa1) {
                inssDaFaixa1 = (salario * aliquotaDaFaixa1) / 100;
                inssTotalDasFaixas = inssDaFaixa1;
            } else if (salario > salarioMaximumDaFaixa1 && salario <= salarioMaximumDaFaixa2) {
                inssDaFaixa1 = (salarioMaximumDaFaixa1 * aliquotaDaFaixa1) / 100;
                inssDaFaixa2 = ((salario - salarioMaximumDaFaixa1) * 9) / 100;
                inssTotalDasFaixas = inssDaFaixa1 + inssDaFaixa2;
            } else if (salario > salarioMaximumDaFaixa2 && salario <= salarioMaximumDaFaixa3) {
                inssDaFaixa1 = (salarioMaximumDaFaixa1 * aliquotaDaFaixa1) / 100;
                inssDaFaixa2 = ((salarioMaximumDaFaixa2 - salarioMaximumDaFaixa1) * aliquotaDaFaixa2) / 100;
                inssDaFaixa3 = ((salario - 2203.49) * aliqqotaDaFaixa3) / 100;
                inssTotalDasFaixas = inssDaFaixa1 + inssDaFaixa2 + inssDaFaixa3;
            } else if (salario > salarioMaximumDaFaixa3 && salario <= salarioMaximumDaFaixa4) {
                inssDaFaixa1 = (salarioMaximumDaFaixa1 * aliquotaDaFaixa1) / 100;
                inssDaFaixa2 = ((salarioMaximumDaFaixa2 - salarioMaximumDaFaixa1) * aliquotaDaFaixa2) / 100;
                inssDaFaixa3 = ((salarioMaximumDaFaixa3 - 2203.49) * aliqqotaDaFaixa3) / 100;
                inssDaFaixa4 = ((salario - 3305.23) * aliquotaDaFaixa4) / 100;
                inssTotalDasFaixas = inssDaFaixa1 + inssDaFaixa2 + inssDaFaixa3 + inssDaFaixa4;

            } else {
                System.out.println("valor muito alto.");
            }
            if (inssTotalDasFaixas != 0) {
                System.out.println("INSS do colaborador : R$" + inssTotalDasFaixas + " de INSS.");
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
