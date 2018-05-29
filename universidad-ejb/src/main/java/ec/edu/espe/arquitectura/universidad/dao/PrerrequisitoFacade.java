/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.universidad.dao;

import ec.edu.espe.arquitectura.universidad.model.DetalleMalla;
import ec.edu.espe.arquitectura.universidad.model.Prerrequisito;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author toshiba
 */
@Stateless
@LocalBean
public class PrerrequisitoFacade extends AbstractFacade<Prerrequisito>{
    
    @PersistenceContext(unitName = "ec.edu.espe.arquitectura.universidad_universidad-ejb_ejb_1PU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrerrequisitoFacade() {
        super(Prerrequisito.class);
    }
    
}
