/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.universidad.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jolube
 */
@Entity
@Table(name = "FRANJA_HORARIA")
public class FranjaHoraria implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_FRANJA_HORARIA",nullable = false, length = 5)
    private String codigo;
    
    @Column(name = "INICIO_HORA", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date inicioHora;
    
    @Column(name = "FIN_HORA",nullable = false)
    @Temporal(TemporalType.TIME)
    private Date finHora;
    
    @Column(name = "DIA", nullable = false, length = 2)
    private String dia;

    public FranjaHoraria() {
    }

    public FranjaHoraria(String codFranjaHoraria) {
        this.codigo = codFranjaHoraria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FranjaHoraria)) {
            return false;
        }
        FranjaHoraria other = (FranjaHoraria) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FranjaHoraria{" + "codigo=" + codigo + ", inicioHora=" + inicioHora + ", finHora=" + finHora + ", dia=" + dia + '}';
    }

}
