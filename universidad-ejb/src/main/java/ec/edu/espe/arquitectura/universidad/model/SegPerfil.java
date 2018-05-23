/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.universidad.model;


import ec.edu.espe.arquitectura.universidad.enums.EstadoSegPerfilEnum;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author jolube
 */
@Entity
@Table(name = "SEG_PERFIL")
public class SegPerfil implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "COD_PERFIL", nullable = false, length = 20)
    private String codigo;

    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(name = "ESTADO", nullable = false, length = 3)
    private EstadoSegPerfilEnum estado;

    public SegPerfil() {
    }

    public SegPerfil(String codigo) {
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

    public EstadoSegPerfilEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoSegPerfilEnum estado) {
        this.estado = estado;
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
        if (!(object instanceof SegPerfil)) {
            return false;
        }
        SegPerfil other = (SegPerfil) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SegPerfil{" + "codigo=" + codigo + ", nombre=" + nombre + ", estado=" + estado + '}';
    }

}
