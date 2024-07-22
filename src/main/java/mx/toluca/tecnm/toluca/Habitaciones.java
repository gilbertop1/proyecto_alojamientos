/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tecnm.toluca.pruebas;

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
import java.math.BigDecimal;
import java.util.Collection;

/**
 *
 * @author GPG
 */
@Entity
@Table(name = "habitaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Habitaciones.findAll", query = "SELECT h FROM Habitaciones h"),
    @NamedQuery(name = "Habitaciones.findByIdHabitacion", query = "SELECT h FROM Habitaciones h WHERE h.idHabitacion = :idHabitacion"),
    @NamedQuery(name = "Habitaciones.findByIdentificador", query = "SELECT h FROM Habitaciones h WHERE h.identificador = :identificador"),
    @NamedQuery(name = "Habitaciones.findByCapacidad", query = "SELECT h FROM Habitaciones h WHERE h.capacidad = :capacidad"),
    @NamedQuery(name = "Habitaciones.findByCosto", query = "SELECT h FROM Habitaciones h WHERE h.costo = :costo"),
    @NamedQuery(name = "Habitaciones.findByCantidad", query = "SELECT h FROM Habitaciones h WHERE h.cantidad = :cantidad"),
    @NamedQuery(name = "Habitaciones.findByDescripcion", query = "SELECT h FROM Habitaciones h WHERE h.descripcion = :descripcion")})
public class Habitaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_habitacion")
    private Integer idHabitacion;
    @Size(max = 20)
    @Column(name = "identificador")
    private String identificador;
    @Column(name = "capacidad")
    private Integer capacidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costo")
    private BigDecimal costo;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "id_alojamiento", referencedColumnName = "id_alojamiento")
    @ManyToOne
    private Alojamientos idAlojamiento;
    @OneToMany(mappedBy = "idHabitacion")
    private Collection<DetalleHabReserva> detalleHabReservaCollection;
    @OneToMany(mappedBy = "idHabitacion")
    private Collection<ControlHabitaciones> controlHabitacionesCollection;
    @OneToMany(mappedBy = "idHabitacion")
    private Collection<Fotos> fotosCollection;

    public Habitaciones() {
    }

    public Habitaciones(Integer idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public Integer getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(Integer idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Alojamientos getIdAlojamiento() {
        return idAlojamiento;
    }

    public void setIdAlojamiento(Alojamientos idAlojamiento) {
        this.idAlojamiento = idAlojamiento;
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
        hash += (idHabitacion != null ? idHabitacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Habitaciones)) {
            return false;
        }
        Habitaciones other = (Habitaciones) object;
        if ((this.idHabitacion == null && other.idHabitacion != null) || (this.idHabitacion != null && !this.idHabitacion.equals(other.idHabitacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tecnm.toluca.pruebas.Habitaciones[ idHabitacion=" + idHabitacion + " ]";
    }
    
}
