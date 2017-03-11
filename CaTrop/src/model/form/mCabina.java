/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.form;

/**
 *
 * @author ace
 */
public class mCabina {

    private String id_cabina;
    private String descripcionCabina;
    private String estado_cabina;
    private String precio;
    private String tipo_cabina;

    public mCabina(String id_cabina, String descripcionCabina, String estado_cabina, String precio, String tipo_cabina) {
        this.id_cabina = id_cabina;
        this.descripcionCabina = descripcionCabina;
        this.estado_cabina = estado_cabina;
        this.precio = precio;
        this.tipo_cabina = tipo_cabina;
    }

    public mCabina() {

    }

    public String getId_cabina() {
        return id_cabina;
    }

    public void setId_cabina(String id_cabina) {
        this.id_cabina = id_cabina;
    }

    public String getDescripcionCabina() {
        return descripcionCabina;
    }

    public void setDescripcionCabina(String descripcionCabina) {
        this.descripcionCabina = descripcionCabina;
    }

    public String getEstado_cabina() {
        return estado_cabina;
    }

    public void setEstado_cabina(String estado_cabina) {
        this.estado_cabina = estado_cabina;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getTipo_cabina() {
        return tipo_cabina;
    }

    public void setTipo_cabina(String tipo_cabina) {
        this.tipo_cabina = tipo_cabina;
    }

}
