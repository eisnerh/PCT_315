/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.formularios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Eisner López Acevedo <eisner.lopez at gmail.com>
 */
public class mCompañia {

    public static void main(String[] args) {

//Un texto cualquiera guardado en una variable
        String saludo = "Cabinas el Tropico";

        try {
//Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
            File archivo = new File("C:\\Users\\eisne\\Dropbox\\Archivos enviados\\texto.txt");

//Escribimos en el archivo con el metodo write
            try (//Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
                    FileWriter escribir = new FileWriter(archivo, true)) {
                //Escribimos en el archivo con el metodo write
                escribir.write(saludo);
            }
        } //Si existe un problema al escribir cae aqui //Si existe un problema al escribir cae aqui
        catch (IOException e) {
            System.out.println("Error al escribir");
        }
    }
}
