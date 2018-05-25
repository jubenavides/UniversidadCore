/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.universidad.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jolube
 */
@Entity
@Table(name = "SUBTEMA")
public class Subtema implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_SUBTEMA",nullable = false, length = 5)
    private String codSubtema;
    
    @Column(name = "DESCRIPCION", nullable = false, length = 100)
    private String descripcion;
    
    @JoinColumn(name = "COD_TEMA", referencedColumnName = "COD_TEMA")
    @ManyToOne
    private Tema codTema;
    
    @OneToMany(mappedBy = "codSubtema")
    private List<Tarea> tareaList;
    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subtema")
//    private List<SeguimientoSilabo> seguimientoSilaboList;

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

//    @XmlTransient
//    public List<SeguimientoSilabo> getSeguimientoSilaboList() {
//        return seguimientoSilaboList;
//    }
//
//    public void setSeguimientoSilaboList(List<SeguimientoSilabo> seguimientoSilaboList) {
//        this.seguimientoSilaboList = seguimientoSilaboList;
//    }

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
        return "Subtema{" + "codSubtema=" + codSubtema + ", descripcion=" + descripcion + ", codTema=" + codTema + ", tareaList=" + tareaList + '}';
    }

}
