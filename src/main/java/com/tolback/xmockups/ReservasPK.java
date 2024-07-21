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
public class ReservasPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_reserva", nullable = false)
    private long idReserva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_alojamiento", nullable = false)
    private int idAlojamiento;

    public ReservasPK() {
    }

    public ReservasPK(long idReserva, int idAlojamiento) {
        this.idReserva = idReserva;
        this.idAlojamiento = idAlojamiento;
    }

    public long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(long idReserva) {
        this.idReserva = idReserva;
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
        hash += (int) idReserva;
        hash += (int) idAlojamiento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservasPK)) {
            return false;
        }
        ReservasPK other = (ReservasPK) object;
        if (this.idReserva != other.idReserva) {
            return false;
        }
        if (this.idAlojamiento != other.idAlojamiento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tolback.xmockups.ReservasPK[ idReserva=" + idReserva + ", idAlojamiento=" + idAlojamiento + " ]";
    }
    
}
