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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author jolube
 */
@Entity
@Table(name = "HORARIO")
public class Horario implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_HORARIO", nullable = false, length = 5)
    private String codigo;
    
    @JoinColumn(name = "COD_FRANJA_MATRICULA", referencedColumnName = "COD_FRANJA_HORARIA", nullable = false, insertable = true, updatable = false)
    @ManyToOne
    private FranjaHoraria codFranjaMatricula;
    
    @JoinColumns({
        @JoinColumn(name = "COD_NRC", referencedColumnName = "COD_NRC", nullable = false, insertable = true, updatable = false)
        , @JoinColumn(name = "COD_PERIODO", referencedColumnName = "COD_PERIODO", nullable = false, insertable = true, updatable = false)})
    @ManyToOne
    private Nrc nrc;
    
    @JoinColumn(name = "COD_UBICACION", referencedColumnName = "COD_UBICACION", nullable = false, insertable = true, updatable = false)
    @ManyToOne
    private Ubicacion codUbicacion;

    public Horario() {
    }

    public Horario(String codHorario) {
        this.codigo = codHorario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public FranjaHoraria getCodFranjaMatricula() {
        return codFranjaMatricula;
    }

    public void setCodFranjaMatricula(FranjaHoraria codFranjaMatricula) {
        this.codFranjaMatricula = codFranjaMatricula;
    }

    public Nrc getNrc() {
        return nrc;
    }

    public void setNrc(Nrc nrc) {
        this.nrc = nrc;
    }

    public Ubicacion getCodUbicacion() {
        return codUbicacion;
    }

    public void setCodUbicacion(Ubicacion codUbicacion) {
        this.codUbicacion = codUbicacion;
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
        if (!(object instanceof Horario)) {
            return false;
        }
        Horario other = (Horario) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Horario{" + "codigo=" + codigo + ", codFranjaMatricula=" + codFranjaMatricula + ", nrc=" + nrc + ", codUbicacion=" + codUbicacion + '}';
    }

}
