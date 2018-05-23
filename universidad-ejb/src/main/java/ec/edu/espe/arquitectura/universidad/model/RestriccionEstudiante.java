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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author jolube
 */
@Entity
@Table(name = "RESTRICCION_ESTUDIANTE")
public class RestriccionEstudiante implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected RestriccionEstudiantePK pk;

    public RestriccionEstudiante() {
    }

    public RestriccionEstudiante(RestriccionEstudiantePK pk) {
        this.pk = pk;
    }

    public RestriccionEstudiante(String codRestriccion, String codEstudiante) {
        this.pk = new RestriccionEstudiantePK(codRestriccion, codEstudiante);
    }

    public RestriccionEstudiantePK getPk() {
        return pk;
    }

    public void setPk(RestriccionEstudiantePK pk) {
        this.pk = pk;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.pk);
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
        final RestriccionEstudiante other = (RestriccionEstudiante) obj;
        if (!Objects.equals(this.pk, other.pk)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RestriccionEstudiante{" + "pk=" + pk + '}';
    }

}
