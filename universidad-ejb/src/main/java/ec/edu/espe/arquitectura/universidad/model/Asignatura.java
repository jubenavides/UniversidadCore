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
@Table(name = "ASIGNATURA")
public class Asignatura implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "COD_ASIGNATURA", nullable = false, length = 5)
    private String codigo;

    @Column(name = "NOMBRE", nullable = false, length = 30)
    private String nombre;

    @Column(name = "DESCRIPCION", nullable = false, length = 50)
    private String descripcion;

    @Column(name = "NUM_CREDITOS", nullable = false)
    private Integer numCreditos;

    @Column(name = "ESTADO", length = 3)
    private String estado;
    
    @JoinColumn(name = "COD_DEPARTAMENTO", referencedColumnName = "COD_DEPARTAMENTO", nullable = false, insertable = false, updatable = false)
    @ManyToOne
    private Departamento codDepartamento;

    public Asignatura() {
    }

    public Asignatura(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getNumCreditos() {
        return numCreditos;
    }

    public void setNumCreditos(Integer numCreditos) {
        this.numCreditos = numCreditos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
        if (!(object instanceof Asignatura)) {
            return false;
        }
        Asignatura other = (Asignatura) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Asignatura{" + "codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", numCreditos=" + numCreditos + ", estado=" + estado + ", codDepartamento=" + codDepartamento + '}';
    }

}
