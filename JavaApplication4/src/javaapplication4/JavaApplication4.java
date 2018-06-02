/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

/**
 *
 * @author jolube
 */
public class JavaApplication4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       UniversidadSoapWS uSoapWS = new UniversidadSoapWS_Service().getUniversidadSoapWSPort();
       System.out.println(uSoapWS.listarPeriodos());
        System.out.println(uSoapWS.listadoNrcs("201801"));
        System.out.println(uSoapWS.listadoEstudiantes("N-001", "201801"));

    }
    
}
