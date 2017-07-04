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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Thiago Silva
 */
@Entity
@Table(name = "tbl_produto")
public class Produto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pro_codigo")
    private Long codigo;
    
    @Column(name = "pro_decricao", length = 50, nullable = false)
    private String descricao;
    
    @Column(name = "pro_preco", precision = 7,scale = 2,nullable = false )
    private BigDecimal preco;
    
    @Column(name = "pro_quantidade", nullable = false)
    private Integer quantidade;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_fabricante_fab_codigo", referencedColumnName = "fab_codigo", nullable = false)
    private Fabricante fabricante; 

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    @Override
    public String toString() {
        return "Produto{" + "codigo=" + codigo + ", descricao=" + descricao + ", preco=" + preco + ", quantidade=" + quantidade + ", fabricante=" + fabricante + '}';
    }
    
    
}
