/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.contructor.Modelo_Factura;
import modelo.formularios.Form_Factura;

/**
 *
 * @author Eisner López Acevedo <eisner.lopez at gmail.com>
 */
public class PruebaSelectFactura {

    /**
     * @param args the command line arguments
     */
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    ResultSet rs2 = null;
    PreparedStatement pst2 = null;

    public static void main(String[] args) {
        // TODO code application logic here
        buscar();
    }

    private static void buscar() {
        String busqueda = "1";
        Modelo_Factura mf = new Modelo_Factura();
        Form_Factura ff = new Form_Factura();
        ff.mostrarFactura(busqueda);

    }

}
