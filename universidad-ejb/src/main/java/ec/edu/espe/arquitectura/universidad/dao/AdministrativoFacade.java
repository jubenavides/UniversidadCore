/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.universidad.dao;

import ec.edu.espe.arquitectura.universidad.model.Administrativo;
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
public class AdministrativoFacade extends AbstractFacade<Administrativo> {

    @PersistenceContext(unitName = "ec.edu.espe.arquitectura.universidad_universidad-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdministrativoFacade() {
        super(Administrativo.class);
    }
    
}
