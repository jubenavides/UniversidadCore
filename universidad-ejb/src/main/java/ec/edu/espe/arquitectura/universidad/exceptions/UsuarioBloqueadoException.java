/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.universidad.exceptions;

/**
 *
 * @author jolube
 */
public class UsuarioBloqueadoException extends Exception {

    public UsuarioBloqueadoException() {
        super();
    }

    public UsuarioBloqueadoException(String message) {
        super(message);
    }

    public UsuarioBloqueadoException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsuarioBloqueadoException(Throwable cause) {
        super(cause);
    }
}
