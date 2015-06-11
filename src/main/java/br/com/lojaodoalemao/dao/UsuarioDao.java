/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaodoalemao.dao;

import br.com.lojaodoalemao.model.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Wolverine
 */
public class UsuarioDao {
    
    EntityManagerFactory factory;

    public UsuarioDao() {
        factory = Persistence.createEntityManagerFactory("wtalkPU");
    }
    
    public Usuario getUsuario(String login, String senha){
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        Query q = manager.createQuery("select u from Usuario u where u.login='" + login + "' and u.senha='" + senha + "'  order by u.nome");
        if (q.getResultList().size()>0){
            Usuario usuario = (Usuario) q.getSingleResult();
            manager.close();
            return usuario;
        }
        manager.close();
        return null;
    }
    
    public List<Usuario> listar(int idUsuario){
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        Query q = manager.createQuery("select u from Usuario u where u.idusuario<>" + idUsuario +  "  order by u.nome");
        if (q.getResultList().size()>0){
            manager.close();
            return q.getResultList();
        }
        manager.close();
        return null;
    }
    
    public List<Usuario> listar(){
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        Query q = manager.createQuery("select u from Usuario u order by u.nome");
        List<Usuario> listaUsuarios = q.getResultList();
        manager.close();
        return listaUsuarios;
    }
    
    public Usuario getUsuario(int idUsuario){
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        Usuario usuario = manager.find(Usuario.class, idUsuario);
        manager.close();
        return usuario;
    }
    
    
    
    
}
