/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojaodoalemao.converter;

import br.com.lojaodoalemao.controller.UsuarioController;
import br.com.lojaodoalemao.model.Usuario;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Wolverine
 */

@FacesConverter(forClass=Usuario.class)
public class UsuarioConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        UsuarioController usuarioController = new UsuarioController();
        int idUsuario = Integer.parseInt(value);
        Usuario usuario = usuarioController.getUsuario(idUsuario);
        return usuario;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return String.valueOf(value);
    }
    
}
