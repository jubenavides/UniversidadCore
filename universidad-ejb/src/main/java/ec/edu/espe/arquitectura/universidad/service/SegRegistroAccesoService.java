/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.universidad.service;


import ec.edu.espe.arquitectura.universidad.dao.SegRegistroAccesoFacade;
import ec.edu.espe.arquitectura.universidad.model.SegRegistroAcceso;
import ec.edu.espe.arquitectura.universidad.model.SegRegistroAcceso;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author jolube
 */
@Stateless
@LocalBean
public class SegRegistroAccesoService {

    @EJB
    private SegRegistroAccesoFacade segRegistroAccesoFacade;
    
    public List<SegRegistroAcceso> obtenerTodos() {
        return this.segRegistroAccesoFacade.findAll();
    }
    
    public SegRegistroAcceso obtenerPorCodigoPerfil(String codigo) {
        return this.segRegistroAccesoFacade.find(codigo);
    }
    
    public void crear(SegRegistroAcceso registro) {
        this.segRegistroAccesoFacade.create(registro);
    }
    
}