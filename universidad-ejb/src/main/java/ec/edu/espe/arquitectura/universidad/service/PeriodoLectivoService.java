/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.universidad.service;


import ec.edu.espe.arquitectura.universidad.dao.PeriodoLectivoFacade;
import ec.edu.espe.arquitectura.universidad.model.PeriodoLectivo;
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
public class PeriodoLectivoService {

     @EJB
    private PeriodoLectivoFacade periodoLectivoFacade;
    
    public List<PeriodoLectivo> obtenerTodos(){
        return this.periodoLectivoFacade.findAll();
    }
    
    public PeriodoLectivo obtenerPorCodigoPeriodoLectivo(String codigo){
        return this.periodoLectivoFacade.find(codigo);
    }
}
