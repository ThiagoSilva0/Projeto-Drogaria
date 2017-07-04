/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drogaria.dao;

import br.com.drogaria.domain.Produto;
import br.com.drogaria.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Thiago Silva
 */
public class ProdutoDao {

    
    
    public void salvar(Produto produto) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        try {
            transacao = sessao.beginTransaction();
            sessao.save(produto);
            transacao.commit();
        } catch (RuntimeException e) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw e;
        } finally {
            sessao.close();
        }
    }

    public List<Produto> listar() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Produto> produtos = null;
        try {
            Query consulta = sessao.createQuery("FROM Produto");
            produtos = consulta.list();
        } catch (RuntimeException e) {
            throw e;
        } finally {
            sessao.close();
        }
        return produtos;
    }

    public Produto buscarPorCodigo(Long codigo) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Produto produto = null;
        try {
            Query consulta = sessao.createQuery("FROM Produto p WHERE p.codigo = :codigo ");
            consulta.setLong("codigo", codigo);
            produto = (Produto) consulta.uniqueResult();
        } catch (RuntimeException e) {
            throw e;
        } finally {
            sessao.close();
        }
        return produto;
    }

    public void excluir(Produto produto) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        try {
            transacao = sessao.beginTransaction();
            sessao.delete(produto);
            transacao.commit();
        } catch (RuntimeException e) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw e;
        } finally {
            sessao.close();
        }
    }
    public void editar(Produto produto){
    
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        try {
            transacao = sessao.beginTransaction();
            sessao.update(produto);
            transacao.commit();
        } catch (RuntimeException e) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw e;
        } finally {
            sessao.close();
        }
    }

}
