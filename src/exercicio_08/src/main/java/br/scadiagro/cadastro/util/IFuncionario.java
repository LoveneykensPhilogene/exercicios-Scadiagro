package br.scadiagro.cadastro.util;

import br.scadiagro.cadastro.model.Funcionario;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface IFuncionario {

    public void CadastrarFuncionario(List<Funcionario> oFuncionario) throws Exception;

    public Funcionario BuscarUmFuncionarioPorCodigo(Long nCodigo) throws Exception;

    public List<Funcionario> BuscarTodosOsFuncionarios(String sPath, String SFile) throws Exception;

    public Funcionario BuscarFuncionarioCOmMenorSalario(String sTipoFile);

    public Funcionario BuscarFuncionarioCOmMaiorSalario(String sTipoFile);

    public Funcionario AtualizarFuncionario(Funcionario oFun, Funcionario oFuncAtualizado) throws Exception;

    public void ExcluirFuncionario(Funcionario oFuncExcluido) throws Exception;

    public void CriarArquivo(String sPath, String sArquivo,Funcionario oFuncionario) throws IOException;

    public BigDecimal BuscarSomaDeTOdosSalarios(String sCaminho) throws Exception;

    public BigDecimal BuscarMediaSalarios(String sCaminho) throws Exception;

    public void ExcTodosFuncionarios(String sArquivo) throws Exception;
}

