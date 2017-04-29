/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author Eisner López Acevedo <eisner.lopez at gmail.com>
 */
public class dbConnection {

    public static Connection getConnection() {
        Properties props;
        props = new Properties();
        FileInputStream fis1;
        Connection con = null;
        try {
            File data1 = new File("/home/ace/PCT_315/TropiCabinas/src/dbConfig.properties");
            if (!data1.exists()) {
                JOptionPane.showMessageDialog(null, "Archivo de propiedades para conexi\u00F3n no existe", "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            } else if (data1.exists()) {
                fis1 = new FileInputStream("/home/ace/PCT_315/TropiCabinas/src/dbConfig.properties");
                props.load(fis1);
                //Cargar la Tipo de Controlador
                Class.forName(props.getProperty("DB_DRIVER_CLASS"));
// Crea la conexión ahora
                con = DriverManager.getConnection(props.getProperty("DB_URL"),
                        props.getProperty("DB_USERNAME"),
                        props.getProperty("DB_PASSWORD"));
            }
        } catch (HeadlessException | IOException | ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return con;
    }
}
