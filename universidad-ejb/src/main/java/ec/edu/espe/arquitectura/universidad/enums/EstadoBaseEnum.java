/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.universidad.enums;

/**
 *
 * @author jolube
 */
public enum EstadoBaseEnum {

    ACT("ACTIVO"),
    INA("INACTIVO");

    private String texto;

    private EstadoBaseEnum(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
