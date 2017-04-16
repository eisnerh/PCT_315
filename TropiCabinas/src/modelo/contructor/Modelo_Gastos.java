/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.contructor;

/**
 *
 * @author treznor
 */
public class Modelo_Gastos {

    private String GastoID;
    private String Tipo_Gasto;
    private String Monto_Gasto;
    private String Fecha_Gasto;
    private String Factura_Gasto;
    private String Colaborador_EmpleadoID;

    public Modelo_Gastos() {

    }

    public Modelo_Gastos(String GastoID, String Tipo_Gasto, String Monto_Gasto, String Fecha_Gasto, String Factura_Gasto, String Colaborador_EmpleadoID) {

        this.GastoID = GastoID;
        this.Tipo_Gasto = Tipo_Gasto;
        this.Monto_Gasto = Monto_Gasto;
        this.Fecha_Gasto = Fecha_Gasto;
        this.Factura_Gasto = Factura_Gasto;
        this.Colaborador_EmpleadoID = Colaborador_EmpleadoID;
    }

    public String getGastoID() {
        return GastoID;
    }

    public void setGastoID(String GastoID) {
        this.GastoID = GastoID;
    }

    public String getTipo_Gasto() {
        return Tipo_Gasto;
    }

    public void setTipo_Gasto(String Tipo_Gasto) {
        this.Tipo_Gasto = Tipo_Gasto;
    }

    public String getMonto_Gasto() {
        return Monto_Gasto;
    }

    public void setMonto_Gasto(String Monto_Gasto) {
        this.Monto_Gasto = Monto_Gasto;
    }

    public String getFecha_Gasto() {
        return Fecha_Gasto;
    }

    public void setFecha_Gasto(String Fecha_Gasto) {
        this.Fecha_Gasto = Fecha_Gasto;
    }

    public String getFactura_Gasto() {
        return Factura_Gasto;
    }

    public void setFactura_Gasto(String Factura_Gasto) {
        this.Factura_Gasto = Factura_Gasto;
    }

    public String getColaborador_EmpleadoID() {
        return Colaborador_EmpleadoID;
    }

    public void setColaborador_EmpleadoID(String Colaborador_EmpleadoID) {
        this.Colaborador_EmpleadoID = Colaborador_EmpleadoID;
    }
}
