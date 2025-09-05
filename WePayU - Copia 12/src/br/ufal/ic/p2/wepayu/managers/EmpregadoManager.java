package br.ufal.ic.p2.wepayu.managers;

import br.ufal.ic.p2.wepayu.ExceptionEmpregados.EmpregadoNaoExisteException;
import br.ufal.ic.p2.wepayu.ExceptionEmpregados.NaoNegativoException;
import br.ufal.ic.p2.wepayu.ExceptionEmpregados.NaoPodeSerNuloException;
import br.ufal.ic.p2.wepayu.ExceptionEmpregados.NaoNumericoException;
import br.ufal.ic.p2.wepayu.ExceptionEmpregados.TipoInvalidoException;
import br.ufal.ic.p2.wepayu.ExceptionEmpregados.TipoNaoAplicavelException;
import br.ufal.ic.p2.wepayu.models.*;
import br.ufal.ic.p2.wepayu.repository.EmpregadoRepository;
import java.math.BigDecimal;
import java.util.*;

public class EmpregadoManager {

    private EmpregadoRepository empregadoRepository = EmpregadoRepository.getInstance();

    public void zerarSistema() {
        empregadoRepository.zerarDados();
    }

    public void encerrarSistema() {
        empregadoRepository.salvarDados();
    }

    public void removerEmpregado(String id) throws Exception {
        if (id == null || id.isEmpty()) {
            throw new Exception("Identificacao do empregado nao pode ser nula.");
        }
        if (!empregadoRepository.remove(id)) {
            throw new EmpregadoNaoExisteException();
        }
    }

    public String getEmpregadoPorNome(String nome, int indice) throws Exception {
        Map<String, Empregado> empregados = empregadoRepository.getAll();
        List<Empregado> empregadosComNome = new ArrayList<>();

        for (Empregado empregado : empregados.values()) {
            if (empregado.getNome().equals(nome)) {
                empregadosComNome.add(empregado);
            }
        }

        empregadosComNome.sort(Comparator.comparing(Empregado::getId));

        if (empregadosComNome.size() >= indice) {
            return empregadosComNome.get(indice - 1).getId();
        }

        throw new Exception("Nao ha empregado com esse nome.");
    }

    public String criarEmpregado(String nome, String endereco, String tipo, String salario, String comissao) throws Exception {
        if (nome == null || nome.isEmpty())
            throw new NaoPodeSerNuloException("Nome");
        if (!nome.matches("[a-zA-Z\\s]+")) {
            throw new Exception("Nome deve conter apenas letras e espacos.");
        }
        if (endereco == null || endereco.isEmpty())
            throw new NaoPodeSerNuloException("Endereco");
        if (salario == null || salario.isEmpty())
            throw new NaoPodeSerNuloException("Salario");
        BigDecimal salarioBigDecimal;
        try {
            salarioBigDecimal = new BigDecimal(salario.replace(",", "."));
        } catch (NumberFormatException e) {
            throw new NaoNumericoException("Salario");
        }
        if (salarioBigDecimal.compareTo(BigDecimal.ZERO) < 0)
            throw new NaoNegativoException("Salario");

        Empregado novoEmpregado;
        switch (tipo) {
            case "horista":
                if (comissao != null)
                    throw new TipoNaoAplicavelException();
                novoEmpregado = new EmpregadoHorista(null, nome, endereco, salarioBigDecimal);
                break;
            case "assalariado":
                if (comissao != null)
                    throw new TipoNaoAplicavelException();
                novoEmpregado = new EmpregadoAssalariado(null, nome, endereco, salarioBigDecimal);
                break;
            case "comissionado":
                if (comissao == null) {
                    throw new TipoNaoAplicavelException();
                } else if (comissao.isEmpty()) {
                    throw new NaoPodeSerNuloException();
                }
                BigDecimal comissaoBigDecimal;
                try {
                    comissaoBigDecimal = new BigDecimal(comissao.replace(",", "."));
                } catch (NumberFormatException e) {
                    throw new NaoNumericoException();
                }
                if (comissaoBigDecimal.compareTo(BigDecimal.ZERO) < 0)
                    throw new NaoNegativoException();
                novoEmpregado = new EmpregadoComissionado(null, nome, endereco, salarioBigDecimal, comissaoBigDecimal);
                break;
            default:
                throw new TipoInvalidoException();
        }

        empregadoRepository.add(novoEmpregado);
        return novoEmpregado.getId();
    }

    public String getAtributoEmpregado(String id, String atributo) throws EmpregadoNaoExisteException, Exception {
        if (id == null || id.isEmpty())
            throw new Exception("Identificacao do empregado nao pode ser nula.");
        Empregado empregado = empregadoRepository.getById(id);
        if (empregado == null)
            throw new EmpregadoNaoExisteException();
        switch (atributo) {
            case "nome":
                return empregado.getNome();
            case "endereco":
                return empregado.getEndereco();
            case "tipo":
                return empregado.getTipo();
            case "salario":
                return empregado.getSalarioFormatado();
            case "sindicalizado":
                return String.valueOf(empregado.isSindicalizado());
            case "comissao":
                if (empregado instanceof EmpregadoComissionado) {
                    return ((EmpregadoComissionado) empregado).getComissaoFormatada();
                }
                throw new Exception("Atributo nao existe.");
            default:
                throw new Exception("Atributo nao existe.");
        }
    }
}