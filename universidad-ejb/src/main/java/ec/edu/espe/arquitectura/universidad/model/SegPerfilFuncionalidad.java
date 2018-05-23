/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.universidad.model;

import ec.edu.espe.arquitectura.universidad.enums.EstadoSegPerfilFuncionalidadEnum;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author jolube
 */
@Entity
@Table(name = "SEG_PERFIL_FUNCIONALIDAD")
public class SegPerfilFuncionalidad implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected SegPerfilFuncionalidadPK segPerfilFuncionalidadPK;

    @Enumerated(EnumType.STRING)
    @Column(name = "ESTADO", nullable = false, length = 3)
    private EstadoSegPerfilFuncionalidadEnum estado;

    @JoinColumns({
        @JoinColumn(name = "COD_MODULO", referencedColumnName = "COD_MODULO", insertable = false, updatable = false, nullable = false)
        , @JoinColumn(name = "SEC_FUNCIONALIDAD", referencedColumnName = "SEC_FUNCIONALIDAD", insertable = false, updatable = false, nullable = false)})
    @ManyToOne
    private SegFuncionalidad segFuncionalidad;

    @JoinColumn(name = "COD_PERFIL", referencedColumnName = "COD_PERFIL", insertable = false, updatable = false, nullable = false)
    @ManyToOne
    private SegPerfil segPerfil;

    public SegPerfilFuncionalidad() {
    }

    public SegPerfilFuncionalidad(SegPerfilFuncionalidadPK segPerfilFuncionalidadPK) {
        this.segPerfilFuncionalidadPK = segPerfilFuncionalidadPK;
    }

    public SegPerfilFuncionalidad(String codPerfil, String codModulo, int secFuncionalidad) {
        this.segPerfilFuncionalidadPK = new SegPerfilFuncionalidadPK(codPerfil, codModulo, secFuncionalidad);
    }

    public SegPerfilFuncionalidadPK getSegPerfilFuncionalidadPK() {
        return segPerfilFuncionalidadPK;
    }

    public void setSegPerfilFuncionalidadPK(SegPerfilFuncionalidadPK segPerfilFuncionalidadPK) {
        this.segPerfilFuncionalidadPK = segPerfilFuncionalidadPK;
    }

    public EstadoSegPerfilFuncionalidadEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoSegPerfilFuncionalidadEnum estado) {
        this.estado = estado;
    }

    public SegFuncionalidad getSegFuncionalidad() {
        return segFuncionalidad;
    }

    public void setSegFuncionalidad(SegFuncionalidad segFuncionalidad) {
        this.segFuncionalidad = segFuncionalidad;
    }

    public SegPerfil getSegPerfil() {
        return segPerfil;
    }

    public void setSegPerfil(SegPerfil segPerfil) {
        this.segPerfil = segPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (segPerfilFuncionalidadPK != null ? segPerfilFuncionalidadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegPerfilFuncionalidad)) {
            return false;
        }
        SegPerfilFuncionalidad other = (SegPerfilFuncionalidad) object;
        if ((this.segPerfilFuncionalidadPK == null && other.segPerfilFuncionalidadPK != null) || (this.segPerfilFuncionalidadPK != null && !this.segPerfilFuncionalidadPK.equals(other.segPerfilFuncionalidadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SegPerfilFuncionalidad{" + "segPerfilFuncionalidadPK=" + segPerfilFuncionalidadPK + ", estado=" + estado + ", segFuncionalidad=" + segFuncionalidad + ", segPerfil=" + segPerfil + '}';
    }

}
