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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "TAREA")
public class Tarea implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_TAREA", nullable = false, length = 5)
    private String codigo;
    
    @Column(name = "DESCRIPCION", nullable = false, length = 100)
    private String descripcion;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PONDERACION", nullable = false)
    private BigDecimal ponderacion;
    
    @JoinColumn(name = "COD_SUBTEMA", referencedColumnName = "COD_SUBTEMA")
    @ManyToOne
    private Subtema codSubtema;

    public Tarea() {
    }

    public Tarea(String codTarea) {
        this.codigo = codTarea;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPonderacion() {
        return ponderacion;
    }

    public void setPonderacion(BigDecimal ponderacion) {
        this.ponderacion = ponderacion;
    }

    public Subtema getCodSubtema() {
        return codSubtema;
    }

    public void setCodSubtema(Subtema codSubtema) {
        this.codSubtema = codSubtema;
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
        if (!(object instanceof Tarea)) {
            return false;
        }
        Tarea other = (Tarea) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tarea{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", ponderacion=" + ponderacion + ", codSubtema=" + codSubtema + '}';
    }

}
