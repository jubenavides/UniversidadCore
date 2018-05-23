/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.universidad.dao;

import ec.edu.espe.arquitectura.universidad.enums.EstadoSegUsuarioEnum;
import ec.edu.espe.arquitectura.universidad.model.SegUsuario;
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
public class SegUsuarioFacade extends AbstractFacade<SegUsuario> {

    @PersistenceContext(unitName = "ec.edu.espe.arquitectura.universidad_universidad-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SegUsuarioFacade() {
        super(SegUsuario.class);
    }
    
    public void unlockUsers(){
        List<SegUsuario> usuarios = this.em.createQuery("SELECT u FROM SegUsuario u WHERE u.estado=:estado")
                .setParameter("estado",EstadoSegUsuarioEnum.BLO).getResultList();
        for (SegUsuario usuario : usuarios) {
            usuario.setEstado(EstadoSegUsuarioEnum.ACT);
            usuario.setIntentosErroneos(0);
            this.edit(usuario);
            System.out.println("Se ha desbloqueado el usuario: " +usuario.getCodigo());
        }
    }
    
    public void blockUsers(SegUsuario usuario){
            usuario.setEstado(EstadoSegUsuarioEnum.BLO);
            this.edit(usuario);
        }
    
}
