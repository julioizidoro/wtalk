/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaodoalemao.dao;

import br.com.lojaodoalemao.model.Comunicacao;
import br.com.lojaodoalemao.model.Interacao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Wolverine
 */
public class ComunicacaoDao {
    
    EntityManagerFactory factory;

    public ComunicacaoDao() {
        factory = Persistence.createEntityManagerFactory("wtalkPU");
    }
    
    public List<Comunicacao> listar(int idUsuario){
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        Query q = manager.createQuery("select c from Comunicacao c where c.usuario.idusuario=" + idUsuario 
                + "  and c.situacao<>'Finalizada'  order by c.dataInicio, c.horaInicio");
        List<Comunicacao> listaComunicacao = q.getResultList();
        manager.close();
        return listaComunicacao;
    }
    
    public List<Interacao> listarInteracao(int idUsuario){
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        Query q = manager.createQuery("select i from Interacao i where i.de.idusuario=" + idUsuario +
                " or i.para.idusuario=" + idUsuario 
                + "  and i.comunicacao.situacao<>'Finalizada'  order by i.comunicacao.idcomunicacao");
        List<Interacao> listaInteracao = q.getResultList();
        manager.close();
        return listaInteracao;
    }
    
    public void salvar(Comunicacao comunicacao) {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        comunicacao = manager.merge(comunicacao);
        manager.getTransaction().commit();
        manager.close();
    }
    
    public void salvar(Interacao interacao) {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction();
        Comunicacao comnunicacao = manager.find(Comunicacao.class, 1);
        interacao.setComunicacao(comnunicacao);
        interacao = manager.merge(interacao);
        manager.close();
    }
    
    
    
}
