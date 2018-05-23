/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.universidad.service;

import ec.edu.espe.arquitectura.universidad.dao.SegUsuarioFacade;
import ec.edu.espe.arquitectura.universidad.enums.EstadoSegUsuarioEnum;
import ec.edu.espe.arquitectura.universidad.model.SegUsuario;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Hendrix
 */
@LocalBean
@Stateless
public class AutenticacionService {

    @EJB
    private SegUsuarioFacade segUsuarioFacade;

    public SegUsuario login(String codUsuario, String clave) {
        SegUsuario usuario = this.segUsuarioFacade.find(codUsuario);
        if (usuario != null && usuario.getClave().equals(clave) && usuario.getEstado().equals(EstadoSegUsuarioEnum.ACT)) {
            return usuario;
        } else {
            if (usuario != null) {
                usuario.setIntentosErroneos(usuario.getIntentosErroneos() + 1);
                segUsuarioFacade.edit(usuario);
                if (usuario.getIntentosErroneos() > 2) {
                    System.err.println("Numero de intentos excedidos se ha bloqueado la cuenta");
                    this.segUsuarioFacade.blockUsers(usuario);
                }
            }
            return null;
        }
    }
}
