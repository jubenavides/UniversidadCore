/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.universidad.universidad.soap;

import com.google.gson.Gson;
import ec.edu.espe.arquitectura.universidad.model.DetalleMatricula;
import ec.edu.espe.arquitectura.universidad.service.DetalleMatriculaService;
import ec.edu.espe.arquitectura.universidad.service.NRCService;
import ec.edu.espe.arquitectura.universidad.service.PeriodoLectivoService;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author jolube
 */
@WebService(serviceName = "universidadSoapWS")
public class UniversidadSoapWS {

    @EJB
    NRCService nrcService;

    @EJB
    PeriodoLectivoService periodoLectivoService;

    @EJB
    DetalleMatriculaService detalleMatriculaService;

    @WebMethod(operationName = "listarPeriodos")
    public String listarPeriodos() {
        Gson gson = new Gson();
        return gson.toJson(periodoLectivoService.obtenerTodos());
    }

    @WebMethod(operationName = "listadoNrcs")
    public String listadoNrcs(@WebParam(name = "periodo") String periodo) {
        Gson gson = new Gson();
        return gson.toJson(nrcService.obtenerNrcPorFecha(periodo));
    }

    @WebMethod(operationName = "listadoEstudiantes")
    public String listadoEstudiantes(@WebParam(name = "nrc") String nrc,
             @WebParam(name = "periodo") String periodo) {
        Gson gson = new Gson();
        return gson.toJson(detalleMatriculaService.obtenerEstudiantesPorNrc(nrc, periodo));
    }

}
