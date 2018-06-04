/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.universidad.dao;

import ec.edu.espe.arquitectura.universidad.model.DetalleMalla;
import java.util.List;
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
public class DetalleMallaFacade extends AbstractFacade<DetalleMalla> {

    @PersistenceContext(unitName = "ec.edu.espe.arquitectura.universidad_universidad-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleMallaFacade() {
        super(DetalleMalla.class);
    }
    
    public List<DetalleMalla> obtenerPorNombreAsignatura(String nombre) {
        Query qry = this.em.createQuery("SELECT obj FROM DetalleMalla obj WHERE obj.codAsignatura.nombre LIKE :nomBus");
        qry.setParameter("nomBus", "%" + nombre + "%");
        return qry.getResultList();
    }
    
    
}
