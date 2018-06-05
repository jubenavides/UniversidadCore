/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.universidad.dao;

import ec.edu.espe.arquitectura.universidad.model.Calificacion;
import ec.edu.espe.arquitectura.universidad.model.CalificacionPK;
import ec.edu.espe.arquitectura.universidad.model.DetalleMatricula;
import ec.edu.espe.arquitectura.universidad.model.Estudiante;
import ec.edu.espe.arquitectura.universidad.util.EstudianteCalificacion;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jolube
 */
@Stateless
@LocalBean
public class CalificacionFacade extends AbstractFacade<Calificacion> {

    @PersistenceContext(unitName = "ec.edu.espe.arquitectura.universidad_universidad-ejb_ejb_1PU")
    private EntityManager em;
    
    @EJB
    DetalleMatriculaFacade detalleMatriculaFacade;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CalificacionFacade() {
        super(Calificacion.class);
    }
        
    public Calificacion calificacionPorDetalleMatriculaYParcial(Integer codDetalleMatricula, Integer parcial){
        Calificacion calificacion = this.em.createQuery("SELECT c FROM Calificacion c WHERE c.calificacionPK.codDetalleMatricula=?1 AND  c.calificacionPK.secCalificacion=?2", Calificacion.class)
                .setParameter(1, codDetalleMatricula)
                .setParameter(2, parcial).getSingleResult();
        return calificacion;
    }

    public List<EstudianteCalificacion> listarPorNrc(String codNrc, String periodo, Integer parcial) {
        List<Estudiante> estudiantes = detalleMatriculaFacade.listarEstudiantesPorNrc(codNrc, periodo);
        List<DetalleMatricula> detallesMatriculas = detalleMatriculaFacade.listadoMatriculasPorNrc(codNrc, periodo);
        List<EstudianteCalificacion> listEstudianteCalificacion = new ArrayList<>();
        for(int i=0; i<detallesMatriculas.size();i++){
            EstudianteCalificacion estCali = new EstudianteCalificacion();
            Calificacion calificacion = this.calificacionPorDetalleMatriculaYParcial(detallesMatriculas.get(i).getCodigo(), parcial);
            if(calificacion!=null){
                estCali.setCalificacion(calificacion.getPuntaje());
            }
            estCali.setCodEstudiante(estudiantes.get(i).getCodigo());
            estCali.setNombreEstudiante(estudiantes.get(i).getApellidos()+ " "+ estudiantes.get(i).getNombres());
            estCali.setCodDetalleMatricula(detallesMatriculas.get(i).getCodigo());
            estCali.setCodNrc(codNrc);
            estCali.setParcial(parcial);
            listEstudianteCalificacion.add(estCali);
        }
        return listEstudianteCalificacion;
    }
    
    public void crearCalificaciones(List<EstudianteCalificacion> listEstudianteCalificacion){
        for (EstudianteCalificacion estCal: listEstudianteCalificacion) {
            Calificacion calificacion = new Calificacion();
            CalificacionPK pk = new CalificacionPK(estCal.getCodDetalleMatricula(), estCal.getParcial());
            calificacion.setCalificacionPK(pk);
            calificacion.setDetalleMatricula(detalleMatriculaFacade.find(estCal.getCodDetalleMatricula()));
            calificacion.setPuntaje(estCal.getCalificacion());
            this.create(calificacion);
        }
    }
    
}
