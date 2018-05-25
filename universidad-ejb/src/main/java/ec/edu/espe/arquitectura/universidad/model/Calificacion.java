/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.universidad.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 *
 * @author jolube
 */
@Entity
@Table(name = "CALIFICACION")
public class Calificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CalificacionPK calificacionPK;
    
    @Max(value=20) 
    @Min(value=0)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PUNTAJE")
    private BigDecimal puntaje;
    
    @JoinColumn(name = "COD_DETALLE_MATRICULA", referencedColumnName = "COD_DETALLE_MATRICULA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DetalleMatricula detalleMatricula;

    public Calificacion() {
    }

    public Calificacion(CalificacionPK calificacionPK) {
        this.calificacionPK = calificacionPK;
    }

    public CalificacionPK getCalificacionPK() {
        return calificacionPK;
    }

    public void setCalificacionPK(CalificacionPK calificacionPK) {
        this.calificacionPK = calificacionPK;
    }

    public BigDecimal getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(BigDecimal puntaje) {
        this.puntaje = puntaje;
    }

    public DetalleMatricula getDetalleMatricula() {
        return detalleMatricula;
    }

    public void setDetalleMatricula(DetalleMatricula detalleMatricula) {
        this.detalleMatricula = detalleMatricula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (calificacionPK != null ? calificacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calificacion)) {
            return false;
        }
        Calificacion other = (Calificacion) object;
        if ((this.calificacionPK == null && other.calificacionPK != null) || (this.calificacionPK != null && !this.calificacionPK.equals(other.calificacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Calificacion{" + "calificacionPK=" + calificacionPK + ", puntaje=" + puntaje + ", detalleMatricula=" + detalleMatricula + '}';
    }
    
}
