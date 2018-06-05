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
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jolube
 */
@Entity
@Table(name = "MATRICULA")
public class Matricula implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_MATRICULA", nullable = false, length = 10)
    private String codigo;
    
    @Max(value=20)  
    @Min(value=0)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PROMEDIO")
    private BigDecimal promedio;
    
    @Min(value=0)
    @Column(name = "COSTO_MATRICULA",nullable = false)
    private BigDecimal costoMatricula;
    
    @Column(name = "PAGADO", length = 3)
    private String pagado;
    
    @JoinColumn(name = "COD_ESTUDIANTE", referencedColumnName = "COD_ESTUDIANTE", nullable = false, insertable = true, updatable = false)
    @ManyToOne
    private Estudiante codEstudiante;
    
    @JoinColumn(name = "COD_PERIODO", referencedColumnName = "COD_PERIODO", nullable = false, insertable = true, updatable = false)
    @ManyToOne
    private PeriodoLectivo codPeriodo;
    
    //verificar me traeria todas las matriculas de un estudiante
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codMatricula")
    private List<DetalleMatricula> detalleMatriculaList;

    public Matricula() {
    }

    public Matricula(String codMatricula) {
        this.codigo = codMatricula;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
    public List<DetalleMatricula> getDetalleMatriculaList() {
        return detalleMatriculaList;
    }

    public void setDetalleMatriculaList(List<DetalleMatricula> detalleMatriculaList) {
        this.detalleMatriculaList = detalleMatriculaList;
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
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Matricula{" + "codigo=" + codigo + ", promedio=" + promedio + ", costoMatricula=" + costoMatricula + ", pagado=" + pagado + ", codEstudiante=" + codEstudiante + ", codPeriodo=" + codPeriodo + ", detalleMatriculaList=" + detalleMatriculaList + '}';
    }

}
