/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaodoalemao.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "interacao")
public class Interacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idinteracao")
    private Integer idinteracao;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Size(max = 10)
    @Column(name = "hora")
    private String hora;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "assunto")
    private String assunto;
    @Size(max = 1)
    @Column(name = "lida")
    private String lida;
    @JoinColumn(name = "comunicacao_idcomunicacao", referencedColumnName = "idcomunicacao")
    @ManyToOne(optional = false)
    private Comunicacao comunicacao;
    @JoinColumn(name = "de", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario de;
    @JoinColumn(name = "para", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario para;

    public Interacao() {
    }

    public Interacao(Integer idinteracao) {
        this.idinteracao = idinteracao;
    }

    public Integer getIdinteracao() {
        return idinteracao;
    }

    public void setIdinteracao(Integer idinteracao) {
        this.idinteracao = idinteracao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getLida() {
        return lida;
    }

    public void setLida(String lida) {
        this.lida = lida;
    }

    public Comunicacao getComunicacao() {
        return comunicacao;
    }

    public Usuario getDe() {
        return de;
    }

    public void setDe(Usuario de) {
        this.de = de;
    }

    public Usuario getPara() {
        return para;
    }

    public void setPara(Usuario para) {
        this.para = para;
    }

    public void setComunicacao(Comunicacao comunicacao) {
        this.comunicacao = comunicacao;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinteracao != null ? idinteracao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Interacao)) {
            return false;
        }
        Interacao other = (Interacao) object;
        if ((this.idinteracao == null && other.idinteracao != null) || (this.idinteracao != null && !this.idinteracao.equals(other.idinteracao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.lojaodoalemao.model.Interacao[ idinteracao=" + idinteracao + " ]";
    }
    
}
