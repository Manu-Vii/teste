package br.ufal.ic.p2.wepayu;

import br.ufal.ic.p2.wepayu.managers.MainManager;

public class Facade {
    private MainManager mainManager = new MainManager();

    public void zerarSistema() {
        mainManager.getEmpregadoManager().zerarSistema();
    }

    public String criarEmpregado(String nome, String endereco, String tipo, String salario, String comissao) throws Exception {
        return mainManager.getEmpregadoManager().criarEmpregado(nome, endereco, tipo, salario, comissao);
    }

    public String criarEmpregado(String nome, String endereco, String tipo, String salario) throws Exception {
        return mainManager.getEmpregadoManager().criarEmpregado(nome, endereco, tipo, salario, null);
    }

    public String getAtributoEmpregado(String id, String atributo) throws Exception {
        return mainManager.getEmpregadoManager().getAtributoEmpregado(id, atributo);
    }

    public void encerrarSistema() {
        mainManager.getEmpregadoManager().encerrarSistema();
    }

    public void removerEmpregado(String id) throws Exception {
        mainManager.getEmpregadoManager().removerEmpregado(id);
    }

    public String getEmpregadoPorNome(String nome, int indice) throws Exception {
        return mainManager.getEmpregadoManager().getEmpregadoPorNome(nome, indice);
    }

    public void lancaCartao(String emp, String data, String horas) throws Exception {
        mainManager.getLancaCartaoPontoManager().lancaCartao(emp, data, horas);
    }

    public String getHorasNormaisTrabalhadas(String emp, String dataInicial, String dataFinal) throws Exception {
        return mainManager.getLancaCartaoPontoManager().getHorasNormaisTrabalhadas(emp, dataInicial, dataFinal);
    }

    public String getHorasExtrasTrabalhadas(String emp, String dataInicial, String dataFinal) throws Exception {
        return mainManager.getLancaCartaoPontoManager().getHorasExtrasTrabalhadas(emp, dataInicial, dataFinal);
    }

    public void lancaVenda(String emp, String data, String valor) throws Exception {
        mainManager.getLancaResultadoVendaManager().lancaVenda(emp, data, valor);
    }

    public String getVendasRealizadas(String emp, String dataInicial, String dataFinal) throws Exception {
        return mainManager.getLancaResultadoVendaManager().getVendasRealizadas(emp, dataInicial, dataFinal);
    }
}