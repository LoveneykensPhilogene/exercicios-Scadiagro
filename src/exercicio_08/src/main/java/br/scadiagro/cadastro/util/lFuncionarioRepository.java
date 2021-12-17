package br.scadiagro.cadastro.util;

import br.scadiagro.cadastro.config.lFormat;
import br.scadiagro.cadastro.model.Funcionario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class lFuncionarioRepository implements IFuncionario {

    private Funcionario oFuncionario;
    private lFormat oFormat;
    private String sPath;
    private String sFile;
    private BufferedReader buffReader;
    private BufferedWriter buffWriter;

    public lFuncionarioRepository() {
    }

    public lFuncionarioRepository(Funcionario oFuncionario, String sPath, String sFile) {
        this.oFuncionario = oFuncionario;
        this.sPath = sPath;
        this.sFile = sFile;
    }

    @Override
    public void CadastrarFuncionario(Funcionario oFuncionario) throws Exception {

        if (oFuncionario != null) {
            setoFuncionario(oFuncionario);
            setsPath(getsFile());
            this.buffWriter = new BufferedWriter(new FileWriter(getsPath()));
            while (getBuffWriter() != null) {
                this.oFormat = new lFormat();
                String sCodigo = this.oFormat.formatarCodigoDoFuncionario(getoFuncionario().getnCodFuncionario().intValue(), 6);
                String sNome = this.oFormat.formatarNomeDoFuncionario(getoFuncionario().getsNome(), 100);
                String sSalario = this.oFormat.formatarSalario(getoFuncionario().getnSalario().toString(), 13);

                buffWriter.write(sCodigo + sNome + sSalario + getoFuncionario().getdData());
                buffWriter.newLine();
            }
            buffWriter.close();

        } else {
            throw new NullPointerException("Não existe");
        }

    }

    @Override
    public Funcionario BuscarUmFuncionarioPorCodigo(Long nCodigo) {
        return null;
    }

    @Override
    public List<Funcionario> BuscarTodosOsFuncionarios() {
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

    @Override
    public void CriarArquivo(String sPath, String sArquivo) {


    }

    public Funcionario getoFuncionario() {
        return oFuncionario;
    }

    public void setoFuncionario(Funcionario oFuncionario) {
        this.oFuncionario = oFuncionario;
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
}
