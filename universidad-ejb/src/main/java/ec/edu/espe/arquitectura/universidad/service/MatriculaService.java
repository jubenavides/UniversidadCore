/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.universidad.service;

import ec.edu.espe.arquitectura.universidad.dao.MatriculaFacade;
import ec.edu.espe.arquitectura.universidad.model.Matricula;
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
public class MatriculaService {

    @EJB
    private MatriculaFacade matriculaFacade;
    
    public List<Matricula> obtenerTodos(){
        return this.matriculaFacade.findAll();
    }
    
    public void crearMatricula(Matricula matricula){
        this.matriculaFacade.create(matricula);
    }
}
