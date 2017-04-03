/*
 * To change this license header; choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.contructor;

/**
 *
 * @author Eisner López Acevedo <eisner.lopez at gmail.com>
 */
public class Modelo_Persona {

    private String idpersona;
    private String nombre;
    private String cedula;
    private String telefono;
    private String direccion;
    private String tipo_persona_idtipo_persona;
    

    public Modelo_Persona() {

    }

    public Modelo_Persona(String idpersona, String nombre, String cedula, String telefono, String direccion, String tipo_persona_idtipo_persona) {
        this.idpersona = idpersona;
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.direccion = direccion;
        this.tipo_persona_idtipo_persona = tipo_persona_idtipo_persona;
    }

    public String getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(String idpersona) {
        this.idpersona = idpersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo_persona_idtipo_persona() {
        return tipo_persona_idtipo_persona;
    }

    public void setTipo_persona_idtipo_persona(String tipo_persona_idtipo_persona) {
        this.tipo_persona_idtipo_persona = tipo_persona_idtipo_persona;
    }

    
}
