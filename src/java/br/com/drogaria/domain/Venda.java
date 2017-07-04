/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drogaria.domain;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Thiago Silva
 */
@Entity
@Table(name = "tbl_venda")
public class Venda  {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ven_codigo")
    private Long codigo;
    
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "ven_horario", nullable = false)
    private Date horario;
    
    @Column(name = "ven_valor_total",precision = 7,scale = 2, nullable = false)
    private BigDecimal valorTotal;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_funcionario_fun_codigo", referencedColumnName = "fun_codigo", nullable = false)
    private Funcionario funcionario; 


    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public String toString() {
        return "Venda{" + "codigo=" + codigo + ", horario=" + horario + ", valorTotal=" + valorTotal + ", funcionario=" + funcionario + '}';
    }
    
    
}
