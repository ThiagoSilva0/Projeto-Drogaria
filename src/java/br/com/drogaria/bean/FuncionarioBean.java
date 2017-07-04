/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drogaria.bean;

import br.com.drogaria.dao.FuncionarioDao;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Funcionario;
import br.com.drogaria.util.FacesUtil;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Thiago Silva
 */
@ManagedBean
@RequestScoped
public class FuncionarioBean {

    private Funcionario funcionario;
    private List<Funcionario> listaFuncionarios;

    public List<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }

    public void setListaFuncionarios(List<Funcionario> listaFuncionarios) {
        this.listaFuncionarios = listaFuncionarios;
    }

    public Funcionario getFuncionario() {
        if (funcionario == null) {
            funcionario = new Funcionario();
        }
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void carregarPesquisa() {

        try {
            FuncionarioDao funcionarioDao = new FuncionarioDao();
            listaFuncionarios = funcionarioDao.listar();
        } catch (Exception e) {
            FacesUtil.adicionarMsgError("Erro ao tentar listar os funcionarios. ERRO " + e.getMessage());
        }
    }

    public void carregarCadastro() {

        try {
            String valor = FacesUtil.getParam("funcodigo");
            if (valor != null) {
                Long codigo = Long.parseLong(valor);
                FuncionarioDao funcionarioDao = new FuncionarioDao();
                funcionario = funcionarioDao.buscarPorCodigo(codigo);
            }
        } catch (Exception e) {
            FacesUtil.adicionarMsgError("Erro ao tentar listar funcionario: ERRO " + e.getMessage());
        }
    }

    public void salvar() {

        try {
            FuncionarioDao funcionarioDao = new FuncionarioDao();
            funcionarioDao.salvar(funcionario);
            funcionario = new Funcionario();
            FacesUtil.adicionarMsgInfo("Funcionario salvo com sucesso!");
        } catch (Exception e) {
            FacesUtil.adicionarMsgError("Erro ao tentar salvar funcionario: ERRO " + e.getMessage());
        }
    }

    public void novo() {

        funcionario = new Funcionario();
    }
    
    public void excluir() {

        try {
            FuncionarioDao funcionarioDao = new FuncionarioDao();
            funcionarioDao.excluir(funcionario);
            FacesUtil.adicionarMsgInfo("Funcionario excluido com sucesso!");
        } catch (Exception e) {
            FacesUtil.adicionarMsgError("Erro ao tentar excluir funcionario: ERRO " + e.getMessage());
        }
    }
    public void editar() {

        try {
            FuncionarioDao funcionarioDao = new FuncionarioDao();
            funcionarioDao.editar(funcionario);
            FacesUtil.adicionarMsgInfo("Funcionario editado com sucesso!");
        } catch (Exception e) {
            FacesUtil.adicionarMsgError("Erro ao tentar editar funcionario: ERRO " + e.getMessage());
        }
    }

}
