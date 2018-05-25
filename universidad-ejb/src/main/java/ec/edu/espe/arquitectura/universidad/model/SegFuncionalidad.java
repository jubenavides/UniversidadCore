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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author jolube
 */
@Entity
@Table(name = "SEG_FUNCIONALIDAD")
public class SegFuncionalidad implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected SegFuncionalidadPK segFuncionalidadPK;

    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;

    @Column(name = "URL", nullable = false, length = 200)
    private String url;

    @Enumerated(EnumType.STRING)
    @Column(name = "ESTADO",  length = 3, nullable = false)
    private EstadoBaseEnum estado;

    @JoinColumn(name = "COD_MODULO", referencedColumnName = "COD_MODULO", insertable = false, updatable = false)
    @ManyToOne
    private SegModulo segModulo;

    public SegFuncionalidad() {
    }

    public SegFuncionalidad(SegFuncionalidadPK segFuncionalidadPK) {
        this.segFuncionalidadPK = segFuncionalidadPK;
    }

    public SegFuncionalidad(String codModulo, int secFuncionalidad) {
        this.segFuncionalidadPK = new SegFuncionalidadPK(codModulo, secFuncionalidad);
    }

    public SegFuncionalidadPK getSegFuncionalidadPK() {
        return segFuncionalidadPK;
    }

    public void setSegFuncionalidadPK(SegFuncionalidadPK segFuncionalidadPK) {
        this.segFuncionalidadPK = segFuncionalidadPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public EstadoBaseEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoBaseEnum estado) {
        this.estado = estado;
    }

    public SegModulo getSegModulo() {
        return segModulo;
    }

    public void setSegModulo(SegModulo segModulo) {
        this.segModulo = segModulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (segFuncionalidadPK != null ? segFuncionalidadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegFuncionalidad)) {
            return false;
        }
        SegFuncionalidad other = (SegFuncionalidad) object;
        if ((this.segFuncionalidadPK == null && other.segFuncionalidadPK != null) || (this.segFuncionalidadPK != null && !this.segFuncionalidadPK.equals(other.segFuncionalidadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SegFuncionalidad{" + "segFuncionalidadPK=" + segFuncionalidadPK + ", nombre=" + nombre + ", url=" + url + ", estado=" + estado + ", segModulo=" + segModulo + '}';
    }

}
