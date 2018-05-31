/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.universidad.service;

import ec.edu.espe.arquitectura.universidad.dao.PrerrequisitoFacade;
import ec.edu.espe.arquitectura.universidad.model.Prerrequisito;
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
public class PrerrequisitoService {
    
    @EJB
    private PrerrequisitoFacade prerrequisitoFacade;
    
    public List<Prerrequisito> obtenerTodos() {
        return this.prerrequisitoFacade.findAll();
    }
    
    public void crear(Prerrequisito prerrequsito) {
        this.prerrequisitoFacade.create(prerrequsito);
    }
    
    public void modificar (Prerrequisito prerrequisito) {
        this.prerrequisitoFacade.edit(prerrequisito);
    }
    
    public void eliminar(Integer codigo)
    {
        Prerrequisito prerrequisito = this.prerrequisitoFacade.find(codigo);
        this.prerrequisitoFacade.remove(prerrequisito);
    }
 
}
