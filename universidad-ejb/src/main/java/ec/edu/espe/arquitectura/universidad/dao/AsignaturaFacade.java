/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.universidad.dao;

import ec.edu.espe.arquitectura.universidad.model.Asignatura;
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
public class AsignaturaFacade extends AbstractFacade<Asignatura> {

    @PersistenceContext(unitName = "ec.edu.espe.arquitectura.universidad_universidad-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AsignaturaFacade() {
        super(Asignatura.class);
    }

    public List<Asignatura> obtenerPorNombreAsignatura(String nombreAsignatura) {
        Query q = this.em.createQuery("SELECT obj FROM Asignatura obj WHERE obj.nombre LIKE :nomBus");
        q.setParameter("nomBus", "%" + nombreAsignatura + "%");
        return q.getResultList();
    }

}
