/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.universidad.dao;

import ec.edu.espe.arquitectura.universidad.model.DetalleMatricula;
import ec.edu.espe.arquitectura.universidad.model.Estudiante;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jolube
 */
@Stateless
@LocalBean
public class DetalleMatriculaFacade extends AbstractFacade<DetalleMatricula> {

    @PersistenceContext(unitName = "ec.edu.espe.arquitectura.universidad_universidad-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleMatriculaFacade() {
        super(DetalleMatricula.class);
    }
    
    public List<Estudiante> listarEstudiantesPorNrc(String nrc, String periodo) {
        List<DetalleMatricula> listDetalleMatricula = this.em.createQuery("SELECT e FROM DetalleMatricula e WHERE e.nrc.nrcPK.codNrc=?1 AND  e.nrc.nrcPK.codPeriodo=?2")
                .setParameter(1, nrc)
                .setParameter(2, periodo).getResultList();
        List<Estudiante> estudiantes = new ArrayList<>();
        for (DetalleMatricula det : listDetalleMatricula) {
            estudiantes.add(det.getCodMatricula().getCodEstudiante());
        }
        return estudiantes;
    }
    
    public List<DetalleMatricula> listadoMatriculasPorNrc(String nrc, String periodo) {
        List<DetalleMatricula> listDetalleMatricula = this.em.createQuery("SELECT e FROM DetalleMatricula e WHERE e.nrc.nrcPK.codNrc=?1 AND  e.nrc.nrcPK.codPeriodo=?2")
                .setParameter(1, nrc)
                .setParameter(2, periodo).getResultList();
        return listDetalleMatricula;
    }
}
