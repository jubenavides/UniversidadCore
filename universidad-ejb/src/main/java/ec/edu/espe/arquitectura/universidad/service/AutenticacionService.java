/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.universidad.service;

import ec.edu.espe.arquitectura.universidad.dao.SegUsuarioFacade;
import ec.edu.espe.arquitectura.universidad.enums.EstadoSegUsuarioEnum;
import ec.edu.espe.arquitectura.universidad.exceptions.UsuarioBloqueadoException;
import ec.edu.espe.arquitectura.universidad.model.SegUsuario;
import ec.edu.espe.arquitectura.universidad.util.BCrypt;
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

    public SegUsuario login(String codUsuario, String clave) throws UsuarioBloqueadoException {
        SegUsuario usuario = this.segUsuarioFacade.find(codUsuario);
        if (usuario != null && BCrypt.checkpw(clave, usuario.getClave()) && usuario.getEstado().equals(EstadoSegUsuarioEnum.ACT)) {
            return usuario;
        } else if (usuario != null && BCrypt.checkpw(clave, usuario.getClave()) && usuario.getEstado().equals(EstadoSegUsuarioEnum.BLO)) {
            throw new UsuarioBloqueadoException("usuario " + usuario.getCodigo() + " se encuentra bloqueado");
        } else if (usuario != null && !BCrypt.checkpw(clave, usuario.getClave())) {
            usuario.setIntentosErroneos(usuario.getIntentosErroneos() + 1);
            segUsuarioFacade.edit(usuario);
            if (usuario.getIntentosErroneos() > 2) {
                usuario.setEstado(EstadoSegUsuarioEnum.BLO);
                segUsuarioFacade.edit(usuario);
                throw new UsuarioBloqueadoException("Ha excedido el numero de intentos usuario " + usuario.getCodigo() + " ha sido bloqueado");
            } else {
                return usuario;
            }
        }
        return null;
    }
}
