/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.contructor;

/**
 *
 * @author Eisner Lopez Acevedo <eisner.lopez at gmail.com>
 */
public class Modelo_Productos {

    private String idProductos;
    private String nombreProductos;
    private String proveedor_idProveedor;
    private String cantidad;
    private String gasto_operativo_gasto_id;

    public Modelo_Productos(String idProductos, String nombreProductos, String proveedor_idProveedor, String cantidad, String gasto_operativo_gasto_id) {
        this.idProductos = idProductos;
        this.nombreProductos = nombreProductos;
        this.proveedor_idProveedor = proveedor_idProveedor;
        this.cantidad = cantidad;
        this.gasto_operativo_gasto_id = gasto_operativo_gasto_id;
    }

    public Modelo_Productos() {

    }

    public String getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(String idProductos) {
        this.idProductos = idProductos;
    }

    public String getNombreProductos() {
        return nombreProductos;
    }

    public void setNombreProductos(String nombreProductos) {
        this.nombreProductos = nombreProductos;
    }

    public String getProveedor_idProveedor() {
        return proveedor_idProveedor;
    }

    public void setProveedor_idProveedor(String proveedor_idProveedor) {
        this.proveedor_idProveedor = proveedor_idProveedor;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getGasto_operativo_gasto_id() {
        return gasto_operativo_gasto_id;
    }

    public void setGasto_operativo_gasto_id(String gasto_operativo_gasto_id) {
        this.gasto_operativo_gasto_id = gasto_operativo_gasto_id;
    }

}
