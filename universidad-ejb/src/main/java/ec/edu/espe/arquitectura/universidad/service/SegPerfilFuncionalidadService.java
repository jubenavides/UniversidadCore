/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.universidad.service;

import ec.edu.espe.arquitectura.universidad.dao.SegPerfilFuncionalidadFacade;
import ec.edu.espe.arquitectura.universidad.model.SegPerfilFuncionalidad;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author jolube
 */
@Stateless
@LocalBean
public class SegPerfilFuncionalidadService {
    
    @EJB
    private SegPerfilFuncionalidadFacade segPerfilFuncionalidadFacade;
    
        public List<SegPerfilFuncionalidad> obtenerTodos() {
        return this.segPerfilFuncionalidadFacade.findAll();
    }
    
    public List<SegPerfilFuncionalidad> obtenerPorCodigoPerfil(String codigo) {
        return this.segPerfilFuncionalidadFacade.findByPerfilCode(codigo);
    }
    
}
