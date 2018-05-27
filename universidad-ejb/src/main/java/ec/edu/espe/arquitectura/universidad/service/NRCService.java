/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.universidad.service;

import ec.edu.espe.arquitectura.universidad.dao.NrcFacade;
import ec.edu.espe.arquitectura.universidad.model.Asignatura;
import ec.edu.espe.arquitectura.universidad.model.Nrc;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author diego
 */
@Stateless
@LocalBean
public class NRCService implements NRCServiceLocal {

    @EJB
    private NrcFacade nrcFacade;

    public List<Nrc> obtenerTodos() {
        return this.nrcFacade.findAll();
    }

    public List<Nrc> listarNrcAsignatura(Asignatura codAsignatura) {
        return this.nrcFacade.listarNrcAsignatura(codAsignatura);
    }
}
