public class Conta {

    private Integer numero;
    private String titular;
    private Double saldo;
    private Double limiteSaque;

    public Conta(Integer numero, String titular, Double saldo, Double limiteSaque) {

        if (limiteSaque > saldo) {
            throw new Excecao("O limite de saque não pode ser maior que o saldo, não dá pra você sacar mais do que tem...");
        }

        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
        this.limiteSaque = limiteSaque;
    }

    public void depositar(Double quantia) {
        this.saldo += quantia;
    }
    public void sacar(Double quantia) {
        if (quantia > limiteSaque) {
            throw new Excecao(" o valor do saque é maior o limite.");
        }
        if (quantia > saldo) {
            throw new Excecao("esse saldo está insuficiente para o saque.");
        }
        this.saldo -= quantia;
    }

    public Integer getNumero() {
        return numero;
    }
    public String getTitular() {
        return titular;
    }
    public Double getSaldo() {
        return saldo;
    }
    public Double getLimiteSaque() {
        return limiteSaque;
    }
}
