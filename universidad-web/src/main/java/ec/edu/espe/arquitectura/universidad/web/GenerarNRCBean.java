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
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class GenerarNRCBean implements Serializable {

    private boolean mostrar;
    private Asignatura asignaturaSeleccionada;
    private Asignatura asignatura;
    private List<PeriodoLectivo> periodosLectivos;
    private PeriodoLectivo periodoSeleccionado;
    private List<Nrc> nrcGenerados;
    private Integer numNRC;
    private List<Asignatura> asignaturas;
    private List<Nrc> nrcExistentes;
    private List<Nrc> nrcExistentesAsignatura;
    private Map<String, Integer> nrcCantidadCrear2;
    private List<Integer> nrcCantidadCrear;
    private Integer secuenciaNrc;

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
        nrcCantidadCrear = new ArrayList<>();
        nrcCantidadCrear2 = new HashMap<>();
        for (int i = 0; i < asignaturas.size(); i++) {
            nrcCantidadCrear.add(0);
            nrcCantidadCrear2.put(asignaturas.get(i).getCodigo(), 0);
        }
        this.secuenciaNrc = 0;
        this.nrcExistentes = nrcService.obtenerTodos();
        if (!this.nrcExistentes.isEmpty()) {
            Integer ultimoNrc = this.nrcExistentes.size();
            this.secuenciaNrc = Integer.parseInt(this.nrcExistentes.get(ultimoNrc - 1).getNrcPK().getCodNrc().split("-")[1]);
            this.secuenciaNrc += 1;
        }
    }

    public void generar() {
        mostrarForms();
    }

    public void listarNrcAsignatura() {
        this.nrcExistentesAsignatura = this.nrcService.listarNrcAsignatura(this.asignaturaSeleccionada);
        System.out.println("");
    }

    public void generarNrc() {
        for (int i = 0; i < asignaturas.size(); i++) {
            Integer cantNRC = 0;
            cantNRC = nrcCantidadCrear2.get(i);
            if (cantNRC > 0) {
                for (int j = 0; j < cantNRC; j++) {
                    Nrc nuevoNrc = new Nrc();
                    nuevoNrc.setNrcPK(new NrcPK("N-" + secuenciaNrc, periodoSeleccionado.getCodigo()));
                    nuevoNrc.setCodAsignatura(asignaturaSeleccionada);
                    nrcGenerados.add(nuevoNrc);
                }
            }
        }

    }

    public void asignarCantidadNRC(Integer index, Integer valor) {
//        for (Map.Entry<String, Integer> nrc : nrcCantidadCrear2.entrySet()) {
//            if (nrc.getKey().equals(cod)) {
//                nrc.setValue(index);
//                break;
//            }
//        }
        nrcCantidadCrear.set(index, valor);

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
        this.mostrar = true;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public Integer getNumNRC() {
        return numNRC;
    }

    public void setNumNRC(Integer numNRC) {
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

}
