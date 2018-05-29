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
import ec.edu.espe.arquitectura.universidad.model.Subtema;
import ec.edu.espe.arquitectura.universidad.model.Tarea;
import ec.edu.espe.arquitectura.universidad.model.Tema;
import ec.edu.espe.arquitectura.universidad.service.PeriodoLectivoService;
import ec.edu.espe.arquitectura.universidad.service.SilaboService;
import ec.edu.espe.arquitectura.universidad.service.SubtemaService;
import ec.edu.espe.arquitectura.universidad.service.TareaService;
import ec.edu.espe.arquitectura.universidad.service.TemaService;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.annotation.PostConstruct;
import org.omnifaces.util.Messages;
import org.primefaces.context.RequestContext;

/**
 *
 * @author adr95
 */
@Named
@ViewScoped
public class SilaboBean implements Serializable {

    private List<Silabo> silabos;
    private Silabo silabo;
    private Silabo silaboSel;
    private List<PeriodoLectivo> periodosLectivos;
    private String codigoPeriodoLectivo;
    private List<Tema> temas;
    private String codigoTema;
    private List<Subtema> subtemas;
    private Subtema subtema;
    private String codigoSubtema;
    private Subtema subtemaSel;
    private List<Tarea> tareas;
    private Subtema tarea;
    private Subtema tareaSel;
    
    private boolean verFormularioEdicion;
    private boolean enAgregar;
    private boolean enModificar;
    private boolean mostrarCrudSubtemas;

    @Inject
    private SilaboService silaboService;
    @Inject
    private PeriodoLectivoService periodoLectivoService;
    @Inject
    private SubtemaService subtemaService;
    @Inject
    private TareaService tareaService;
    @Inject
    private TemaService temaService;

    @PostConstruct
    public void init() {
        this.silabos = this.silaboService.obtenerTodos();
        this.silabo = new Silabo();
        this.periodosLectivos = this.periodoLectivoService.obtenerTodos();
        this.subtemas = this.subtemaService.obtenerTodos();
        this.tareas = this.tareaService.obtenerTodos();
        this.temas = this.temaService.obtenerTodos();
        this.cancelarEdicion();
    }

    public void verSilabo() {
        RequestContext.getCurrentInstance().execute("PF('administrarSilabo').show();");
    }
    
    public void gestionarTareasSilabo() {
        RequestContext.getCurrentInstance().execute("PF('gestionarTareasSilabo').show();");
        
    }
    
    public void gestionarSubtemasSilabo() {
        this.setMostrarCrudSubtemas(true);
    }

    public void cancelar() {
        RequestContext.getCurrentInstance().execute("PF('administrarSilabo').hide();");
    }
    
    public void cancelarEdicion(){
        this.limpiarControles();
        this.setVerFormularioEdicion(false);
        this.subtemaSel = null;
    }
    
    public void limpiarControles(){
        this.setEnAgregar(false);
        this.setEnModificar(false);
    }
    
    public void agregarSubtema(){
        this.setVerFormularioEdicion(true);
        this.setEnAgregar(true);
        this.subtema = new Subtema();    
    }

    public void modificarSubtema(){
        this.setVerFormularioEdicion(true);
        this.setEnModificar(true);
        this.subtema = new Subtema();
        this.subtema.setCodSubtema(this.subtemaSel.getCodSubtema());
        this.subtema.setCodTema(this.subtemaSel.getCodTema());
        this.subtema.setDescripcion(this.subtemaSel.getDescripcion());
    }

    public void eliminarSubtema(){
        this.subtemaService.eliminar(this.subtemaSel.getCodSubtema());
        this.subtema =  new Subtema();
        this.subtemas = this.subtemaService.obtenerTodos();
        this.cancelarEdicion();
    }
    
    public void guardarSubtema(){
        
        try{
            this.subtema.setCodTema(this.temaService.obtenerPorCodigoTema(codigoTema));
            if(this.getEnAgregar()){
                this.subtemaService.crear(this.subtema);          
            }else{
                this.subtemaService.modificar(this.subtema); 
            }
            
        }catch (Exception ex){
            Messages.addGlobalError(null, "Ocurrí\u00f3 un error al guardar  la informaci\u00f3n");
        }
        this.subtema = new Subtema();
        this.subtemas = this.subtemaService.obtenerTodos();
        this.cancelarEdicion();
    }
    
    public List<Silabo> getSilabos() {
        return silabos;
    }

    public void setSilabos(List<Silabo> silabos) {
        this.silabos = silabos;
    }

    public Silabo getSilabo() {
        return silabo;
    }

    public void setSilabo(Silabo silabo) {
        this.silabo = silabo;
    }

    public Silabo getSilaboSel() {
        return silaboSel;
    }

    public void setSilaboSel(Silabo silaboSel) {
        this.silaboSel = silaboSel;
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

    public List<Subtema> getSubtemas() {
        return subtemas;
    }

    public void setSubtemas(List<Subtema> subtemas) {
        this.subtemas = subtemas;
    }

    public Subtema getSubtema() {
        return subtema;
    }

    public void setSubtema(Subtema subtema) {
        this.subtema = subtema;
    }

    public Subtema getSubtemaSel() {
        return subtemaSel;
    }

    public void setSubtemaSel(Subtema subtemaSel) {
        this.subtemaSel = subtemaSel;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    public Subtema getTarea() {
        return tarea;
    }

    public void setTarea(Subtema tarea) {
        this.tarea = tarea;
    }

    public Subtema getTareaSel() {
        return tareaSel;
    }

    public void setTareaSel(Subtema tareaSel) {
        this.tareaSel = tareaSel;
    }

    public boolean getVerFormularioEdicion() {
        return verFormularioEdicion;
    }

    public void setVerFormularioEdicion(boolean verFormularioEdicion) {
        this.verFormularioEdicion = verFormularioEdicion;
    }

    public boolean getEnAgregar() {
        return enAgregar;
    }

    public void setEnAgregar(boolean enAgregar) {
        this.enAgregar = enAgregar;
    }

    public boolean getEnModificar() {
        return enModificar;
    }

    public void setEnModificar(boolean enModificar) {
        this.enModificar = enModificar;
    }

    public String getCodigoTema() {
        return codigoTema;
    }

    public void setCodigoTema(String codigoTema) {
        this.codigoTema = codigoTema;
    }

    public String getCodigoSubtema() {
        return codigoSubtema;
    }

    public void setCodigoSubtema(String codigoSubtema) {
        this.codigoSubtema = codigoSubtema;
    }

    public List<Tema> getTemas() {
        return temas;
    }

    public void setTemas(List<Tema> temas) {
        this.temas = temas;
    }

    public boolean isMostrarCrudSubtemas() {
        return mostrarCrudSubtemas;
    }

    public void setMostrarCrudSubtemas(boolean mostrarCrudSubtemas) {
        this.mostrarCrudSubtemas = mostrarCrudSubtemas;
    }
    
    
    
    

}
