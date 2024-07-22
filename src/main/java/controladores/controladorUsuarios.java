/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import service.UsuariosFacadeREST;
import mx.toluca.tecnm.Usuarios;


/**
 *
 * @author GPG
 */
@RequestScoped
@Named
public class controladorUsuarios {
    
    @Inject
    Usuarios u;
    @Inject
    UsuariosFacadeREST uF;

    public Usuarios getU() {
        return u;
    }

    public void setU(Usuarios u) {
        this.u = u;
    }
    
    public void verificaRegistro(){
        System.out.println(""+u.getCorreo());
        System.out.println(""+u.getContrasena());
        
        
    }
    
    
}
