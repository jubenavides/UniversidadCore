/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.universidad.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jolube
 */
@Entity
@Table(name = "UBICACION")
public class Ubicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_UBICACION", nullable = false, length = 3)
    private String codigo;
    
    @Column(name = "DESCRIPCION", nullable = false, length = 50)
    private String descripcion;
    
    @JoinColumn(name = "COD_UBICACION_PADRE", referencedColumnName = "COD_UBICACION")
    @ManyToOne
    private Ubicacion codUbicacionPadre;
    
    //verificar sirve para ver todos los horarios hay en una ubicacion
    @OneToMany(mappedBy = "codUbicacion")
    private Collection<Horario> horarioCollection;

    public Ubicacion() {
    }

    public Ubicacion(String codUbicacion) {
        this.codigo = codUbicacion;
    }

    public Ubicacion(String codUbicacion, String descripcion) {
        this.codigo = codUbicacion;
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

    public Ubicacion getCodUbicacionPadre() {
        return codUbicacionPadre;
    }

    public void setCodUbicacionPadre(Ubicacion codUbicacionPadre) {
        this.codUbicacionPadre = codUbicacionPadre;
    }

    @XmlTransient
    public Collection<Horario> getHorarioCollection() {
        return horarioCollection;
    }

    public void setHorarioCollection(Collection<Horario> horarioCollection) {
        this.horarioCollection = horarioCollection;
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
        if (!(object instanceof Ubicacion)) {
            return false;
        }
        Ubicacion other = (Ubicacion) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ubicacion{" + "codUbicacion=" + codigo + ", descripcion=" + descripcion + ", codUbicacionPadre=" + codUbicacionPadre + ", horarioCollection=" + horarioCollection + '}';
    }

}
