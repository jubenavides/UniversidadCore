/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.universidad.service;

import ec.edu.espe.arquitectura.universidad.dao.SilaboFacade;
import ec.edu.espe.arquitectura.universidad.model.Silabo;
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
public class SilaboService {

    @EJB
    private SilaboFacade silaboFacade;
    
    public List<Silabo> obtenerTodos(){
        return this.silaboFacade.findAll();
    }
    

    
}
