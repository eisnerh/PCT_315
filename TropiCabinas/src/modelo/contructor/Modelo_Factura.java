/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.contructor;

/**
 *
 * @author Eisner López Acevedo <eisner.lopez at gmail.com>
 */
public class Modelo_Factura {

    private String factura_id;
    private String cant_dia;
    private String fecha;
    private String impuesto_cabina;
    private String precio_total_cabina;
    private String cabina_cabina_id;
    private String colaborador_empleado_id;
    private String numero_factura;

    public Modelo_Factura() {

    }

    public Modelo_Factura(String factura_id, String cant_dia, String fecha, String impuesto_cabina, String precio_total_cabina, String cabina_cabina_id, String colaborador_empleado_id, String numero_factura) {
        this.factura_id = factura_id;
        this.cant_dia = cant_dia;
        this.fecha = fecha;
        this.impuesto_cabina = impuesto_cabina;
        this.precio_total_cabina = precio_total_cabina;
        this.cabina_cabina_id = cabina_cabina_id;
        this.colaborador_empleado_id = colaborador_empleado_id;
        this.numero_factura = numero_factura;
    }

    public String getFactura_id() {
        return factura_id;
    }

    public void setFactura_id(String factura_id) {
        this.factura_id = factura_id;
    }

    public String getCant_dia() {
        return cant_dia;
    }

    public void setCant_dia(String cant_dia) {
        this.cant_dia = cant_dia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getImpuesto_cabina() {
        return impuesto_cabina;
    }

    public void setImpuesto_cabina(String impuesto_cabina) {
        this.impuesto_cabina = impuesto_cabina;
    }

    public String getPrecio_total_cabina() {
        return precio_total_cabina;
    }

    public void setPrecio_total_cabina(String precio_total_cabina) {
        this.precio_total_cabina = precio_total_cabina;
    }

    public String getCabina_cabina_id() {
        return cabina_cabina_id;
    }

    public void setCabina_cabina_id(String cabina_cabina_id) {
        this.cabina_cabina_id = cabina_cabina_id;
    }

    public String getColaborador_empleado_id() {
        return colaborador_empleado_id;
    }

    public void setColaborador_empleado_id(String colaborador_empleado_id) {
        this.colaborador_empleado_id = colaborador_empleado_id;
    }

    public String getNumero_factura() {
        return numero_factura;
    }

    public void setNumero_factura(String numero_factura) {
        this.numero_factura = numero_factura;
    }

}
