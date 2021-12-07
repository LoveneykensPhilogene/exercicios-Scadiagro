package exercicio_06;

import exercicio_05.Funcionario;

public class Elemento {
    private Elemento posicaoAnterior;
    private Elemento proximoPosicao;
    private Integer tamanho;
    private Funcionario funcionario;

    public Elemento(Elemento primeraPosicao, Elemento segundaPosicao, Funcionario funcionario, Integer tamanho) {
        this.posicaoAnterior = primeraPosicao;
        this.proximoPosicao = segundaPosicao;
        this.funcionario = funcionario;
        this.tamanho = tamanho;
    }

    public Elemento(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Elemento() {
    }

    public Elemento getPosicaoAnterior() {
        return posicaoAnterior;
    }

    public void setPosicaoAnterior(Elemento posicaoAnterior) {
        this.posicaoAnterior = posicaoAnterior;
    }

    public Elemento getProximoPosicao() {
        return proximoPosicao;
    }

    public void setProximoPosicao(Elemento proximoPosicao) {
        this.proximoPosicao = proximoPosicao;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

      @Override
    public String toString() {
        return "Elemento[" +
                "primeraPosicao='" + posicaoAnterior.getFuncionario() + ',' +
                ", segundaPosicao='" + proximoPosicao.getFuncionario() + ',' +
                               ']';
    }

}
