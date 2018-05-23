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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author jolube
 */
@Entity
@Table(name = "SEG_USUARIO_ROL")
public class SegUsuarioRol implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected SegUsuarioRolPK segUsuarioRolPK;

    @Column(name = "COD_EXTERNO", nullable = false, length = 10)
    private String codExterno;

    @JoinColumn(name = "COD_ROL", referencedColumnName = "COD_ROL", insertable = false, updatable = false, nullable = false)
    @ManyToOne
    private SegRol segRol;

    @JoinColumn(name = "COD_USUARIO", referencedColumnName = "COD_USUARIO", insertable = false, updatable = false, nullable = false)
    @ManyToOne
    private SegUsuario segUsuario;

    public SegUsuarioRol() {
    }

    public SegUsuarioRol(SegUsuarioRolPK segUsuarioRolPK) {
        this.segUsuarioRolPK = segUsuarioRolPK;
    }

    public SegUsuarioRol(SegUsuarioRolPK segUsuarioRolPK, String codExterno) {
        this.segUsuarioRolPK = segUsuarioRolPK;
        this.codExterno = codExterno;
    }

    public SegUsuarioRol(String codRol, String codUsuario) {
        this.segUsuarioRolPK = new SegUsuarioRolPK(codRol, codUsuario);
    }

    public SegUsuarioRolPK getSegUsuarioRolPK() {
        return segUsuarioRolPK;
    }

    public void setSegUsuarioRolPK(SegUsuarioRolPK segUsuarioRolPK) {
        this.segUsuarioRolPK = segUsuarioRolPK;
    }

    public String getCodExterno() {
        return codExterno;
    }

    public void setCodExterno(String codExterno) {
        this.codExterno = codExterno;
    }

    public SegRol getSegRol() {
        return segRol;
    }

    public void setSegRol(SegRol segRol) {
        this.segRol = segRol;
    }

    public SegUsuario getSegUsuario() {
        return segUsuario;
    }

    public void setSegUsuario(SegUsuario segUsuario) {
        this.segUsuario = segUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (segUsuarioRolPK != null ? segUsuarioRolPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegUsuarioRol)) {
            return false;
        }
        SegUsuarioRol other = (SegUsuarioRol) object;
        if ((this.segUsuarioRolPK == null && other.segUsuarioRolPK != null) || (this.segUsuarioRolPK != null && !this.segUsuarioRolPK.equals(other.segUsuarioRolPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SegUsuarioRol{" + "segUsuarioRolPK=" + segUsuarioRolPK + ", codExterno=" + codExterno + ", segRol=" + segRol + ", segUsuario=" + segUsuario + '}';
    }

}
