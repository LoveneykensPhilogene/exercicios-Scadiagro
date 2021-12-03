package exercicio_05;

import java.time.LocalDate;

public class Funcionario {
    private int cod_funcionario;
    private String nome;
    private String valorSalario;
    private LocalDate dataAdmissao;

    public Funcionario() {
    }

    public Funcionario(int cod_funcionario, String nome, String valorSalario, LocalDate dataAdmissao) {
        this.cod_funcionario = cod_funcionario;
        this.nome = nome;
        this.valorSalario = valorSalario;
        this.dataAdmissao = dataAdmissao;
    }

    public int getCod_funcionario() {
        return cod_funcionario;
    }

    public void setCod_funcionario(int cod_funcionario) {
        this.cod_funcionario = cod_funcionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getValorSalario() {
        return valorSalario;
    }

    public void setValorSalario(String valorSalario) {
        this.valorSalario = valorSalario;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "cod_funcionario=" + cod_funcionario +
                ", nome='" + nome + '\'' +
                ", valorSalario='" + valorSalario + '\'' +
                ", dataAdmissao=" + dataAdmissao +
                '}';
    }
}
