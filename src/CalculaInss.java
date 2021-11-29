import java.util.Scanner;

public class CalculaInss {

    public static void main(String args[]) {
        double aliquotaDaFaixa1 = 7.5;
        double  aliquotaDaFaixa2  = 9;
        double aliqqotaDaFaixa3 = 12;
        double aliquotaDaFaixa4 = 14;
        double salario = 0.0;
        double inss = 0.0;
        Scanner s = new Scanner(System.in);
        try (s) {
            System.out.println(("Digite o salario do colaborador : "));
            salario = s.nextDouble();

            if (salario <= 1100) {
                inss = (salario * aliquotaDaFaixa1) / 100;
            } else if (salario > 1100 && salario <= 2203.48) {
                inss = (salario * aliquotaDaFaixa2) / 100;
            } else if (salario > 2203.48 && salario <= 3305.22) {
                inss = (salario * aliqqotaDaFaixa3) / 100;
            } else if (salario > 3305.22 && salario <= 6433.57) {
                inss = (salario * aliquotaDaFaixa4) / 100;
            } else {
                System.out.println("Valor muito alto.");
            }
            if (inss != 0d) {
                System.out.println("INSS do colaborador é : R$" + inss);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
   }
}
