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
import ec.edu.espe.arquitectura.universidad.service.SilaboService;
import java.io.Serializable;
import java.util.ArrayList;
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
public class SilaboBean implements Serializable{
    
    private List<Silabo> silabos;
    private Silabo silabo;
    private Silabo silaboSel;
    private List<PeriodoLectivo> periodosLectivos;
    private String codigoPeriodoLectivo;
    
    @Inject
    private SilaboService silaboService;
    @Inject
    private PeriodoLectivoService periodoLectivoService;
    
    @PostConstruct
    public void init(){
        this.silabos = this.silaboService.obtenerTodos();
        this.silabo = new Silabo();
        this.periodosLectivos = this.periodoLectivoService.obtenerTodos();
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
    
    
    
}
