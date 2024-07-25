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
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author GPG
 */
@Entity
@Table(name = "control_habitaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ControlHabitaciones.findAll", query = "SELECT c FROM ControlHabitaciones c"),
    @NamedQuery(name = "ControlHabitaciones.findById", query = "SELECT c FROM ControlHabitaciones c WHERE c.id = :id"),
    @NamedQuery(name = "ControlHabitaciones.findByNumero", query = "SELECT c FROM ControlHabitaciones c WHERE c.numero = :numero")})
public class ControlHabitaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "numero")
    private int numero;
    @JoinColumn(name = "id_alojamiento", referencedColumnName = "id_alojamiento")
    @ManyToOne
    private Alojamientos idAlojamiento;
    @JoinColumn(name = "id_habitacion", referencedColumnName = "id_habitacion")
    @ManyToOne
    private Habitaciones idHabitacion;

    public ControlHabitaciones() {
    }

    public ControlHabitaciones(Integer id) {
        this.id = id;
    }

    public ControlHabitaciones(Integer id, int numero) {
        this.id = id;
        this.numero = numero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ControlHabitaciones)) {
            return false;
        }
        ControlHabitaciones other = (ControlHabitaciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.toluca.tecnm.ControlHabitaciones[ id=" + id + " ]";
    }
    
}
