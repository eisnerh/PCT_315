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
public class Modelo_ClienteEmpresa {

    private String empresa_id;
    private String codigo_cliente;
    private String estado_cliente;
    private String persona_idpersona;

    public Modelo_ClienteEmpresa() {

    }

    public Modelo_ClienteEmpresa(String empresa_id, String codigo_cliente, String estado_cliente, String persona_idpersona) {
        this.empresa_id = empresa_id;
        this.codigo_cliente = codigo_cliente;
        this.estado_cliente = estado_cliente;
        this.persona_idpersona = persona_idpersona;
    }

    public String getEmpresa_id() {
        return empresa_id;
    }

    public void setEmpresa_id(String empresa_id) {
        this.empresa_id = empresa_id;
    }

    public String getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(String codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public String getEstado_cliente() {
        return estado_cliente;
    }

    public void setEstado_cliente(String estado_cliente) {
        this.estado_cliente = estado_cliente;
    }

    public String getPersona_idpersona() {
        return persona_idpersona;
    }

    public void setPersona_idpersona(String persona_idpersona) {
        this.persona_idpersona = persona_idpersona;
    }

}
