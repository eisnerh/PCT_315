/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.conexionDB;

/**
 *
 * @author Cesar Gonzalez Salas, Eisner Lopez Acevedo /////
 */
public class Proyecto_Cabinas_Eltropico {

    /**
     * @param args the command line arguments
     * @throws java.lang.InstantiationException
     */
    public static void main(String[] args) throws InstantiationException {
        // TODO code application logic here

        Pantalla_principal Pant_Prin = new Pantalla_principal();
        Pant_Prin.setVisible(true);

        conexionDB Conec = new conexionDB();
        
        if (Conec != null) {
            System.out.println("HELL YEAH!!!");
        } else {
            System.out.println("Mieda");
        }
    }
}
