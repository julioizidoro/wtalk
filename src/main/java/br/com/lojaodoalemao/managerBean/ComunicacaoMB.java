/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaodoalemao.managerBean;

import br.com.lojaodoalemao.controller.ComunicacaoController;
import br.com.lojaodoalemao.controller.UsuarioController;
import br.com.lojaodoalemao.model.Comunicacao;
import br.com.lojaodoalemao.model.Interacao;
import br.com.lojaodoalemao.model.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;



import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Wolverine
 */
@Named("ComunicacaoMB")
@SessionScoped
public class ComunicacaoMB implements Serializable{
    
    @Inject
    private UsuarioLogadoMB usuarioLogadoMB;
    private List<Comunicacao> listaComunicacao;
    private Comunicacao comunicacao;
    private String titulo;
    private Interacao interacao;
    private List<Usuario> listaUsuario;
    private String idUsuario;

    public ComunicacaoMB() {
        comunicacao = new Comunicacao();
        interacao = new Interacao();
    }

    public UsuarioLogadoMB getUsuarioLogadoMB() {
        return usuarioLogadoMB;
    }

    public void setUsuarioLogadoMB(UsuarioLogadoMB usuarioLogadoMB) {
        this.usuarioLogadoMB = usuarioLogadoMB;
    }

    public List<Comunicacao> getListaComunicacao() {
        carregarListaComunicacao();
        return listaComunicacao;
    }

    public void setListaComunicacao(List<Comunicacao> listaComunicacao) {
        this.listaComunicacao = listaComunicacao;
    }

    public Comunicacao getComunicacao() {
        return comunicacao;
    }

    public void setComunicacao(Comunicacao comunicacao) {
        this.comunicacao = comunicacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Interacao getInteracao() {
        return interacao;
    }

    public void setInteracao(Interacao interacao) {
        this.interacao = interacao;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<Usuario> getListaUsuario() {
        carregarListaUsuarios();
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }
    
    public String carregarListaComunicacao(){
        ComunicacaoController comunicacaoController = new ComunicacaoController();
        List<Interacao> listaInteracao = comunicacaoController.listarInteracao(usuarioLogadoMB.getUsuario().getIdusuario());
        if (listaInteracao!=null){
            int comInserida = 0;
            int comLista = 0;
            listaComunicacao = new ArrayList<Comunicacao>();
            for (int i=0;i<listaInteracao.size();i++){
                comLista = listaInteracao.get(i).getComunicacao().getIdcomunicacao();
                if (comInserida!=comLista){
                    listaComunicacao.add(listaInteracao.get(i).getComunicacao());
                    comInserida = listaInteracao.get(i).getComunicacao().getIdcomunicacao();
                }
            }
        }
        return "Ok";
    }
    
    public String atualizar(){
        carregarListaComunicacao();
        return "jsf/principal";
    }
    
    public String filtrar(){
        return "jsf/principal";
    }
    
    public String nova(){
        titulo = "Nova Comunicação";
        return "cadcom";
    }
    
    public void carregarListaUsuarios(){
        UsuarioController usuarioController = new UsuarioController();
        listaUsuario = usuarioController.listar();
        if (listaUsuario==null){
            listaUsuario = new ArrayList<Usuario>();
        }
    }
    
    public String salvar(){
        ComunicacaoController comunicacaoController = new ComunicacaoController();
        interacao.setComunicacao(comunicacao);
        interacao.setData(new Date());
        interacao.setHora(comunicacao.getHoraInicio());
        interacao.setLida("N");
        interacao.setDe(usuarioLogadoMB.getUsuario());
        UsuarioController usuarioController = new UsuarioController();
        interacao.setPara(usuarioController.getUsuario(Integer.parseInt(idUsuario)));
       
        this.comunicacao.setUsuario(usuarioLogadoMB.getUsuario());
        this.interacao.setComunicacao(comunicacao);
         if (this.comunicacao.getInteracaoList()==null){
            this.comunicacao.setInteracaoList(new ArrayList<Interacao>());
        }
        this.comunicacao.getInteracaoList().add(interacao);
        comunicacaoController.salvar(comunicacao);
//        ComunicacaoDao comunicacaoDao = new ComunicacaoDao();
//        comunicacaoDao.salvar(interacao);
        return "principal";
    }
    
    public String cancelar(){
        return "principal";
    }
}




//<!--
//             <p:pickList id="pickListaUsuarios" value="#{ComunicacaoMB.usuarios}" var="usuario" 
//                         itemLabel="#{usuario.nome}" itemValue="#{usuario}" >
//                <f:facet name="sourceCaption">Usuários</f:facet>
//                <f:facet name="targetCaption">Selecionados</f:facet>
//             </p:pickList> 
//             -->
