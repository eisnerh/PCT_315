/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author ace
 */
@Entity
@Table(name = "factura_cabina", catalog = "pct3", schema = "")
@NamedQueries({
    @NamedQuery(name = "FacturaCabina.findAll", query = "SELECT f FROM FacturaCabina f"),
    @NamedQuery(name = "FacturaCabina.findByFacturaId", query = "SELECT f FROM FacturaCabina f WHERE f.facturaId = :facturaId"),
    @NamedQuery(name = "FacturaCabina.findByCantDia", query = "SELECT f FROM FacturaCabina f WHERE f.cantDia = :cantDia"),
    @NamedQuery(name = "FacturaCabina.findByFecha", query = "SELECT f FROM FacturaCabina f WHERE f.fecha = :fecha"),
    @NamedQuery(name = "FacturaCabina.findByImpuestoCabina", query = "SELECT f FROM FacturaCabina f WHERE f.impuestoCabina = :impuestoCabina"),
    @NamedQuery(name = "FacturaCabina.findByPrecioTotalCabina", query = "SELECT f FROM FacturaCabina f WHERE f.precioTotalCabina = :precioTotalCabina"),
    @NamedQuery(name = "FacturaCabina.findByDatosEmpresaIddatosEmpresa", query = "SELECT f FROM FacturaCabina f WHERE f.datosEmpresaIddatosEmpresa = :datosEmpresaIddatosEmpresa"),
    @NamedQuery(name = "FacturaCabina.findByPersonaIdpersona", query = "SELECT f FROM FacturaCabina f WHERE f.personaIdpersona = :personaIdpersona"),
    @NamedQuery(name = "FacturaCabina.findByDatoEmpresaIddatoEmpresa", query = "SELECT f FROM FacturaCabina f WHERE f.datoEmpresaIddatoEmpresa = :datoEmpresaIddatoEmpresa"),
    @NamedQuery(name = "FacturaCabina.findByClienteEmpresaEmpresaId", query = "SELECT f FROM FacturaCabina f WHERE f.clienteEmpresaEmpresaId = :clienteEmpresaEmpresaId"),
    @NamedQuery(name = "FacturaCabina.findByColaboradorEmpleadoId", query = "SELECT f FROM FacturaCabina f WHERE f.colaboradorEmpleadoId = :colaboradorEmpleadoId")})
public class FacturaCabina implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "factura_id")
    private Long facturaId;
    @Basic(optional = false)
    @Column(name = "cant_dia")
    private short cantDia;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "impuesto_cabina")
    private float impuestoCabina;
    @Basic(optional = false)
    @Column(name = "precio_total_cabina")
    private long precioTotalCabina;
    @Basic(optional = false)
    @Column(name = "datos_empresa_iddatos_empresa")
    private int datosEmpresaIddatosEmpresa;
    @Basic(optional = false)
    @Column(name = "persona_idpersona")
    private int personaIdpersona;
    @Basic(optional = false)
    @Column(name = "dato_empresa_iddato_empresa")
    private int datoEmpresaIddatoEmpresa;
    @Basic(optional = false)
    @Column(name = "cliente_empresa_empresa_id")
    private long clienteEmpresaEmpresaId;
    @Basic(optional = false)
    @Column(name = "colaborador_empleado_id")
    private long colaboradorEmpleadoId;
    @JoinColumn(name = "cabina_cabina_id", referencedColumnName = "cabina_id")
    @ManyToOne(optional = false)
    private Cabina cabinaCabinaId;

    public FacturaCabina() {
    }

    public FacturaCabina(Long facturaId) {
        this.facturaId = facturaId;
    }

    public FacturaCabina(Long facturaId, short cantDia, Date fecha, float impuestoCabina, long precioTotalCabina, int datosEmpresaIddatosEmpresa, int personaIdpersona, int datoEmpresaIddatoEmpresa, long clienteEmpresaEmpresaId, long colaboradorEmpleadoId) {
        this.facturaId = facturaId;
        this.cantDia = cantDia;
        this.fecha = fecha;
        this.impuestoCabina = impuestoCabina;
        this.precioTotalCabina = precioTotalCabina;
        this.datosEmpresaIddatosEmpresa = datosEmpresaIddatosEmpresa;
        this.personaIdpersona = personaIdpersona;
        this.datoEmpresaIddatoEmpresa = datoEmpresaIddatoEmpresa;
        this.clienteEmpresaEmpresaId = clienteEmpresaEmpresaId;
        this.colaboradorEmpleadoId = colaboradorEmpleadoId;
    }

    public Long getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(Long facturaId) {
        Long oldFacturaId = this.facturaId;
        this.facturaId = facturaId;
        changeSupport.firePropertyChange("facturaId", oldFacturaId, facturaId);
    }

    public short getCantDia() {
        return cantDia;
    }

    public void setCantDia(short cantDia) {
        short oldCantDia = this.cantDia;
        this.cantDia = cantDia;
        changeSupport.firePropertyChange("cantDia", oldCantDia, cantDia);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        Date oldFecha = this.fecha;
        this.fecha = fecha;
        changeSupport.firePropertyChange("fecha", oldFecha, fecha);
    }

    public float getImpuestoCabina() {
        return impuestoCabina;
    }

    public void setImpuestoCabina(float impuestoCabina) {
        float oldImpuestoCabina = this.impuestoCabina;
        this.impuestoCabina = impuestoCabina;
        changeSupport.firePropertyChange("impuestoCabina", oldImpuestoCabina, impuestoCabina);
    }

    public long getPrecioTotalCabina() {
        return precioTotalCabina;
    }

    public void setPrecioTotalCabina(long precioTotalCabina) {
        long oldPrecioTotalCabina = this.precioTotalCabina;
        this.precioTotalCabina = precioTotalCabina;
        changeSupport.firePropertyChange("precioTotalCabina", oldPrecioTotalCabina, precioTotalCabina);
    }

    public int getDatosEmpresaIddatosEmpresa() {
        return datosEmpresaIddatosEmpresa;
    }

    public void setDatosEmpresaIddatosEmpresa(int datosEmpresaIddatosEmpresa) {
        int oldDatosEmpresaIddatosEmpresa = this.datosEmpresaIddatosEmpresa;
        this.datosEmpresaIddatosEmpresa = datosEmpresaIddatosEmpresa;
        changeSupport.firePropertyChange("datosEmpresaIddatosEmpresa", oldDatosEmpresaIddatosEmpresa, datosEmpresaIddatosEmpresa);
    }

    public int getPersonaIdpersona() {
        return personaIdpersona;
    }

    public void setPersonaIdpersona(int personaIdpersona) {
        int oldPersonaIdpersona = this.personaIdpersona;
        this.personaIdpersona = personaIdpersona;
        changeSupport.firePropertyChange("personaIdpersona", oldPersonaIdpersona, personaIdpersona);
    }

    public int getDatoEmpresaIddatoEmpresa() {
        return datoEmpresaIddatoEmpresa;
    }

    public void setDatoEmpresaIddatoEmpresa(int datoEmpresaIddatoEmpresa) {
        int oldDatoEmpresaIddatoEmpresa = this.datoEmpresaIddatoEmpresa;
        this.datoEmpresaIddatoEmpresa = datoEmpresaIddatoEmpresa;
        changeSupport.firePropertyChange("datoEmpresaIddatoEmpresa", oldDatoEmpresaIddatoEmpresa, datoEmpresaIddatoEmpresa);
    }

    public long getClienteEmpresaEmpresaId() {
        return clienteEmpresaEmpresaId;
    }

    public void setClienteEmpresaEmpresaId(long clienteEmpresaEmpresaId) {
        long oldClienteEmpresaEmpresaId = this.clienteEmpresaEmpresaId;
        this.clienteEmpresaEmpresaId = clienteEmpresaEmpresaId;
        changeSupport.firePropertyChange("clienteEmpresaEmpresaId", oldClienteEmpresaEmpresaId, clienteEmpresaEmpresaId);
    }

    public long getColaboradorEmpleadoId() {
        return colaboradorEmpleadoId;
    }

    public void setColaboradorEmpleadoId(long colaboradorEmpleadoId) {
        long oldColaboradorEmpleadoId = this.colaboradorEmpleadoId;
        this.colaboradorEmpleadoId = colaboradorEmpleadoId;
        changeSupport.firePropertyChange("colaboradorEmpleadoId", oldColaboradorEmpleadoId, colaboradorEmpleadoId);
    }

    public Cabina getCabinaCabinaId() {
        return cabinaCabinaId;
    }

    public void setCabinaCabinaId(Cabina cabinaCabinaId) {
        Cabina oldCabinaCabinaId = this.cabinaCabinaId;
        this.cabinaCabinaId = cabinaCabinaId;
        changeSupport.firePropertyChange("cabinaCabinaId", oldCabinaCabinaId, cabinaCabinaId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facturaId != null ? facturaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaCabina)) {
            return false;
        }
        FacturaCabina other = (FacturaCabina) object;
        if ((this.facturaId == null && other.facturaId != null) || (this.facturaId != null && !this.facturaId.equals(other.facturaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.FacturaCabina[ facturaId=" + facturaId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
