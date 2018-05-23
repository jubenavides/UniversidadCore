/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.universidad.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jolube
 */
@Entity
@Table(name = "SEGUIMIENTO_SILABO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeguimientoSilabo.findAll", query = "SELECT s FROM SeguimientoSilabo s")
    , @NamedQuery(name = "SeguimientoSilabo.findByCodSubtema", query = "SELECT s FROM SeguimientoSilabo s WHERE s.seguimientoSilaboPK.codSubtema = :codSubtema")
    , @NamedQuery(name = "SeguimientoSilabo.findByCodEstudiante", query = "SELECT s FROM SeguimientoSilabo s WHERE s.seguimientoSilaboPK.codEstudiante = :codEstudiante")
    , @NamedQuery(name = "SeguimientoSilabo.findByRevisado", query = "SELECT s FROM SeguimientoSilabo s WHERE s.revisado = :revisado")})
public class SeguimientoSilabo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SeguimientoSilaboPK seguimientoSilaboPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "REVISADO")
    private String revisado;
    @JoinColumn(name = "COD_ESTUDIANTE", referencedColumnName = "COD_ESTUDIANTE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estudiante estudiante;
    @JoinColumn(name = "COD_SUBTEMA", referencedColumnName = "COD_SUBTEMA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Subtema subtema;

    public SeguimientoSilabo() {
    }

    public SeguimientoSilabo(SeguimientoSilaboPK seguimientoSilaboPK) {
        this.seguimientoSilaboPK = seguimientoSilaboPK;
    }

    public SeguimientoSilabo(SeguimientoSilaboPK seguimientoSilaboPK, String revisado) {
        this.seguimientoSilaboPK = seguimientoSilaboPK;
        this.revisado = revisado;
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
        return "ec.edu.espe.universidadCore.model.SeguimientoSilabo[ seguimientoSilaboPK=" + seguimientoSilaboPK + " ]";
    }
    
}
