/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drogaria.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Thiago Silva
 */
@Entity
@Table(name = "tbl_itens")
public class Item implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo")
    private Long codigo;
    
    @Column(name = "ite_quantidade", nullable = false)
    private Integer quantidade;
    
    @Column(name = "ite_valor_parcial",precision = 7, scale = 2,nullable = false)
    private BigDecimal valorParcial;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_vendas_ven_codigo", referencedColumnName = "ven_codigo",nullable = false)
    private Venda venda;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_produto_pro_codigo",referencedColumnName = "pro_codigo",nullable = false)
    private Produto produto;
    
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorParcial() {
        return valorParcial;
    }

    public void setValorParcial(BigDecimal valorParcial) {
        this.valorParcial = valorParcial;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return "Item{" + "codigo=" + codigo + ", quantidade=" + quantidade + ", valorParcial=" + valorParcial + ", venda=" + venda + ", produto=" + produto + '}';
    }

   
    
}
