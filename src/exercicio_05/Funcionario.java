package exercicio_05;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario {
    private int cod_funcionario;
    private String nome;
    private BigDecimal valorSalario;
    private LocalDate dataAdmissao;

    public Funcionario() {
    }

    public Funcionario(int cod_funcionario, String nome, BigDecimal valorSalario, LocalDate dataAdmissao) {
        this.cod_funcionario = cod_funcionario;
        this.nome = nome;
        this.valorSalario = valorSalario;
        this.dataAdmissao = dataAdmissao;
    }
    public Funcionario(int cod_funcionario){
        this.cod_funcionario=cod_funcionario;
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

    public BigDecimal getValorSalario() {
        return valorSalario;
    }

    public void setValorSalario(BigDecimal valorSalario) {
        this.valorSalario = valorSalario;
    }

    @Override
    public String toString() {
        return "\n====Funcionario ====\n" +
                "cod_funcionario : " + cod_funcionario + "\n" +
                "nome : " + nome + "\n" +
                "valorSalario : R$" + valorSalario + "\n" +
                "dataAdmissao : " + dataAdmissao + "\n"+
                "Tempo na empresa : "+LocalDate.now().getMonth().compareTo(dataAdmissao.getMonth())+"\t Mês(es)";

    }
}
