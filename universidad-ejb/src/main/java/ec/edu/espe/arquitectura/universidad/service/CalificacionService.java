/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.universidad.service;

import ec.edu.espe.arquitectura.universidad.dao.CalificacionFacade;
import ec.edu.espe.arquitectura.universidad.model.Calificacion;
import ec.edu.espe.arquitectura.universidad.util.EstudianteCalificacion;
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
public class CalificacionService {

    @EJB
    private CalificacionFacade calificacionFacade;

    public List<EstudianteCalificacion> obtenerPorNrc(String codNrc, String periodo, Integer parcial) {
        return this.calificacionFacade.listarPorNrc(codNrc, periodo, parcial);
    }
    
    public void guardarCalificaciones(List<EstudianteCalificacion> listEstudianteCalificacion){
        this.calificacionFacade.crearCalificaciones(listEstudianteCalificacion);
    }

}
