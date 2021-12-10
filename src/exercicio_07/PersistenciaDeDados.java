package exercicio_07;

import exercicio_05.Funcionario;
import exercicio_06.Elemento;
import exercicio_06.ListaEncadeada;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaDeDados {
    private ListaEncadeada dados;

    public PersistenciaDeDados(ListaEncadeada dados) {
        this.dados = dados;
    }

    public PersistenciaDeDados() {
    }

    public ListaEncadeada getDados() {
        return dados;
    }

    public void setDados(ListaEncadeada dados) {
        this.dados = dados;
    }

    private List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
    private final String arquivoFuncionario = "Funcionario.dat";
    private final String arquivoOrdenadoPorNome = "funcionario_idx01.idx";
    private final String arquivoOrdenadoPorCodigo = "funcionario_idx01.idx";

    public void gravarDadosDosFuncionarios(ListaEncadeada dadosDosFuncionarios) {
        try (BufferedWriter bufferFuncionario = new BufferedWriter(new FileWriter(arquivoFuncionario))) {
            Elemento elemento = dadosDosFuncionarios.getInicio();


            bufferFuncionario.write("Código" + formatarNomeDoFuncionario("Nome", 100) + "Salario         " + "Data");

            bufferFuncionario.newLine();

            while (elemento != null) {
                String codigo = formatarCodigoDoFuncionario(elemento.getFuncionario().getCod_funcionario(), 6);
                String nome = formatarNomeDoFuncionario(elemento.getFuncionario().getNome(), 100);
                String salario = formatarSalario(elemento.getFuncionario().getValorSalario().toString(), 13);
                LocalDate data = elemento.getFuncionario().getDataAdmissao();
                bufferFuncionario.write(codigo + nome + salario + data);

                bufferFuncionario.newLine();
                elemento = elemento.getProximaPosicao();

            }

            bufferFuncionario.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void gravarDadosOrdenadosPorCodigo() {
        try (BufferedWriter bufferCodido = new BufferedWriter(new FileWriter(arquivoOrdenadoPorCodigo))) {

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void gravarDadosOrdenadosPorNome() {
        try (BufferedWriter bufferNome = new BufferedWriter(new FileWriter(arquivoOrdenadoPorCodigo))) {

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void lerDadosDosFuncionarios() {
        // limpa a lista de funcionarios
        listaFuncionarios = new ArrayList<Funcionario>();
        try (BufferedReader readerFuncionario = new BufferedReader(new InputStreamReader(new FileInputStream(arquivoFuncionario)))) {
            String codigo = "";
            String nome = "";
            String salario = "";
            String date = "";

            String line = readerFuncionario.readLine();

            while (line != null) {
                // descartando o cabeçalho
                if (!line.substring(0, 6).equalsIgnoreCase("código")) {
                    Funcionario funcionario = new Funcionario();
                    codigo = line.substring(0, 6);
                    nome = line.substring(6, 100).replace(" ", "");
                    salario = line.substring(106, 122);
                    date = line.substring(122, line.length());
                    // aqui insere o funcionario da linha do arquivo em uma lista de funcionários
                    listaFuncionarios.add(new Funcionario(Integer.parseInt(codigo), nome, new BigDecimal(salario), LocalDate.parse(date)));

                }
                line = readerFuncionario.readLine();
            }
            readerFuncionario.close();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public List<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }

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
