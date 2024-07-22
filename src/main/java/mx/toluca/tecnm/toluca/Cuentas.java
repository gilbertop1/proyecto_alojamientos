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
@Table(name = "cuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuentas.findAll", query = "SELECT c FROM Cuentas c"),
    @NamedQuery(name = "Cuentas.findByIdCuenta", query = "SELECT c FROM Cuentas c WHERE c.idCuenta = :idCuenta"),
    @NamedQuery(name = "Cuentas.findByNoCuenta", query = "SELECT c FROM Cuentas c WHERE c.noCuenta = :noCuenta"),
    @NamedQuery(name = "Cuentas.findByBanco", query = "SELECT c FROM Cuentas c WHERE c.banco = :banco"),
    @NamedQuery(name = "Cuentas.findByBeneficiario", query = "SELECT c FROM Cuentas c WHERE c.beneficiario = :beneficiario")})
public class Cuentas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cuenta")
    private Integer idCuenta;
    @Column(name = "no_cuenta")
    private BigInteger noCuenta;
    @Size(max = 20)
    @Column(name = "banco")
    private String banco;
    @Size(max = 50)
    @Column(name = "beneficiario")
    private String beneficiario;
    @OneToMany(mappedBy = "idCuenta")
    private Collection<Alojamientos> alojamientosCollection;

    public Cuentas() {
    }

    public Cuentas(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
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
    public Collection<Alojamientos> getAlojamientosCollection() {
        return alojamientosCollection;
    }

    public void setAlojamientosCollection(Collection<Alojamientos> alojamientosCollection) {
        this.alojamientosCollection = alojamientosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuenta != null ? idCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuentas)) {
            return false;
        }
        Cuentas other = (Cuentas) object;
        if ((this.idCuenta == null && other.idCuenta != null) || (this.idCuenta != null && !this.idCuenta.equals(other.idCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tecnm.toluca.pruebas.Cuentas[ idCuenta=" + idCuenta + " ]";
    }
    
}
