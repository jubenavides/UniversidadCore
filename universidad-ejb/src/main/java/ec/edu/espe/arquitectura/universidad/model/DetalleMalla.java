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
    
    @Column(name = "NIVEL")
    private Integer nivel;
    
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

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
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
