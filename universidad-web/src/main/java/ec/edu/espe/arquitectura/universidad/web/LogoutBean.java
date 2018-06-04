package ec.edu.espe.arquitectura.universidad.web;

import java.io.IOException;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

import javax.inject.Named;
import org.omnifaces.util.Faces;
import org.omnifaces.util.FacesLocal;
import org.omnifaces.util.Messages;

/**
 *
 * @author jolube
 */
@Named
@RequestScoped// porque se llama una sola vez
public class LogoutBean {

    
    public void cerrarSesion() {
        FacesContext context = Faces.getContext();
        try {
            Faces.invalidateSession();
            Messages.addFlashGlobalInfo("Se ha cerrado la sesión");
            FacesLocal.redirect(context, "index");
        } catch (IOException ex) {
            System.err.println(ex +"Se produjo un error al cerrar la sesión");
        }
    }
    
}
