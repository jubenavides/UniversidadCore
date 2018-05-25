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
import javax.persistence.Table;

/**
 *
 * @author jolube
 */
@Entity
@Table(name = "ESTUDIANTE")
public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "COD_ESTUDIANTE", nullable = false, length = 10)
    private String codigo;

    @Column(name = "NOMBRES", nullable = false, length = 50)
    private String nombres;

    @Column(name = "APELLIDOS", nullable = false, length = 50)
    private String apellidos;

    @Column(name = "IDENTIFICACION", nullable = false, length = 10)
    private String identificacion;

    @Column(name = "DIRECCION", nullable = false, length = 50)
    private String direccion;

    @Column(name = "CORREO_PERSONAL", nullable = false, length = 50)
    private String correoPersonal;

    @Enumerated(EnumType.STRING)
    @Column(name = "ESTADO", nullable = false, length = 3)
    private EstadoBaseEnum estado;

    @Column(name = "CORREO_INSTITUCIONAL", nullable = false, length = 50)
    private String correoInstitucional;

    @Column(name = "TIPO", nullable = false, length = 3)
    private String tipo;

    public Estudiante() {
    }

    public Estudiante(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoPersonal() {
        return correoPersonal;
    }

    public void setCorreoPersonal(String correoPersonal) {
        this.correoPersonal = correoPersonal;
    }

    public EstadoBaseEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoBaseEnum estado) {
        this.estado = estado;
    }

    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "codigo=" + codigo + ", nombres=" + nombres + ", apellidos=" + apellidos + ", identificacion=" + identificacion + ", direccion=" + direccion + ", correoPersonal=" + correoPersonal + ", estado=" + estado + ", correoInstitucional=" + correoInstitucional + ", tipo=" + tipo + '}';
    }

}
