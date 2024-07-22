/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.toluca.service.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import service.UsuariosFacadeREST;
import tecnm.toluca.pruebas.Usuarios;

/**
 *
 * @author bglui
 */

@RequestScoped
@Named

public class ControladorLoging {
    
    
    
        
    @Inject
    UsuariosFacadeREST lg;
    
       private List<Usuarios> in ;
    
    
    public void botonSiguiente(){
        System.out.println("Registros: " + getLg().count());
        System.out.println("Prueba!!!!");
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
    
    
    
}
