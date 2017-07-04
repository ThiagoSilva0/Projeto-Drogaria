/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drogaria.dao;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Thiago Silva
 */
public class FabricanteDao {

    public void salvar(Fabricante fabricante) {
        Session sessao = null;
        Transaction transacao = null;

        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.save(fabricante);
            transacao.commit();
        } catch (RuntimeException ex) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw ex;
        }
    }

    public List<Fabricante> listar() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();

        List<Fabricante> fabricantes = null;
        try {
            Query consulta = sessao.createQuery("From Fabricante");
            fabricantes = consulta.list();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            try {
                sessao.close();
            } catch (Exception e) {
                throw e;
            }
        }
        return fabricantes;
    }

    public Fabricante buscarPorCodigo(Long codigo) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();

        Fabricante fabricante = null;
        try {
            Query consulta = (Query) sessao.createQuery("Select fabricante FROM Fabricante fabricante WHERE fabricante.codigo like :codigo");
            consulta.setLong("codigo", codigo);
            fabricante = (Fabricante) consulta.uniqueResult();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }
        return fabricante;
    }

    public void excluir(Fabricante fabricante) {

        try {
            Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction transacao = sessao.beginTransaction();
            sessao.delete(fabricante);
            transacao.commit();
        } catch (RuntimeException ex) {

            throw ex;
        }
    }

    public void editar(Fabricante fabricante) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
//            Fabricante fabricanteEditar = buscarPorCodigo(fabricante.getCodigo());
//            fabricanteEditar.setDescricao(fabricante.getDescricao());
//            sessao.update(fabricanteEditar);
            sessao.update(fabricante);
            transacao.commit();
        } catch (RuntimeException ex) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw ex;
        }
    }

}
