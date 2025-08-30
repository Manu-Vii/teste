package br.ufal.ic.p2.wepayu.models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class EmpregadoComissionado extends Empregado {
    private BigDecimal salarioMensal;
    private BigDecimal comissao;

    // NOVO ATRIBUTO PARA ARMAZENAR A COMISSÃO COMO STRING
    private String comissaoStr;

    // Construtor padrão (sem argumentos)
    public EmpregadoComissionado() {
    }

    public EmpregadoComissionado(String id, String nome, String endereco, BigDecimal salarioMensal, BigDecimal comissao) {
        super(id, nome, endereco);
        this.salarioMensal = salarioMensal.setScale(2, RoundingMode.HALF_EVEN);
        this.comissao = comissao.setScale(2, RoundingMode.HALF_EVEN);
    }

    @Override
    public String getTipo() {
        return "comissionado";
    }

    @Override
    public BigDecimal getSalario() {
        return salarioMensal;
    }

    public String getComissaoFormatada() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
        DecimalFormat df = new DecimalFormat("#,##0.00", symbols);
        df.setGroupingUsed(false);
        return df.format(comissao);
    }

    // Setters para serialização
    public void setSalarioMensal(BigDecimal salarioMensal) {
        this.salarioMensal = salarioMensal;
    }

    public void setComissao(BigDecimal comissao) {
        this.comissao = comissao;
    }

    // SETTERS DA CLASSE PAI E NOVOS GETTERS/SETTERS
    @Override
    public void setSalarioStr(String salarioStr) {
        this.salarioMensal = new BigDecimal(salarioStr);
    }

    public String getComissaoStr() {
        return this.comissao.toString();
    }

    public void setComissaoStr(String comissaoStr) {
        this.comissao = new BigDecimal(comissaoStr);
    }
}