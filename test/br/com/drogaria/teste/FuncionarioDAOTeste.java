/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drogaria.teste;

import br.com.drogaria.dao.FuncionarioDao;
import br.com.drogaria.domain.Funcionario;
import org.junit.Test;

/**
 *
 * @author Thiago Silva
 */
public class FuncionarioDAOTeste {
    @Test
    public void salvar(){
    
        Funcionario funcionario1 = new Funcionario();
        funcionario1.setCpf("03");
        funcionario1.setFuncao("pro");
        funcionario1.setNome("thi");
        funcionario1.setSenha("na");
        
        FuncionarioDao dao = new FuncionarioDao();
        dao.salvar(funcionario1);
    }
}
