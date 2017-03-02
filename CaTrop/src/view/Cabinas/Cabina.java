/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.Cabinas;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import view.FacturaCabina;

/**
 *
 * @author ace
 */
@Entity
@Table(name = "cabina", catalog = "pct3", schema = "")
@NamedQueries({
    @NamedQuery(name = "Cabina.findAll", query = "SELECT c FROM Cabina c"),
    @NamedQuery(name = "Cabina.findByCabinaId", query = "SELECT c FROM Cabina c WHERE c.cabinaId = :cabinaId"),
    @NamedQuery(name = "Cabina.findByDescripcionCabina", query = "SELECT c FROM Cabina c WHERE c.descripcionCabina = :descripcionCabina"),
    @NamedQuery(name = "Cabina.findByEstadoCabina", query = "SELECT c FROM Cabina c WHERE c.estadoCabina = :estadoCabina"),
    @NamedQuery(name = "Cabina.findByPrecio", query = "SELECT c FROM Cabina c WHERE c.precio = :precio"),
    @NamedQuery(name = "Cabina.findByTipoCabina", query = "SELECT c FROM Cabina c WHERE c.tipoCabina = :tipoCabina")})
public class Cabina implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cabina_id")
    private Short cabinaId;
    @Basic(optional = false)
    @Column(name = "descripcion_cabina")
    private String descripcionCabina;
    @Basic(optional = false)
    @Column(name = "estado_cabina")
    private String estadoCabina;
    @Basic(optional = false)
    @Column(name = "precio")
    private float precio;
    @Basic(optional = false)
    @Column(name = "tipo_cabina")
    private String tipoCabina;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cabinaCabinaId")
    private List<FacturaCabina> facturaCabinaList;

    public Cabina() {
    }

    public Cabina(Short cabinaId) {
        this.cabinaId = cabinaId;
    }

    public Cabina(Short cabinaId, String descripcionCabina, String estadoCabina, float precio, String tipoCabina) {
        this.cabinaId = cabinaId;
        this.descripcionCabina = descripcionCabina;
        this.estadoCabina = estadoCabina;
        this.precio = precio;
        this.tipoCabina = tipoCabina;
    }

    public Short getCabinaId() {
        return cabinaId;
    }

    public void setCabinaId(Short cabinaId) {
        Short oldCabinaId = this.cabinaId;
        this.cabinaId = cabinaId;
        changeSupport.firePropertyChange("cabinaId", oldCabinaId, cabinaId);
    }

    public String getDescripcionCabina() {
        return descripcionCabina;
    }

    public void setDescripcionCabina(String descripcionCabina) {
        String oldDescripcionCabina = this.descripcionCabina;
        this.descripcionCabina = descripcionCabina;
        changeSupport.firePropertyChange("descripcionCabina", oldDescripcionCabina, descripcionCabina);
    }

    public String getEstadoCabina() {
        return estadoCabina;
    }

    public void setEstadoCabina(String estadoCabina) {
        String oldEstadoCabina = this.estadoCabina;
        this.estadoCabina = estadoCabina;
        changeSupport.firePropertyChange("estadoCabina", oldEstadoCabina, estadoCabina);
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        float oldPrecio = this.precio;
        this.precio = precio;
        changeSupport.firePropertyChange("precio", oldPrecio, precio);
    }

    public String getTipoCabina() {
        return tipoCabina;
    }

    public void setTipoCabina(String tipoCabina) {
        String oldTipoCabina = this.tipoCabina;
        this.tipoCabina = tipoCabina;
        changeSupport.firePropertyChange("tipoCabina", oldTipoCabina, tipoCabina);
    }

    public List<FacturaCabina> getFacturaCabinaList() {
        return facturaCabinaList;
    }

    public void setFacturaCabinaList(List<FacturaCabina> facturaCabinaList) {
        this.facturaCabinaList = facturaCabinaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cabinaId != null ? cabinaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cabina)) {
            return false;
        }
        Cabina other = (Cabina) object;
        if ((this.cabinaId == null && other.cabinaId != null) || (this.cabinaId != null && !this.cabinaId.equals(other.cabinaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Cabina[ cabinaId=" + cabinaId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
