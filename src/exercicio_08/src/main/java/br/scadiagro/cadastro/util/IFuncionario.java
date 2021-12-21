package br.scadiagro.cadastro.util;

import br.scadiagro.cadastro.model.Funcionario;

import java.math.BigDecimal;
import java.util.List;

public interface IFuncionario {

    public void CadastrarFuncionario(List<Funcionario> oFuncionario) throws Exception;

    public Funcionario BuscarUmFuncionarioPorCodigo(Long nCodigo);

    public List<Funcionario> BuscarTodosOsFuncionarios(String sPath,String SFile) throws Exception;

     public Funcionario BuscarFuncionarioCOmMenorSalario(String sTipoFile);

    public Funcionario BuscarFuncionarioCOmMaiorSalario(String sTipoFile);

    public Funcionario AtualizarFuncionario(Funcionario oFun,Funcionario oFuncAtualizado);

    public void ExcluirFuncionario(Funcionario oFuncExcluido);

    public void CriarArquivo(String sPath,String sArquivo);

}
