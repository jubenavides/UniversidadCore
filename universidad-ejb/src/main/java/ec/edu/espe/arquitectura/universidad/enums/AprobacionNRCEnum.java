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
public enum AprobacionNRCEnum {

    SI("APROBADO"),
    NO("REPROBADO");

    private String texto;

    private AprobacionNRCEnum(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
