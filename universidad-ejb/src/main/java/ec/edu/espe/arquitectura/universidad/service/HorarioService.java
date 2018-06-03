/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.universidad.service;

import ec.edu.espe.arquitectura.universidad.dao.HorarioFacade;
import ec.edu.espe.arquitectura.universidad.model.Horario;
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
public class HorarioService {

    @EJB
    
    private HorarioFacade horarioFacade;
    
    public List<Horario> obtenerTodos(){
        return horarioFacade.findAll();
    }
    
    public Horario obtenerPorCodigoHorario(String codigo) {
        return this.horarioFacade.find(codigo);
    }
    
    public void crear(Horario horario) {
        this.horarioFacade.create(horario);
    }
    
    public void modificar(Horario horario) {
        this.horarioFacade.edit(horario);
    }
    
    public void eliminar(String codigo) {
        Horario horario = this.horarioFacade.find(codigo);
        this.horarioFacade.remove(horario);
    }
}
