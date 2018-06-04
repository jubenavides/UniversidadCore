/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.universidad.web;

import ec.edu.espe.arquitectura.universidad.model.DetalleMalla;
import ec.edu.espe.arquitectura.universidad.model.Prerrequisito;
import ec.edu.espe.arquitectura.universidad.service.DetalleMallaService;
import ec.edu.espe.arquitectura.universidad.service.PrerrequisitoService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.util.Messages;

/**
 *
 * @author toshiba
 */
@Named
@ViewScoped
public class PrerrequisitoBean extends BaseBean implements Serializable {

    //
    //private List<Malla> malla;
    private List<Prerrequisito> prerrequisitos;
    private Prerrequisito prerrequisito;
    private List<DetalleMalla> detalleMallas;
    private DetalleMalla detalleMallaSel;
    private DetalleMalla detalleMalla;
    private boolean mostrar;

    private List<DetalleMalla> selectedPrerrequisitos;
    private List<DetalleMalla> detMaasignaturas;
    private List<DetalleMalla> detMaasignaturasFiltro;
    private String buscar;

    @Inject
    private PrerrequisitoService prerrequisitoService;

    @Inject
    private DetalleMallaService detalleMallaService;

    @PostConstruct
    public void init() {

        this.detalleMallas = this.detalleMallaService.obtenerTodos();
        this.selectedPrerrequisitos = new ArrayList<DetalleMalla>();
        this.prerrequisito = new Prerrequisito();
        this.mostrar = false;
    }

    public void buscarAsignatura() {

        this.detalleMallas = this.detalleMallaService.obtenerPorNombre(this.buscar);

    }
    
     public boolean validarExistencia(Prerrequisito pre) {
         List<Prerrequisito> aux = this.prerrequisitoService.obtenerTodos();
         boolean band = false;
         for(Prerrequisito ap: aux)
         {
             if(pre.getCodMateria().getCodAsignatura().getCodigo().equals(ap.getCodMateria().getCodAsignatura().getCodigo()) 
                     && pre.getCodPreRequisito().getCodAsignatura().getCodigo().equals(ap.getCodPreRequisito().getCodAsignatura().getCodigo()))
             {
                 band = true;
                 break;
             }
         }
         return band;
    }

    public void asignarPrerrequisito() {
        agregar();
        List<DetalleMalla> aux = new ArrayList<>();
        this.detMaasignaturasFiltro = this.detalleMallas;
        for (int i = 0; i < this.detalleMallas.size(); i++) {
            if (this.detalleMallas.get(i).getNivel() < this.detalleMallaSel.getNivel()) {
                aux.add(detalleMallas.get(i));
            }
        }
        this.detMaasignaturasFiltro = aux;
        this.mostrar = true;
    }

    public void guardarPrerrequisitos() {
        if (this.selectedPrerrequisitos.size() > 0) {
            for (int i = 0; i < this.selectedPrerrequisitos.size(); i++) {
                Prerrequisito pre = new Prerrequisito();
                pre.setCodPreRequisito(this.selectedPrerrequisitos.get(i));
                pre.setCodMateria(this.detalleMallaSel);
                if (!validarExistencia(pre)) {
                    try {
                        this.prerrequisitoService.crear(pre);
                        Messages.addFlashGlobalInfo("Se agrego el prerrequisito");
                    } catch (Exception ex) {
                        Messages.addGlobalError(null, "Ocurrio un error al guardar prerrequisito");
                    }
                }

            }
            this.mostrar = false;
        }
    }

    public void ocultar() {
        this.mostrar = false;
    }

    public List<DetalleMalla> getDetalleMallas() {
        return detalleMallas;
    }

    public void setDetalleMallas(List<DetalleMalla> detalleMallas) {
        this.detalleMallas = detalleMallas;
    }

    public DetalleMalla getDetalleMalla() {
        return detalleMalla;
    }

    public void setDetalleMalla(DetalleMalla detalleMalla) {
        this.detalleMalla = detalleMalla;
    }

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    public Prerrequisito getPrerrequisito() {
        return prerrequisito;
    }

    public void setPrerrequisito(Prerrequisito prerrequisito) {
        this.prerrequisito = prerrequisito;
    }

    public void setPrerrequisitos(List<Prerrequisito> prerrequisitos) {
        this.prerrequisitos = prerrequisitos;
    }

    public void setPrerrequisitoService(PrerrequisitoService prerrequisitoService) {
        this.prerrequisitoService = prerrequisitoService;
    }

    public List<DetalleMalla> getSelectedPrerrequisitos() {
        return selectedPrerrequisitos;
    }

    public void setSelectedPrerrequisitos(List<DetalleMalla> selectedPrerrequisitos) {
        this.selectedPrerrequisitos = selectedPrerrequisitos;
    }

    public List<DetalleMalla> getDetMaasignaturas() {
        return detMaasignaturas;
    }

    public void setDetMaasignaturas(List<DetalleMalla> detMaasignaturas) {
        this.detMaasignaturas = detMaasignaturas;
    }

    public DetalleMalla getDetalleMallaSel() {
        return detalleMallaSel;
    }

    public void setDetalleMallaSel(DetalleMalla detalleMallaSel) {
        this.detalleMallaSel = detalleMallaSel;
    }

    public List<DetalleMalla> getDetMaasignaturasFiltro() {
        return detMaasignaturasFiltro;
    }

    public void setDetMaasignaturasFiltro(List<DetalleMalla> detMaasignaturasFiltro) {
        this.detMaasignaturasFiltro = detMaasignaturasFiltro;
    }

    public boolean isMostrar() {
        return mostrar;
    }

    public void setMostrar(boolean mostrar) {
        this.mostrar = mostrar;
    }

}
