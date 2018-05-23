/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.universidad.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jolube
 */
@Entity
@Table(name = "DETALLE_MATRICULA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleMatricula.findAll", query = "SELECT d FROM DetalleMatricula d")
    , @NamedQuery(name = "DetalleMatricula.findByCodDetalleMatricula", query = "SELECT d FROM DetalleMatricula d WHERE d.codDetalleMatricula = :codDetalleMatricula")
    , @NamedQuery(name = "DetalleMatricula.findByCostoNrc", query = "SELECT d FROM DetalleMatricula d WHERE d.costoNrc = :costoNrc")
    , @NamedQuery(name = "DetalleMatricula.findByAprobacionNrc", query = "SELECT d FROM DetalleMatricula d WHERE d.aprobacionNrc = :aprobacionNrc")})
public class DetalleMatricula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_DETALLE_MATRICULA")
    private Integer codDetalleMatricula;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COSTO_NRC")
    private BigDecimal costoNrc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "APROBACION_NRC")
    private String aprobacionNrc;
    @JoinColumn(name = "COD_MATRICULA", referencedColumnName = "COD_MATRICULA")
    @ManyToOne(optional = false)
    private Matricula codMatricula;
    @JoinColumns({
        @JoinColumn(name = "COD_NRC", referencedColumnName = "COD_NRC")
        , @JoinColumn(name = "COD_PERIODO", referencedColumnName = "COD_PERIODO")})
    @ManyToOne(optional = false)
    private Nrc nrc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detalleMatricula")
    private Collection<Calificacion> calificacionCollection;

    public DetalleMatricula() {
    }

    public DetalleMatricula(Integer codDetalleMatricula) {
        this.codDetalleMatricula = codDetalleMatricula;
    }

    public DetalleMatricula(Integer codDetalleMatricula, String aprobacionNrc) {
        this.codDetalleMatricula = codDetalleMatricula;
        this.aprobacionNrc = aprobacionNrc;
    }

    public Integer getCodDetalleMatricula() {
        return codDetalleMatricula;
    }

    public void setCodDetalleMatricula(Integer codDetalleMatricula) {
        this.codDetalleMatricula = codDetalleMatricula;
    }

    public BigDecimal getCostoNrc() {
        return costoNrc;
    }

    public void setCostoNrc(BigDecimal costoNrc) {
        this.costoNrc = costoNrc;
    }

    public String getAprobacionNrc() {
        return aprobacionNrc;
    }

    public void setAprobacionNrc(String aprobacionNrc) {
        this.aprobacionNrc = aprobacionNrc;
    }

    public Matricula getCodMatricula() {
        return codMatricula;
    }

    public void setCodMatricula(Matricula codMatricula) {
        this.codMatricula = codMatricula;
    }

    public Nrc getNrc() {
        return nrc;
    }

    public void setNrc(Nrc nrc) {
        this.nrc = nrc;
    }

    @XmlTransient
    public Collection<Calificacion> getCalificacionCollection() {
        return calificacionCollection;
    }

    public void setCalificacionCollection(Collection<Calificacion> calificacionCollection) {
        this.calificacionCollection = calificacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDetalleMatricula != null ? codDetalleMatricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleMatricula)) {
            return false;
        }
        DetalleMatricula other = (DetalleMatricula) object;
        if ((this.codDetalleMatricula == null && other.codDetalleMatricula != null) || (this.codDetalleMatricula != null && !this.codDetalleMatricula.equals(other.codDetalleMatricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.universidadCore.model.DetalleMatricula[ codDetalleMatricula=" + codDetalleMatricula + " ]";
    }
    
}
