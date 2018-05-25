/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.universidad.web;

import java.io.Serializable;
import javax.ejb.Stateless;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author diego
 */
@Named
@ViewScoped
public class GenerarNRCBean implements Serializable {

    private String periodo;
    private boolean mostrar;

    public void generar() {
        this.mostrar = true;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public boolean isMostrar() {
        return mostrar;
    }

    public void setMostrar(boolean mostrar) {
        this.mostrar = mostrar;
    }

}
