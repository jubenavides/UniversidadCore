/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.universidad.web;

import ec.edu.espe.arquitectura.universidad.enums.EstadoSegUsuarioEnum;
import ec.edu.espe.arquitectura.universidad.model.SegRegistroAcceso;
import ec.edu.espe.arquitectura.universidad.model.SegUsuario;
import ec.edu.espe.arquitectura.universidad.service.AutenticacionService;
import ec.edu.espe.arquitectura.universidad.service.SegRegistroAccesoService;
import ec.edu.espe.arquitectura.universidad.service.SegUsuarioService;
import ec.edu.espe.arquitectura.universidad.web.util.FacesUtil;
import java.io.Serializable;
import java.util.Date;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Hendrix
 */
@Named
@ViewScoped
public class IndexBean implements Serializable {

    private String codigoUsuario;
    private String clave;

    @Inject
    private AutenticacionService autenticacionService;

    @Inject
    private SegUsuarioService usuarioService;

    @Inject
    private UsuarioSesionBean usuarioSessionBean;

    @Inject
    private SegRegistroAccesoService registroAccesoService;

    public String login() {
        SegUsuario usuario = this.autenticacionService.login(this.codigoUsuario,this.clave);
        if (usuario != null) {
            if (usuario.getEstado().equals(EstadoSegUsuarioEnum.ACT)) {
                this.usuarioSessionBean.setUsuario(usuario);
                this.registroAccesoService.crear(registroAcceso(usuario.getCodigo()));
                usuario.setIntentosErroneos(0);
                usuario.setFechaUltimoAcceso(new Date());
                this.usuarioService.modificar(usuario);
                return "menuPrincipal";
            } else if (usuario.getEstado().equals(EstadoSegUsuarioEnum.BLO)) {
                FacesUtil.addMessageError(null, "No se puede iniciar sesión, su usuario se encuentra bloqueado");
                return "index";
            }
        } else {
            FacesUtil.addMessageError(null, "Los datos ingresados son incorrectos");
        }
        return "index";
    }

    public SegRegistroAcceso registroAcceso(String codUsuario) {
        String ip = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRemoteAddr();
        String funcionalidad = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getContextPath();
        SegRegistroAcceso registro = new SegRegistroAcceso();
        registro.setCodUsuario(codUsuario);
        registro.setTipoAcceso("login");
        registro.setIp(ip);
        registro.setFuncionalidad(funcionalidad);
        registro.setResultado("resultado");
        return registro;
    }

    public String logout() {
        this.usuarioSessionBean.setUsuario(null);
        return "index";
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

}
