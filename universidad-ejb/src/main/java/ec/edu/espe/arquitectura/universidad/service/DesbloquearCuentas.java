/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.universidad.service;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;

/**
 *
 * @author jolube
 */
@Singleton
public class DesbloquearCuentas {

    @Inject
    SegUsuarioService segUsuarioService;
    
    @Schedule(minute = "*/5", hour = "*", persistent = false)
    public void desbloquearUsuariosTask() {
        System.out.println("Ejecutando Servicio desbloquear cuentas");
        segUsuarioService.desbloquearUsuarios();
    }
}