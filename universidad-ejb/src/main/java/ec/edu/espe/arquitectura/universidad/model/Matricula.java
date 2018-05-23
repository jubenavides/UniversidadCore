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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "MATRICULA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matricula.findAll", query = "SELECT m FROM Matricula m")
    , @NamedQuery(name = "Matricula.findByCodMatricula", query = "SELECT m FROM Matricula m WHERE m.codMatricula = :codMatricula")
    , @NamedQuery(name = "Matricula.findByPromedio", query = "SELECT m FROM Matricula m WHERE m.promedio = :promedio")
    , @NamedQuery(name = "Matricula.findByCostoMatricula", query = "SELECT m FROM Matricula m WHERE m.costoMatricula = :costoMatricula")
    , @NamedQuery(name = "Matricula.findByPagado", query = "SELECT m FROM Matricula m WHERE m.pagado = :pagado")})
public class Matricula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "COD_MATRICULA")
    private String codMatricula;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PROMEDIO")
    private BigDecimal promedio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COSTO_MATRICULA")
    private BigDecimal costoMatricula;
    @Size(max = 3)
    @Column(name = "PAGADO")
    private String pagado;
    @JoinColumn(name = "COD_ESTUDIANTE", referencedColumnName = "COD_ESTUDIANTE")
    @ManyToOne
    private Estudiante codEstudiante;
    @JoinColumn(name = "COD_PERIODO", referencedColumnName = "COD_PERIODO")
    @ManyToOne
    private PeriodoLectivo codPeriodo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codMatricula")
    private Collection<DetalleMatricula> detalleMatriculaCollection;

    public Matricula() {
    }

    public Matricula(String codMatricula) {
        this.codMatricula = codMatricula;
    }

    public Matricula(String codMatricula, BigDecimal costoMatricula) {
        this.codMatricula = codMatricula;
        this.costoMatricula = costoMatricula;
    }

    public String getCodMatricula() {
        return codMatricula;
    }

    public void setCodMatricula(String codMatricula) {
        this.codMatricula = codMatricula;
    }

    public BigDecimal getPromedio() {
        return promedio;
    }

    public void setPromedio(BigDecimal promedio) {
        this.promedio = promedio;
    }

    public BigDecimal getCostoMatricula() {
        return costoMatricula;
    }

    public void setCostoMatricula(BigDecimal costoMatricula) {
        this.costoMatricula = costoMatricula;
    }

    public String getPagado() {
        return pagado;
    }

    public void setPagado(String pagado) {
        this.pagado = pagado;
    }

    public Estudiante getCodEstudiante() {
        return codEstudiante;
    }

    public void setCodEstudiante(Estudiante codEstudiante) {
        this.codEstudiante = codEstudiante;
    }

    public PeriodoLectivo getCodPeriodo() {
        return codPeriodo;
    }

    public void setCodPeriodo(PeriodoLectivo codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    @XmlTransient
    public Collection<DetalleMatricula> getDetalleMatriculaCollection() {
        return detalleMatriculaCollection;
    }

    public void setDetalleMatriculaCollection(Collection<DetalleMatricula> detalleMatriculaCollection) {
        this.detalleMatriculaCollection = detalleMatriculaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMatricula != null ? codMatricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.codMatricula == null && other.codMatricula != null) || (this.codMatricula != null && !this.codMatricula.equals(other.codMatricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.universidadCore.model.Matricula[ codMatricula=" + codMatricula + " ]";
    }
    
}
