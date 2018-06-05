/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.universidad.service;

import ec.edu.espe.arquitectura.universidad.dao.DocenteFacade;
import ec.edu.espe.arquitectura.universidad.model.Docente;
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
public class DocenteService {

    @EJB
    private DocenteFacade docenteFacade;
    
    public List<Docente> obtenerTodos(){
        return this.docenteFacade.findAll();
    }
    
    public Docente obtenerPorCodigo(String codDocente){
        return this.docenteFacade.find(codDocente);
    }

}
