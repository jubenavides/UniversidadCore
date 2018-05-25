/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.universidad.model;

import java.io.Serializable;
import java.util.List;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jolube
 */
@Entity
@Table(name = "SILABO")
public class Silabo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "COD_SILABO", nullable = false, length = 3)
    private String codigo;

    @Column(name = "DESCRIPCION", nullable = false, length = 50)
    private String descripcion;

    @Column(name = "FECHA_ELABORACION")
    @Temporal(TemporalType.DATE)
    private Date fechaElaboracion;

    @JoinColumn(name = "COD_ASIGNATURA", referencedColumnName = "COD_ASIGNATURA", nullable = false, insertable = false, updatable = false)
    @ManyToOne
    private Asignatura codAsignatura;
    
    
    @JoinColumn(name = "COD_PERIODO", referencedColumnName = "COD_PERIODO", nullable = false, insertable = false, updatable = false)
    @ManyToOne
    private PeriodoLectivo codPeriodo;

    //revisar : cuando veo un silabo si me interesa q se cargue todos los temas
    @OneToMany(mappedBy = "codSilabo")
    private List<Tema> temas;

    public Silabo() {
    }

    public Silabo(String codigo) {
        this.codigo = codigo;
    }

    public Silabo(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaElaboracion() {
        return fechaElaboracion;
    }

    public void setFechaElaboracion(Date fechaElaboracion) {
        this.fechaElaboracion = fechaElaboracion;
    }

    public Asignatura getCodAsignatura() {
        return codAsignatura;
    }

    public void setCodAsignatura(Asignatura codAsignatura) {
        this.codAsignatura = codAsignatura;
    }

    public PeriodoLectivo getCodPeriodo() {
        return codPeriodo;
    }

    public void setCodPeriodo(PeriodoLectivo codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    @XmlTransient
    public List<Tema> getTemas() {
        return temas;
    }

    public void setTemas(List<Tema> temas) {
        this.temas = temas;
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
        if (!(object instanceof Silabo)) {
            return false;
        }
        Silabo other = (Silabo) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Silabo{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", fechaElaboracion=" + fechaElaboracion + ", codAsignatura=" + codAsignatura + ", codPeriodo=" + codPeriodo + ", temas=" + temas + '}';
    }

}
