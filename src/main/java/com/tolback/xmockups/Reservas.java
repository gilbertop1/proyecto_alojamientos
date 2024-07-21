/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tolback.xmockups;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

/**
 *
 * @author bglui
 */
@Entity
@Table(name = "reservas", catalog = "alojamientosbd", schema = "POSTGRES", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_reserva"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservas.findAll", query = "SELECT r FROM Reservas r"),
    @NamedQuery(name = "Reservas.findByIdReserva", query = "SELECT r FROM Reservas r WHERE r.reservasPK.idReserva = :idReserva"),
    @NamedQuery(name = "Reservas.findByIdAlojamiento", query = "SELECT r FROM Reservas r WHERE r.reservasPK.idAlojamiento = :idAlojamiento"),
    @NamedQuery(name = "Reservas.findByTotal", query = "SELECT r FROM Reservas r WHERE r.total = :total"),
    @NamedQuery(name = "Reservas.findByEstatus", query = "SELECT r FROM Reservas r WHERE r.estatus = :estatus")})
public class Reservas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReservasPK reservasPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total", precision = 5, scale = 2)
    private BigDecimal total;
    @Size(max = 15)
    @Column(name = "estatus", length = 15)
    private String estatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservas")
    private Collection<DetalleHabReserva> detalleHabReservaCollection;
    @JoinColumn(name = "id_alojamiento", referencedColumnName = "id_alojamiento", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alojamientos alojamientos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservas")
    private Collection<DetalleServReserva> detalleServReservaCollection;

    public Reservas() {
    }

    public Reservas(ReservasPK reservasPK) {
        this.reservasPK = reservasPK;
    }

    public Reservas(long idReserva, int idAlojamiento) {
        this.reservasPK = new ReservasPK(idReserva, idAlojamiento);
    }

    public ReservasPK getReservasPK() {
        return reservasPK;
    }

    public void setReservasPK(ReservasPK reservasPK) {
        this.reservasPK = reservasPK;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @XmlTransient
    public Collection<DetalleHabReserva> getDetalleHabReservaCollection() {
        return detalleHabReservaCollection;
    }

    public void setDetalleHabReservaCollection(Collection<DetalleHabReserva> detalleHabReservaCollection) {
        this.detalleHabReservaCollection = detalleHabReservaCollection;
    }

    public Alojamientos getAlojamientos() {
        return alojamientos;
    }

    public void setAlojamientos(Alojamientos alojamientos) {
        this.alojamientos = alojamientos;
    }

    @XmlTransient
    public Collection<DetalleServReserva> getDetalleServReservaCollection() {
        return detalleServReservaCollection;
    }

    public void setDetalleServReservaCollection(Collection<DetalleServReserva> detalleServReservaCollection) {
        this.detalleServReservaCollection = detalleServReservaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reservasPK != null ? reservasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservas)) {
            return false;
        }
        Reservas other = (Reservas) object;
        if ((this.reservasPK == null && other.reservasPK != null) || (this.reservasPK != null && !this.reservasPK.equals(other.reservasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tolback.xmockups.Reservas[ reservasPK=" + reservasPK + " ]";
    }
    
}
