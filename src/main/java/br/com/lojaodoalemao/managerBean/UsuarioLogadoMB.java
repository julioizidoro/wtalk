/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaodoalemao.managerBean;

//import java.io.Serializable;

import br.com.lojaodoalemao.controller.UsuarioController;
import br.com.lojaodoalemao.model.Usuario;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


/**
 *
 * @author Wolverine
 */

@Named("UsuarioLogadoBean")
@SessionScoped
public class UsuarioLogadoMB implements Serializable{
    
    
    private Usuario usuario;
    private String mensagem;

    public UsuarioLogadoMB() {
        usuario = new Usuario();
    }
    
    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    public String verificarLogin(){
        String senha = usuario.getSenha();
        String login = usuario.getLogin();
        if ((login.equalsIgnoreCase("")) || (senha.equalsIgnoreCase(""))){
            mensagem = "Campos não preenchido";
        }else {
            UsuarioController usuarioController = new UsuarioController();
            this.usuario = usuarioController.getUsuario(login, senha);
            if (usuario==null){
                mensagem = "Login e/ou senha incorreto";
                return null;
            }else {
                return "principal";
            }
        }
        return null;
    }
    
}
