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
@Table(name = "detalle_serv_reserva", catalog = "alojamientosbd", schema = "POSTGRES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleServReserva.findAll", query = "SELECT d FROM DetalleServReserva d"),
    @NamedQuery(name = "DetalleServReserva.findByIdReserva", query = "SELECT d FROM DetalleServReserva d WHERE d.detalleServReservaPK.idReserva = :idReserva"),
    @NamedQuery(name = "DetalleServReserva.findByIdAlojamiento", query = "SELECT d FROM DetalleServReserva d WHERE d.detalleServReservaPK.idAlojamiento = :idAlojamiento"),
    @NamedQuery(name = "DetalleServReserva.findByIdServicio", query = "SELECT d FROM DetalleServReserva d WHERE d.detalleServReservaPK.idServicio = :idServicio")})
public class DetalleServReserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleServReservaPK detalleServReservaPK;
    @JoinColumn(name = "id_alojamiento", referencedColumnName = "id_alojamiento", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alojamientos alojamientos;
    @JoinColumn(name = "id_reserva", referencedColumnName = "id_reserva", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Reservas reservas;
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ServiciosAdicionales serviciosAdicionales;

    public DetalleServReserva() {
    }

    public DetalleServReserva(DetalleServReservaPK detalleServReservaPK) {
        this.detalleServReservaPK = detalleServReservaPK;
    }

    public DetalleServReserva(long idReserva, int idAlojamiento, short idServicio) {
        this.detalleServReservaPK = new DetalleServReservaPK(idReserva, idAlojamiento, idServicio);
    }

    public DetalleServReservaPK getDetalleServReservaPK() {
        return detalleServReservaPK;
    }

    public void setDetalleServReservaPK(DetalleServReservaPK detalleServReservaPK) {
        this.detalleServReservaPK = detalleServReservaPK;
    }

    public Alojamientos getAlojamientos() {
        return alojamientos;
    }

    public void setAlojamientos(Alojamientos alojamientos) {
        this.alojamientos = alojamientos;
    }

    public Reservas getReservas() {
        return reservas;
    }

    public void setReservas(Reservas reservas) {
        this.reservas = reservas;
    }

    public ServiciosAdicionales getServiciosAdicionales() {
        return serviciosAdicionales;
    }

    public void setServiciosAdicionales(ServiciosAdicionales serviciosAdicionales) {
        this.serviciosAdicionales = serviciosAdicionales;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleServReservaPK != null ? detalleServReservaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleServReserva)) {
            return false;
        }
        DetalleServReserva other = (DetalleServReserva) object;
        if ((this.detalleServReservaPK == null && other.detalleServReservaPK != null) || (this.detalleServReservaPK != null && !this.detalleServReservaPK.equals(other.detalleServReservaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tolback.xmockups.DetalleServReserva[ detalleServReservaPK=" + detalleServReservaPK + " ]";
    }
    
}
