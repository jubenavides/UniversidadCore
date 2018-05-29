/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */

package ec.edu.espe.arquitectura.universidad.web;

import ec.edu.espe.arquitectura.universidad.model.Asignatura;
import ec.edu.espe.arquitectura.universidad.model.DetalleMalla;
import ec.edu.espe.arquitectura.universidad.service.AsignaturaService;
import ec.edu.espe.arquitectura.universidad.service.DetalleMallaService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author toshiba
 */
@Named
@ViewScoped
public class DetalleMallaBean extends BaseBean implements Serializable{
    
    private List<DetalleMalla> detalleMallas;
    private DetalleMalla detalleMalla;
    private DetalleMalla detalleMallaSel;
    
    
    @Inject
    private DetalleMallaService detalleMallaService;
    
    @Inject
    private AsignaturaService asignaturaService;
    
    
    
    @PostConstruct
    public void init(){
        this.detalleMallas = this.detalleMallaService.obtenerTodos();
        this.detalleMalla = new DetalleMalla();
    }
    
    @Override
    public void detalles() {
        super.detalles();
        this.detalleMalla = this.detalleMallaSel;
    }
    
     public void buscar() {
         this.detalleMallas = new ArrayList<>();
         DetalleMalla dmallaEncontrado = this.detalleMallaService.obtenerPorCodigoDetalleMalla(this.detalleMalla.getCodigo());
         if (dmallaEncontrado !=null) {
             this.detalleMallas.add(dmallaEncontrado);
         }else {
             this.detalleMallas = null;
         }
         this.detalleMalla = new DetalleMalla();

    }

    public DetalleMalla getDetalleMalla() {
        return detalleMalla;
    }

    public List<DetalleMalla> getDetalleMallas() {
        return detalleMallas;
    }

    public DetalleMalla getDetalleMallaSel() {
        return detalleMallaSel;
    }

    public void setDetalleMallaSel(DetalleMalla detalleMallaSel) {
        this.detalleMallaSel = detalleMallaSel;
    }

    public void setDetalleMalla(DetalleMalla detalleMalla) {
        this.detalleMalla = detalleMalla;
    }
    
    public String obtnerNombreAsignatura (String codigo) {
        Asignatura asignaturaEncontrada = this.asignaturaService.obtenerPorCodigoAsignatura(codigo);
        return asignaturaEncontrada.getNombre();
    }
    
    
    
    
    
    
    

    
    
     
    
    
}