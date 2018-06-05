/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.universidad.web;

import ec.edu.espe.arquitectura.universidad.model.SegUsuario;
import ec.edu.espe.arquitectura.universidad.service.SegUsuarioService;
import java.io.Serializable;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import ec.edu.espe.arquitectura.universidad.util.BCrypt;
import java.util.logging.Logger;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;
import org.primefaces.context.RequestContext;

/**
 *
 * @author jolube
 */
@Named
@ViewScoped
public class CambioContraseniaBean implements Serializable {

    private String contraseniaAnterior;
    private String contraseniaNueva;
    private String contraseniaConfirmacion;

    private static final Logger LOG = Logger.getLogger(CambioContraseniaBean.class.getName());

    @Inject
    private UsuarioSesionBean session;

    @Inject
    SegUsuarioService segUsuarioService;

    public String getContraseniaAnterior() {
        return contraseniaAnterior;
    }

    public void setContraseniaAnterior(String contraseniaAnterior) {
        this.contraseniaAnterior = contraseniaAnterior;
    }

    public String getContraseniaNueva() {
        return contraseniaNueva;
    }

    public void setContraseniaNueva(String contraseniaNueva) {
        this.contraseniaNueva = contraseniaNueva;
    }

    public String getContraseniaConfirmacion() {
        return contraseniaConfirmacion;
    }

    public void setContraseniaConfirmacion(String contraseniaConfirmacion) {
        this.contraseniaConfirmacion = contraseniaConfirmacion;
    }

    public void cambiarContrasenia() {
        if (compararNuevasContrasenias()) {
            try {
                UIInput input = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent(":contraseniaForm:contrasenia");
                SegUsuario usuario = segUsuarioService.obtenerPorCodigoUsuario(session.getCodUsuario());
                if (BCrypt.checkpw(contraseniaAnterior, usuario.getClave())) {
                    input.setValid(true);
                    usuario.setClave(BCrypt.hashpw(contraseniaNueva, BCrypt.gensalt()));//guardo con el nuevo hash);
                    segUsuarioService.modificar(usuario);
                    Messages.addGlobalInfo("Contraseña modificada con éxito.");
                    RequestContext.getCurrentInstance().execute("PF('cambioContrasenia').hide();");
                    /* Permite cerrar la sesion al cambiar la contraseña
                        Faces.invalidateSession();
                        Messages.addFlashGlobalInfo("Se ha cerrado la sesión");*/
                } else {
                    Messages.addGlobalError("La contraseña anterior no coincide con la ingresada.");
                    input.setValid(false);
                }
            } catch (Exception ex) {
                LOG.severe("Error al cambiar la contraseña " + ex);
                Messages.addGlobalError(ex.getMessage());
            }
        }
    }

    public boolean compararNuevasContrasenias() {
        UIInput nuevaContrasenia = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("contraseniaForm:nuevaContrasenia");
        UIInput anteriorContrasenia = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("contraseniaForm:confirmacionContrasenia");
        if (contraseniaNueva != null && contraseniaNueva.compareTo("") != 0
                && contraseniaConfirmacion != null && contraseniaConfirmacion.compareTo("") != 0) {
            if (contraseniaNueva.compareTo(contraseniaConfirmacion) == 0) {
                nuevaContrasenia.setValid(true);
                anteriorContrasenia.setValid(true);
                return true;
            } else {
                nuevaContrasenia.setValid(false);
                anteriorContrasenia.setValid(false);
                Messages.addGlobalError("La nueva contraseña no coindice.");
            }
        }
        return false;
    }

    public void vaciarCampos() {
        contraseniaAnterior = "";
        contraseniaNueva = "";
        contraseniaConfirmacion = "";
        RequestContext.getCurrentInstance().execute("PF('cambioContrasenia').show();");
    }
}
