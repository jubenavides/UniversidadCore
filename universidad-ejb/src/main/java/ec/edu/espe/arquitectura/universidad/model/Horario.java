/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.universidad.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jolube
 */
@Entity
@Table(name = "HORARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horario.findAll", query = "SELECT h FROM Horario h")
    , @NamedQuery(name = "Horario.findByCodHorario", query = "SELECT h FROM Horario h WHERE h.codHorario = :codHorario")})
public class Horario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "COD_HORARIO")
    private String codHorario;
    @JoinColumn(name = "COD_FRANJA_MATRICULA", referencedColumnName = "COD_FRANJA_HORARIA")
    @ManyToOne
    private FranjaHoraria codFranjaMatricula;
    @JoinColumns({
        @JoinColumn(name = "COD_NRC", referencedColumnName = "COD_NRC")
        , @JoinColumn(name = "COD_PERIODO", referencedColumnName = "COD_PERIODO")})
    @ManyToOne
    private Nrc nrc;
    @JoinColumn(name = "COD_UBICACION", referencedColumnName = "COD_UBICACION")
    @ManyToOne
    private Ubicacion codUbicacion;

    public Horario() {
    }

    public Horario(String codHorario) {
        this.codHorario = codHorario;
    }

    public String getCodHorario() {
        return codHorario;
    }

    public void setCodHorario(String codHorario) {
        this.codHorario = codHorario;
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
        hash += (codHorario != null ? codHorario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horario)) {
            return false;
        }
        Horario other = (Horario) object;
        if ((this.codHorario == null && other.codHorario != null) || (this.codHorario != null && !this.codHorario.equals(other.codHorario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.universidadCore.model.Horario[ codHorario=" + codHorario + " ]";
    }
    
}
