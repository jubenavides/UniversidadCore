/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.universidad.dao;

import ec.edu.espe.arquitectura.universidad.model.SegPerfilFuncionalidad;
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
public class SegPerfilFuncionalidadFacade extends AbstractFacade<SegPerfilFuncionalidad> {

    @PersistenceContext(unitName = "ec.edu.espe.arquitectura.universidad_universidad-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SegPerfilFuncionalidadFacade() {
        super(SegPerfilFuncionalidad.class);
    }
    
    public List<SegPerfilFuncionalidad> findByPerfilCode(String codigo){
        return this.em.createQuery("SELECT f FROM SegPerfilFuncionalidad f WHERE f.segPerfil.codigo=?1")
                .setParameter(1, codigo).getResultList();
    }
}
