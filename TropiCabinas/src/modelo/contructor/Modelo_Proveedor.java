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
public class Modelo_Proveedor {

    private String idproveedor;
    private String desc_proveedor;
    private String persona_idpersona;

    public Modelo_Proveedor() {

    }

    public Modelo_Proveedor(String idproveedor, String desc_proveedor, String persona_idpersona) {
        this.idproveedor = idproveedor;
        this.desc_proveedor = desc_proveedor;
        this.persona_idpersona = persona_idpersona;
    }

    public String getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(String idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getDesc_proveedor() {
        return desc_proveedor;
    }

    public void setDesc_proveedor(String desc_proveedor) {
        this.desc_proveedor = desc_proveedor;
    }

    public String getPersona_idpersona() {
        return persona_idpersona;
    }

    public void setPersona_idpersona(String persona_idpersona) {
        this.persona_idpersona = persona_idpersona;
    }

}
