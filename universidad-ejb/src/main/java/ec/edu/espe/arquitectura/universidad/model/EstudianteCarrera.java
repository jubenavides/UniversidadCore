/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.universidad.model;

import ec.edu.espe.arquitectura.universidad.enums.EstadoBaseEnum;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author jolube
 */
@Entity
@Table(name = "ESTUDIANTE_CARRERA")
public class EstudianteCarrera implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "COD_ESTUDIANTE_CARRERA", nullable = false, length = 5)
    private String codigo;

    @Enumerated(EnumType.STRING)
    @Column(name = "ESTADO", length = 3)
    private EstadoBaseEnum estado;

    @JoinColumn(name = "COD_CARRERA", referencedColumnName = "COD_CARRERA", nullable = false, insertable = false, updatable = false)
    @ManyToOne
    private Carrera codCarrera;

    @JoinColumn(name = "COD_ESTUDIANTE", referencedColumnName = "COD_ESTUDIANTE", nullable = false, insertable = false, updatable = false)
    @ManyToOne
    private Estudiante codEstudiante;

    public EstudianteCarrera() {
    }

    public EstudianteCarrera(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public EstadoBaseEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoBaseEnum estado) {
        this.estado = estado;
    }

    public Carrera getCodCarrera() {
        return codCarrera;
    }

    public void setCodCarrera(Carrera codCarrera) {
        this.codCarrera = codCarrera;
    }

    public Estudiante getCodEstudiante() {
        return codEstudiante;
    }

    public void setCodEstudiante(Estudiante codEstudiante) {
        this.codEstudiante = codEstudiante;
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
        if (!(object instanceof EstudianteCarrera)) {
            return false;
        }
        EstudianteCarrera other = (EstudianteCarrera) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EstudianteCarrera{" + "codigo=" + codigo + ", estado=" + estado + ", codCarrera=" + codCarrera + ", codEstudiante=" + codEstudiante + '}';
    }

}
