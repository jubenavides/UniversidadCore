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
public class NrcPK implements Serializable {

    @Column(name = "COD_NRC", nullable = false, length = 5)
    private String codNrc;

    @Column(name = "COD_PERIODO", nullable = false, length = 6)
    private String codPeriodo;

    public NrcPK() {
    }

    public NrcPK(String codNrc, String codPeriodo) {
        this.codNrc = codNrc;
        this.codPeriodo = codPeriodo;
    }

    public String getCodNrc() {
        return codNrc;
    }

    public void setCodNrc(String codNrc) {
        this.codNrc = codNrc;
    }

    public String getCodPeriodo() {
        return codPeriodo;
    }

    public void setCodPeriodo(String codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codNrc != null ? codNrc.hashCode() : 0);
        hash += (codPeriodo != null ? codPeriodo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NrcPK)) {
            return false;
        }
        NrcPK other = (NrcPK) object;
        if ((this.codNrc == null && other.codNrc != null) || (this.codNrc != null && !this.codNrc.equals(other.codNrc))) {
            return false;
        }
        if ((this.codPeriodo == null && other.codPeriodo != null) || (this.codPeriodo != null && !this.codPeriodo.equals(other.codPeriodo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.universidadCore.model.NrcPK[ codNrc=" + codNrc + ", codPeriodo=" + codPeriodo + " ]";
    }

}
