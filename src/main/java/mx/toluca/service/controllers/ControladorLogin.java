package mx.toluca.service.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.UsuariosFacadeREST;
import mx.toluca.tecnm.Usuarios;

@RequestScoped
@Named
public class ControladorLogin {

    @Inject
    UsuariosFacadeREST lg;

    private List<Usuarios> in;

    private String correo;
    private String contrasena;

    private static final Logger LOGGER = Logger.getLogger(ControladorLogin.class.getName());

    public String botonSiguiente() {
        try {
            LOGGER.log(Level.INFO, "Registros: {0}", getLg().count());
            LOGGER.info("Prueba!!!!");
            return "GestionAlojamientos?faces-redirect=true";
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error al contar los registros", e);
            return "ErrorPage?faces-redirect=true";
        }
    }

    public String login() {
        Usuarios usuario = lg.findUserByCorreoAndContrasena(correo, contrasena);
        if (usuario != null) {
            // El usuario fue encontrado, redirige a la página deseada
            return "GestionAlojamientos";
        } else {
            // Las credenciales son incorrectas
                   FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Credenciales incorrectas", "Error"));
        return null; // Quedarse en la misma página
        }
    }

    public UsuariosFacadeREST getLg() {
        return lg;
    }

    public void setLg(UsuariosFacadeREST lg) {
        this.lg = lg;
    }

    public List<Usuarios> getIn() {
        return in;
    }

    public void setIn(List<Usuarios> in) {
        this.in = in;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
