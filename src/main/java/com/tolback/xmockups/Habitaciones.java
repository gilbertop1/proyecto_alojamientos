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
@Table(name = "habitaciones", catalog = "alojamientosbd", schema = "POSTGRES", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_habitacion"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Habitaciones.findAll", query = "SELECT h FROM Habitaciones h"),
    @NamedQuery(name = "Habitaciones.findByIdHabitacion", query = "SELECT h FROM Habitaciones h WHERE h.habitacionesPK.idHabitacion = :idHabitacion"),
    @NamedQuery(name = "Habitaciones.findByIdAlojamiento", query = "SELECT h FROM Habitaciones h WHERE h.habitacionesPK.idAlojamiento = :idAlojamiento"),
    @NamedQuery(name = "Habitaciones.findByIdentificador", query = "SELECT h FROM Habitaciones h WHERE h.identificador = :identificador"),
    @NamedQuery(name = "Habitaciones.findByCapacidad", query = "SELECT h FROM Habitaciones h WHERE h.capacidad = :capacidad"),
    @NamedQuery(name = "Habitaciones.findByCosto", query = "SELECT h FROM Habitaciones h WHERE h.costo = :costo"),
    @NamedQuery(name = "Habitaciones.findByCantidad", query = "SELECT h FROM Habitaciones h WHERE h.cantidad = :cantidad"),
    @NamedQuery(name = "Habitaciones.findByDescripcion", query = "SELECT h FROM Habitaciones h WHERE h.descripcion = :descripcion")})
public class Habitaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HabitacionesPK habitacionesPK;
    @Size(max = 20)
    @Column(name = "identificador", length = 20)
    private String identificador;
    @Column(name = "capacidad")
    private Short capacidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costo", precision = 5, scale = 2)
    private BigDecimal costo;
    @Column(name = "cantidad")
    private Short cantidad;
    @Size(max = 200)
    @Column(name = "descripcion", length = 200)
    private String descripcion;
    @JoinColumn(name = "id_alojamiento", referencedColumnName = "id_alojamiento", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alojamientos alojamientos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "habitaciones")
    private Collection<DetalleHabReserva> detalleHabReservaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "habitaciones")
    private Collection<ControlHabitaciones> controlHabitacionesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "habitaciones")
    private Collection<Fotos> fotosCollection;

    public Habitaciones() {
    }

    public Habitaciones(HabitacionesPK habitacionesPK) {
        this.habitacionesPK = habitacionesPK;
    }

    public Habitaciones(short idHabitacion, int idAlojamiento) {
        this.habitacionesPK = new HabitacionesPK(idHabitacion, idAlojamiento);
    }

    public HabitacionesPK getHabitacionesPK() {
        return habitacionesPK;
    }

    public void setHabitacionesPK(HabitacionesPK habitacionesPK) {
        this.habitacionesPK = habitacionesPK;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Short getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Short capacidad) {
        this.capacidad = capacidad;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public Short getCantidad() {
        return cantidad;
    }

    public void setCantidad(Short cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Alojamientos getAlojamientos() {
        return alojamientos;
    }

    public void setAlojamientos(Alojamientos alojamientos) {
        this.alojamientos = alojamientos;
    }

    @XmlTransient
    public Collection<DetalleHabReserva> getDetalleHabReservaCollection() {
        return detalleHabReservaCollection;
    }

    public void setDetalleHabReservaCollection(Collection<DetalleHabReserva> detalleHabReservaCollection) {
        this.detalleHabReservaCollection = detalleHabReservaCollection;
    }

    @XmlTransient
    public Collection<ControlHabitaciones> getControlHabitacionesCollection() {
        return controlHabitacionesCollection;
    }

    public void setControlHabitacionesCollection(Collection<ControlHabitaciones> controlHabitacionesCollection) {
        this.controlHabitacionesCollection = controlHabitacionesCollection;
    }

    @XmlTransient
    public Collection<Fotos> getFotosCollection() {
        return fotosCollection;
    }

    public void setFotosCollection(Collection<Fotos> fotosCollection) {
        this.fotosCollection = fotosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (habitacionesPK != null ? habitacionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Habitaciones)) {
            return false;
        }
        Habitaciones other = (Habitaciones) object;
        if ((this.habitacionesPK == null && other.habitacionesPK != null) || (this.habitacionesPK != null && !this.habitacionesPK.equals(other.habitacionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tolback.xmockups.Habitaciones[ habitacionesPK=" + habitacionesPK + " ]";
    }
    
}
