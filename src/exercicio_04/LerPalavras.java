package exercicio_04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LerPalavras {
    public static void main(String[] args) {
        int quantidadeDeCarateres = 0;
        int quantidadeDePalavras = 0;
        int numeroDevezes = 0;
        String conjuntoDepalavras = "";
        String textoInversa = "";
        String ordemInversaDasPalavras = "";
        String texto = "";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Digita o texto :");

            texto = br.readLine();

            String palavras[] = texto.split(" ");

            for (String palavra : palavras) {
                conjuntoDepalavras += palavra;
                System.out.println(palavra);
                quantidadeDePalavras++;
            }
            for (int indiceDePalavras = 0; indiceDePalavras < palavras.length; indiceDePalavras++) {

                System.out.println("palavra é : " + " numero de vezes : " + numeroDevezes);
            }

            for (int indiceTexto = texto.length() - 1; indiceTexto >= 0; indiceTexto--) {
                textoInversa = textoInversa + Character.toString(texto.charAt(indiceTexto));

            }

            for (int indiceDePalavras = palavras.length - 1; indiceDePalavras >= 0; indiceDePalavras--) {

                ordemInversaDasPalavras += " " + palavras[indiceDePalavras];

            }
            quantidadeDeCarateres = conjuntoDepalavras.length();

            System.out.println("A quantidade de carateres  : " + quantidadeDeCarateres +
                    "\n" + "A quantidade de palavras : " + quantidadeDePalavras);

            System.out.println("Texto na ordem inverse :" + textoInversa + "\n" + "Ordem inversa palavra por palavra :" + ordemInversaDasPalavras);

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}





