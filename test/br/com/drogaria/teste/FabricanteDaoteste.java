/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drogaria.teste;

import br.com.drogaria.dao.FabricanteDao;
import br.com.drogaria.domain.Fabricante;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Thiago Silva
 */
public class FabricanteDaoteste {

    
    @Test
    @Ignore
    public void salvar() {
        Fabricante f2 = new Fabricante();
        FabricanteDao dao = new FabricanteDao();
        Fabricante f3 = new Fabricante();
        Fabricante f4 = new Fabricante();
        f2.setDescricao("boné");
        f3.setDescricao("camiseta");
        f4.setDescricao("sapato");
        dao.salvar(f2);
        dao.salvar(f3);
        dao.salvar(f4);
    }

    @Test
    @Ignore
    public void listar() {
        FabricanteDao dao = new FabricanteDao();
        List<Fabricante> fabricantes = dao.listar();

       
            System.out.println(fabricantes.toString());
       
    }

    @Test
    @Ignore
    public void buscarPorCodigo() {

        FabricanteDao dao = new FabricanteDao();
        Fabricante f = dao.buscarPorCodigo(27l);

        System.out.println(f);
    }

    @Test
    @Ignore
    public void excluir() {

        FabricanteDao dao = new FabricanteDao();

        Fabricante fabricante = dao.buscarPorCodigo(27l);

        dao.excluir(fabricante);

    }

    @Test
    
    public void editar() {
        FabricanteDao dao = new FabricanteDao();

        Fabricante fabricante = dao.buscarPorCodigo(1l);
        fabricante.setDescricao("Generico");
        dao.editar(fabricante);

        
    }

}
