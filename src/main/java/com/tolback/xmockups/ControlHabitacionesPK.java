/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tolback.xmockups;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *
 * @author bglui
 */
@Embeddable
public class ControlHabitacionesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_alojamiento", nullable = false)
    private int idAlojamiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_habitacion", nullable = false)
    private short idHabitacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero", nullable = false)
    private short numero;

    public ControlHabitacionesPK() {
    }

    public ControlHabitacionesPK(int idAlojamiento, short idHabitacion, short numero) {
        this.idAlojamiento = idAlojamiento;
        this.idHabitacion = idHabitacion;
        this.numero = numero;
    }

    public int getIdAlojamiento() {
        return idAlojamiento;
    }

    public void setIdAlojamiento(int idAlojamiento) {
        this.idAlojamiento = idAlojamiento;
    }

    public short getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(short idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public short getNumero() {
        return numero;
    }

    public void setNumero(short numero) {
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAlojamiento;
        hash += (int) idHabitacion;
        hash += (int) numero;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ControlHabitacionesPK)) {
            return false;
        }
        ControlHabitacionesPK other = (ControlHabitacionesPK) object;
        if (this.idAlojamiento != other.idAlojamiento) {
            return false;
        }
        if (this.idHabitacion != other.idHabitacion) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tolback.xmockups.ControlHabitacionesPK[ idAlojamiento=" + idAlojamiento + ", idHabitacion=" + idHabitacion + ", numero=" + numero + " ]";
    }
    
}
