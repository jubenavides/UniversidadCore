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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author jolube
 */
@Entity
@Table(name = "DETALLE_MALLA")
public class DetalleMalla implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_DETALLE_MALLA", nullable = false)
    private Integer codigo;
    
    @JoinColumn(name = "COD_ASIGNATURA", referencedColumnName = "COD_ASIGNATURA", nullable = false, updatable =  false, insertable = false)
    @ManyToOne
    private Asignatura codAsignatura;
    
    @JoinColumn(name = "COD_MALLA", referencedColumnName = "COD_MALLA", nullable = false, updatable =  false, insertable = false)
    @ManyToOne
    private Malla codMalla;

    public DetalleMalla() {
    }

    public DetalleMalla(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodDetalleMalla() {
        return codigo;
    }

    public void setCodDetalleMalla(Integer codigo) {
        this.codigo = codigo;
    }

    public Asignatura getCodAsignatura() {
        return codAsignatura;
    }

    public void setCodAsignatura(Asignatura codAsignatura) {
        this.codAsignatura = codAsignatura;
    }

    public Malla getCodMalla() {
        return codMalla;
    }

    public void setCodMalla(Malla codMalla) {
        this.codMalla = codMalla;
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
        if (!(object instanceof DetalleMalla)) {
            return false;
        }
        DetalleMalla other = (DetalleMalla) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DetalleMalla{" + "codigo=" + codigo + ", codAsignatura=" + codAsignatura + ", codMalla=" + codMalla + '}';
    }

}
