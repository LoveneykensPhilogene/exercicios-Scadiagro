package exercicio_06;

import exercicio_05.Funcionario;

public class Elemento {
    private Elemento posicaoAnterior;
    private Elemento proximaPosicao;
    private Funcionario funcionario;

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

    public Elemento getProximaPosicao() {
        return proximaPosicao;
    }

    public void setProximaPosicao(Elemento proximaPosicao) {
        this.proximaPosicao = proximaPosicao;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

}
