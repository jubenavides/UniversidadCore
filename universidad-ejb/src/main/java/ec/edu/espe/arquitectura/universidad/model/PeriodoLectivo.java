/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.universidad.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "PERIODO_LECTIVO")
public class PeriodoLectivo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "COD_PERIODO", nullable = false, length = 6)
    private String codigo;

    @Column(name = "SEMESTRE", nullable = false, length = 3)
    private String semestre;

    @Column(name = "FEHA_INICIO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fehaInicio;

    @Column(name = "FECHA_FIN", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COSTO_CREDITO", nullable = false)
    private BigDecimal costoCredito;

    @Column(name = "COMPONENTES_EVALUACION", nullable = false)
    private Integer componentesEvaluacion;

    @Column(name = "ESTADO", nullable = false, length = 3)
    private String estado;

    public PeriodoLectivo() {
    }

    public PeriodoLectivo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodPeriodo() {
        return codigo;
    }

    public void setCodPeriodo(String codigo) {
        this.codigo = codigo;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public Date getFehaInicio() {
        return fehaInicio;
    }

    public void setFehaInicio(Date fehaInicio) {
        this.fehaInicio = fehaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public BigDecimal getCostoCredito() {
        return costoCredito;
    }

    public void setCostoCredito(BigDecimal costoCredito) {
        this.costoCredito = costoCredito;
    }

    public Integer getComponentesEvaluacion() {
        return componentesEvaluacion;
    }

    public void setComponentesEvaluacion(Integer componentesEvaluacion) {
        this.componentesEvaluacion = componentesEvaluacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
        if (!(object instanceof PeriodoLectivo)) {
            return false;
        }
        PeriodoLectivo other = (PeriodoLectivo) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PeriodoLectivo{" + "codigo=" + codigo + ", semestre=" + semestre + ", fehaInicio=" + fehaInicio + ", fechaFin=" + fechaFin + ", costoCredito=" + costoCredito + ", componentesEvaluacion=" + componentesEvaluacion + ", estado=" + estado + '}';
    }

}
