/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.universidad.service;


import ec.edu.espe.arquitectura.universidad.dao.SegPerfilFacade;
import ec.edu.espe.arquitectura.universidad.model.SegPerfil;
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
public class SegPerfilService {

    @EJB
    private SegPerfilFacade segPerfilFacade;
    
    public List<SegPerfil> obtenerTodos() {
        return this.segPerfilFacade.findAll();
    }
    
    public SegPerfil obtenerPorCodigoPerfil(String codigo) {
        return this.segPerfilFacade.find(codigo);
    }
    
    public void crear(SegPerfil perfil) {
        this.segPerfilFacade.create(perfil);
    }
    
    public void modificar(SegPerfil perfil) {
        this.segPerfilFacade.edit(perfil);
    }
    
    public void eliminar(String codigo) {
        SegPerfil perfil = this.segPerfilFacade.find(codigo);
        this.segPerfilFacade.remove(perfil);
    }
}