/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.universidad.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jolube
 */
@Entity
@Table(name = "FRANJA_HORARIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FranjaHoraria.findAll", query = "SELECT f FROM FranjaHoraria f")
    , @NamedQuery(name = "FranjaHoraria.findByCodFranjaHoraria", query = "SELECT f FROM FranjaHoraria f WHERE f.codFranjaHoraria = :codFranjaHoraria")
    , @NamedQuery(name = "FranjaHoraria.findByInicioHora", query = "SELECT f FROM FranjaHoraria f WHERE f.inicioHora = :inicioHora")
    , @NamedQuery(name = "FranjaHoraria.findByFinHora", query = "SELECT f FROM FranjaHoraria f WHERE f.finHora = :finHora")
    , @NamedQuery(name = "FranjaHoraria.findByDia", query = "SELECT f FROM FranjaHoraria f WHERE f.dia = :dia")})
public class FranjaHoraria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "COD_FRANJA_HORARIA")
    private String codFranjaHoraria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INICIO_HORA")
    @Temporal(TemporalType.TIME)
    private Date inicioHora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FIN_HORA")
    @Temporal(TemporalType.TIME)
    private Date finHora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "DIA")
    private String dia;
    @OneToMany(mappedBy = "codFranjaMatricula")
    private Collection<Horario> horarioCollection;

    public FranjaHoraria() {
    }

    public FranjaHoraria(String codFranjaHoraria) {
        this.codFranjaHoraria = codFranjaHoraria;
    }

    public FranjaHoraria(String codFranjaHoraria, Date inicioHora, Date finHora, String dia) {
        this.codFranjaHoraria = codFranjaHoraria;
        this.inicioHora = inicioHora;
        this.finHora = finHora;
        this.dia = dia;
    }

    public String getCodFranjaHoraria() {
        return codFranjaHoraria;
    }

    public void setCodFranjaHoraria(String codFranjaHoraria) {
        this.codFranjaHoraria = codFranjaHoraria;
    }

    public Date getInicioHora() {
        return inicioHora;
    }

    public void setInicioHora(Date inicioHora) {
        this.inicioHora = inicioHora;
    }

    public Date getFinHora() {
        return finHora;
    }

    public void setFinHora(Date finHora) {
        this.finHora = finHora;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
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
        hash += (codFranjaHoraria != null ? codFranjaHoraria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FranjaHoraria)) {
            return false;
        }
        FranjaHoraria other = (FranjaHoraria) object;
        if ((this.codFranjaHoraria == null && other.codFranjaHoraria != null) || (this.codFranjaHoraria != null && !this.codFranjaHoraria.equals(other.codFranjaHoraria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.universidadCore.model.FranjaHoraria[ codFranjaHoraria=" + codFranjaHoraria + " ]";
    }
    
}
