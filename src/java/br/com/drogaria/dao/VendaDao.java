/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drogaria.dao;

import br.com.drogaria.domain.Venda;
import br.com.drogaria.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Thiago Silva
 */
public class VendaDao {

    public void salvar(Venda venda) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        try {
            transacao = sessao.beginTransaction();
            sessao.save(venda);
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

    public void editar(Venda venda) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        try {
            transacao = sessao.beginTransaction();
            sessao.update(venda);
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

    public void excluir(Venda venda) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        try {
            transacao = sessao.beginTransaction();
            sessao.delete(venda);
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

    public List<Venda> listar() {

        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Venda> vendas = null;
        try {
            Query consulta = sessao.createQuery("FROM Venda");
            vendas = consulta.list();
        } catch (RuntimeException e) {
            throw e;
        } finally {
            sessao.close();
        }
        return vendas;
    }

    public Venda bucarPorCodigo(Long codigo) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Venda venda = null;
        try {
            Query consulta = sessao.createQuery("FROM Venda v Where v.codigo = :codigo");
            consulta.setLong("codigo", codigo);
            venda = (Venda) consulta.uniqueResult();
        } catch (RuntimeException e) {
            throw e;
        } finally {
            sessao.close();
        }
        return venda;
    }

}
