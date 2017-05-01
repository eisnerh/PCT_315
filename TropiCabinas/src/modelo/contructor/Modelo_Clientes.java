/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.contructor;

/**
 *
 * @author Eisner López Acevedo <eisner.lopez at gmail.com>
 * @author Cesar Gonzalez Salas <cgonzalez816 at gmail.com>
 */
public class Modelo_Clientes {

    private String empresa_id;
    private String codigo_cliente;
    private String nombre;
    private String desc_persona;

    public Modelo_Clientes() {

    }

    public Modelo_Clientes(String empresa_id, String codigo_cliente, String nombre, String desc_persona) {
        this.empresa_id = empresa_id;
        this.codigo_cliente = codigo_cliente;
        this.nombre = nombre;
        this.desc_persona = desc_persona;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesc_persona() {
        return desc_persona;
    }

    public void setDesc_persona(String desc_persona) {
        this.desc_persona = desc_persona;
    }

}
