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
import java.math.BigDecimal;
import java.util.Collection;

/**
 *
 * @author GPG
 */
@Entity
@Table(name = "servicios_adicionales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServiciosAdicionales.findAll", query = "SELECT s FROM ServiciosAdicionales s"),
    @NamedQuery(name = "ServiciosAdicionales.findByIdServicio", query = "SELECT s FROM ServiciosAdicionales s WHERE s.idServicio = :idServicio"),
    @NamedQuery(name = "ServiciosAdicionales.findByCosto", query = "SELECT s FROM ServiciosAdicionales s WHERE s.costo = :costo"),
    @NamedQuery(name = "ServiciosAdicionales.findByDescripcion", query = "SELECT s FROM ServiciosAdicionales s WHERE s.descripcion = :descripcion")})
public class ServiciosAdicionales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_servicio")
    private Integer idServicio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costo")
    private BigDecimal costo;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "id_alojamiento", referencedColumnName = "id_alojamiento")
    @ManyToOne
    private Alojamientos idAlojamiento;
    @OneToMany(mappedBy = "idServicio")
    private Collection<DetalleServReserva> detalleServReservaCollection;

    public ServiciosAdicionales() {
    }

    public ServiciosAdicionales(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
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
    public Collection<DetalleServReserva> getDetalleServReservaCollection() {
        return detalleServReservaCollection;
    }

    public void setDetalleServReservaCollection(Collection<DetalleServReserva> detalleServReservaCollection) {
        this.detalleServReservaCollection = detalleServReservaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServicio != null ? idServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiciosAdicionales)) {
            return false;
        }
        ServiciosAdicionales other = (ServiciosAdicionales) object;
        if ((this.idServicio == null && other.idServicio != null) || (this.idServicio != null && !this.idServicio.equals(other.idServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.toluca.tecnm.ServiciosAdicionales[ idServicio=" + idServicio + " ]";
    }
    
}
