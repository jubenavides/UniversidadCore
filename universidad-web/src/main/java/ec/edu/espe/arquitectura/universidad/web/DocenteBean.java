/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.universidad.web;

import ec.edu.espe.arquitectura.universidad.model.PeriodoLectivo;
import ec.edu.espe.arquitectura.universidad.model.Docente;
import ec.edu.espe.arquitectura.universidad.model.Nrc;
//import ec.edu.espe.arquitectura.universidad.service.PeriodoLectivoService;
import ec.edu.espe.arquitectura.universidad.service.DocenteService;
import ec.edu.espe.arquitectura.universidad.service.NRCService;
import ec.edu.espe.arquitectura.universidad.service.PeriodoLectivoService;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.annotation.PostConstruct;

/**
 *
 * @author adr95
 */
@Named
@ViewScoped
public class DocenteBean implements Serializable {

    private boolean mostrar;
    private List<Docente> docentes;
    private Docente docente;
    private Docente docenteSel;
    private List<PeriodoLectivo> periodosLectivos;
    private PeriodoLectivo periodoSeleccionado;
    private Nrc nrcSeleccionado;
    private String codigoPeriodoLectivo;
    private List<Nrc> nrcDisponibles;

    @Inject
    private DocenteService docenteService;
    @Inject
    private PeriodoLectivoService periodoLectivoService;

    @Inject
    private NRCService nrcService;

    @PostConstruct
    public void init() {
        this.docentes = this.docenteService.obtenerTodos();
        this.docente = new Docente();
        this.periodosLectivos = this.periodoLectivoService.obtenerTodos();
        this.periodoSeleccionado = new PeriodoLectivo();
        this.nrcSeleccionado = new Nrc();
        this.nrcDisponibles = this.nrcService.listarNrcPeriodo(this.periodoSeleccionado);
    }

    public boolean isMostrar() {
        return mostrar;
    }

    public void setMostrar(boolean mostrar) {
        this.mostrar = mostrar;
    }

    public void listarNRCDisponibles() {
        this.nrcDisponibles = this.nrcService.listarNrcPeriodo(this.periodoSeleccionado);
    }

    public List<Nrc> getNrcDisponibles() {
        return nrcDisponibles;
    }

    public void setNrcDisponibles(List<Nrc> nrcDisponibles) {
        this.nrcDisponibles = nrcDisponibles;
    }

    public PeriodoLectivo getPeriodoSeleccionado() {
        return periodoSeleccionado;
    }

    public void setPeriodoSeleccionado(PeriodoLectivo periodoSeleccionado) {
        this.periodoSeleccionado = periodoSeleccionado;
    }

    public List<Docente> getDocentes() {
        return docentes;
    }

    public void setDocentes(List<Docente> docentes) {
        this.docentes = docentes;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Docente getDocenteSel() {
        return docenteSel;
    }

    public void setDocenteSel(Docente docenteSel) {
        this.docenteSel = docenteSel;
    }

    public List<PeriodoLectivo> getPeriodosLectivos() {
        return periodosLectivos;
    }

    public void setPeriodosLectivos(List<PeriodoLectivo> periodosLectivos) {
        this.periodosLectivos = periodosLectivos;
    }

    public String getCodigoPeriodoLectivo() {
        return codigoPeriodoLectivo;
    }

    public void setCodigoPeriodoLectivo(String codigoPeriodoLectivo) {
        this.codigoPeriodoLectivo = codigoPeriodoLectivo;
    }

    public DocenteService getDocenteService() {
        return docenteService;
    }

    public void setDocenteService(DocenteService docenteService) {
        this.docenteService = docenteService;
    }

    //public PeriodoLectivoService getPeriodoLectivoService() {
    //  return periodoLectivoService;
    //}
    //public void setPeriodoLectivoService(PeriodoLectivoService periodoLectivoService) {
    //  this.periodoLectivoService = periodoLectivoService;
    //}
}
