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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author jolube
 */
@Entity
@Table(name = "DEPARTAMENTO")
public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "COD_DEPARTAMENTO", nullable = false, length = 5)
    private String codigo;

    @Column(name = "DESCRIPCION", nullable = false, length = 50)
    private String descripcion;

    //verificar si deberia traer las carreras o no
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigo")
//    private Collection<Carrera> carreraCollection;
    
    @JoinColumn(name = "COD_UNIDAD", referencedColumnName = "COD_UNIDAD", nullable = false, insertable = false, updatable = false)
    @ManyToOne
    private Unidad codUnidad;

    public Departamento() {
    }

    public Departamento(String codigo) {
        this.codigo = codigo;
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

    public Unidad getCodUnidad() {
        return codUnidad;
    }

    public void setCodUnidad(Unidad codUnidad) {
        this.codUnidad = codUnidad;
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
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Departamento{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", codUnidad=" + codUnidad + '}';
    }

}
