/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drogaria.dao;

import br.com.drogaria.domain.Item;
import br.com.drogaria.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Thiago Silva
 */
public class ItemDao {

    public void salvar(Item item) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        try {
            transacao = sessao.beginTransaction();
            sessao.save(item);
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

    public void editar(Item item) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        try {
            transacao = sessao.beginTransaction();
            sessao.update(item);
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

    public void excluir(Item item) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        try {
            transacao = sessao.beginTransaction();
            sessao.delete(item);
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

    public List<Item> listar() {

        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Item> itens = null;
        try {
            Query consulta = sessao.createQuery("FROM Item");
            itens = consulta.list();
        } catch (RuntimeException e) {
            throw e;
        } finally {
            sessao.close();
        }
        return itens;
    }

    public Item buscarPorCodigo(Long codigo) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Item item = null;
        try {
            Query consulta = sessao.createQuery("FROM Item i where i.codigo = :codigo");
            consulta.setLong("codigo", codigo);
            item = (Item) consulta.uniqueResult();
        } catch (RuntimeException e) {
            throw e;
        } finally {
            sessao.close();
        }
        return item;
    }

}
