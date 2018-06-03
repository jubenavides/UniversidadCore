/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.universidad.web;

import ec.edu.espe.arquitectura.universidad.model.FranjaHoraria;
import ec.edu.espe.arquitectura.universidad.model.Horario;
import ec.edu.espe.arquitectura.universidad.model.Nrc;
import ec.edu.espe.arquitectura.universidad.model.PeriodoLectivo;
import ec.edu.espe.arquitectura.universidad.model.Ubicacion;
import ec.edu.espe.arquitectura.universidad.service.FranjaHorariaService;
import ec.edu.espe.arquitectura.universidad.service.HorarioService;
import ec.edu.espe.arquitectura.universidad.service.NRCService;
import ec.edu.espe.arquitectura.universidad.service.PeriodoLectivoService;
import ec.edu.espe.arquitectura.universidad.service.UbicacionService;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author adr95
 */
@Named
@ViewScoped
public class HorarioBean implements Serializable {

    private List<Horario> horarios;
    private Horario horario;
    private Horario horarioSel;
    private List<FranjaHoraria> franjasHorarias;
    private FranjaHoraria franjaHoraria;
    private FranjaHoraria franjaHorariaSel;
    private List<Nrc> nrcExistentes;
    private Nrc nrcSel;
    private Nrc nrc;
    private List<PeriodoLectivo> periodosLectivos;
    private PeriodoLectivo periodoSeleccionado;
    private List<Ubicacion> aulas;
    private Ubicacion aula;
    private Ubicacion aulaSel;
    private boolean mostrarListaNrc;
    private boolean listo;
    private Integer secuenciaHorario;
    
    
    @Inject
    private NRCService nrcService;
    
    @Inject
    private UbicacionService ubicacionService;
    
    @Inject
    private FranjaHorariaService franjaHorariaService;
    
    @Inject 
    private HorarioService horarioService;
    
    @Inject
    private PeriodoLectivoService periodoLectivoService;

    
    @PostConstruct
    public void init() {
        this.aulas = this.ubicacionService.obtenerAulas();
        this.franjasHorarias = this.franjaHorariaService.obtenerTodos();
        this.periodosLectivos = this.periodoLectivoService.obtenerTodos();
        this.nrcExistentes = this.nrcService.obtenerTodos();
        this.aula = new Ubicacion();
        this.franjaHoraria = new FranjaHoraria();
        this.horario = new Horario();
        this.setMostrarListaNrc(false);
        this.setListo(false);
        this.periodoSeleccionado = new PeriodoLectivo();
        
    }
    
    public void mostrarNrcPorPeriodo(){
        this.nrcExistentes=this.nrcService.listarNrcPeriodo(this.periodoSeleccionado);
        
        this.setMostrarListaNrc(true);
    }
    
    public void guardarHorario(){
        this.secuenciaHorario = 0;
        this.horarios = horarioService.obtenerTodos();
        if (!this.horarios.isEmpty()) {
            Integer ultimoHorario = this.horarios.size();
            this.secuenciaHorario = Integer.parseInt(this.horarios.get(ultimoHorario - 1).getCodigo().split("-")[1]);
            this.secuenciaHorario++;
        }
        DecimalFormat formateador = new DecimalFormat("000");
        this.horario = new Horario();
        this.horario.setCodigo("H-" + formateador.format(this.secuenciaHorario));
        this.horario.setNrc(this.nrcSel);
        this.horario.setCodFranjaMatricula(this.franjaHorariaSel);
        this.horario.setCodUbicacion(this.aulaSel);
        this.horarioService.crear(horario);
    }
    
    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Horario getHorarioSel() {
        return horarioSel;
    }

    public void setHorarioSel(Horario horarioSel) {
        this.horarioSel = horarioSel;
    }

    public List<FranjaHoraria> getFranjasHorarias() {
        return franjasHorarias;
    }

    public void setFranjasHorarias(List<FranjaHoraria> franjasHorarias) {
        this.franjasHorarias = franjasHorarias;
    }

    public FranjaHoraria getFranjaHoraria() {
        return franjaHoraria;
    }

    public void setFranjaHoraria(FranjaHoraria franjaHoraria) {
        this.franjaHoraria = franjaHoraria;
    }

    public FranjaHoraria getFranjaHorariaSel() {
        return franjaHorariaSel;
    }

    public void setFranjaHorariaSel(FranjaHoraria franjaHorariaSel) {
        this.franjaHorariaSel = franjaHorariaSel;
    }

    public List<Nrc> getNrcExistentes() {
        return nrcExistentes;
    }

    public void setNrcExistentes(List<Nrc> nrcExistentes) {
        this.nrcExistentes = nrcExistentes;
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

    public List<Ubicacion> getAulas() {
        return aulas;
    }

    public void setAulas(List<Ubicacion> aulas) {
        this.aulas = aulas;
    }

    public Ubicacion getAula() {
        return aula;
    }

    public void setAula(Ubicacion aula) {
        this.aula = aula;
    }

    public Ubicacion getAulaSel() {
        return aulaSel;
    }

    public void setAulaSel(Ubicacion aulaSel) {
        this.aulaSel = aulaSel;
    }

    public NRCService getNrcService() {
        return nrcService;
    }

    public void setNrcService(NRCService nrcService) {
        this.nrcService = nrcService;
    }

    public boolean isMostrarListaNrc() {
        return mostrarListaNrc;
    }

    public void setMostrarListaNrc(boolean mostrarListaNrc) {
        this.mostrarListaNrc = mostrarListaNrc;
    }

    public Nrc getNrcSel() {
        return nrcSel;
    }

    public void setNrcSel(Nrc nrcSel) {
        this.nrcSel = nrcSel;
    }

    public Nrc getNrc() {
        return nrc;
    }

    public void setNrc(Nrc nrc) {
        this.nrc = nrc;
    }

    public boolean isListo() {
        return listo;
    }

    public void setListo(boolean listo) {
        this.listo = listo;
    }

    public Integer getSecuenciaHorario() {
        return secuenciaHorario;
    }

    public void setSecuenciaHorario(Integer secuenciaHorario) {
        this.secuenciaHorario = secuenciaHorario;
    }

    
    
    
    
    
}
