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
@Table(name = "DOCENTE")
public class Docente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "COD_DOCENTE", nullable = false, length = 10)
    private String codigo;

    @Column(name = "NOMBRES", nullable = false, length = 25)
    private String nombres;

    @Column(name = "APELLIDOS", nullable = false, length = 25)
    private String apellidos;

    @Column(name = "IDENTIFICACION", nullable = false, length = 10)
    private String identificacion;

    @Column(name = "CORREO_PERSONAL", nullable = false, length = 50)
    private String correoPersonal;

    @Column(name = "CORREO_INSTITUCIONAL", nullable = false, length = 50)
    private String correoInstitucional;

    @Column(name = "DIRECCION", length = 50)
    private String direccion;

    @Column(name = "TIPO", nullable = false, length = 50)
    private String tipo;

    @Column(name = "CARGA_HORARIA", nullable = false)
    private Integer cargaHoraria;

    @Column(name = "ESTADO", length = 3)
    private String estado;

    @JoinColumn(name = "COD_DEPARTAMENTO", referencedColumnName = "COD_DEPARTAMENTO", nullable = false, insertable = false, updatable = false)
    @ManyToOne
    private Departamento codDepartamento;

    public Docente() {
    }

    public Docente(String codigo) {
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

    public String getCorreoPersonal() {
        return correoPersonal;
    }

    public void setCorreoPersonal(String correoPersonal) {
        this.correoPersonal = correoPersonal;
    }

    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
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
        if (!(object instanceof Docente)) {
            return false;
        }
        Docente other = (Docente) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Docente{" + "codigo=" + codigo + ", nombres=" + nombres + ", apellidos=" + apellidos + ", identificacion=" + identificacion + ", correoPersonal=" + correoPersonal + ", correoInstitucional=" + correoInstitucional + ", direccion=" + direccion + ", tipo=" + tipo + ", cargaHoraria=" + cargaHoraria + ", estado=" + estado + ", codDepartamento=" + codDepartamento + '}';
    }

}
