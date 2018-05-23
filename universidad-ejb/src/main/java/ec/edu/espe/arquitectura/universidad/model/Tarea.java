/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarea.findAll", query = "SELECT t FROM Tarea t")
    , @NamedQuery(name = "Tarea.findByCodTarea", query = "SELECT t FROM Tarea t WHERE t.codTarea = :codTarea")
    , @NamedQuery(name = "Tarea.findByDescripcion", query = "SELECT t FROM Tarea t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "Tarea.findByPonderacion", query = "SELECT t FROM Tarea t WHERE t.ponderacion = :ponderacion")})
public class Tarea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "COD_TAREA")
    private String codTarea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PONDERACION")
    private BigDecimal ponderacion;
    @JoinColumn(name = "COD_SUBTEMA", referencedColumnName = "COD_SUBTEMA")
    @ManyToOne
    private Subtema codSubtema;

    public Tarea() {
    }

    public Tarea(String codTarea) {
        this.codTarea = codTarea;
    }

    public Tarea(String codTarea, String descripcion, BigDecimal ponderacion) {
        this.codTarea = codTarea;
        this.descripcion = descripcion;
        this.ponderacion = ponderacion;
    }

    public String getCodTarea() {
        return codTarea;
    }

    public void setCodTarea(String codTarea) {
        this.codTarea = codTarea;
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
        hash += (codTarea != null ? codTarea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarea)) {
            return false;
        }
        Tarea other = (Tarea) object;
        if ((this.codTarea == null && other.codTarea != null) || (this.codTarea != null && !this.codTarea.equals(other.codTarea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.universidad.model.Tarea[ codTarea=" + codTarea + " ]";
    }
    
}
