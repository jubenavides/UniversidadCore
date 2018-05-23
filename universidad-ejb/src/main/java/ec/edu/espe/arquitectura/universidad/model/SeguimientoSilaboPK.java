/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.universidad.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jolube
 */
@Embeddable
public class SeguimientoSilaboPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "COD_SUBTEMA")
    private String codSubtema;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "COD_ESTUDIANTE")
    private String codEstudiante;

    public SeguimientoSilaboPK() {
    }

    public SeguimientoSilaboPK(String codSubtema, String codEstudiante) {
        this.codSubtema = codSubtema;
        this.codEstudiante = codEstudiante;
    }

    public String getCodSubtema() {
        return codSubtema;
    }

    public void setCodSubtema(String codSubtema) {
        this.codSubtema = codSubtema;
    }

    public String getCodEstudiante() {
        return codEstudiante;
    }

    public void setCodEstudiante(String codEstudiante) {
        this.codEstudiante = codEstudiante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSubtema != null ? codSubtema.hashCode() : 0);
        hash += (codEstudiante != null ? codEstudiante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeguimientoSilaboPK)) {
            return false;
        }
        SeguimientoSilaboPK other = (SeguimientoSilaboPK) object;
        if ((this.codSubtema == null && other.codSubtema != null) || (this.codSubtema != null && !this.codSubtema.equals(other.codSubtema))) {
            return false;
        }
        if ((this.codEstudiante == null && other.codEstudiante != null) || (this.codEstudiante != null && !this.codEstudiante.equals(other.codEstudiante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.universidadCore.model.SeguimientoSilaboPK[ codSubtema=" + codSubtema + ", codEstudiante=" + codEstudiante + " ]";
    }
    
}
