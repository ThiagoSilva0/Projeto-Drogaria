/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drogaria.bean;

import br.com.drogaria.dao.FabricanteDao;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.util.FacesUtil;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Thiago Silva
 */
@ManagedBean
@RequestScoped
public class FabricanteBean {

    private Fabricante fabricante;
    private List<Fabricante> listaFabricantes;
    private List<Fabricante> listaFabricantesFiltrados;

    public Fabricante getFabricante() {
        if (fabricante == null) {
            fabricante = new Fabricante();
        }

        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public List<Fabricante> getListaFabricantes() {
        return listaFabricantes;
    }

    public void setListaFabricantes(List<Fabricante> listaFabricantes) {
        this.listaFabricantes = listaFabricantes;
    }

    public List<Fabricante> getListaFabricantesFiltrados() {
        return listaFabricantesFiltrados;
    }

    public void setListaFabricantesFiltrados(List<Fabricante> listaFabricantesFiltrados) {
        this.listaFabricantesFiltrados = listaFabricantesFiltrados;
    }

    public void salvar() {
        try {
            FabricanteDao fabricanteDao = new FabricanteDao();
            fabricanteDao.salvar(fabricante);
            fabricante = new Fabricante();
            FacesUtil.adicionarMsgInfo("Fabricante salvo com sucesso!");
        } catch (RuntimeException e) {
            FacesUtil.adicionarMsgError("Erro ao tentar incluir fabricante: " + e.getMessage());

        }

    }

    public void novo() {

        fabricante = new Fabricante();
    }

    public void carregarPesquisa() {
        try {
            FabricanteDao fabricanteDao = new FabricanteDao();
            listaFabricantes = fabricanteDao.listar();
        } catch (Exception e) {
            FacesUtil.adicionarMsgError("Erro ao tentar listar o fabricantes: " + e.getMessage());
        }
    }

    public void carregarCadastro() {
        try {
            String valor = FacesUtil.getParam("fabcodigo");
            if (valor != null) {
                Long codigo = Long.parseLong(valor);
                FabricanteDao fabricanteDao = new FabricanteDao();
                fabricante = fabricanteDao.buscarPorCodigo(codigo);
            }
        } catch (Exception e) {
            FacesUtil.adicionarMsgError("Erro ao tentar obter os fabricantes: " + e.getMessage());
        }
    }
    public void excluir(){
    
        try {
            FabricanteDao fabricanteDao = new FabricanteDao();
            fabricanteDao.excluir(fabricante);
            FacesUtil.adicionarMsgInfo("Fabricante removido com sucesso!");
        } catch (Exception e) {
            FacesUtil.adicionarMsgError("Erro ao tentar remover o fabricante: " + e.getMessage());
        }
    }
    public void editar(){
    
        try {
            FabricanteDao fabricanteDao = new FabricanteDao();
            fabricanteDao.editar(fabricante);
            FacesUtil.adicionarMsgInfo("Fabricante editado com sucesso!");
        } catch (Exception e) {
            FacesUtil.adicionarMsgError("Erro ao tentar editar os dados do fabricante! "+e.getMessage());
        }
    }

}
