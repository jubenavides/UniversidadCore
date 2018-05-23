/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.universidad.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author jolube
 */
@Embeddable
public class RestriccionEstudiantePK implements Serializable {

    @Column(name = "COD_RESTRICCION", nullable = false, length = 3)
    private String codRestriccion;
    
    @Column(name = "COD_ESTUDIANTE", nullable = false,length = 10)
    private String codEstudiante;

    public RestriccionEstudiantePK() {
    }

    public RestriccionEstudiantePK(String codRestriccion, String codEstudiante) {
        this.codRestriccion = codRestriccion;
        this.codEstudiante = codEstudiante;
    }

    public String getCodRestriccion() {
        return codRestriccion;
    }

    public void setCodRestriccion(String codRestriccion) {
        this.codRestriccion = codRestriccion;
    }

    public String getCodEstudiante() {
        return codEstudiante;
    }

    public void setCodEstudiante(String codEstudiante) {
        this.codEstudiante = codEstudiante;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.codRestriccion);
        hash = 29 * hash + Objects.hashCode(this.codEstudiante);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RestriccionEstudiantePK other = (RestriccionEstudiantePK) obj;
        if (!Objects.equals(this.codRestriccion, other.codRestriccion)) {
            return false;
        }
        if (!Objects.equals(this.codEstudiante, other.codEstudiante)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RestriccionEstudiantePK{" + "codRestriccion=" + codRestriccion + ", codEstudiante=" + codEstudiante + '}';
    }

}
