package br.ufal.ic.p2.wepayu.models;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class EmpregadoHorista extends Empregado {
    private BigDecimal salarioHora;

    // Construtor padrão (sem argumentos)
    public EmpregadoHorista() {
    }

    public EmpregadoHorista(String id, String nome, String endereco, BigDecimal salarioHora) {
        super(id, nome, endereco);
        this.salarioHora = salarioHora.setScale(2, RoundingMode.HALF_EVEN);
    }

    @Override
    public String getTipo() {
        return "horista";
    }

    @Override
    public BigDecimal getSalario() {
        return salarioHora;
    }

    // Setter para serialização
    public void setSalarioHora(BigDecimal salarioHora) {
        this.salarioHora = salarioHora;
    }

    // Setter da classe pai
    @Override
    public void setSalarioStr(String salarioStr) {
        this.salarioHora = new BigDecimal(salarioStr);
    }
}