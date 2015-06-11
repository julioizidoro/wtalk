/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaodoalemao.facade;

import br.com.lojaodoalemao.dao.UsuarioDao;
import br.com.lojaodoalemao.model.Usuario;
import java.util.List;

/**
 *
 * @author Wolverine
 */
public class UsuarioFacade {
    
    UsuarioDao usuarioDao;
    
    public Usuario getUsuario(String login, String senha){
        usuarioDao = new UsuarioDao();
        return usuarioDao.getUsuario(login, senha);
    }
    
    public List<Usuario> listar(){
        usuarioDao = new UsuarioDao();
        return usuarioDao.listar();
    }
    
    public Usuario getUsuario(int idUsuario){
        usuarioDao = new UsuarioDao();
        return usuarioDao.getUsuario(idUsuario);
    }
    
}
