package exercicio_07;

import exercicio_05.Funcionario;
import exercicio_06.Elemento;
import exercicio_06.ListaEncadeada;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PersistenciaDeDados {
    private ListaEncadeada dados;

    public PersistenciaDeDados(ListaEncadeada dados) {
        this.dados = dados;
    }

    public PersistenciaDeDados() {
    }

    private Exception exception;

    private List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
    private List<Funcionario> listaPorNome = new ArrayList<>();
    private List<Funcionario> listaPorCodigo = new ArrayList<>();
    private final String arquivoFuncionario = "Funcionario.dat";
    private final String arquivoOrdenadoPorNome = "funcionario_idx02.idx";
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

    public void gravarDadosOrdenadosPorCodigo(ListaEncadeada dadosDosFuncionarios) {
        try (BufferedWriter bufferFuncionario = new BufferedWriter(new FileWriter(arquivoOrdenadoPorCodigo))) {
            Elemento elemento = dadosDosFuncionarios.getInicio();

            bufferFuncionario.write("Código" + formatarNomeDoFuncionario("Nome", 100) + "Salario         " + "Data");

            bufferFuncionario.newLine();

            while (elemento != null) {

                listaPorCodigo.add(new Funcionario(elemento.getFuncionario().getCod_funcionario(), elemento.getFuncionario().getNome(), elemento.getFuncionario().getValorSalario(), elemento.getFuncionario().getDataAdmissao()));

                elemento = elemento.getProximaPosicao();
            }
            listaPorCodigo.sort(Comparator.comparingInt(Funcionario::getCod_funcionario));
            for (Funcionario funcionario : listaPorCodigo) {
                String codigo = formatarCodigoDoFuncionario(funcionario.getCod_funcionario(), 6);
                String nome = formatarNomeDoFuncionario(funcionario.getNome(), 100);
                String salario = formatarSalario(funcionario.getValorSalario().toString(), 13);
                LocalDate data = funcionario.getDataAdmissao();
                bufferFuncionario.write(codigo + nome + salario + data);
                bufferFuncionario.newLine();

            }

            bufferFuncionario.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void gravarDadosOrdenadosPorNome(ListaEncadeada dadosDosFuncionarios) {
        try (BufferedWriter bufferFuncionario = new BufferedWriter(new FileWriter(arquivoOrdenadoPorNome))) {
            Elemento elemento = dadosDosFuncionarios.getInicio();


            bufferFuncionario.write("Código" + formatarNomeDoFuncionario("Nome", 100) + "Salario         " + "Data");

            bufferFuncionario.newLine();

            while (elemento != null) {
                listaPorNome.add(new Funcionario(elemento.getFuncionario().getCod_funcionario(), elemento.getFuncionario().getNome(), elemento.getFuncionario().getValorSalario(), elemento.getFuncionario().getDataAdmissao()));

                elemento = elemento.getProximaPosicao();

            }

            listaPorNome.sort(Comparator.comparing(funcionario -> funcionario.getNome()));

            for (Funcionario funcionario : listaPorNome) {
                String codigo = formatarCodigoDoFuncionario(funcionario.getCod_funcionario(), 6);
                String nome = formatarNomeDoFuncionario(funcionario.getNome(), 100);
                String salario = formatarSalario(funcionario.getValorSalario().toString(), 13);
                LocalDate data = funcionario.getDataAdmissao();
                bufferFuncionario.write(codigo + nome + salario + data);
                bufferFuncionario.newLine();

            }

            bufferFuncionario.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void lerDadosDosFuncionarios() {

        listaFuncionarios = new ArrayList<Funcionario>();
        String codigo = "";
        try (BufferedReader readerFuncionario = new BufferedReader(new InputStreamReader(new FileInputStream(arquivoFuncionario)))) {
            String nome = "";
            String salario = "";
            String date = "";

            String line = readerFuncionario.readLine();

            while (line != null) {

                if (!line.substring(0, 6).equalsIgnoreCase("código")) {

                    codigo = line.substring(0, 6);
                    nome = line.substring(6, 100).replace(" ", "");
                    salario = line.substring(106, 122);
                    date = line.substring(122, line.length());
                    listaFuncionarios.add(new Funcionario(Integer.parseInt(codigo), nome, new BigDecimal(salario), LocalDate.parse(date)));

                }
                line = readerFuncionario.readLine();
            }
            System.out.println("\n=== Lista sem indexação ===\n");
            for (Funcionario funcionario : listaFuncionarios) {
                System.out.println(funcionario);
            }
            readerFuncionario.close();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public void lerDadosIndexadosPorCodigo() {
        int codigo = 0;
        String nome = "";
        String salario = "";
        String data = "";
        listaPorCodigo = new ArrayList<>();
        try (BufferedReader readerPorNome = new BufferedReader(new InputStreamReader(new FileInputStream(arquivoOrdenadoPorCodigo)))) {
            String line = readerPorNome.readLine();
            while (line != null) {

                if (!line.substring(0, 6).equalsIgnoreCase("código")) {
                    codigo = Integer.parseInt(line.substring(0, 6));
                    nome = line.substring(6, 100).replace(" ", "");
                    salario = line.substring(106, 122);
                    data = line.substring(122, line.length());
                    listaPorCodigo.add(new Funcionario(codigo, nome, new BigDecimal(salario), LocalDate.parse(data)));

                }

                line = readerPorNome.readLine();

            }
            System.out.println("\n=== Lista indexada pelo código do funcionário ===\n");
            for (Funcionario funcionario : listaPorCodigo) {
                System.out.println(funcionario);
            }
            readerPorNome.close();

        } catch (
                Exception e) {
            System.out.println(e);
        }

    }

    public void lerDadosIndexadosPorNome() {
        int codigo = 0;
        String nome = "";
        String salario = "";
        String data = "";
        listaPorNome = new ArrayList<>();
        try (BufferedReader readerPorNome = new BufferedReader(new InputStreamReader(new FileInputStream(arquivoOrdenadoPorNome)))) {
            String line = readerPorNome.readLine();
            while (line != null) {

                if (!line.substring(0, 6).equalsIgnoreCase("código")) {
                    codigo = Integer.parseInt(line.substring(0, 6));
                    nome = line.substring(6, 100).replace(" ", "");
                    salario = line.substring(106, 122);
                    data = line.substring(122, line.length());
                    listaPorNome.add(new Funcionario(codigo, nome, new BigDecimal(salario), LocalDate.parse(data)));

                }

                line = readerPorNome.readLine();

            }

            System.out.println("=== Lista indexada pelo nome ===\n");
            for(Funcionario funcionario:listaPorNome){
                System.out.println(funcionario);
            }

            readerPorNome.close();

        } catch (
                Exception e) {
            System.out.println(e);
        }

    }

    public ListaEncadeada getDados() {
        return dados;
    }

    public void setDados(ListaEncadeada dados) {
        this.dados = dados;
    }

    public List<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }

    public List<Funcionario> getListaPorNome() {
        return listaPorNome;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
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
