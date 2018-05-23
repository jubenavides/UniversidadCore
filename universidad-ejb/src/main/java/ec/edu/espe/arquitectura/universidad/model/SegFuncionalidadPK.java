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
public class SegFuncionalidadPK implements Serializable {

    @Column(name = "COD_MODULO",nullable = false, length = 20)
    private String codModulo;
    
    @Column(name = "SEC_FUNCIONALIDAD", nullable = false)
    private Integer secFuncionalidad;

    public SegFuncionalidadPK() {
    }

    public SegFuncionalidadPK(String codModulo, Integer secFuncionalidad) {
        this.codModulo = codModulo;
        this.secFuncionalidad = secFuncionalidad;
    }

    public String getCodModulo() {
        return codModulo;
    }

    public void setCodModulo(String codModulo) {
        this.codModulo = codModulo;
    }

    public Integer getSecFuncionalidad() {
        return secFuncionalidad;
    }

    public void setSecFuncionalidad(Integer secFuncionalidad) {
        this.secFuncionalidad = secFuncionalidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codModulo != null ? codModulo.hashCode() : 0);
        hash += (int) secFuncionalidad;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegFuncionalidadPK)) {
            return false;
        }
        SegFuncionalidadPK other = (SegFuncionalidadPK) object;
        if ((this.codModulo == null && other.codModulo != null) || (this.codModulo != null && !this.codModulo.equals(other.codModulo))) {
            return false;
        }
        if (this.secFuncionalidad != other.secFuncionalidad) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SegFuncionalidadPK{" + "codModulo=" + codModulo + ", secFuncionalidad=" + secFuncionalidad + '}';
    }

}
