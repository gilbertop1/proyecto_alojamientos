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
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author GPG
 */
@Entity
@Table(name = "detalle_serv_reserva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleServReserva.findAll", query = "SELECT d FROM DetalleServReserva d"),
    @NamedQuery(name = "DetalleServReserva.findByIdRegistro", query = "SELECT d FROM DetalleServReserva d WHERE d.idRegistro = :idRegistro")})
public class DetalleServReserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_registro")
    private Integer idRegistro;
    @JoinColumn(name = "id_alojamiento", referencedColumnName = "id_alojamiento")
    @ManyToOne
    private Alojamientos idAlojamiento;
    @JoinColumn(name = "id_reserva", referencedColumnName = "id_reserva")
    @ManyToOne
    private Reservas idReserva;
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio")
    @ManyToOne
    private ServiciosAdicionales idServicio;

    public DetalleServReserva() {
    }

    public DetalleServReserva(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Alojamientos getIdAlojamiento() {
        return idAlojamiento;
    }

    public void setIdAlojamiento(Alojamientos idAlojamiento) {
        this.idAlojamiento = idAlojamiento;
    }

    public Reservas getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Reservas idReserva) {
        this.idReserva = idReserva;
    }

    public ServiciosAdicionales getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(ServiciosAdicionales idServicio) {
        this.idServicio = idServicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegistro != null ? idRegistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleServReserva)) {
            return false;
        }
        DetalleServReserva other = (DetalleServReserva) object;
        if ((this.idRegistro == null && other.idRegistro != null) || (this.idRegistro != null && !this.idRegistro.equals(other.idRegistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tecnm.toluca.pruebas.DetalleServReserva[ idRegistro=" + idRegistro + " ]";
    }
    
}
