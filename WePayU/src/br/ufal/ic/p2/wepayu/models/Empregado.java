package br.ufal.ic.p2.wepayu.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public abstract class Empregado implements Serializable {
    private String id;
    private String nome;
    private String endereco;
    private boolean sindicalizado;

    // NOVO ATRIBUTO PARA ARMAZENAR O SALÁRIO COMO STRING PARA SERIALIZAÇÃO
    private String salarioStr;

    // Construtor padrão (sem argumentos)
    public Empregado() {
    }

    // Construtor com argumentos
    public Empregado(String id, String nome, String endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.sindicalizado = false;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public boolean isSindicalizado() {
        return sindicalizado;
    }

    public String getSalarioFormatado() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
        DecimalFormat df = new DecimalFormat("#,##0.00", symbols);
        df.setGroupingUsed(false);
        return df.format(getSalario());
    }

    public abstract String getTipo();

    public abstract BigDecimal getSalario();

    // Getters e setters para serialização
    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setSindicalizado(boolean sindicalizado) {
        this.sindicalizado = sindicalizado;
    }

    // NOVO GETTER E SETTER PARA O SALÁRIO COMO STRING
    public String getSalarioStr() {
        return this.getSalario().toString();
    }

    public void setSalarioStr(String salarioStr) {
        // As subclasses precisam implementar a conversão
    }
}