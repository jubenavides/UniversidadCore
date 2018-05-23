/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.universidad.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jolube
 */
@Entity
@Table(name = "CALIFICACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calificacion.findAll", query = "SELECT c FROM Calificacion c")
    , @NamedQuery(name = "Calificacion.findByCodDetalleMatricula", query = "SELECT c FROM Calificacion c WHERE c.calificacionPK.codDetalleMatricula = :codDetalleMatricula")
    , @NamedQuery(name = "Calificacion.findBySecCalificacion", query = "SELECT c FROM Calificacion c WHERE c.calificacionPK.secCalificacion = :secCalificacion")
    , @NamedQuery(name = "Calificacion.findByPuntaje", query = "SELECT c FROM Calificacion c WHERE c.puntaje = :puntaje")})
public class Calificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CalificacionPK calificacionPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
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

    public Calificacion(int codDetalleMatricula, int secCalificacion) {
        this.calificacionPK = new CalificacionPK(codDetalleMatricula, secCalificacion);
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
        return "ec.edu.espe.universidadCore.model.Calificacion[ calificacionPK=" + calificacionPK + " ]";
    }
    
}
