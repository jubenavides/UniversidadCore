/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.universidad.web;

import ec.edu.espe.arquitectura.universidad.model.Asignatura;
import ec.edu.espe.arquitectura.universidad.model.DetalleMatricula;
import ec.edu.espe.arquitectura.universidad.model.Nrc;
import ec.edu.espe.arquitectura.universidad.model.PeriodoLectivo;
import ec.edu.espe.arquitectura.universidad.service.DetalleMallaService;
import ec.edu.espe.arquitectura.universidad.service.NRCService;
import ec.edu.espe.arquitectura.universidad.service.PeriodoLectivoService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author diego
 */
@Named
@ViewScoped
public class MatriculaBean implements Serializable {

    private boolean mostrar;
    private Asignatura asignatura;
    private List<PeriodoLectivo> periodosLectivos;
    private PeriodoLectivo periodoSeleccionado;
    private List<Nrc> nrcDisponibles;
    private Nrc nrcSeleccionado;
    private List<DetalleMatricula> matriculaEstudiante;

    @Inject
    private PeriodoLectivoService periodoLectivoService;

    @Inject
    private DetalleMallaService detalleMallaService;
    
    @Inject
    private NRCService nrcService;

    @PostConstruct
    public void init() {
        this.periodosLectivos = this.periodoLectivoService.obtenerTodos();
        this.periodoSeleccionado = new PeriodoLectivo();
        
    }
    
    public void listarNRCDisponibles(){
        this.nrcDisponibles = this.nrcService.listarNrcPeriodo(this.periodoSeleccionado);
    }

    public void ocultarForms() {
        this.mostrar = false;
    }

    public void ocultarNrc() {
        this.mostrar = false;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public List<PeriodoLectivo> getPeriodosLectivos() {
        return periodosLectivos;
    }

    public void setPeriodosLectivos(List<PeriodoLectivo> periodosLectivos) {
        this.periodosLectivos = periodosLectivos;
    }

    public PeriodoLectivo getPeriodoSeleccionado() {
        return periodoSeleccionado;
    }

    public void setPeriodoSeleccionado(PeriodoLectivo periodoSeleccionado) {
        this.periodoSeleccionado = periodoSeleccionado;
    }

    public boolean isMostrar() {
        return mostrar;
    }

    public void setMostrar(boolean mostrar) {
        this.mostrar = mostrar;
    }

    public List<DetalleMatricula> getMatriculaEstudiante() {
        return matriculaEstudiante;
    }

    public void setMatriculaEstudiante(List<DetalleMatricula> matriculaEstudiante) {
        this.matriculaEstudiante = matriculaEstudiante;
    }

    public List<Nrc> getNrcDisponibles() {
        return nrcDisponibles;
    }

    public void setNrcDisponibles(List<Nrc> nrcDisponibles) {
        this.nrcDisponibles = nrcDisponibles;
    }

    public Nrc getNrcSeleccionado() {
        return nrcSeleccionado;
    }

    public void setNrcSeleccionado(Nrc nrcSeleccionado) {
        this.nrcSeleccionado = nrcSeleccionado;
    }
    
    

}
