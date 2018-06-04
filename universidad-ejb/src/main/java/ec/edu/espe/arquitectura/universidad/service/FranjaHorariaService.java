/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.universidad.service;

import ec.edu.espe.arquitectura.universidad.dao.FranjaHorariaFacade;
import ec.edu.espe.arquitectura.universidad.model.FranjaHoraria;
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
public class FranjaHorariaService {

    @EJB
    
    private FranjaHorariaFacade franjaFacade;
    
    public List<FranjaHoraria> obtenerTodos(){
        return franjaFacade.findAll();
    }
}
