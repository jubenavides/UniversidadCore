/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.universidad.web;

import ec.edu.espe.arquitectura.universidad.model.Calificacion;
import ec.edu.espe.arquitectura.universidad.model.Docente;
import ec.edu.espe.arquitectura.universidad.model.Estudiante;
import ec.edu.espe.arquitectura.universidad.model.Nrc;
import ec.edu.espe.arquitectura.universidad.model.PeriodoLectivo;
import ec.edu.espe.arquitectura.universidad.service.CalificacionService;
import ec.edu.espe.arquitectura.universidad.service.DocenteService;
import ec.edu.espe.arquitectura.universidad.service.NRCService;
import ec.edu.espe.arquitectura.universidad.service.PeriodoLectivoService;
import ec.edu.espe.arquitectura.universidad.util.EstudianteCalificacion;
import java.io.Serializable;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.primefaces.event.CellEditEvent;

/**
 *
 * @author jolube
 */
@Named
@ViewScoped
public class CalificacionesBean implements Serializable {

    private List<Nrc> listaNrc;
    private String nrcSelect;

    private List<PeriodoLectivo> periodos;
    private String periodoSel;

    private Docente docente;
    private Calificacion calificacion;
    private List<Calificacion> calificaciones;

    private Estudiante estudiante;
    private List<Estudiante> estudiantes;
    
    private Integer parcial;
    
    private List<EstudianteCalificacion> listEstudianteCalificacion;

    private static final Logger LOG = Logger.getLogger(CalificacionesBean.class.getName());

    @Inject
    private UsuarioSesionBean session;

    @Inject
    NRCService nrcService;

    @Inject
    DocenteService docenteService;

    @Inject
    PeriodoLectivoService periodoService;
    
    @Inject
    CalificacionService calificacionService;
    

    @PostConstruct
    public void init() {
        this.periodos = periodoService.obtenerTodos();
        this.docente = docenteService.obtenerPorCodigo(session.getCodUsuario());
        this.periodoSel = this.periodos.get(0).getCodigo();
        this.parcial = 1;
        asignarPeriodo();
        cargarListado();
    }

    public void asignarPeriodo() {
        this.listaNrc = nrcService.obtenerNrcDocente(periodoSel, docente.getCodigo());
        nrcSelect = listaNrc.get(0).getNrcPK().getCodNrc();
    }

    public void cargarListado() {
        listEstudianteCalificacion = calificacionService.obtenerPorNrc(nrcSelect, periodoSel, parcial);
    }

    public void guardar(){
        calificacionService.guardarCalificaciones(listEstudianteCalificacion);
    }
    //Para edicion de la tabla
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
    //Getters and Setters
    public List<Nrc> getListaNrc() {
        return listaNrc;
    }

    public void setListaNrc(List<Nrc> listaNrc) {
        this.listaNrc = listaNrc;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Calificacion getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public DocenteService getDocenteService() {
        return docenteService;
    }

    public void setDocenteService(DocenteService docenteService) {
        this.docenteService = docenteService;
    }

    public List<PeriodoLectivo> getPeriodos() {
        return periodos;
    }

    public void setPeriodos(List<PeriodoLectivo> periodos) {
        this.periodos = periodos;
    }

    public String getNrcSelect() {
        return nrcSelect;
    }

    public void setNrcSelect(String nrcSelect) {
        this.nrcSelect = nrcSelect;
    }

    public String getPeriodoSel() {
        return periodoSel;
    }

    public void setPeriodoSel(String periodoSel) {
        this.periodoSel = periodoSel;
    }

    public Integer getParcial() {
        return parcial;
    }

    public void setParcial(Integer parcial) {
        this.parcial = parcial;
    }

    public List<EstudianteCalificacion> getListEstudianteCalificacion() {
        return listEstudianteCalificacion;
    }

    public void setListEstudianteCalificacion(List<EstudianteCalificacion> listEstudianteCalificacion) {
        this.listEstudianteCalificacion = listEstudianteCalificacion;
    }
    
}
