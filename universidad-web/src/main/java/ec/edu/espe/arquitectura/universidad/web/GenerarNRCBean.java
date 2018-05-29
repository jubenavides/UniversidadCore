/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.universidad.web;

import ec.edu.espe.arquitectura.universidad.model.Asignatura;
import ec.edu.espe.arquitectura.universidad.model.Nrc;
import ec.edu.espe.arquitectura.universidad.model.NrcPK;
import ec.edu.espe.arquitectura.universidad.model.PeriodoLectivo;
import ec.edu.espe.arquitectura.universidad.service.AsignaturaService;
import ec.edu.espe.arquitectura.universidad.service.NRCService;
import ec.edu.espe.arquitectura.universidad.service.PeriodoLectivoService;
import java.io.Serializable;
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
public class GenerarNRCBean implements Serializable {

    private boolean mostrar;
    private Asignatura asignaturaSeleccionada;
    private Asignatura asignatura;
    private List<PeriodoLectivo> periodosLectivos;
    private PeriodoLectivo periodoSeleccionado;
    private List<Nrc> nrcGenerados;
    private int numNRC;
    private List<Asignatura> asignaturas;
    private List<Nrc> nrcExistentes;
    private List<Nrc> nrcExistentesAsignatura;
    private Integer secuenciaNrc;
    private Nrc nrc;

    @Inject
    private PeriodoLectivoService periodoLectivoService;
    @Inject
    private NRCService nrcService;

    @Inject
    private AsignaturaService asignaturaService;

    @PostConstruct
    public void init() {
        this.periodosLectivos = this.periodoLectivoService.obtenerTodos();
        this.asignaturas = this.asignaturaService.obtenerTodos();
        nrcGenerados = new ArrayList<>();
        this.secuenciaNrc = 0;
        this.asignatura = new Asignatura();
        this.periodoSeleccionado = new PeriodoLectivo();
    }

    public void generar() {
        mostrarForms();
    }

    public void buscarAsignatura() {
//        this.asignaturas = new ArrayList<>();
        this.asignaturas = this.asignaturaService.obtenerPorNombreAsignatura(this.asignatura.getNombre());
//        if (asig != null) {
//            this.asignaturas.add(asig);
//        } else {
//            this.asignaturas.add(null);
//        }
//        this.asignatura = new Asignatura();
    }

    public void ocultarNrc() {
        this.mostrar = false;
    }

    public void listarNrcAsignatura() {
        this.nrcExistentesAsignatura = this.nrcService.listarNrcAsignatura(this.asignaturaSeleccionada);
        mostrarForms();
        System.out.println("");
    }

    public void listarNrcAsignaturaPeriodo() {
        this.nrcExistentesAsignatura = this.nrcService.listarNrcAsignaturaPeriodo(this.asignaturaSeleccionada, this.periodoSeleccionado);
        mostrarForms();
        System.out.println("");
    }

    public void generarNrc() {
        this.secuenciaNrc = 0;
        this.nrcExistentes = nrcService.obtenerTodos();
        if (!this.nrcExistentes.isEmpty()) {
            Integer ultimoNrc = this.nrcExistentes.size();
            this.secuenciaNrc = Integer.parseInt(this.nrcExistentes.get(ultimoNrc - 1).getNrcPK().getCodNrc().split("-")[1]);
            this.secuenciaNrc++;
        }
        Integer cantNRC = 0;
        cantNRC = this.numNRC;
        DecimalFormat formateador = new DecimalFormat("000");
        if (cantNRC > 0) {
            for (int j = 0; j < cantNRC; j++) {
                Nrc nuevoNrc = new Nrc();
                nuevoNrc.setNrcPK(new NrcPK("N-" + formateador.format(this.secuenciaNrc), this.periodoSeleccionado.getCodigo()));
                nuevoNrc.setCodAsignatura(asignaturaSeleccionada);
                nuevoNrc.setCodDocente(null);
                this.nrcGenerados.add(nuevoNrc);
                try {
                    this.nrcService.crearNrc(nuevoNrc);
                    Messages.addFlashGlobalInfo("Se agregó el Nrc: " + nuevoNrc.getNrcPK().getCodNrc() + ", para la materia" + this.asignaturaSeleccionada.getNombre());
                } catch (Exception ex) {
                    Messages.addGlobalError(null, "Ocurrí\u00f3 un error al generar los Nrc");
                }
                secuenciaNrc++;
            }
            this.nrcExistentesAsignatura = this.nrcService.listarNrcAsignaturaPeriodo(asignaturaSeleccionada, periodoSeleccionado);
        }

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

    public void mostrarForms() {
        if (!asignaturaSeleccionada.getCodigo().equals("")) {
            this.mostrar = true;
        } else {
            this.mostrar = false;
        }
    }

    public void ocultarForms() {
        this.mostrar = false;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public int getNumNRC() {
        return numNRC;
    }

    public void setNumNRC(int numNRC) {
        this.numNRC = numNRC;
    }

    public List<Nrc> getNrcGenerados() {
        return nrcGenerados;
    }

    public void setNrcGenerados(List<Nrc> nrcGenerados) {
        this.nrcGenerados = nrcGenerados;
    }

    public Asignatura getAsignaturaSeleccionada() {
        return asignaturaSeleccionada;
    }

    public void setAsignaturaSeleccionada(Asignatura asignaturaSeleccionada) {
        this.asignaturaSeleccionada = asignaturaSeleccionada;
    }

    public PeriodoLectivo getPeriodoSeleccionado() {
        return periodoSeleccionado;
    }

    public void setPeriodoSeleccionado(PeriodoLectivo periodoSeleccionado) {
        this.periodoSeleccionado = periodoSeleccionado;
    }

    public List<Nrc> getNrcExistentes() {
        return nrcExistentes;
    }

    public void setNrcExistentes(List<Nrc> nrcExistentes) {
        this.nrcExistentes = nrcExistentes;
    }

    public List<Nrc> getNrcExistentesAsignatura() {
        return nrcExistentesAsignatura;
    }

    public void setNrcExistentesAsignatura(List<Nrc> nrcExistentesAsignatura) {
        this.nrcExistentesAsignatura = nrcExistentesAsignatura;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Nrc getNrc() {
        return nrc;
    }

    public void setNrc(Nrc nrc) {
        this.nrc = nrc;
    }

}
