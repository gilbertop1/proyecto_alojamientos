/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tolback.xmockups;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author bglui
 */
@Entity
@Table(name = "control_habitaciones", catalog = "alojamientosbd", schema = "POSTGRES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ControlHabitaciones.findAll", query = "SELECT c FROM ControlHabitaciones c"),
    @NamedQuery(name = "ControlHabitaciones.findByIdAlojamiento", query = "SELECT c FROM ControlHabitaciones c WHERE c.controlHabitacionesPK.idAlojamiento = :idAlojamiento"),
    @NamedQuery(name = "ControlHabitaciones.findByIdHabitacion", query = "SELECT c FROM ControlHabitaciones c WHERE c.controlHabitacionesPK.idHabitacion = :idHabitacion"),
    @NamedQuery(name = "ControlHabitaciones.findByNumero", query = "SELECT c FROM ControlHabitaciones c WHERE c.controlHabitacionesPK.numero = :numero")})
public class ControlHabitaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ControlHabitacionesPK controlHabitacionesPK;
    @JoinColumn(name = "id_alojamiento", referencedColumnName = "id_alojamiento", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alojamientos alojamientos;
    @JoinColumn(name = "id_habitacion", referencedColumnName = "id_habitacion", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Habitaciones habitaciones;

    public ControlHabitaciones() {
    }

    public ControlHabitaciones(ControlHabitacionesPK controlHabitacionesPK) {
        this.controlHabitacionesPK = controlHabitacionesPK;
    }

    public ControlHabitaciones(int idAlojamiento, short idHabitacion, short numero) {
        this.controlHabitacionesPK = new ControlHabitacionesPK(idAlojamiento, idHabitacion, numero);
    }

    public ControlHabitacionesPK getControlHabitacionesPK() {
        return controlHabitacionesPK;
    }

    public void setControlHabitacionesPK(ControlHabitacionesPK controlHabitacionesPK) {
        this.controlHabitacionesPK = controlHabitacionesPK;
    }

    public Alojamientos getAlojamientos() {
        return alojamientos;
    }

    public void setAlojamientos(Alojamientos alojamientos) {
        this.alojamientos = alojamientos;
    }

    public Habitaciones getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(Habitaciones habitaciones) {
        this.habitaciones = habitaciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (controlHabitacionesPK != null ? controlHabitacionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ControlHabitaciones)) {
            return false;
        }
        ControlHabitaciones other = (ControlHabitaciones) object;
        if ((this.controlHabitacionesPK == null && other.controlHabitacionesPK != null) || (this.controlHabitacionesPK != null && !this.controlHabitacionesPK.equals(other.controlHabitacionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tolback.xmockups.ControlHabitaciones[ controlHabitacionesPK=" + controlHabitacionesPK + " ]";
    }
    
}
