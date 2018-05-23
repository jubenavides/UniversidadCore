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
import javax.persistence.Embeddable;

/**
 *
 * @author jolube
 */
@Embeddable
public class SegUsuarioRolPK implements Serializable {

    @Column(name = "COD_ROL", nullable = false, length = 10)
    private String codRol;

    @Column(name = "COD_USUARIO", nullable = false, length = 20)
    private String codUsuario;

    public SegUsuarioRolPK() {
    }

    public SegUsuarioRolPK(String codRol, String codUsuario) {
        this.codRol = codRol;
        this.codUsuario = codUsuario;
    }

    public String getCodRol() {
        return codRol;
    }

    public void setCodRol(String codRol) {
        this.codRol = codRol;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codRol != null ? codRol.hashCode() : 0);
        hash += (codUsuario != null ? codUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegUsuarioRolPK)) {
            return false;
        }
        SegUsuarioRolPK other = (SegUsuarioRolPK) object;
        if ((this.codRol == null && other.codRol != null) || (this.codRol != null && !this.codRol.equals(other.codRol))) {
            return false;
        }
        if ((this.codUsuario == null && other.codUsuario != null) || (this.codUsuario != null && !this.codUsuario.equals(other.codUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SegUsuarioRolPK{" + "codRol=" + codRol + ", codUsuario=" + codUsuario + '}';
    }

}
