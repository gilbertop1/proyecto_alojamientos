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
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author GPG
 */
@Entity
@Table(name = "detalle_hab_reserva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleHabReserva.findAll", query = "SELECT d FROM DetalleHabReserva d"),
    @NamedQuery(name = "DetalleHabReserva.findByIdResgistro", query = "SELECT d FROM DetalleHabReserva d WHERE d.idResgistro = :idResgistro"),
    @NamedQuery(name = "DetalleHabReserva.findByFechaLlegada", query = "SELECT d FROM DetalleHabReserva d WHERE d.fechaLlegada = :fechaLlegada"),
    @NamedQuery(name = "DetalleHabReserva.findByFechaSalida", query = "SELECT d FROM DetalleHabReserva d WHERE d.fechaSalida = :fechaSalida")})
public class DetalleHabReserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_resgistro")
    private Integer idResgistro;
    @Column(name = "fecha_llegada")
    @Temporal(TemporalType.DATE)
    private Date fechaLlegada;
    @Column(name = "fecha_salida")
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    @JoinColumn(name = "id_alojamiento", referencedColumnName = "id_alojamiento")
    @ManyToOne
    private Alojamientos idAlojamiento;
    @JoinColumn(name = "id_habitacion", referencedColumnName = "id_habitacion")
    @ManyToOne
    private Habitaciones idHabitacion;
    @JoinColumn(name = "id_reserva", referencedColumnName = "id_reserva")
    @ManyToOne
    private Reservas idReserva;

    public DetalleHabReserva() {
    }

    public DetalleHabReserva(Integer idResgistro) {
        this.idResgistro = idResgistro;
    }

    public Integer getIdResgistro() {
        return idResgistro;
    }

    public void setIdResgistro(Integer idResgistro) {
        this.idResgistro = idResgistro;
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

    public Alojamientos getIdAlojamiento() {
        return idAlojamiento;
    }

    public void setIdAlojamiento(Alojamientos idAlojamiento) {
        this.idAlojamiento = idAlojamiento;
    }

    public Habitaciones getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(Habitaciones idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public Reservas getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Reservas idReserva) {
        this.idReserva = idReserva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResgistro != null ? idResgistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleHabReserva)) {
            return false;
        }
        DetalleHabReserva other = (DetalleHabReserva) object;
        if ((this.idResgistro == null && other.idResgistro != null) || (this.idResgistro != null && !this.idResgistro.equals(other.idResgistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tecnm.toluca.pruebas.DetalleHabReserva[ idResgistro=" + idResgistro + " ]";
    }
    
}
