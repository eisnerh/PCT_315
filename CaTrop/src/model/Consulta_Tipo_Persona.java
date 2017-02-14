/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ace
 */
public class Consulta_Tipo_Persona {

    static Statement sentencia;
    static ResultSet resultado;

    public static ArrayList<String> llenar_combo() {
        ArrayList<String> lista = new ArrayList<String>();
        String q = "SELECT * FROM `puesto`";
        try {
            resultado = sentencia.executeQuery(q);
            System.out.println("Correcto");
        } catch (Exception e) {
            System.out.println("No Correcto");
        }
        try {
            while (resultado.next()) {
                lista.add(resultado.getString("`descripcion_puesto`"));
            }
        } catch (Exception e) {
        }
        return lista;
    }

}
