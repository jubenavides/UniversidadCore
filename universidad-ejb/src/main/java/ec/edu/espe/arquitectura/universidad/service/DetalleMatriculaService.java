/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.universidad.service;

import ec.edu.espe.arquitectura.universidad.dao.DetalleMatriculaFacade;
import ec.edu.espe.arquitectura.universidad.model.DetalleMatricula;
import ec.edu.espe.arquitectura.universidad.model.Estudiante;
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
public class DetalleMatriculaService {
    
    @EJB
    DetalleMatriculaFacade detalleMatriculaFacade;
    
    public List<Estudiante> obtenerEstudiantesPorNrc(String nrc, String periodo){
        return detalleMatriculaFacade.listarEstudiantesPorNrc(nrc,periodo);
    }
    
    public void crearDetalleMatricula(DetalleMatricula detalleMatricula){
        this.detalleMatriculaFacade.create(detalleMatricula);
    }
}
