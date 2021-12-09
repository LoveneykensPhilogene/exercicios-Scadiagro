package exercicio_06;

import exercicio_05.Funcionario;

public class ListaEncadeada {
    private Elemento inicio;
    private Elemento fim;
    private Integer tamanho;

    public Elemento getInicio() {
        return inicio;
    }

    public void setInicio(Elemento inicio) {
        this.inicio = inicio;
    }

    public Elemento getFim() {
        return fim;
    }

    public void setFim(Elemento fim) {
        this.fim = fim;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }

    public void adicionarPrimeiroElemento(Funcionario funcionario) {

        Elemento elemento = new Elemento();
        this.tamanho = 0;
        elemento.setFuncionario(funcionario);
        elemento.setPosicaoAnterior(null);
        elemento.setProximaPosicao(this.inicio);

        if (this.inicio != null) {
            this.inicio.setPosicaoAnterior(elemento);
        }
        this.inicio = elemento;

        if (this.tamanho.equals(0)) {
            this.fim = this.inicio;
        }

    }

    public void ordenarPeloCodigoDoElemento() {

    }

    public void ordenarPeloNomeDoElemento() {
    }

    public void listaDosElementos() {
        Elemento elemento = this.inicio;
        while (elemento != null) {
            this.tamanho++;

            System.out.println(elemento.getFuncionario());
            elemento = elemento.getProximaPosicao();
        }

    }
}
