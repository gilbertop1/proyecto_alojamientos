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
@Table(name = "servicios_adicionales", catalog = "alojamientosbd", schema = "POSTGRES", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_servicio"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServiciosAdicionales.findAll", query = "SELECT s FROM ServiciosAdicionales s"),
    @NamedQuery(name = "ServiciosAdicionales.findByIdServicio", query = "SELECT s FROM ServiciosAdicionales s WHERE s.serviciosAdicionalesPK.idServicio = :idServicio"),
    @NamedQuery(name = "ServiciosAdicionales.findByIdAlojamiento", query = "SELECT s FROM ServiciosAdicionales s WHERE s.serviciosAdicionalesPK.idAlojamiento = :idAlojamiento"),
    @NamedQuery(name = "ServiciosAdicionales.findByCosto", query = "SELECT s FROM ServiciosAdicionales s WHERE s.costo = :costo"),
    @NamedQuery(name = "ServiciosAdicionales.findByDescripcion", query = "SELECT s FROM ServiciosAdicionales s WHERE s.descripcion = :descripcion")})
public class ServiciosAdicionales implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ServiciosAdicionalesPK serviciosAdicionalesPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costo", precision = 4, scale = 2)
    private BigDecimal costo;
    @Size(max = 200)
    @Column(name = "descripcion", length = 200)
    private String descripcion;
    @JoinColumn(name = "id_alojamiento", referencedColumnName = "id_alojamiento", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alojamientos alojamientos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviciosAdicionales")
    private Collection<DetalleServReserva> detalleServReservaCollection;

    public ServiciosAdicionales() {
    }

    public ServiciosAdicionales(ServiciosAdicionalesPK serviciosAdicionalesPK) {
        this.serviciosAdicionalesPK = serviciosAdicionalesPK;
    }

    public ServiciosAdicionales(short idServicio, int idAlojamiento) {
        this.serviciosAdicionalesPK = new ServiciosAdicionalesPK(idServicio, idAlojamiento);
    }

    public ServiciosAdicionalesPK getServiciosAdicionalesPK() {
        return serviciosAdicionalesPK;
    }

    public void setServiciosAdicionalesPK(ServiciosAdicionalesPK serviciosAdicionalesPK) {
        this.serviciosAdicionalesPK = serviciosAdicionalesPK;
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

    public Alojamientos getAlojamientos() {
        return alojamientos;
    }

    public void setAlojamientos(Alojamientos alojamientos) {
        this.alojamientos = alojamientos;
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
        hash += (serviciosAdicionalesPK != null ? serviciosAdicionalesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiciosAdicionales)) {
            return false;
        }
        ServiciosAdicionales other = (ServiciosAdicionales) object;
        if ((this.serviciosAdicionalesPK == null && other.serviciosAdicionalesPK != null) || (this.serviciosAdicionalesPK != null && !this.serviciosAdicionalesPK.equals(other.serviciosAdicionalesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tolback.xmockups.ServiciosAdicionales[ serviciosAdicionalesPK=" + serviciosAdicionalesPK + " ]";
    }
    
}
