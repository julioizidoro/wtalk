/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaodoalemao.facade;

import br.com.lojaodoalemao.dao.ComunicacaoDao;
import br.com.lojaodoalemao.model.Comunicacao;
import br.com.lojaodoalemao.model.Interacao;
import java.util.List;

/**
 *
 * @author Wolverine
 */
public class ComunicacaoFacade {
    
    ComunicacaoDao comunicacaoDao;
    
    public List<Comunicacao> listar(int idUsuario){
        comunicacaoDao = new ComunicacaoDao();
        return comunicacaoDao.listar(idUsuario);
    }
    
    public List<Interacao> listarInteracao(int idUsuario){
        comunicacaoDao = new ComunicacaoDao();
        return comunicacaoDao.listarInteracao(idUsuario);
    }
    
    public void salvar(Comunicacao comunicacao) throws Exception{
        comunicacaoDao = new ComunicacaoDao();
        comunicacaoDao.salvar(comunicacao);
    }
    
}
