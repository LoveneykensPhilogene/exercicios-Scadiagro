package br.scadiagro.cadastro.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Funcionario implements Serializable {
    private static final long serialversionUID = 1l;

    private Long nCodFuncionario;
    private String sNome;
    private BigDecimal nSalario;
    private LocalDate dData;

    public Funcionario() {
    }

    public Funcionario(Long nCodFuncionario, String sNome, BigDecimal nSalario, LocalDate dData) {
        this.nCodFuncionario = nCodFuncionario;
        this.sNome = sNome;
        this.nSalario = nSalario;
        this.dData = dData;
    }

    public Long getnCodFuncionario() {
        return nCodFuncionario;
    }

    public void setnCodFuncionario(Long nCodFuncionario) {
        this.nCodFuncionario = nCodFuncionario;
    }

    public String getsNome() {
        return sNome;
    }

    public void setsNome(String sNome) {
        this.sNome = sNome;
    }

    public BigDecimal getnSalario() {
        return nSalario;
    }

    public void setnSalario(BigDecimal nSalario) {
        this.nSalario = nSalario;
    }

    public LocalDate getdData() {
        return dData;
    }

    public void setdData(LocalDate dData) {
        this.dData = dData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return nCodFuncionario.equals(that.nCodFuncionario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nCodFuncionario);
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nCodFuncionario=" + nCodFuncionario +
                ", sNome='" + sNome + '\'' +
                ", nSalario=" + nSalario +
                ", dData=" + dData +
                '}';
    }
}

