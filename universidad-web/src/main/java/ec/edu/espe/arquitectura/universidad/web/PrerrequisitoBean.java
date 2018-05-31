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

    private DetalleMalla detalleMallaSel;

    private String[] selectedPrerrequisitos;
    private List<DetalleMalla> detMaasignaturas;
    private List<DetalleMalla> detMaasignaturasFiltro;

    @Inject
    private PrerrequisitoService prerrequisitoService;

    @Inject
    private DetalleMallaService detalleMallaService;

    @PostConstruct
    public void init() {
        //this.prerrequisitos = this.prerrequisitoService.obtenerTodos();
        this.detMaasignaturas = this.detalleMallaService.obtenerTodos();

        this.prerrequisito = new Prerrequisito();
    }

    public void asignarPrerrequisito() {
        agregar();
        List<DetalleMalla> aux = new ArrayList<>();
        this.detMaasignaturasFiltro = this.detMaasignaturas;
        for (int i = 0; i < this.detMaasignaturas.size(); i++) {
            if (this.detMaasignaturas.get(i).getNivel() < this.detalleMallaSel.getNivel()) {
                aux.add(detMaasignaturas.get(i));
            }
        }
        this.detMaasignaturasFiltro = aux;
    }

    public void guardarPrerrequisitos() {
        if (selectedPrerrequisitos.length > 0) {
            for (int i = 0; i < selectedPrerrequisitos.length; i++) {
                Prerrequisito pre = new Prerrequisito();
                pre.setCodPreRequisito(new DetalleMalla(Integer.parseInt(selectedPrerrequisitos[i].split(",")[0].split("=")[1])));
                pre.setCodMateria(new DetalleMalla(detalleMallaSel.getCodigo()));
                pre.setCodigo(0);
                try {
                    this.prerrequisitoService.crear(pre);
                    Messages.addFlashGlobalInfo("Se agrego el prerrequisito");
                } catch (Exception ex) {
                    Messages.addGlobalError(null, "Ocurrio un error al guardar prerrequisito");
                }
            }
        }
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

    public String[] getSelectedPrerrequisitos() {
        return selectedPrerrequisitos;
    }

    public void setSelectedPrerrequisitos(String[] selectedPrerrequisitos) {
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

}
