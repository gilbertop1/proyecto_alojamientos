/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.toluca.tecnm;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;

/**
 *
 * @author GPG
 */
@Entity
@Table(name = "alojamientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alojamientos.findAll", query = "SELECT a FROM Alojamientos a"),
    @NamedQuery(name = "Alojamientos.findByIdAlojamiento", query = "SELECT a FROM Alojamientos a WHERE a.idAlojamiento = :idAlojamiento"),
    @NamedQuery(name = "Alojamientos.findByNombre", query = "SELECT a FROM Alojamientos a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Alojamientos.findByCalle", query = "SELECT a FROM Alojamientos a WHERE a.calle = :calle"),
    @NamedQuery(name = "Alojamientos.findByNumero", query = "SELECT a FROM Alojamientos a WHERE a.numero = :numero"),
    @NamedQuery(name = "Alojamientos.findByCodigoPostal", query = "SELECT a FROM Alojamientos a WHERE a.codigoPostal = :codigoPostal"),
    @NamedQuery(name = "Alojamientos.findByCorreo", query = "SELECT a FROM Alojamientos a WHERE a.correo = :correo"),
    @NamedQuery(name = "Alojamientos.findByTelefono", query = "SELECT a FROM Alojamientos a WHERE a.telefono = :telefono"),
    @NamedQuery(name = "Alojamientos.findByNoCuenta", query = "SELECT a FROM Alojamientos a WHERE a.noCuenta = :noCuenta"),
    @NamedQuery(name = "Alojamientos.findByBanco", query = "SELECT a FROM Alojamientos a WHERE a.banco = :banco"),
    @NamedQuery(name = "Alojamientos.findByBeneficiario", query = "SELECT a FROM Alojamientos a WHERE a.beneficiario = :beneficiario")})
public class Alojamientos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_alojamiento")
    private Integer idAlojamiento;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "calle")
    private String calle;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "codigo_postal")
    private Integer codigoPostal;
    @Size(max = 50)
    @Column(name = "correo")
    private String correo;
    @Column(name = "telefono")
    private Integer telefono;
    @Column(name = "no_cuenta")
    private BigInteger noCuenta;
    @Size(max = 20)
    @Column(name = "banco")
    private String banco;
    @Size(max = 50)
    @Column(name = "beneficiario")
    private String beneficiario;
    @OneToMany(mappedBy = "idAlojamiento")
    private Collection<Habitaciones> habitacionesCollection;
    @OneToMany(mappedBy = "idAlojamiento")
    private Collection<DetalleHabReserva> detalleHabReservaCollection;
    @OneToMany(mappedBy = "idAlojamiento")
    private Collection<Reservas> reservasCollection;
    @OneToMany(mappedBy = "idAlojamiento")
    private Collection<ServiciosAdicionales> serviciosAdicionalesCollection;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne
    private Estados idEstado;
    @OneToMany(mappedBy = "idAlojamiento")
    private Collection<ControlHabitaciones> controlHabitacionesCollection;
    @OneToMany(mappedBy = "idAlojamiento")
    private Collection<DetalleServReserva> detalleServReservaCollection;
    @OneToMany(mappedBy = "idAlojamiento")
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

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
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

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public BigInteger getNoCuenta() {
        return noCuenta;
    }

    public void setNoCuenta(BigInteger noCuenta) {
        this.noCuenta = noCuenta;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
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
        return "mx.toluca.tecnm.Alojamientos[ idAlojamiento=" + idAlojamiento + " ]";
    }
    
}
