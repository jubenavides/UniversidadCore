/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.universidad.service;

import ec.edu.espe.arquitectura.universidad.dao.TareaFacade;
import ec.edu.espe.arquitectura.universidad.model.Tarea;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author adr95
 */
@Stateless
@LocalBean
public class TareaService {

    @EJB
    private TareaFacade tareaFacade;
    
    public List<Tarea> obtenerTodos(){
        return this.tareaFacade.findAll();
    }
    
    public Tarea obtenerPorCodigoTema(String codigo) {
        return this.tareaFacade.find(codigo);
    }
    
    public void crear(Tarea tarea) {
        this.tareaFacade.create(tarea);
    }
    
    public void modificar(Tarea tarea) {
        this.tareaFacade.edit(tarea);
    }
    
    public void eliminar(String codigo) {
        Tarea tarea = this.tareaFacade.find(codigo);
        this.tareaFacade.remove(tarea);
    }
}
