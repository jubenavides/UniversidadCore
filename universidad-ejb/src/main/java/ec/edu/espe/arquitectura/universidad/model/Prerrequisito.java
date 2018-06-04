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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author jolube
 */
@Entity
@Table(name = "PRERREQUISITO")
public class Prerrequisito implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_PRERREQUISITO")
    private Integer codigo;
    
    @JoinColumn(name = "COD_MAT_MALLA", referencedColumnName = "COD_DETALLE_MALLA", nullable = false, insertable = true, updatable = false)
    @ManyToOne
    private DetalleMalla codMateria;
    
    @JoinColumn(name = "COD_MAT_PRE", referencedColumnName = "COD_DETALLE_MALLA", nullable = false, insertable = true, updatable = false)
    @ManyToOne
    private DetalleMalla codPreRequisito;
    
    public Prerrequisito() {
    }

    public Prerrequisito(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public DetalleMalla getCodMateria() {
        return codMateria;
    }

    public void setCodMateria(DetalleMalla codMateria) {
        this.codMateria = codMateria;
    }

    public DetalleMalla getCodPreRequisito() {
        return codPreRequisito;
    }

    public void setCodPreRequisito(DetalleMalla codPreRequisito) {
        this.codPreRequisito = codPreRequisito;
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
        if (!(object instanceof Prerrequisito)) {
            return false;
        }
        Prerrequisito other = (Prerrequisito) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Prerrequisito{" + "codigo=" + codigo + ", codMateria=" + codMateria + ", codPreRequisito=" + codPreRequisito + '}';
    }

}
