/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.universidad.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jolube
 */
@Embeddable
public class NrcPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "COD_NRC")
    private String codNrc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "COD_PERIODO")
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
