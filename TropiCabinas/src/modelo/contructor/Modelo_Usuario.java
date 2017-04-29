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
public class Modelo_Usuario {

    private String idUsuario;
    private String Usuario;
    private String Password;
    private String Colaborador_empleado_id;

    public Modelo_Usuario() {

    }

    public Modelo_Usuario(String idUsuario, String Usuario, String Password, String Colaborador_empleado_id) {
        this.idUsuario = idUsuario;
        this.Usuario = Usuario;
        this.Password = Password;
        this.Colaborador_empleado_id = Colaborador_empleado_id;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getColaborador_empleado_id() {
        return Colaborador_empleado_id;
    }

    public void setColaborador_empleado_id(String Colaborador_empleado_id) {
        this.Colaborador_empleado_id = Colaborador_empleado_id;
    }

}
