package exercicio_06;

import exercicio_05.Funcionario;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

    public boolean listaVazia() {
        boolean empty = getInicio() == null;
        return empty;
    }

    public void tamanhoDaLista() {
        setTamanho(0);
        while (getInicio() != null) {
            tamanho++;
            setInicio(getInicio().getProximaPosicao());
        }
        System.out.println(getTamanho());
    }

    public void adicionarElementoNoInicio(Funcionario funcionario) {

        funcionario = dadosDoFuncionarioFormatado(funcionario);
        Elemento elemento = new Elemento();
        elemento.setFuncionario(funcionario);
        elemento.setProximaPosicao(getInicio());
        setInicio(elemento);
        if (getInicio() == null) {
            setInicio(elemento);
            setFim(getInicio());
            setInicio(getFim());
        } else {
            setInicio(elemento);
        }

    }

    public void adicionarElementoNoFim(Funcionario funcionario) {
        Elemento elemento = new Elemento(funcionario);
        if (getInicio().equals(null)) {
            setInicio(elemento);
            setFim(elemento);
        } else {
            getFim().setPosicaoAnterior(elemento);
            setFim(elemento);
        }
    }

    public void ordenarPeloCodigoDoElemento() {

        List<Funcionario> novoElemento = new ArrayList<Funcionario>();
        Elemento elemento = getInicio();

        while (elemento != null) {

            novoElemento.add(elemento.getFuncionario());
            novoElemento.sort(Comparator.comparingInt(Funcionario::getCod_funcionario));
            elemento = elemento.getProximaPosicao();
        }
        System.out.println("\n====Ordenada por código===\n");
        for (int indiceDoNovoElemento = 0; indiceDoNovoElemento < novoElemento.size(); indiceDoNovoElemento++) {
            ListaEncadeada lista = new ListaEncadeada();
            lista.adicionarElementoNoInicio(novoElemento.get(indiceDoNovoElemento));
            System.out.println(lista.getInicio().getFuncionario());
        }

    }

    public void ordenarPeloNomeElemento() {

        List<Funcionario> novoElemento = new ArrayList<Funcionario>();
        Elemento elemento = getInicio();

        while (elemento != null) {

            novoElemento.add(elemento.getFuncionario());
            novoElemento.sort(Comparator.comparing(Funcionario::getNome));
            elemento = elemento.getProximaPosicao();
        }
        System.out.println("\n====Ordenada por nome===\n");
        for (int indiceDoNovoElemento = 0; indiceDoNovoElemento < novoElemento.size(); indiceDoNovoElemento++) {
            ListaEncadeada lista = new ListaEncadeada();
            lista.adicionarElementoNoInicio(novoElemento.get(indiceDoNovoElemento));
            System.out.println(lista.getInicio().getFuncionario());
        }

    }

    public void listaDosElementos() {
        Elemento elemento = this.inicio;
        while (elemento != null) {
            System.out.println(elemento.getFuncionario());
            elemento = elemento.getProximaPosicao();
        }

    }

    public Funcionario dadosDoFuncionarioFormatado(Funcionario funcionario) {
        Funcionario funcionarioFormatado = new Funcionario();

        funcionarioFormatado.setCod_funcionario(funcionario.getCod_funcionario());
        funcionarioFormatado.setNome(funcionario.getNome());
        funcionarioFormatado.setValorSalario(funcionario.getValorSalario().setScale(2, RoundingMode.DOWN));
        funcionarioFormatado.setDataAdmissao(funcionario.getDataAdmissao());

        return funcionarioFormatado;
    }

    public void instrucao() {

        System.out.println("========================\n" + "*Instrução*\n"
                + "Opção 1 =>Digite número 1 : "
                + "Para iniciar o programa \n"
                + "Opção 2 =>Digite número 0 :"
                + "Encerrar a sessão."
                + "\n========================\n");
    }

    public void abrirSistema(int entrada) {

        int btnLigar = 1;
        if (btnLigar == entrada) {
            System.out.println("Você está logado.");
        } else {
            System.out.println(new Exception("Digitou um número errado") + "\nSegue a intrução");
        }

    }
}
