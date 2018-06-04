/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.universidad.service;

import ec.edu.espe.arquitectura.universidad.dao.DetalleMallaFacade;
import ec.edu.espe.arquitectura.universidad.model.DetalleMalla;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author toshiba
 */
@Stateless
@LocalBean
public class DetalleMallaService {
    
    @EJB
    private DetalleMallaFacade detalleMallaFacade;
    
    public List<DetalleMalla> obtenerTodos() {
        return this.detalleMallaFacade.findAll();
    }
    
    public DetalleMalla obtenerPorCodigoDetalleMalla(Integer codigo) {
        return this.detalleMallaFacade.find(codigo);
    }
    
    public List<DetalleMalla> obtenerPorNombre(String nombreAsignatura) {
        return this.detalleMallaFacade.obtenerPorNombreAsignatura(nombreAsignatura);
    }
    
}
