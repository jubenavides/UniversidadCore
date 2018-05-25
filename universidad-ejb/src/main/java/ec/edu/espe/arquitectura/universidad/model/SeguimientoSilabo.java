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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author jolube
 */
@Entity
@Table(name = "SEGUIMIENTO_SILABO")
public class SeguimientoSilabo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected SeguimientoSilaboPK seguimientoSilaboPK;
    
    @Column(name = "REVISADO",nullable = false, length = 2)
    private String revisado;
    
    @JoinColumn(name = "COD_ESTUDIANTE", referencedColumnName = "COD_ESTUDIANTE", insertable = false, updatable = false, nullable = false)
    @ManyToOne
    private Estudiante estudiante;
    
    @JoinColumn(name = "COD_SUBTEMA", referencedColumnName = "COD_SUBTEMA", insertable = false, updatable = false, nullable = false)
    @ManyToOne
    private Subtema subtema;

    public SeguimientoSilabo() {
    }

    public SeguimientoSilabo(SeguimientoSilaboPK seguimientoSilaboPK) {
        this.seguimientoSilaboPK = seguimientoSilaboPK;
    }

    public SeguimientoSilabo(String codSubtema, String codEstudiante) {
        this.seguimientoSilaboPK = new SeguimientoSilaboPK(codSubtema, codEstudiante);
    }

    public SeguimientoSilaboPK getSeguimientoSilaboPK() {
        return seguimientoSilaboPK;
    }

    public void setSeguimientoSilaboPK(SeguimientoSilaboPK seguimientoSilaboPK) {
        this.seguimientoSilaboPK = seguimientoSilaboPK;
    }

    public String getRevisado() {
        return revisado;
    }

    public void setRevisado(String revisado) {
        this.revisado = revisado;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Subtema getSubtema() {
        return subtema;
    }

    public void setSubtema(Subtema subtema) {
        this.subtema = subtema;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seguimientoSilaboPK != null ? seguimientoSilaboPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeguimientoSilabo)) {
            return false;
        }
        SeguimientoSilabo other = (SeguimientoSilabo) object;
        if ((this.seguimientoSilaboPK == null && other.seguimientoSilaboPK != null) || (this.seguimientoSilaboPK != null && !this.seguimientoSilaboPK.equals(other.seguimientoSilaboPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SeguimientoSilabo{" + "seguimientoSilaboPK=" + seguimientoSilaboPK + ", revisado=" + revisado + ", estudiante=" + estudiante + ", subtema=" + subtema + '}';
    }

}
