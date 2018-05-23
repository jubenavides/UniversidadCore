/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.universidad.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author jolube
 */
@Entity
@Table(name = "RESTRICCION")
public class Restriccion implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_RESTRICCION", nullable = false, length = 3)
    private String codigo;
    
    @Column(name = "DESCRIPCION", nullable = false, length = 50)
    private String descripcion;
    
    public Restriccion() {
    }

    public Restriccion(String codigo) {
        this.codigo = codigo;
    }

    public String getCodRestriccion() {
        return codigo;
    }

    public void setCodRestriccion(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        if (!(object instanceof Restriccion)) {
            return false;
        }
        Restriccion other = (Restriccion) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Restriccion{" + "codigo=" + codigo + ", descripcion=" + descripcion + '}';
    }

}
