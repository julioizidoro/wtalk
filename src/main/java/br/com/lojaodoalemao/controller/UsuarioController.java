/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaodoalemao.controller;

import br.com.lojaodoalemao.facade.UsuarioFacade;
import br.com.lojaodoalemao.model.Usuario;
import java.util.List;

/**
 *
 * @author Wolverine
 */
public class UsuarioController {
    
    UsuarioFacade usuarioFacade;
    
    public Usuario getUsuario(String login, String senha){
        usuarioFacade= new UsuarioFacade();
        return usuarioFacade.getUsuario(login, senha);
    }
    
    public List<Usuario> listar(){
        usuarioFacade = new UsuarioFacade();
        return usuarioFacade.listar();
    }
    
    public Usuario getUsuario(int idUsuario){
        usuarioFacade = new UsuarioFacade();
        return usuarioFacade.getUsuario(idUsuario);
    }
    
}
