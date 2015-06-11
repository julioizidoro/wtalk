/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaodoalemao.model;

import br.com.lojaodoalemao.util.Formatacao;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "comunicacao")
public class Comunicacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcomunicacao")
    private Integer idcomunicacao;
    @Size(max = 100)
    @Column(name = "assunto")
    private String assunto;
    @Column(name = "dataInicio")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    @Size(max = 10)
    @Column(name = "horaInicio")
    private String horaInicio;
    @Size(max = 50)
    @Column(name = "situacao")
    private String situacao;
    @Size(max = 50)
    @Column(name = "prioridade")
    private String prioridade;
    @Column(name = "dataFinalizada")
    @Temporal(TemporalType.DATE)
    private Date dataFinalizada;
    @Size(max = 5)
    @Column(name = "horaFinalizada")
    private String horaFinalizada;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comunicacao")
    private List<Interacao> interacaoList;

    public Comunicacao() {
        setDataInicio(new Date());
        setHoraInicio(Formatacao.foramtarHoraString());
        setSituacao("Ativa");
    }

    public Integer getIdcomunicacao() {
        return idcomunicacao;
    }

    public void setIdcomunicacao(Integer idcomunicacao) {
        this.idcomunicacao = idcomunicacao;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public Date getDataFinalizada() {
        return dataFinalizada;
    }

    public void setDataFinalizada(Date dataFinalizada) {
        this.dataFinalizada = dataFinalizada;
    }

    public String getHoraFinalizada() {
        return horaFinalizada;
    }

    public void setHoraFinalizada(String horaFinalizada) {
        this.horaFinalizada = horaFinalizada;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Interacao> getInteracaoList() {
        return interacaoList;
    }

    public void setInteracaoList(List<Interacao> interacaoList) {
        this.interacaoList = interacaoList;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcomunicacao != null ? idcomunicacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comunicacao)) {
            return false;
        }
        Comunicacao other = (Comunicacao) object;
        if ((this.idcomunicacao == null && other.idcomunicacao != null) || (this.idcomunicacao != null && !this.idcomunicacao.equals(other.idcomunicacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.lojaodoalemao.model.Comunicacao[ idcomunicacao=" + idcomunicacao + " ]";
    }
    
}
