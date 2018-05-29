/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.universidad.service;

import ec.edu.espe.arquitectura.universidad.dao.SubtemaFacade;
import ec.edu.espe.arquitectura.universidad.model.Subtema;
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
public class SubtemaService {

    @EJB
    private SubtemaFacade subtemaFacade;
    
    public List<Subtema> obtenerTodos(){
        return this.subtemaFacade.findAll();
    }
    
    public Subtema obtenerPorCodigoSubtema(String codigo) {
        return this.subtemaFacade.find(codigo);
    }
    
    public void crear(Subtema subtema) {
        this.subtemaFacade.create(subtema);
    }
    
    public void modificar(Subtema subtema) {
        this.subtemaFacade.edit(subtema);
    }
    
    public void eliminar(String codigo) {
        Subtema subtema = this.subtemaFacade.find(codigo);
        this.subtemaFacade.remove(subtema);
    }
}
