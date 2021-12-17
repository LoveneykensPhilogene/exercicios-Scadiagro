package br.scadiagro.cadastro.util;

import br.scadiagro.cadastro.model.Funcionario;

import java.util.List;

public interface IFuncionario {

    public void CadastrarFuncionario(Funcionario oFuncionario) throws Exception;

    public Funcionario BuscarUmFuncionarioPorCodigo(Long nCodigo);

    public List<Funcionario> BuscarTodosOsFuncionarios();

    public Funcionario BuscarFuncionarioCOmMenorSalario(String sTipo);

    public Funcionario BuscarFuncionarioCOmMaiorSalario(String sTipo);

    public Funcionario AtualizarFuncionario(Funcionario oFuncAtualizado);

    public void ExcluirFuncionario(Funcionario oFuncExcluido);

    public void CriarArquivo(String sPath,String sArquivo);

}
