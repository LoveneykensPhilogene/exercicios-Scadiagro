package exercicio_04;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class LerPalavras {
    public static void main(String[] args) {
        int quantidadeDeCarateres = 0;
        int quantidadeDePalavras = 0;
        String conjuntoDepalavras = "";
        String textoInversa = "";
        String ordemInversaDasPalavras = "";
        String texto1 = "É nas manhãs silenciosas " +
                "Quando não tem ninguém perto que ele mostra o que ele é " +
                "Faz nascer do zero, as mais belas criações " +
                "Ele corre os riscos " +
                "Em cada curva tem um pouco dele " +
                "Lapidando cada traço ele eleva a arte, as linhas se encaixam, rimam, ele ilustra a vida, ele também é poeta. " +
                "E por apreço poético, ele que desenha os seus poemas, agora está desenhado em palavras, porque poeta também pode ser poesia.";

        String palavras[] = texto1.replace(",", "").replace(".", "").split(" ");
        List<String> listaDePalavra = new ArrayList<>();

        for (String palavra : palavras) {
            conjuntoDepalavras += palavra;
            quantidadeDePalavras++;
            listaDePalavra.add(palavra);

        }

        for (int indiceTexto = texto1.length() - 1; indiceTexto >= 0; indiceTexto--) {
            textoInversa = textoInversa + Character.toString(texto1.charAt(indiceTexto));

        }

        for (int indiceDePalavras = palavras.length - 1; indiceDePalavras >= 0; indiceDePalavras--) {

            ordemInversaDasPalavras += " " + palavras[indiceDePalavras];

        }
        quantidadeDeCarateres = conjuntoDepalavras.length();

        System.out.println("A quantidade de carateres  : " + quantidadeDeCarateres +
                "\n" + "A quantidade de palavras : " + quantidadeDePalavras);

        for (int posicaoDeCadaPalavra = 0; posicaoDeCadaPalavra < listaDePalavra.size(); posicaoDeCadaPalavra++) {
            SortedMap<String, Integer> valoresRepetidos = new TreeMap<>();

            listaDePalavra.forEach(buscaPalavra -> valoresRepetidos.compute(buscaPalavra, (palavraEncontrada, numeroDeVezes) -> (numeroDeVezes == null) ? 1 : numeroDeVezes + 1));
            valoresRepetidos.entrySet().forEach(palavrasRepetidas -> {
                System.out.println("palavra encontrada : " + palavrasRepetidas.getKey() + "\t" + " : " + palavrasRepetidas.getValue());
            });
        }

        System.out.println("Texto na ordem inverse :" + textoInversa + "\n" + "Ordem inversa palavra por palavra :" + ordemInversaDasPalavras);

    }
}





