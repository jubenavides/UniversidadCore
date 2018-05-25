/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.universidad.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author jolube
 */
@Embeddable
public class CalificacionPK implements Serializable {

    @Column(name = "COD_DETALLE_MATRICULA", nullable = false)
    private Integer codDetalleMatricula;

    @Column(name = "SEC_CALIFICACION", nullable = false)
    private Integer secCalificacion;

    public CalificacionPK() {
    }

    public CalificacionPK(Integer codDetalleMatricula, Integer secCalificacion) {
        this.codDetalleMatricula = codDetalleMatricula;
        this.secCalificacion = secCalificacion;
    }

    public Integer getCodDetalleMatricula() {
        return codDetalleMatricula;
    }

    public void setCodDetalleMatricula(Integer codDetalleMatricula) {
        this.codDetalleMatricula = codDetalleMatricula;
    }

    public Integer getSecCalificacion() {
        return secCalificacion;
    }

    public void setSecCalificacion(Integer secCalificacion) {
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
        return "CalificacionPK{" + "codDetalleMatricula=" + codDetalleMatricula + ", secCalificacion=" + secCalificacion + '}';
    }

}
