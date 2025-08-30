package br.ufal.ic.p2.wepayu.Exception;

public class NaoPodeSerNuloException extends Exception {

    public NaoPodeSerNuloException(String atributo) {
        super(atributo + " nao pode ser nulo.");
    }

    public NaoPodeSerNuloException() {
        super("Comissao nao pode ser nula.");
    }
}