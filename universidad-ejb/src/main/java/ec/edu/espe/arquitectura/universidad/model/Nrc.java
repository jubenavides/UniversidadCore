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
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "NRC")
public class Nrc implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected NrcPK nrcPK;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nrc")
    private List<DetalleMatricula> detalleMatriculaList;
    
    @JoinColumn(name = "COD_ASIGNATURA", referencedColumnName = "COD_ASIGNATURA", nullable = false)
    @ManyToOne
    private Asignatura codAsignatura;
    
    @JoinColumn(name = "COD_DOCENTE", referencedColumnName = "COD_DOCENTE")
    @ManyToOne
    private Docente codDocente;
    
    @JoinColumn(name = "COD_PERIODO", referencedColumnName = "COD_PERIODO", insertable = false, updatable = false, nullable = false)
    @ManyToOne
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
    public List<DetalleMatricula> getDetalleMatriculaList() {
        return detalleMatriculaList;
    }

    public void setDetalleMatriculaList(List<DetalleMatricula> detalleMatriculaList) {
        this.detalleMatriculaList = detalleMatriculaList;
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
        return "Nrc{" + "nrcPK=" + nrcPK + ", detalleMatriculaList=" + detalleMatriculaList + ", codAsignatura=" + codAsignatura + ", codDocente=" + codDocente + ", periodoLectivo=" + periodoLectivo + '}';
    }

}
