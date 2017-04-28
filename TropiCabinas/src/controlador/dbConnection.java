/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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
        FileInputStream fis1 = null;
        Connection con = null;

        try {
<<<<<<< HEAD:TropiCabinas/src/controlador/DBConnection.java
            File data1 = new File("C:\\Users\\treznor\\Desktop\\NEW\\PCT_315\\TropiCabinas\\src\\dbConfig.properties");
            File data2 = new File("/home/ace/PCT_315/TropiCabinas/src/dbConfig.properties");
            File data3 = new File("C:\\Users\\treznor\\Desktop\\NEW\\PCT_315\\TropiCabinas\\src\\dbConfig.properties");
            if (!data1.exists()) {
                System.out.println("File 1 doesn't exist");
                System.exit(1);
            } else if (data1.exists()) {
                System.out.println("File 1 exist");
                fis1 = new FileInputStream("C:\\Users\\treznor\\Desktop\\NEW\\PCT_315\\TropiCabinas\\src\\dbConfig.properties");
=======
            File data1 = new File("C:\\Users\\eisne\\PCT_315\\TropiCabinas\\src\\dbConfig.properties");
            if (!data1.exists()) {  
                System.exit(1);
            } else if (data1.exists()) {
                fis1 = new FileInputStream("C:\\Users\\eisne\\PCT_315\\TropiCabinas\\src\\dbConfig.properties");
>>>>>>> develop:TropiCabinas/src/controlador/dbConnection.java
                props.load(fis1);
                // load the Driver Class
                Class.forName(props.getProperty("DB_DRIVER_CLASS"));
                // create the connection now
                con = DriverManager.getConnection(props.getProperty("DB_URL"),
                        props.getProperty("DB_USERNAME"),
                        props.getProperty("DB_PASSWORD"));
            }

        } catch (IOException | ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, e);
        }
        return con;
    }
}
