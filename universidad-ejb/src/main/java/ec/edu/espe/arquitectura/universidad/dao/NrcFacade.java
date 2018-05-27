/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.universidad.dao;

import ec.edu.espe.arquitectura.universidad.model.Asignatura;
import ec.edu.espe.arquitectura.universidad.model.Nrc;
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
public class NrcFacade extends AbstractFacade<Nrc> {

    @PersistenceContext(unitName = "ec.edu.espe.arquitectura.universidad_universidad-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NrcFacade() {
        super(Nrc.class);
    }

    public List<Nrc> listarNrcAsignatura(Asignatura codAsignatura) {
        Query q = this.em.createQuery("SELECT obj FROM Nrc obj WHERE obj.codAsignatura = ?1");
        q.setParameter(1, codAsignatura);
        return q.getResultList();
    }
}
