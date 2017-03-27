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
public class mCliente_Empresa {
    private String idusuario;
    private String usuario;
    private String password;
    private String colaborador_empleado_id;

    public mCliente_Empresa()
    {
        
    }

    public mCliente_Empresa(String idusuario, String usuario, String password, String colaborador_empleado_id) {
        this.idusuario = idusuario;
        this.usuario = usuario;
        this.password = password;
        this.colaborador_empleado_id = colaborador_empleado_id;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
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

    public String getColaborador_empleado_id() {
        return colaborador_empleado_id;
    }

    public void setColaborador_empleado_id(String colaborador_empleado_id) {
        this.colaborador_empleado_id = colaborador_empleado_id;
    }
    
    
}
