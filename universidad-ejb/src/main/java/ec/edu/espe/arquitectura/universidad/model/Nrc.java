/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.universidad.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jolube
 */
@Entity
@Table(name = "NRC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nrc.findAll", query = "SELECT n FROM Nrc n")
    , @NamedQuery(name = "Nrc.findByCodNrc", query = "SELECT n FROM Nrc n WHERE n.nrcPK.codNrc = :codNrc")
    , @NamedQuery(name = "Nrc.findByCodPeriodo", query = "SELECT n FROM Nrc n WHERE n.nrcPK.codPeriodo = :codPeriodo")})
public class Nrc implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NrcPK nrcPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nrc")
    private Collection<DetalleMatricula> detalleMatriculaCollection;
    @OneToMany(mappedBy = "nrc")
    private Collection<Horario> horarioCollection;
    @JoinColumn(name = "COD_ASIGNATURA", referencedColumnName = "COD_ASIGNATURA")
    @ManyToOne(optional = false)
    private Asignatura codAsignatura;
    @JoinColumn(name = "COD_DOCENTE", referencedColumnName = "COD_DOCENTE")
    @ManyToOne
    private Docente codDocente;
    @JoinColumn(name = "COD_PERIODO", referencedColumnName = "COD_PERIODO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PeriodoLectivo periodoLectivo;

    public Nrc() {
    }

    public Nrc(NrcPK nrcPK) {
        this.nrcPK = nrcPK;
    }

    public Nrc(String codNrc, String codPeriodo) {
        this.nrcPK = new NrcPK(codNrc, codPeriodo);
    }

    public NrcPK getNrcPK() {
        return nrcPK;
    }

    public void setNrcPK(NrcPK nrcPK) {
        this.nrcPK = nrcPK;
    }

    @XmlTransient
    public Collection<DetalleMatricula> getDetalleMatriculaCollection() {
        return detalleMatriculaCollection;
    }

    public void setDetalleMatriculaCollection(Collection<DetalleMatricula> detalleMatriculaCollection) {
        this.detalleMatriculaCollection = detalleMatriculaCollection;
    }

    @XmlTransient
    public Collection<Horario> getHorarioCollection() {
        return horarioCollection;
    }

    public void setHorarioCollection(Collection<Horario> horarioCollection) {
        this.horarioCollection = horarioCollection;
    }

    public Asignatura getCodAsignatura() {
        return codAsignatura;
    }

    public void setCodAsignatura(Asignatura codAsignatura) {
        this.codAsignatura = codAsignatura;
    }

    public Docente getCodDocente() {
        return codDocente;
    }

    public void setCodDocente(Docente codDocente) {
        this.codDocente = codDocente;
    }

    public PeriodoLectivo getPeriodoLectivo() {
        return periodoLectivo;
    }

    public void setPeriodoLectivo(PeriodoLectivo periodoLectivo) {
        this.periodoLectivo = periodoLectivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nrcPK != null ? nrcPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nrc)) {
            return false;
        }
        Nrc other = (Nrc) object;
        if ((this.nrcPK == null && other.nrcPK != null) || (this.nrcPK != null && !this.nrcPK.equals(other.nrcPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.universidadCore.model.Nrc[ nrcPK=" + nrcPK + " ]";
    }
    
}
