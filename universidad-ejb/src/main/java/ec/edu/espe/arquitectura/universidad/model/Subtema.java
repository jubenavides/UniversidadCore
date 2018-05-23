/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.universidad.model;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "SUBTEMA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subtema.findAll", query = "SELECT s FROM Subtema s")
    , @NamedQuery(name = "Subtema.findByCodSubtema", query = "SELECT s FROM Subtema s WHERE s.codSubtema = :codSubtema")
    , @NamedQuery(name = "Subtema.findByDescripcion", query = "SELECT s FROM Subtema s WHERE s.descripcion = :descripcion")})
public class Subtema implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "COD_SUBTEMA")
    private String codSubtema;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "COD_TEMA", referencedColumnName = "COD_TEMA")
    @ManyToOne
    private Tema codTema;
    @OneToMany(mappedBy = "codSubtema")
    private List<Tarea> tareaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subtema")
    private List<SeguimientoSilabo> seguimientoSilaboList;

    public Subtema() {
    }

    public Subtema(String codSubtema) {
        this.codSubtema = codSubtema;
    }

    public Subtema(String codSubtema, String descripcion) {
        this.codSubtema = codSubtema;
        this.descripcion = descripcion;
    }

    public String getCodSubtema() {
        return codSubtema;
    }

    public void setCodSubtema(String codSubtema) {
        this.codSubtema = codSubtema;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Tema getCodTema() {
        return codTema;
    }

    public void setCodTema(Tema codTema) {
        this.codTema = codTema;
    }

    @XmlTransient
    public List<Tarea> getTareaList() {
        return tareaList;
    }

    public void setTareaList(List<Tarea> tareaList) {
        this.tareaList = tareaList;
    }

    @XmlTransient
    public List<SeguimientoSilabo> getSeguimientoSilaboList() {
        return seguimientoSilaboList;
    }

    public void setSeguimientoSilaboList(List<SeguimientoSilabo> seguimientoSilaboList) {
        this.seguimientoSilaboList = seguimientoSilaboList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSubtema != null ? codSubtema.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subtema)) {
            return false;
        }
        Subtema other = (Subtema) object;
        if ((this.codSubtema == null && other.codSubtema != null) || (this.codSubtema != null && !this.codSubtema.equals(other.codSubtema))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.universidad.model.Subtema[ codSubtema=" + codSubtema + " ]";
    }
    
}
