/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tolback.xmockups;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author bglui
 */
@Entity
@Table(name = "fotos", catalog = "alojamientosbd", schema = "POSTGRES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fotos.findAll", query = "SELECT f FROM Fotos f"),
    @NamedQuery(name = "Fotos.findByIdAlojamiento", query = "SELECT f FROM Fotos f WHERE f.fotosPK.idAlojamiento = :idAlojamiento"),
    @NamedQuery(name = "Fotos.findByIdHabitacion", query = "SELECT f FROM Fotos f WHERE f.fotosPK.idHabitacion = :idHabitacion"),
    @NamedQuery(name = "Fotos.findByRuta", query = "SELECT f FROM Fotos f WHERE f.ruta = :ruta")})
public class Fotos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FotosPK fotosPK;
    @Size(max = 200)
    @Column(name = "ruta", length = 200)
    private String ruta;
    @JoinColumn(name = "id_alojamiento", referencedColumnName = "id_alojamiento", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alojamientos alojamientos;
    @JoinColumn(name = "id_habitacion", referencedColumnName = "id_habitacion", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Habitaciones habitaciones;

    public Fotos() {
    }

    public Fotos(FotosPK fotosPK) {
        this.fotosPK = fotosPK;
    }

    public Fotos(int idAlojamiento, short idHabitacion) {
        this.fotosPK = new FotosPK(idAlojamiento, idHabitacion);
    }

    public FotosPK getFotosPK() {
        return fotosPK;
    }

    public void setFotosPK(FotosPK fotosPK) {
        this.fotosPK = fotosPK;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Alojamientos getAlojamientos() {
        return alojamientos;
    }

    public void setAlojamientos(Alojamientos alojamientos) {
        this.alojamientos = alojamientos;
    }

    public Habitaciones getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(Habitaciones habitaciones) {
        this.habitaciones = habitaciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fotosPK != null ? fotosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fotos)) {
            return false;
        }
        Fotos other = (Fotos) object;
        if ((this.fotosPK == null && other.fotosPK != null) || (this.fotosPK != null && !this.fotosPK.equals(other.fotosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tolback.xmockups.Fotos[ fotosPK=" + fotosPK + " ]";
    }
    
}
