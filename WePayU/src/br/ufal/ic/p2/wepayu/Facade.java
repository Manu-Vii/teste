package br.ufal.ic.p2.wepayu;

import br.ufal.ic.p2.wepayu.Exception.EmpregadoNaoExisteException;
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

    public String getAtributoEmpregado(String id, String atributo) throws EmpregadoNaoExisteException, Exception {
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
}