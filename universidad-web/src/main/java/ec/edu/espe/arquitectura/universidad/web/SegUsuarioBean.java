/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.universidad.web;

import ec.edu.espe.arquitectura.universidad.model.SegPerfil;
import ec.edu.espe.arquitectura.universidad.model.SegUsuario;
import ec.edu.espe.arquitectura.universidad.service.SegPerfilService;
import ec.edu.espe.arquitectura.universidad.service.SegUsuarioService;
import ec.edu.espe.arquitectura.universidad.util.BCrypt;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.util.Messages;

/**
 *
 * @author jolube
 */
@Named
@ViewScoped
public class SegUsuarioBean extends BaseBean implements Serializable {

    private List<SegUsuario> segUsuarios;
    private SegUsuario segUsuario;
    private SegUsuario segUsuarioSel;
    private List<SegPerfil> segPerfiles;
    private String codigoPerfil;

    @Inject
    private SegUsuarioService segUsuarioService;
    @Inject
    private SegPerfilService segPerfilService;

    @PostConstruct
    public void init() {
        this.segUsuarios = this.segUsuarioService.obtenerTodos();
        this.segUsuario = new SegUsuario();
        this.segPerfiles = this.segPerfilService.obtenerTodos();
    }

    @Override
    public void agregar() {
        this.segUsuario = new SegUsuario();
        super.agregar();

    }

    @Override
    public void modificar() {
        super.modificar();
        this.segUsuario = new SegUsuario();
        this.segUsuario.setCodigo(this.segUsuarioSel.getCodigo());
        this.segUsuario.setCodPerfil(this.segUsuarioSel.getCodPerfil());
        this.segUsuario.setCorreoElectronico(this.segUsuarioSel.getCorreoElectronico());
        this.segUsuario.setNombre(this.segUsuarioSel.getNombre());
        this.segUsuario.setClave(this.segUsuarioSel.getClave());
        this.segUsuario.setEstado(this.segUsuarioSel.getEstado());
        this.segUsuario.setFechaCreacion(this.segUsuarioSel.getFechaCreacion());
        this.segUsuario.setIntentosErroneos(0);
        this.segUsuario.setFechaUltimoAcceso(this.segUsuarioSel.getFechaUltimoAcceso());
    }

    @Override
    public void detalles() {
        super.detalles();
        this.segUsuario = this.segUsuarioSel;
    }

    public void cancelar() {
        super.reset();
        this.segUsuario = new SegUsuario();
        this.segUsuarioSel = null;
    }

    public void guardar() {
        try {
            this.segUsuario.setCodPerfil(this.segPerfilService.obtenerPorCodigoPerfil(this.codigoPerfil));
            if (enAgregar) {
                this.segUsuario.setFechaCreacion(new Date());
                this.segUsuario.setClave(generarClave());
                this.segUsuario.setIntentosErroneos(0);
                this.segUsuarioService.crear(this.segUsuario);
                Messages.addFlashGlobalInfo("Se agregó el Usuario: " + this.segUsuario.getCodigo() + ", " + this.segUsuario.getNombre());
            } else {
                this.segUsuario.setClave(BCrypt.hashpw(this.segUsuario.getClave(), BCrypt.gensalt()));
                this.segUsuarioService.modificar(segUsuario);
            }
        } catch (Exception ex) {
            Messages.addGlobalError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }

        super.reset();
        this.segUsuario = new SegUsuario();
        this.segUsuarios = this.segUsuarioService.obtenerTodos();
    }

    public void eliminar() {
        this.segUsuarioService.eliminar(this.segUsuarioSel.getCodigo());
        super.reset();
        this.segUsuario = new SegUsuario();
        this.segUsuarios = this.segUsuarioService.obtenerTodos();
    }

    public void buscar() {
        this.segUsuarios = new ArrayList<>();
        this.segUsuarios.add(this.segUsuarioService.obtenerPorCodigoUsuario(this.segUsuario.getCodigo()));
        this.segUsuario = new SegUsuario();
    }

    private String generarClave() {
        String clave = "ARQUI" + this.segUsuario.getCodigo() + "2018";
        return BCrypt.hashpw(clave, BCrypt.gensalt());
    }

    public List<SegUsuario> getSegUsuarios() {
        return segUsuarios;
    }

    public void setSegUsuarios(List<SegUsuario> segUsuarios) {
        this.segUsuarios = segUsuarios;
    }

    public SegUsuario getSegUsuario() {
        return segUsuario;
    }

    public void setSegUsuario(SegUsuario segUsuario) {
        this.segUsuario = segUsuario;
    }

    public SegUsuario getSegUsuarioSel() {
        return segUsuarioSel;
    }

    public void setSegUsuarioSel(SegUsuario segUsuarioSel) {
        this.segUsuarioSel = segUsuarioSel;
    }

    public List<SegPerfil> getSegPerfiles() {
        return segPerfiles;
    }

    public void setSegPerfiles(List<SegPerfil> segPerfiles) {
        this.segPerfiles = segPerfiles;
    }

    public String getCodigoPerfil() {
        return codigoPerfil;
    }

    public void setCodigoPerfil(String codigoPerfil) {
        this.codigoPerfil = codigoPerfil;
    }

}
