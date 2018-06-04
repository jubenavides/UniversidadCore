/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.universidad.web;

import ec.edu.espe.arquitectura.universidad.model.SegUsuario;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author jubenavides
 */
@Named
@SessionScoped
public class UsuarioSesionBean implements Serializable{
    
    private SegUsuario usuario;
    
     public boolean isLoggedIn() {
        return usuario != null && !usuario.getCodigo().isEmpty();
    }

    public String getNombre() {
        return this.usuario.getNombre();
    }
    
    public String getCodUsuario() {
        return this.usuario.getCodigo();
    }

    public String getCodPerfil() {
        return this.usuario.getCodPerfil().getCodigo();
    }
    
    public SegUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(SegUsuario usuario) {
        this.usuario = usuario;
    }

}
