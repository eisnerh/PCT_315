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
public class mUsuario {
    //Declaración de los campos de la tabla Usuarios.
    private String usuario;
    private String password;
    private double colaborador_empleado_id;

    public mUsuario(String usuario, String password, double colaborador_empleado_id) {
        this.usuario = usuario;
        this.password = password;
        this.colaborador_empleado_id = colaborador_empleado_id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getColaborador_empleado_id() {
        return colaborador_empleado_id;
    }

    public void setColaborador_empleado_id(double colaborador_empleado_id) {
        this.colaborador_empleado_id = colaborador_empleado_id;
    }
    
}
