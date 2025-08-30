package br.ufal.ic.p2.wepayu.managers;

public class MainManager {
    public EmpregadoManager empregadoManager = new EmpregadoManager();

    public EmpregadoManager getEmpregadoManager() {
        return empregadoManager;
    }
}