/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.universidad.web;

import ec.edu.espe.arquitectura.universidad.enums.AprobacionNRCEnum;
import ec.edu.espe.arquitectura.universidad.model.Asignatura;
import ec.edu.espe.arquitectura.universidad.model.DetalleMatricula;
import ec.edu.espe.arquitectura.universidad.model.Matricula;
import ec.edu.espe.arquitectura.universidad.model.Nrc;
import ec.edu.espe.arquitectura.universidad.model.PeriodoLectivo;
import ec.edu.espe.arquitectura.universidad.service.DetalleMallaService;
import ec.edu.espe.arquitectura.universidad.service.DetalleMatriculaService;
import ec.edu.espe.arquitectura.universidad.service.MatriculaService;
import ec.edu.espe.arquitectura.universidad.service.NRCService;
import ec.edu.espe.arquitectura.universidad.service.PeriodoLectivoService;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.util.Messages;

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
    private List<Matricula> matriculas;
    private DetalleMatricula detMat;
    private Matricula matricula;
    private Integer secuenciaMatricula;

    @Inject
    private PeriodoLectivoService periodoLectivoService;

    @Inject
    private DetalleMallaService detalleMallaService;

    @Inject
    private NRCService nrcService;

    @Inject
    private MatriculaService matriculaService;

    @Inject
    private DetalleMatriculaService detalleMatriculaService;

    @PostConstruct
    public void init() {
        this.periodosLectivos = this.periodoLectivoService.obtenerTodos();
        this.periodoSeleccionado = new PeriodoLectivo();
        this.matriculaEstudiante = new ArrayList<>();

    }

    public void listarNRCDisponibles() {
        this.nrcDisponibles = this.nrcService.listarNrcPeriodo(this.periodoSeleccionado);
        this.mostrar = true;
    }

    public void guardarMatricula() {
        this.secuenciaMatricula = 0;
        this.matriculas = matriculaService.obtenerTodos();
        if (!this.matriculas.isEmpty()) {
            Integer ultimoHorario = this.matriculas.size();
            this.secuenciaMatricula = Integer.parseInt(this.matriculas.get(ultimoHorario - 1).getCodigo().split("-")[1]);
            this.secuenciaMatricula++;
        }
        DecimalFormat formateador = new DecimalFormat("00000000");
        try {
            this.matricula = new Matricula();
            this.detMat = new DetalleMatricula();
            String codMatricula = "M-" + formateador.format(this.secuenciaMatricula);
            this.matricula.setCodigo(codMatricula);
            this.matricula.setCodPeriodo(this.periodoSeleccionado);
            this.matricula.setCostoMatricula(new BigDecimal("0"));
            this.matricula.setPromedio(new BigDecimal("0"));
            this.matricula.setPagado("NO");
            this.matriculaService.crearMatricula(matricula);
            guardarDetalleMatricula(matricula);
//            Messages.addFlashGlobalInfo("Se agregó el Nrc: " + nuevoNrc.getNrcPK().getCodNrc() + ", para la materia" + this.asignaturaSeleccionada.getNombre());
        } catch (Exception ex) {
            Messages.addGlobalError(null, "Ocurrí\u00f3 un error al guardar la matrícula");
        }
    }

    public void agregarAsignaturaMatricula() {
        boolean band = false;
        for (DetalleMatricula mat : this.matriculaEstudiante) {
            if (this.nrcSeleccionado.getNrcPK().getCodNrc().equals(mat.getNrc().getNrcPK().getCodNrc())
                    || this.nrcSeleccionado.getCodAsignatura().getNombre().equals(mat.getNrc().getCodAsignatura().getNombre()) 
                    || !this.nrcSeleccionado.getNrcPK().getCodPeriodo().equals(mat.getNrc().getNrcPK().getCodPeriodo())) {
                band = true;
                break;
            }
        }
        if (!band) {
            detMat = new DetalleMatricula();
            detMat.setNrc(nrcSeleccionado);
            detMat.setAprobacionNrc(AprobacionNRCEnum.NO);
            this.matriculaEstudiante.add(detMat);
        }
    }

    public void guardarDetalleMatricula(Matricula matricula) {
        for (DetalleMatricula detalle : this.matriculaEstudiante) {
            detalle.setCodMatricula(matricula);
            try {
                this.detalleMatriculaService.crearDetalleMatricula(detalle);
                this.matriculaEstudiante = new ArrayList<>();
                Messages.addFlashGlobalInfo("Se agregó el Nrc: " + detalle.getNrc().getNrcPK().getCodNrc() + ", para la materia" + detalle.getNrc().getCodAsignatura().getNombre());
            } catch (Exception ex) {
                Messages.addGlobalError(null, "Ocurrí\u00f3 un error al guardar el detalle de la matrícula");
            }
        }
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

    public Integer getSecuenciaMatricula() {
        return secuenciaMatricula;
    }

    public void setSecuenciaMatricula(Integer secuenciaMatricula) {
        this.secuenciaMatricula = secuenciaMatricula;
    }

}
