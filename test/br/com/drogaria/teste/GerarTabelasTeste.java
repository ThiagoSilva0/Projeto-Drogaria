/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drogaria.teste;

import br.com.drogaria.util.HibernateUtil;
import org.junit.Test;

/**
 *
 * @author Thiago Silva
 */
public class GerarTabelasTeste {
    @Test
    public void gerar(){
        HibernateUtil.getSessionFactory();
        HibernateUtil.getSessionFactory().close();
    }
}
