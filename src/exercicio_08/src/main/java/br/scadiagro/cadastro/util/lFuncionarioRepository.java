package br.scadiagro.cadastro.util;

import br.scadiagro.cadastro.config.lFormat;
import br.scadiagro.cadastro.model.Funcionario;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class lFuncionarioRepository implements IFuncionario {

    private Funcionario oFuncionario;
    private lFormat oFormat;
    private String sPath;
    private String sFile;
    private String separator;
    private String separatorData;
    private BufferedReader buffReader;
    private BufferedWriter buffWriter;
    private List<Funcionario> listFucionario;

    private List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
    private List<Funcionario> listaPorNome = new ArrayList<>();
    private List<Funcionario> listaPorCodigo = new ArrayList<>();
    private final String arquivoOrdenadoPorNome = "funcionario_idx02.idx";
    private final String arquivoOrdenadoPorCodigo = "funcionario_idx01.idx";

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
             separatorData = getSeparator().repeat(3);
             //gravarDadosOrdenadosPorCodigo(oListFuncionario);
             //gravarDadosOrdenadosPorNome(oListFuncionario);

            setsFile("Funcionario.dat");
            setsPath(getsFile());
            this.buffWriter = new BufferedWriter(new FileWriter(getsPath()));
            this.oFormat = new lFormat();
            buffWriter.write("Codigo" + getSeparator() + oFormat.formatarNomeDoFuncionario("Nome", 100) + "Salário" + separatorData + "Data");
            buffWriter.newLine();

            for (Funcionario ofun : oListFuncionario) {
                setoFuncionario(ofun);
                String sCodigo = this.oFormat.formatarCodigoDoFuncionario(getoFuncionario().getnCodFuncionario().intValue(), 6);
                String sNome = this.oFormat.formatarNomeDoFuncionario(getoFuncionario().getsNome(), 100);
                String sSalario = this.oFormat.formatarSalario(getoFuncionario().getnSalario().toString(), 13);
                buffWriter.write(sCodigo + getSeparator() + sNome + sSalario + getSeparator() + getoFuncionario().getdData());
                System.out.println("Pasoou!" + "" + ofun.getsNome() + listFucionario);

                buffWriter.newLine();
            }
            buffWriter.close();

        } else {
            System.out.println("não");
            throw new NullPointerException("Não existe");
        }

    }

    @Override
    public Funcionario BuscarUmFuncionarioPorCodigo(Long nCodigo) {


        return null;
    }

    @Override
    public List<Funcionario> BuscarTodosOsFuncionarios(String sPath, String sFile) throws Exception {
        String sCodigo = "";
        String sNome = "";
        BigDecimal sSalario;
        String sData = "";

        sPath = "";
        sPath += sPath;
        sFile = sPath + sFile;

        setsPath(sPath);
        setsFile(sFile);
        this.buffReader = new BufferedReader(new InputStreamReader(new FileInputStream(getsFile())));
        String lines = buffReader.readLine();
        while (lines != null) {
            if (!(lines.substring(0, 6).equalsIgnoreCase("Código"))) {
                sCodigo = lines.substring(0, 6);

            }
            System.out.println(sCodigo);
        }
        return null;
    }

    @Override
    public Funcionario BuscarFuncionarioCOmMenorSalario(String sTipo) {
        return null;
    }

    @Override
    public Funcionario BuscarFuncionarioCOmMaiorSalario(String sTipo) {
        return null;
    }

    @Override
    public Funcionario AtualizarFuncionario(Funcionario oFuncAtualizado) {
        return null;
    }

    @Override
    public void ExcluirFuncionario(Funcionario oFuncExcluido) {

    }


   public void gravarDadosOrdenadosPorNome(List<Funcionario> oListFuncionario) throws Exception {
        try (BufferedWriter bufferFuncionario = new BufferedWriter(new FileWriter(arquivoOrdenadoPorCodigo))) {

            bufferFuncionario.write("Código" + oFormat.formatarNomeDoFuncionario("Nome", 100) + "Salário" + "Data");

            bufferFuncionario.newLine();

            while (oListFuncionario != null) {

                oListFuncionario.sort(Comparator.comparing(Funcionario::getsNome));

                for (Funcionario oFuncionario :oListFuncionario) {
                    String codigo = oFormat.formatarCodigoDoFuncionario(oFuncionario.getnCodFuncionario().intValue(), 6);
                    String nome = oFormat.formatarNomeDoFuncionario(oFuncionario.getsNome(), 100);
                    String salario = oFormat.formatarSalario(oFuncionario.getnSalario().toString(), 13);
                    LocalDate data = oFuncionario.getdData();
                   // buffWriter.write(codigo+  + nome + salario+ g + data);
                    buffWriter.newLine();

                }
            }

            buffWriter.close();

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
}
