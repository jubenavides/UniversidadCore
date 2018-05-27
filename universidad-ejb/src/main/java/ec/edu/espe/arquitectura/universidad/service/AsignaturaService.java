/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.universidad.service;

import ec.edu.espe.arquitectura.universidad.dao.AsignaturaFacade;
import ec.edu.espe.arquitectura.universidad.model.Asignatura;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author diego
 */
@Stateless
@LocalBean
public class AsignaturaService implements AsignaturaServiceLocal {
    @EJB
    private AsignaturaFacade asignaturaFacade;
    
    public List<Asignatura> obtenerTodos(){
        return this.asignaturaFacade.findAll();
    }
    
    public List<Asignatura> obtenerPorNombreAsignatura(String nombreAsignatura){
        return this.asignaturaFacade.obtenerPorNombreAsignatura(nombreAsignatura);
    }
    
}
