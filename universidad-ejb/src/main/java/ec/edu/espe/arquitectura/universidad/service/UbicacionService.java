/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.universidad.service;

import ec.edu.espe.arquitectura.universidad.dao.UbicacionFacade;
import ec.edu.espe.arquitectura.universidad.model.Ubicacion;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author adr95
 */
@Stateless
@LocalBean
public class UbicacionService {

    @EJB
    
    private UbicacionFacade ubicacionFacade;
    
    public List<Ubicacion> obtenerTodos(){
        return ubicacionFacade.findAll();
    }
    
    public List<Ubicacion> obtenerAulas(){
        return ubicacionFacade.listarAulas();
    }
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
