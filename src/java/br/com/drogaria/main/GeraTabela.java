/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drogaria.main;

import br.com.drogaria.util.HibernateUtil;

/**
 *
 * @author Thiago Silva
 */
public class GeraTabela {
    
    public static void main(String []args){
    
        HibernateUtil.getSessionFactory();
        HibernateUtil.getSessionFactory().close();
    }
}
