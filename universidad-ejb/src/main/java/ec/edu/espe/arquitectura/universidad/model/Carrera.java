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
@Table(name = "CARRERA")
public class Carrera implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_CARRERA", nullable = false, length = 5)
    private String codigo;
    
    @Column(name = "DESCRIPCION", nullable = false, length = 50)
    private String descripcion;
    
    @Column(name = "MODALIDAD", nullable = false, length = 20)
    private String modalidad;
    
    @Column(name = "NIVEL", nullable = false, length = 20)
    private String nivel;
    
    @JoinColumn(name = "COD_DEPARTAMENTO", referencedColumnName = "COD_DEPARTAMENTO", nullable = false, updatable = false, insertable = false)
    @ManyToOne
    private Departamento codDepartamento;

    public Carrera() {
    }

    public Carrera(String codigo) {
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

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Departamento getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(Departamento codDepartamento) {
        this.codDepartamento = codDepartamento;
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
        if (!(object instanceof Carrera)) {
            return false;
        }
        Carrera other = (Carrera) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Carrera{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", modalidad=" + modalidad + ", nivel=" + nivel + ", codDepartamento=" + codDepartamento + '}';
    }

}
