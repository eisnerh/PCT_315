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
public class mClienteEmpresa {

    private String empresaId;
    private String nombreEmpresa;
    private String estadoCliente;

    public mClienteEmpresa(String empresaId, String nombreEmpresa, String estadoCliente) {
        this.empresaId = empresaId;
        this.nombreEmpresa = nombreEmpresa;
        this.estadoCliente = estadoCliente;
    }

    public mClienteEmpresa() {

    }


    public String getEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(String estadoCliente) {
        this.estadoCliente = estadoCliente;
    }

    public String getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(String empresaId) {
        this.empresaId = empresaId;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

}
