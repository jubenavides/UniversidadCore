/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.universidad.service;


import ec.edu.espe.arquitectura.universidad.dao.SegUsuarioFacade;
import ec.edu.espe.arquitectura.universidad.model.SegUsuario;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author jolube
 */
@Stateless
@LocalBean
public class SegUsuarioService {

    @EJB
    private SegUsuarioFacade segUsuarioFacade;
    
    public List<SegUsuario> obtenerTodos() {
        return this.segUsuarioFacade.findAll();
    }
    
    public SegUsuario obtenerPorCodigoUsuario(String codigo) {
        return this.segUsuarioFacade.find(codigo);
    }
    
    public void crear(SegUsuario usuario) {
        this.segUsuarioFacade.create(usuario);
    }
    
    public void modificar(SegUsuario usuario) {
        this.segUsuarioFacade.edit(usuario);
    }
    
    public void eliminar(String codigo) {
        SegUsuario usuario = this.segUsuarioFacade.find(codigo);
        this.segUsuarioFacade.remove(usuario);
    }
    
    public void desbloquearUsuarios(){
        this.segUsuarioFacade.unlockUsers();
    }
    
    public void bloquearUsuario(SegUsuario usuario){
        this.segUsuarioFacade.blockUsers(usuario);
    }
    
}