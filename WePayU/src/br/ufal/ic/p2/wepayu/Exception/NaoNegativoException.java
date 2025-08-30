package br.ufal.ic.p2.wepayu.Exception;

public class NaoNegativoException extends Exception {
    public NaoNegativoException(String atributo) {
        super(atributo + " deve ser nao-negativo.");
    }

    public NaoNegativoException() {
        super("Comissao deve ser nao-negativa.");
    }
}