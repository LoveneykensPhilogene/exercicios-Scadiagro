package br.scadiagro.cadastro.config;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class lFormat {

    public String formatarCodigoDoFuncionario(int codigo, int tamahoDoCodigo) {

        String codFuncionario = String.valueOf(codigo);
        String prefixoDoCodigo = "0";

        if (codFuncionario.length() < tamahoDoCodigo) {
            int tamanhoDoPrefixo = tamahoDoCodigo - codFuncionario.length();
            codFuncionario = prefixoDoCodigo.repeat(tamanhoDoPrefixo) + codFuncionario;
        } else {

        }

        if (codFuncionario.length() > tamahoDoCodigo) {
            System.out.println(new Exception("Valor maximo do codigo é " + tamahoDoCodigo));
        }

        return codFuncionario;
    }

    public String formatarNomeDoFuncionario(String nome, int tamahoDoNome) {
        String prefixoDoCodigo = " ";

        if (nome.length() < tamahoDoNome) {
            int tamanhoDoPrefixo = tamahoDoNome - nome.length();
            nome = nome + prefixoDoCodigo.repeat(tamanhoDoPrefixo);
        } else {

        }

        if (nome.length() > tamahoDoNome) {
            System.out.println(new Exception("Número maximo de caracter é " + tamahoDoNome));
        }

        return nome;
    }

    public String formatarSalario(String salario, int tamanho) {

        String prefixo = "0";
        String salarioFinal = "";
        String salarioFormatadoComPonto = salario.replace(",", ".");

        BigDecimal salarioFuncionario = new BigDecimal(salarioFormatadoComPonto);

        BigDecimal segunoSalario = BigDecimal.valueOf(salarioFuncionario.doubleValue()).setScale(2);
        int tamanhoDepoisDoPonto = segunoSalario.toString().length() - 3;

        if (tamanhoDepoisDoPonto < tamanho) {
            int tamanhoDoPrefixo = tamanho - tamanhoDepoisDoPonto;
            salarioFinal = prefixo.repeat(tamanhoDoPrefixo) + segunoSalario.toString();
        }

        return salarioFinal;
    }

    public LocalDate formatarData(String data) {

        String formatacaoDaData = data.replace("/", "-");
        LocalDate localDate = LocalDate.parse(formatacaoDaData, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        return localDate;
    }


}
