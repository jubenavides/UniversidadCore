/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.universidad.util;

import java.math.BigDecimal;

/**
 *
 * @author jolube
 */
public class EstudianteCalificacion {
    private String codEstudiante;
    private String nombreEstudiante;
    private BigDecimal calificacion;
    private Integer parcial;
    private String codNrc;
    private Integer codDetalleMatricula;
    
    
    public EstudianteCalificacion(){
    }

    public String getCodEstudiante() {
        return codEstudiante;
    }

    public void setCodEstudiante(String codEstudiante) {
        this.codEstudiante = codEstudiante;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public BigDecimal getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(BigDecimal calificacion) {
        this.calificacion = calificacion;
    }

    public Integer getParcial() {
        return parcial;
    }

    public void setParcial(Integer parcial) {
        this.parcial = parcial;
    }

    public String getCodNrc() {
        return codNrc;
    }

    public void setCodNrc(String codNrc) {
        this.codNrc = codNrc;
    }

    public Integer getCodDetalleMatricula() {
        return codDetalleMatricula;
    }

    public void setCodDetalleMatricula(Integer codDetalleMatricula) {
        this.codDetalleMatricula = codDetalleMatricula;
    }

}
