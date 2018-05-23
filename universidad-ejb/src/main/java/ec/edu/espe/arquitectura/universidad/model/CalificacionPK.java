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

/**
 *
 * @author jolube
 */
@Embeddable
public class CalificacionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_DETALLE_MATRICULA")
    private int codDetalleMatricula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEC_CALIFICACION")
    private int secCalificacion;

    public CalificacionPK() {
    }

    public CalificacionPK(int codDetalleMatricula, int secCalificacion) {
        this.codDetalleMatricula = codDetalleMatricula;
        this.secCalificacion = secCalificacion;
    }

    public int getCodDetalleMatricula() {
        return codDetalleMatricula;
    }

    public void setCodDetalleMatricula(int codDetalleMatricula) {
        this.codDetalleMatricula = codDetalleMatricula;
    }

    public int getSecCalificacion() {
        return secCalificacion;
    }

    public void setSecCalificacion(int secCalificacion) {
        this.secCalificacion = secCalificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codDetalleMatricula;
        hash += (int) secCalificacion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CalificacionPK)) {
            return false;
        }
        CalificacionPK other = (CalificacionPK) object;
        if (this.codDetalleMatricula != other.codDetalleMatricula) {
            return false;
        }
        if (this.secCalificacion != other.secCalificacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.universidadCore.model.CalificacionPK[ codDetalleMatricula=" + codDetalleMatricula + ", secCalificacion=" + secCalificacion + " ]";
    }
    
}
