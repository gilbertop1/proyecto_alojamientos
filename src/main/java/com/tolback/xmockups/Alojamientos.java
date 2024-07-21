/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tolback.xmockups;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author bglui
 */
@Entity
@Table(name = "alojamientos", catalog = "alojamientosbd", schema = "POSTGRES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alojamientos.findAll", query = "SELECT a FROM Alojamientos a"),
    @NamedQuery(name = "Alojamientos.findByIdAlojamiento", query = "SELECT a FROM Alojamientos a WHERE a.idAlojamiento = :idAlojamiento"),
    @NamedQuery(name = "Alojamientos.findByIdUsuario", query = "SELECT a FROM Alojamientos a WHERE a.idUsuario = :idUsuario"),
    @NamedQuery(name = "Alojamientos.findByNombre", query = "SELECT a FROM Alojamientos a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Alojamientos.findByCalle", query = "SELECT a FROM Alojamientos a WHERE a.calle = :calle"),
    @NamedQuery(name = "Alojamientos.findByNumero", query = "SELECT a FROM Alojamientos a WHERE a.numero = :numero"),
    @NamedQuery(name = "Alojamientos.findByCodigoPostal", query = "SELECT a FROM Alojamientos a WHERE a.codigoPostal = :codigoPostal"),
    @NamedQuery(name = "Alojamientos.findByCorreo", query = "SELECT a FROM Alojamientos a WHERE a.correo = :correo"),
    @NamedQuery(name = "Alojamientos.findByTelefono", query = "SELECT a FROM Alojamientos a WHERE a.telefono = :telefono")})
public class Alojamientos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_alojamiento", nullable = false)
    private Integer idAlojamiento;
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Size(max = 50)
    @Column(name = "nombre", length = 50)
    private String nombre;
    @Size(max = 50)
    @Column(name = "calle", length = 50)
    private String calle;
    @Column(name = "numero")
    private Short numero;
    @Column(name = "codigo_postal")
    private Integer codigoPostal;
    @Size(max = 50)
    @Column(name = "correo", length = 50)
    private String correo;
    @Column(name = "telefono")
    private Long telefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alojamientos")
    private Collection<Habitaciones> habitacionesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alojamientos")
    private Collection<DetalleHabReserva> detalleHabReservaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alojamientos")
    private Collection<Reservas> reservasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alojamientos")
    private Collection<ServiciosAdicionales> serviciosAdicionalesCollection;
    @JoinColumn(name = "id_cuenta", referencedColumnName = "id_cuenta")
    @ManyToOne
    private Cuentas idCuenta;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne
    private Estados idEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alojamientos")
    private Collection<ControlHabitaciones> controlHabitacionesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alojamientos")
    private Collection<DetalleServReserva> detalleServReservaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alojamientos")
    private Collection<Fotos> fotosCollection;

    public Alojamientos() {
    }

    public Alojamientos(Integer idAlojamiento) {
        this.idAlojamiento = idAlojamiento;
    }

    public Integer getIdAlojamiento() {
        return idAlojamiento;
    }

    public void setIdAlojamiento(Integer idAlojamiento) {
        this.idAlojamiento = idAlojamiento;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Short getNumero() {
        return numero;
    }

    public void setNumero(Short numero) {
        this.numero = numero;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public Collection<Habitaciones> getHabitacionesCollection() {
        return habitacionesCollection;
    }

    public void setHabitacionesCollection(Collection<Habitaciones> habitacionesCollection) {
        this.habitacionesCollection = habitacionesCollection;
    }

    @XmlTransient
    public Collection<DetalleHabReserva> getDetalleHabReservaCollection() {
        return detalleHabReservaCollection;
    }

    public void setDetalleHabReservaCollection(Collection<DetalleHabReserva> detalleHabReservaCollection) {
        this.detalleHabReservaCollection = detalleHabReservaCollection;
    }

    @XmlTransient
    public Collection<Reservas> getReservasCollection() {
        return reservasCollection;
    }

    public void setReservasCollection(Collection<Reservas> reservasCollection) {
        this.reservasCollection = reservasCollection;
    }

    @XmlTransient
    public Collection<ServiciosAdicionales> getServiciosAdicionalesCollection() {
        return serviciosAdicionalesCollection;
    }

    public void setServiciosAdicionalesCollection(Collection<ServiciosAdicionales> serviciosAdicionalesCollection) {
        this.serviciosAdicionalesCollection = serviciosAdicionalesCollection;
    }

    public Cuentas getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Cuentas idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Estados getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estados idEstado) {
        this.idEstado = idEstado;
    }

    @XmlTransient
    public Collection<ControlHabitaciones> getControlHabitacionesCollection() {
        return controlHabitacionesCollection;
    }

    public void setControlHabitacionesCollection(Collection<ControlHabitaciones> controlHabitacionesCollection) {
        this.controlHabitacionesCollection = controlHabitacionesCollection;
    }

    @XmlTransient
    public Collection<DetalleServReserva> getDetalleServReservaCollection() {
        return detalleServReservaCollection;
    }

    public void setDetalleServReservaCollection(Collection<DetalleServReserva> detalleServReservaCollection) {
        this.detalleServReservaCollection = detalleServReservaCollection;
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
        hash += (idAlojamiento != null ? idAlojamiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alojamientos)) {
            return false;
        }
        Alojamientos other = (Alojamientos) object;
        if ((this.idAlojamiento == null && other.idAlojamiento != null) || (this.idAlojamiento != null && !this.idAlojamiento.equals(other.idAlojamiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tolback.xmockups.Alojamientos[ idAlojamiento=" + idAlojamiento + " ]";
    }
    
}
