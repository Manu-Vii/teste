package br.ufal.ic.p2.wepayu.models;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class EmpregadoAssalariado extends Empregado {
    private BigDecimal salarioMensal;

    // Construtor padrão (sem argumentos)
    public EmpregadoAssalariado() {
    }

    public EmpregadoAssalariado(String id, String nome, String endereco, BigDecimal salarioMensal) {
        super(id, nome, endereco);
        this.salarioMensal = salarioMensal.setScale(2, RoundingMode.HALF_EVEN);
    }

    @Override
    public String getTipo() {
        return "assalariado";
    }

    @Override
    public BigDecimal getSalario() {
        return salarioMensal;
    }

    // Setter para serialização
    public void setSalarioMensal(BigDecimal salarioMensal) {
        this.salarioMensal = salarioMensal;
    }

    // Setter da classe pai
    @Override
    public void setSalarioStr(String salarioStr) {
        this.salarioMensal = new BigDecimal(salarioStr);
    }
}