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
public class mPuesto {
    
    private String puesto_id;
    private String descripcion_puesto;
    private String pago_hora_sencilla;
    private String pago_hora_extra;
    
    public mPuesto()
    {
        
    }

    public mPuesto(String puesto_id, String descripcion_puesto, String pago_hora_sencilla, String pago_hora_extra) {
        this.puesto_id = puesto_id;
        this.descripcion_puesto = descripcion_puesto;
        this.pago_hora_sencilla = pago_hora_sencilla;
        this.pago_hora_extra = pago_hora_extra;
    }

    public String getPuesto_id() {
        return puesto_id;
    }

    public void setPuesto_id(String puesto_id) {
        this.puesto_id = puesto_id;
    }

    public String getDescripcion_puesto() {
        return descripcion_puesto;
    }

    public void setDescripcion_puesto(String descripcion_puesto) {
        this.descripcion_puesto = descripcion_puesto;
    }

    public String getPago_hora_sencilla() {
        return pago_hora_sencilla;
    }

    public void setPago_hora_sencilla(String pago_hora_sencilla) {
        this.pago_hora_sencilla = pago_hora_sencilla;
    }

    public String getPago_hora_extra() {
        return pago_hora_extra;
    }

    public void setPago_hora_extra(String pago_hora_extra) {
        this.pago_hora_extra = pago_hora_extra;
    }
    
    

}
