/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.universidad.model;

import ec.edu.espe.arquitectura.universidad.enums.EstadoTemaEnum;
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
@Table(name = "TEMA")
public class Tema implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_TEMA", nullable = false, length = 5)
    private String codigo;
    
    @Column(name = "NOMBRE", nullable = false, length = 30)
    private String nombre;
    
    @Column(name = "DESCRIPCION", nullable = false, length = 100)
    private String descripcion;
    
    @Column(name = "FECHA_INICIO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    
    @Column(name = "FECHA_FIN", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    
    @Column(name = "ESTADO", nullable = false,length = 2)
    private EstadoTemaEnum estado;
    
    //revisar: cuando cargo un tema deseo ver los subtemas
    @OneToMany(mappedBy = "codTema")
    private List<Subtema> subtemas;
    
    @JoinColumn(name = "COD_SILABO", referencedColumnName = "COD_SILABO", nullable = false, insertable = false, updatable = false)
    @ManyToOne
    private Silabo codSilabo;

    public Tema() {
    }

    public Tema(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public EstadoTemaEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoTemaEnum estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Subtema> getSubtemaList() {
        return subtemas;
    }

    public Silabo getCodSilabo() {
        return codSilabo;
    }

    public void setCodSilabo(Silabo codSilabo) {
        this.codSilabo = codSilabo;
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
        if (!(object instanceof Tema)) {
            return false;
        }
        Tema other = (Tema) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tema{" + "codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", estado=" + estado + ", codSilabo=" + codSilabo + '}';
    }

}
