/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drogaria.teste;

import br.com.drogaria.dao.FabricanteDao;
import br.com.drogaria.dao.ProdutoDao;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;
import java.math.BigDecimal;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Thiago Silva
 */
public class ProdutoDaoTeste {

    @Test
    @Ignore
    public void salvar() {
        FabricanteDao fabricanteDao = new FabricanteDao();
        Fabricante fabricante = fabricanteDao.buscarPorCodigo(4l);

        Produto produto = new Produto();
        produto.setDescricao("benegrip");
        produto.setPreco(new BigDecimal(11.50d));
        produto.setQuantidade(52);
        produto.setFabricante(fabricante);

        ProdutoDao dao = new ProdutoDao();

        dao.salvar(produto);
    }

    @Test
    public void buscarPorCodigo() {
        ProdutoDao produtoDao = new ProdutoDao();

        Produto produto = produtoDao.buscarPorCodigo(7l);
        System.out.println("--------------------------------------");
        System.out.println(produto);
    }

    @Test
    @Ignore
    public void listar() {
        ProdutoDao produtoDao = new ProdutoDao();
        List<Produto> produtos = produtoDao.listar();
        for(Produto produto: produtos){
            System.out.println(produto);
        }
    }
    @Test
    @Ignore
    public void excluir(){
    ProdutoDao produtoDao = new ProdutoDao();
    Produto produto = produtoDao.buscarPorCodigo(7l);
    produtoDao.excluir(produto);
    }
    @Test
    @Ignore
    public void editar(){
    
        ProdutoDao produtoDao = new ProdutoDao();
        Produto produto = produtoDao.buscarPorCodigo(8l);
        
        produto.setDescricao("anador");
        produto.setPreco(new BigDecimal(2.90D));
        produto.setQuantidade(23);
        
        FabricanteDao fabricanteDao = new FabricanteDao();
        Fabricante fabricante = fabricanteDao.buscarPorCodigo(1l);
        produto.setFabricante(fabricante);
        
        produtoDao.editar(produto);
    }
}
