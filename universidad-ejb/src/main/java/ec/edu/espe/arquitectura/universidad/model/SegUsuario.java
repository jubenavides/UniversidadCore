/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.universidad.model;

import ec.edu.espe.arquitectura.universidad.enums.EstadoSegUsuarioEnum;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jolube
 */
@Entity
@Table(name = "SEG_USUARIO")
public class SegUsuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "COD_USUARIO", nullable = false, length = 20)
    private String codigo;

    @Column(name = "CORREO_ELECTRONICO", nullable = false, length = 120)
    private String correoElectronico;

    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    @Column(name = "CLAVE", nullable = false, length = 64)
    private String clave;

    @Enumerated(EnumType.STRING)
    @Column(name = "ESTADO", nullable = false, length = 3)
    private EstadoSegUsuarioEnum estado;

    @Column(name = "FECHA_CREACION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Column(name = "INTENTOS_ERRONEOS", nullable = false)
    private Integer intentosErroneos;

    @Column(name = "FECHA_ULTIMO_ACCESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltimoAcceso;

    @JoinColumn(name = "COD_PERFIL", referencedColumnName = "COD_PERFIL", nullable = false, updatable = false, insertable = true)
    @ManyToOne
    private SegPerfil codPerfil;

    public SegUsuario() {
    }

    public SegUsuario(String codigo) {
        this.codigo = codigo;
    }

    public SegUsuario(String codigo, String correoElectronico, String nombre){
        this.codigo = codigo;
        this.correoElectronico = correoElectronico;
        this.nombre = nombre;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public EstadoSegUsuarioEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoSegUsuarioEnum estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIntentosErroneos() {
        return intentosErroneos;
    }

    public void setIntentosErroneos(Integer intentosErroneos) {
        this.intentosErroneos = intentosErroneos;
    }

    public Date getFechaUltimoAcceso() {
        return fechaUltimoAcceso;
    }

    public void setFechaUltimoAcceso(Date fechaUltimoAcceso) {
        this.fechaUltimoAcceso = fechaUltimoAcceso;
    }

    public SegPerfil getCodPerfil() {
        return codPerfil;
    }

    public void setCodPerfil(SegPerfil codPerfil) {
        this.codPerfil = codPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SegUsuario other = (SegUsuario) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SegUsuario{" + "codigo=" + codigo + ", correoElectronico=" + correoElectronico + ", nombre=" + nombre + ", clave=" + clave + ", estado=" + estado + ", fechaCreacion=" + fechaCreacion + ", intentosErroneos=" + intentosErroneos + ", fechaUltimoAcceso=" + fechaUltimoAcceso + ", codPerfil=" + codPerfil + '}';
    }

}
