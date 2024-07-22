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
@Table(name = "reservas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservas.findAll", query = "SELECT r FROM Reservas r"),
    @NamedQuery(name = "Reservas.findByIdReserva", query = "SELECT r FROM Reservas r WHERE r.idReserva = :idReserva"),
    @NamedQuery(name = "Reservas.findByTotal", query = "SELECT r FROM Reservas r WHERE r.total = :total"),
    @NamedQuery(name = "Reservas.findByEstatus", query = "SELECT r FROM Reservas r WHERE r.estatus = :estatus")})
public class Reservas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_reserva")
    private Integer idReserva;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total")
    private BigDecimal total;
    @Size(max = 15)
    @Column(name = "estatus")
    private String estatus;
    @OneToMany(mappedBy = "idReserva")
    private Collection<DetalleHabReserva> detalleHabReservaCollection;
    @JoinColumn(name = "id_alojamiento", referencedColumnName = "id_alojamiento")
    @ManyToOne
    private Alojamientos idAlojamiento;
    @OneToMany(mappedBy = "idReserva")
    private Collection<DetalleServReserva> detalleServReservaCollection;

    public Reservas() {
    }

    public Reservas(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
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

    public Alojamientos getIdAlojamiento() {
        return idAlojamiento;
    }

    public void setIdAlojamiento(Alojamientos idAlojamiento) {
        this.idAlojamiento = idAlojamiento;
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
        hash += (idReserva != null ? idReserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservas)) {
            return false;
        }
        Reservas other = (Reservas) object;
        if ((this.idReserva == null && other.idReserva != null) || (this.idReserva != null && !this.idReserva.equals(other.idReserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tecnm.toluca.pruebas.Reservas[ idReserva=" + idReserva + " ]";
    }
    
}
