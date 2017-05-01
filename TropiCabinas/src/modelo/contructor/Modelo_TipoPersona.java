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
public class Modelo_TipoPersona {

    private int idtipo_persona;

    private String desc_persona;

    public Modelo_TipoPersona() {

    }

    public Modelo_TipoPersona(int idtipo_persona, String desc_persona) {
        this.idtipo_persona = idtipo_persona;
        this.desc_persona = desc_persona;
    }

    public int getIdtipo_persona() {
        return idtipo_persona;
    }

    public void setIdtipo_persona(int idtipo_persona) {
        this.idtipo_persona = idtipo_persona;
    }

    public String getDesc_persona() {
        return desc_persona;
    }

    public void setDesc_persona(String desc_persona) {
        this.desc_persona = desc_persona;
    }

}
