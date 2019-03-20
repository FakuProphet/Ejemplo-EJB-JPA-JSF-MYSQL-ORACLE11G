/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.pojos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Prophet
 */
@Entity
@Table(name = "PUESTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Puestos.findAll", query = "SELECT p FROM Puestos p")
    , @NamedQuery(name = "Puestos.findByPuestoid", query = "SELECT p FROM Puestos p WHERE p.puestoid = :puestoid")
    , @NamedQuery(name = "Puestos.findByDescripcion", query = "SELECT p FROM Puestos p WHERE p.descripcion = :descripcion")})
public class Puestos implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "PUESTOID")
    private BigDecimal puestoid;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(mappedBy = "puestoid")
    private List<Empleados> empleadosList;

    public Puestos() {
    }

    public Puestos(BigDecimal puestoid) {
        this.puestoid = puestoid;
    }

    public BigDecimal getPuestoid() {
        return puestoid;
    }

    public void setPuestoid(BigDecimal puestoid) {
        this.puestoid = puestoid;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Empleados> getEmpleadosList() {
        return empleadosList;
    }

    public void setEmpleadosList(List<Empleados> empleadosList) {
        this.empleadosList = empleadosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (puestoid != null ? puestoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Puestos)) {
            return false;
        }
        Puestos other = (Puestos) object;
        if ((this.puestoid == null && other.puestoid != null) || (this.puestoid != null && !this.puestoid.equals(other.puestoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.Puestos[ puestoid=" + puestoid + " ]";
    }
    
}
