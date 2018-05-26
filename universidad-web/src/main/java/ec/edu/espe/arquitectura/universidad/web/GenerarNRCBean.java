/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.universidad.web;

import ec.edu.espe.arquitectura.universidad.model.PeriodoLectivo;
import ec.edu.espe.arquitectura.universidad.model.Silabo;
import ec.edu.espe.arquitectura.universidad.service.PeriodoLectivoService;
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
public class GenerarNRCBean implements Serializable {

    private boolean mostrar;
    private List<PeriodoLectivo> periodosLectivos;
    
    @Inject
    private PeriodoLectivoService periodoLectivoService;
    
    @PostConstruct
    public void init(){
        this.periodosLectivos = this.periodoLectivoService.obtenerTodos();
    }

    public void generar() {
        this.mostrar = true;
    }

    public boolean isMostrar() {
        return mostrar;
    }

    public void setMostrar(boolean mostrar) {
        this.mostrar = mostrar;
    }

    public List<PeriodoLectivo> getPeriodosLectivos() {
        return periodosLectivos;
    }

    public void setPeriodosLectivos(List<PeriodoLectivo> periodosLectivos) {
        this.periodosLectivos = periodosLectivos;
    }
}
