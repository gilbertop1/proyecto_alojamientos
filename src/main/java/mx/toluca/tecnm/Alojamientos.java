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
import java.util.Collection;

/**
 *
 * @author bglui
 */
@Entity
@Table(name = "alojamientos", catalog = "", schema = "")
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
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
    private Integer numero;
    @Column(name = "codigo_postal")
    private Integer codigoPostal;
    @Size(max = 50)
    @Column(name = "correo", length = 50)
    private String correo;
    @Column(name = "telefono")
    private Integer telefono;
    @OneToMany(mappedBy = "idAlojamiento")
    private Collection<Habitaciones> habitacionesCollection;
    @OneToMany(mappedBy = "idAlojamiento")
    private Collection<Reservas> reservasCollection;
    @OneToMany(mappedBy = "idAlojamiento")
    private Collection<ServiciosAdicionales> serviciosAdicionalesCollection;
    @JoinColumn(name = "id_cuenta", referencedColumnName = "id_cuenta")
    @ManyToOne
    private Cuentas idCuenta;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne
    private Estados idEstado;

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

    @XmlTransient
    public Collection<Habitaciones> getHabitacionesCollection() {
        return habitacionesCollection;
    }

    public void setHabitacionesCollection(Collection<Habitaciones> habitacionesCollection) {
        this.habitacionesCollection = habitacionesCollection;
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
