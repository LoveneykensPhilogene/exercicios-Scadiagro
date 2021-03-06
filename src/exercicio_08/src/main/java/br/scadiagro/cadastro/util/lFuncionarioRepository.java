package br.scadiagro.cadastro.util;

import br.scadiagro.cadastro.config.lFormat;
import br.scadiagro.cadastro.model.Funcionario;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class lFuncionarioRepository implements IFuncionario {

    private static Funcionario oFuncionario;
    private lFormat oFormat;
    private String sPath;
    private String sFile;
    private String separator;
    private String separatorData;
    private BufferedReader buffReader;
    private BufferedWriter buffWriter;
    private List<Funcionario> listFucionario;
    private List<Funcionario> listaPorNome = new ArrayList<>();
    private List<Funcionario> listaPorCodigo = new ArrayList<>();
    private final String sArquivoFuncionario = "db//Funcionario.dat";
    private final String sArquivoOrdenadoPorNome = "db//funcionario_idx02.idx";
    private final String sArquivoOrdenadoPorCodigo = "db//funcionario_idx01.idx";

    public lFuncionarioRepository() {
    }

    public lFuncionarioRepository(Funcionario oFuncionario, lFormat oFormat, String sPath, String sFile, String separator, BufferedReader buffReader, BufferedWriter buffWriter, List<Funcionario> listFucionario) {
        this.oFuncionario = oFuncionario;
        this.oFormat = oFormat;
        this.sPath = sPath;
        this.sFile = sFile;
        this.separator = separator;
        this.buffReader = buffReader;
        this.buffWriter = buffWriter;
        this.listFucionario = listFucionario;
    }

    public lFuncionarioRepository(Funcionario oFuncionario, String sPath, String sFile) {
        this.oFuncionario = oFuncionario;
        this.sPath = sPath;
        this.sFile = sFile;
    }

    @Override
    public void CadastrarFuncionario(List<Funcionario> oListFuncionario) throws Exception {

        if (oListFuncionario != null) {
            listFucionario = new ArrayList<>();
            listFucionario.addAll(oListFuncionario);
            setSeparator(" ".repeat(4));
            setSeparatorData(getSeparator().repeat(3));
            GravarDadosOrdenadosPorCodigo(oListFuncionario);
            gravarDadosOrdenadosPorNome(oListFuncionario);

            setsFile(sArquivoFuncionario);
            setsPath(getsFile());
            this.buffWriter = new BufferedWriter(new FileWriter(getsPath()));
            this.oFormat = new lFormat();
            buffWriter.write("C??digo" + getSeparator() + oFormat.formatarNomeDoFuncionario("Nome", 100) + "Sal??rio" + getSeparatorData() + "Data");
            buffWriter.newLine();

            for (Funcionario ofun : oListFuncionario) {
                setoFuncionario(ofun);
                String sCodigo = this.oFormat.formatarCodigoDoFuncionario(getoFuncionario().getnCodFuncionario().intValue(), 6);
                String sNome = this.oFormat.formatarNomeDoFuncionario(getoFuncionario().getsNome().toUpperCase(), 100);
                String sSalario = this.oFormat.formatarSalario(getoFuncionario().getnSalario().toString(), 13);
                buffWriter.write(sCodigo + getSeparator() + sNome + sSalario + getSeparator() + getoFuncionario().getdData());

                buffWriter.newLine();
            }
            buffWriter.close();

        } else {
            listFucionario = new ArrayList<>();
            listFucionario.addAll(oListFuncionario);
            setSeparator(" ".repeat(4));
            setSeparatorData(getSeparator().repeat(3));
            GravarDadosOrdenadosPorCodigo(oListFuncionario);
            gravarDadosOrdenadosPorNome(oListFuncionario);

            setsFile(sArquivoFuncionario);
            setsPath(getsFile());
            this.buffWriter = new BufferedWriter(new FileWriter(getsPath()));
            this.oFormat = new lFormat();
            buffWriter.write("C??digo" + getSeparator() + oFormat.formatarNomeDoFuncionario("Nome", 100) + "Sal??rio" + getSeparatorData() + "Data");
            buffWriter.newLine();
            throw new NullPointerException("N??o existe");
        }

    }

    public void gravarDadosOrdenadosPorNome(List<Funcionario> dadosDosFuncionarios) throws IOException {
        this.oFormat = new lFormat();
        buffWriter = new BufferedWriter(new FileWriter(sArquivoOrdenadoPorNome));

        buffWriter.write("C??digo" + getSeparator() + oFormat.formatarNomeDoFuncionario("Nome", 100) + "Salario" + getSeparatorData() + "Data");

        buffWriter.newLine();

        dadosDosFuncionarios.sort(Comparator.comparing(Funcionario::getsNome));

        for (Funcionario oFuncionario : dadosDosFuncionarios) {
            String codigo = oFormat.formatarCodigoDoFuncionario(oFuncionario.getnCodFuncionario().intValue(), 6);
            String nome = oFormat.formatarNomeDoFuncionario(oFuncionario.getsNome(), 100);
            String salario = oFormat.formatarSalario(oFuncionario.getnSalario().toString(), 13);
            LocalDate data = oFuncionario.getdData();
            buffWriter.write(codigo + getSeparator() + nome + salario + getSeparator() + data);
            buffWriter.newLine();

        }

        buffWriter.close();

    }

    public void GravarDadosOrdenadosPorCodigo(List<Funcionario> dadosDosFuncionarios) throws IOException {
        this.oFormat = new lFormat();
        buffWriter = new BufferedWriter(new FileWriter(sArquivoOrdenadoPorCodigo));

        buffWriter.write("C??digo" + getSeparator() + oFormat.formatarNomeDoFuncionario("Nome", 100) + "Salario" + getSeparatorData() + "Data");

        buffWriter.newLine();

        dadosDosFuncionarios.sort(Comparator.comparing(Funcionario::getnCodFuncionario));

        for (Funcionario oFuncionario : dadosDosFuncionarios) {
            String codigo = oFormat.formatarCodigoDoFuncionario(oFuncionario.getnCodFuncionario().intValue(), 6);
            String nome = oFormat.formatarNomeDoFuncionario(oFuncionario.getsNome(), 100);
            String salario = oFormat.formatarSalario(oFuncionario.getnSalario().toString(), 13);
            LocalDate data = oFuncionario.getdData();
            buffWriter.write(codigo + getSeparator() + nome + salario + getSeparator() + data);
            buffWriter.newLine();

        }

        buffWriter.close();

    }

    @Override
    public Funcionario BuscarUmFuncionarioPorCodigo(Long nCodigo) throws Exception {
        this.listFucionario = BuscarTodosOsFuncionarios("", getsArquivoFuncionario());
        for (Funcionario oFuncionario : getListFucionario()) {
            if (oFuncionario.getnCodFuncionario().equals(nCodigo)) {
                return oFuncionario;
            }
        }
        return oFuncionario;
    }

    @Override
    public List<Funcionario> BuscarTodosOsFuncionarios(String sPath, String sFile) throws Exception {
        String sCodigo = "";
        String sNome = "";
        String sSalario;
        String sData = "";
        if (sPath.isEmpty()) {
            setsFile(sFile);
        } else {
            setsFile(getsPath() + getsFile());
        }

        this.buffReader = new BufferedReader(new InputStreamReader(new FileInputStream(getsFile())));
        String lines = buffReader.readLine();
        this.listFucionario = new ArrayList<>();
        while (lines != null) {
            if (!lines.substring(0, 6).equalsIgnoreCase("C??digo")) {
                sCodigo = lines.substring(0, 6);
                sNome = lines.substring(6, 100).replace(" ", "");
                sSalario = lines.substring(106, 130).replace(" ", "");
                sData = lines.substring(130, lines.length());
                this.listFucionario.add(new Funcionario(Long.parseLong(sCodigo), sNome, new BigDecimal(sSalario), LocalDate.parse(sData, DateTimeFormatter.ofPattern("yyyy-MM-dd"))));

            }
            lines = buffReader.readLine();

        }

        return getListFucionario();
    }

    @Override
    public Funcionario BuscarFuncionarioCOmMenorSalario(String sTipoFile) {
        try {
            this.listFucionario = BuscarTodosOsFuncionarios("", sTipoFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        BigDecimal nMenorSalario = getListFucionario().get(0).getnSalario();
        Funcionario oFuncionario = new Funcionario();
        for (Funcionario oFun : getListFucionario()) {
            if (nMenorSalario.doubleValue() > oFun.getnSalario().doubleValue()) {
                nMenorSalario = oFun.getnSalario();
            }
            if (nMenorSalario == oFun.getnSalario()) {
                oFuncionario = oFun;
            }
        }
        return oFuncionario;
    }

    @Override
    public Funcionario BuscarFuncionarioCOmMaiorSalario(String sTipo) {
        try {
            this.listFucionario = BuscarTodosOsFuncionarios("", sTipo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        BigDecimal nMaiorSalario = getListFucionario().get(0).getnSalario();
        Funcionario oFuncionario = new Funcionario();
        for (Funcionario oFun : getListFucionario()) {
            if (nMaiorSalario.doubleValue() < oFun.getnSalario().doubleValue()) {
                nMaiorSalario = oFun.getnSalario();
            }
            if (nMaiorSalario == oFun.getnSalario()) {
                oFuncionario = oFun;
            }
        }
        return oFuncionario;
    }

    @Override
    public Funcionario AtualizarFuncionario(Funcionario oFunc, Funcionario oFuncAtualizado) throws Exception {
        try {
            this.listFucionario.addAll(BuscarTodosOsFuncionarios("", getsArquivoFuncionario()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Funcionario oFun : getListFucionario()) {
            int indiceFunc = getListFucionario().indexOf(oFun);

            if (oFun.equals(oFunc)) {

                oFun.setnCodFuncionario(oFuncAtualizado.getnCodFuncionario());
                oFun.setsNome(oFuncAtualizado.getsNome());
                oFun.setnSalario(oFuncAtualizado.getnSalario());
                oFun.setdData(oFuncAtualizado.getdData());
                getListFucionario().set(indiceFunc, oFun);
                oFuncAtualizado = oFun;
            }
        }
        CadastrarFuncionario(getListFucionario());

        return oFuncAtualizado;
    }

    @Override
    public void ExcluirFuncionario(Funcionario oFuncExcluido) throws Exception {

        List<Funcionario> oListFuncionarios = BuscarTodosOsFuncionarios("", getsArquivoFuncionario());
        List<Funcionario> listFuncionarioIgual = oListFuncionarios.stream().map(func -> func).filter(fun -> fun.equals(oFuncExcluido)).toList();
        this.listFucionario.removeAll(listFuncionarioIgual);
        CadastrarFuncionario(getListFucionario());
    }

    @Override
    public void CriarArquivo(String sPath, String sArquivo, Funcionario oFuncionario) throws IOException {
        this.oFormat = new lFormat();
        setSeparator(" ".repeat(4));
        setSeparatorData(getSeparator().repeat(3));

        String sCodigo = oFormat.formatarCodigoDoFuncionario(oFuncionario.getnCodFuncionario().intValue(), 6);
        String sNome = oFormat.formatarNomeDoFuncionario(oFuncionario.getsNome(), 100);
        String sSalario = oFormat.formatarSalario(oFuncionario.getnSalario().toString(), 13);
        LocalDate sData = oFuncionario.getdData();

        buffWriter = new BufferedWriter(new FileWriter(sArquivo));

        buffWriter.write("C??digo" + getSeparator() + oFormat.formatarNomeDoFuncionario("Nome", 100) + "Salario" + getSeparatorData() + "Data");

        buffWriter.newLine();

        buffWriter.write(sCodigo + getSeparator() + sNome + sSalario + getSeparator() + sData);
        buffWriter.close();

    }

    @Override
    public BigDecimal BuscarSomaDeTOdosSalarios(String sCaminho) throws Exception {
        List<Funcionario> listFuncDOCaminho = BuscarTodosOsFuncionarios("", sCaminho);
        BigDecimal nSoma = new BigDecimal(0d);

        for (Funcionario oFunDoCaminho : listFuncDOCaminho) {
            nSoma = nSoma.add(oFunDoCaminho.getnSalario());
        }
        return nSoma;
    }

    @Override
    public BigDecimal BuscarMediaSalarios(String sCaminho) throws Exception {
        List<Funcionario> listFuncDOCaminho = BuscarTodosOsFuncionarios("", sCaminho);
        BigDecimal nSomaSalario = BuscarSomaDeTOdosSalarios(sCaminho);
        int nValorFormatado = Integer.parseInt(String.valueOf(nSomaSalario.intValue()));
        BigDecimal nMedia = new BigDecimal(nValorFormatado / listFuncDOCaminho.size()).setScale(2, RoundingMode.DOWN);

        return nMedia;
    }

    @Override
    public void ExcTodosFuncionarios(String sArquivo) throws Exception {
        this.listFucionario = new ArrayList<>();
        CadastrarFuncionario(getListFucionario());
    }

    public String getsArquivoFuncionario() {
        return sArquivoFuncionario;
    }

    public String getsArquivoOrdenadoPorNome() {
        return sArquivoOrdenadoPorNome;
    }

    public String getsArquivoOrdenadoPorCodigo() {
        return sArquivoOrdenadoPorCodigo;
    }

    public String getsPath() {
        return sPath;
    }

    public void setsPath(String sPath) {
        this.sPath = sPath;
    }

    public String getsFile() {
        return sFile;
    }

    public void setsFile(String sFile) {
        this.sFile = sFile;
    }

    public BufferedReader getBuffReader() {
        return buffReader;
    }

    public void setBuffReader(BufferedReader buffReader) {
        this.buffReader = buffReader;
    }

    public BufferedWriter getBuffWriter() {
        return buffWriter;
    }

    public void setBuffWriter(BufferedWriter buffWriter) {
        this.buffWriter = buffWriter;
    }

    public List<Funcionario> getListFucionario() {
        return listFucionario;
    }

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public Funcionario getoFuncionario() {
        return oFuncionario;
    }

    public void setoFuncionario(Funcionario oFuncionario) {
        this.oFuncionario = oFuncionario;
    }

    public String getSeparatorData() {
        return separatorData;
    }

    public void setSeparatorData(String separatorData) {
        this.separatorData = separatorData;
    }
}

