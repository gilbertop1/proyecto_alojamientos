/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tolback.xmockups;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author bglui
 */
@Entity
@Table(name = "detalle_hab_reserva", catalog = "alojamientosbd", schema = "POSTGRES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleHabReserva.findAll", query = "SELECT d FROM DetalleHabReserva d"),
    @NamedQuery(name = "DetalleHabReserva.findByIdReserva", query = "SELECT d FROM DetalleHabReserva d WHERE d.detalleHabReservaPK.idReserva = :idReserva"),
    @NamedQuery(name = "DetalleHabReserva.findByIdAlojamiento", query = "SELECT d FROM DetalleHabReserva d WHERE d.detalleHabReservaPK.idAlojamiento = :idAlojamiento"),
    @NamedQuery(name = "DetalleHabReserva.findByIdHabitacion", query = "SELECT d FROM DetalleHabReserva d WHERE d.detalleHabReservaPK.idHabitacion = :idHabitacion"),
    @NamedQuery(name = "DetalleHabReserva.findByFechaLlegada", query = "SELECT d FROM DetalleHabReserva d WHERE d.fechaLlegada = :fechaLlegada"),
    @NamedQuery(name = "DetalleHabReserva.findByFechaSalida", query = "SELECT d FROM DetalleHabReserva d WHERE d.fechaSalida = :fechaSalida")})
public class DetalleHabReserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleHabReservaPK detalleHabReservaPK;
    @Column(name = "fecha_llegada")
    @Temporal(TemporalType.DATE)
    private Date fechaLlegada;
    @Column(name = "fecha_salida")
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    @JoinColumn(name = "id_alojamiento", referencedColumnName = "id_alojamiento", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alojamientos alojamientos;
    @JoinColumn(name = "id_habitacion", referencedColumnName = "id_habitacion", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Habitaciones habitaciones;
    @JoinColumn(name = "id_reserva", referencedColumnName = "id_reserva", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Reservas reservas;

    public DetalleHabReserva() {
    }

    public DetalleHabReserva(DetalleHabReservaPK detalleHabReservaPK) {
        this.detalleHabReservaPK = detalleHabReservaPK;
    }

    public DetalleHabReserva(long idReserva, int idAlojamiento, short idHabitacion) {
        this.detalleHabReservaPK = new DetalleHabReservaPK(idReserva, idAlojamiento, idHabitacion);
    }

    public DetalleHabReservaPK getDetalleHabReservaPK() {
        return detalleHabReservaPK;
    }

    public void setDetalleHabReservaPK(DetalleHabReservaPK detalleHabReservaPK) {
        this.detalleHabReservaPK = detalleHabReservaPK;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
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

    public Reservas getReservas() {
        return reservas;
    }

    public void setReservas(Reservas reservas) {
        this.reservas = reservas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleHabReservaPK != null ? detalleHabReservaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleHabReserva)) {
            return false;
        }
        DetalleHabReserva other = (DetalleHabReserva) object;
        if ((this.detalleHabReservaPK == null && other.detalleHabReservaPK != null) || (this.detalleHabReservaPK != null && !this.detalleHabReservaPK.equals(other.detalleHabReservaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tolback.xmockups.DetalleHabReserva[ detalleHabReservaPK=" + detalleHabReservaPK + " ]";
    }
    
}
