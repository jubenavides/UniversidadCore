/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.universidad.web;

import ec.edu.espe.arquitectura.universidad.model.Asignatura;
import ec.edu.espe.arquitectura.universidad.service.AsignaturaService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author diego
 */
@Named
@ViewScoped
public class AsignaturaBean implements Serializable{

    private List<Asignatura> asignaturas;
    
    @Inject
    private AsignaturaService asignaturaService;
    
    @PostConstruct
    public void init() {
        this.asignaturas = this.asignaturaService.obtenerTodos();
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }
}
