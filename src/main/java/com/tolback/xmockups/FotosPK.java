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
public class FotosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_alojamiento", nullable = false)
    private int idAlojamiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_habitacion", nullable = false)
    private short idHabitacion;

    public FotosPK() {
    }

    public FotosPK(int idAlojamiento, short idHabitacion) {
        this.idAlojamiento = idAlojamiento;
        this.idHabitacion = idHabitacion;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAlojamiento;
        hash += (int) idHabitacion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FotosPK)) {
            return false;
        }
        FotosPK other = (FotosPK) object;
        if (this.idAlojamiento != other.idAlojamiento) {
            return false;
        }
        if (this.idHabitacion != other.idHabitacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tolback.xmockups.FotosPK[ idAlojamiento=" + idAlojamiento + ", idHabitacion=" + idHabitacion + " ]";
    }
    
}
