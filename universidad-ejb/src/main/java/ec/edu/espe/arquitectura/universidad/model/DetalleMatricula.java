/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.universidad.model;

import ec.edu.espe.arquitectura.universidad.enums.AprobacionNRCEnum;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jolube
 */
@Entity
@Table(name = "DETALLE_MATRICULA")
public class DetalleMatricula implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_DETALLE_MATRICULA")
    private Integer codigo;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Min(value=0)
    @Column(name = "COSTO_NRC")
    private BigDecimal costoNrc;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "APROBACION_NRC", nullable = false, length = 3)
    private AprobacionNRCEnum aprobacionNrc;
    
    @JoinColumn(name = "COD_MATRICULA", referencedColumnName = "COD_MATRICULA", nullable = false, insertable = false, updatable = false)
    @ManyToOne
    private Matricula codMatricula;
    
    @JoinColumns({
        @JoinColumn(name = "COD_NRC", referencedColumnName = "COD_NRC", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "COD_PERIODO", referencedColumnName = "COD_PERIODO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Nrc nrc;
    
    //revisar me serviria para ver todas las calificaciones en una matricula
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detalleMatricula")
    private List<Calificacion> calificacionList;

    public DetalleMatricula() {
    }

    public DetalleMatricula(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void SetCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getCostoNrc() {
        return costoNrc;
    }

    public void setCostoNrc(BigDecimal costoNrc) {
        this.costoNrc = costoNrc;
    }

    public AprobacionNRCEnum getAprobacionNrc() {
        return aprobacionNrc;
    }

    public void setAprobacionNrc(AprobacionNRCEnum aprobacionNrc) {
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
    public List<Calificacion> getCalificacionList() {
        return calificacionList;
    }

    public void setCalificacionList(List<Calificacion> calificacionList) {
        this.calificacionList = calificacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleMatricula)) {
            return false;
        }
        DetalleMatricula other = (DetalleMatricula) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DetalleMatricula{" + "codigo=" + codigo + ", costoNrc=" + costoNrc + ", aprobacionNrc=" + aprobacionNrc + ", codMatricula=" + codMatricula + ", nrc=" + nrc + ", calificacionList=" + calificacionList + '}';
    }

}
