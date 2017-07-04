/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drogaria.teste;

import br.com.drogaria.dao.ItemDao;
import br.com.drogaria.dao.ProdutoDao;
import br.com.drogaria.dao.VendaDao;
import br.com.drogaria.domain.Item;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.domain.Venda;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Thiago Silva
 */
public class ItemDAOTest {
    
    @Test
    @Ignore
    public void salvar(){
    
        ProdutoDao produtoDao = new ProdutoDao();
        Produto produto = produtoDao.buscarPorCodigo(8l);
        
        VendaDao vendaDao = new VendaDao();
        Venda venda = vendaDao.bucarPorCodigo(15l);
        
        
        Item item = new Item();
        
        item.setProduto(produto);
        item.setVenda(venda);
        item.setQuantidade(3);
        item.setValorParcial(new BigDecimal(22.6D));
        
        ItemDao itemDao = new ItemDao();
        
        itemDao.salvar(item);
        
    }
    @Test
    @Ignore
    public void listar(){
    
        
        ItemDao itemDao = new ItemDao();
        List<Item> itens = itemDao.listar();
        
        System.out.println(itens);
    }
    @Test
    public void buscarPorCodigo(){
    
        ItemDao itemDao = new ItemDao();
        Item item = itemDao.buscarPorCodigo(16L);
        
        System.out.println(item);
        
    }
}
