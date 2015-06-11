/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaodoalemao.controller;

import br.com.lojaodoalemao.facade.ComunicacaoFacade;
import br.com.lojaodoalemao.model.Comunicacao;
import br.com.lojaodoalemao.model.Interacao;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wolverine
 */
public class ComunicacaoController {
    
    ComunicacaoFacade comunicacaoFacade;
    
    public List<Comunicacao> listar(int idUsuario){
        comunicacaoFacade = new ComunicacaoFacade();
        return comunicacaoFacade.listar(idUsuario);
    }
    
    public List<Interacao> listarInteracao(int idUsuario){
        comunicacaoFacade = new ComunicacaoFacade();
        return comunicacaoFacade.listarInteracao(idUsuario);
    }
    
    public void salvar(Comunicacao comunicacao) {
        comunicacaoFacade = new ComunicacaoFacade();
        try {
            comunicacaoFacade.salvar(comunicacao);
        } catch (Exception ex) {
            Logger.getLogger(ComunicacaoController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }
    
}
