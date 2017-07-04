/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drogaria.teste;

import br.com.drogaria.dao.FuncionarioDao;
import br.com.drogaria.dao.VendaDao;
import br.com.drogaria.domain.Funcionario;
import br.com.drogaria.domain.Venda;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Thiago Silva
 */
public class VendaDAOTeste {
    @Test
    @Ignore
    public void salvar(){
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        Funcionario funcionario = funcionarioDao.buscarPorCodigo(13l);
        
        Venda venda = new Venda();
        venda.setFuncionario(funcionario);
        venda.setHorario(new Date());
        venda.setValorTotal(new BigDecimal(8.9D));
        
        VendaDao dao = new VendaDao();
        dao.salvar(venda);
                
    }
    @Test
    @Ignore
    public void listar(){
    
        VendaDao vendaDao = new VendaDao();
        
        List<Venda> vendas = vendaDao.listar();
        
        System.out.println(vendas);
    }
    @Test
    
    public void buscarPorCodigo(){
    
        VendaDao vendaDao = new VendaDao();
        
        Venda venda = vendaDao.bucarPorCodigo(15l);
        
        System.out.println(venda);
        
    }
    
}
