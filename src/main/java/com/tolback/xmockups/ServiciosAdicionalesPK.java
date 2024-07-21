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
public class ServiciosAdicionalesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_servicio", nullable = false)
    private short idServicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_alojamiento", nullable = false)
    private int idAlojamiento;

    public ServiciosAdicionalesPK() {
    }

    public ServiciosAdicionalesPK(short idServicio, int idAlojamiento) {
        this.idServicio = idServicio;
        this.idAlojamiento = idAlojamiento;
    }

    public short getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(short idServicio) {
        this.idServicio = idServicio;
    }

    public int getIdAlojamiento() {
        return idAlojamiento;
    }

    public void setIdAlojamiento(int idAlojamiento) {
        this.idAlojamiento = idAlojamiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idServicio;
        hash += (int) idAlojamiento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiciosAdicionalesPK)) {
            return false;
        }
        ServiciosAdicionalesPK other = (ServiciosAdicionalesPK) object;
        if (this.idServicio != other.idServicio) {
            return false;
        }
        if (this.idAlojamiento != other.idAlojamiento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tolback.xmockups.ServiciosAdicionalesPK[ idServicio=" + idServicio + ", idAlojamiento=" + idAlojamiento + " ]";
    }
    
}
