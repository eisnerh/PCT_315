/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.ConexionDB;
import java.awt.HeadlessException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.Agregar_Usuario_frm;

/**
 *
 * @author ace
 */
public class Agregar_Usuario {
    
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public void AddUser(String User, String Pass)
            
    {
        
        String sqlSelect_Valor = "SELECT `idusuario`, `usuario`, `password`, `colaborador_empleado_id` FROM `usuario` WHERE `usuario` = '";

        String sqlInsert = "INSERT INTO `usuario`(`usuario`, `password`, `colaborador_empleado_id`) VALUES ('";
        
        try {
            int P = JOptionPane.showConfirmDialog(null, " Quiere agregar otro dato ?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (P == 0) {
                con = ConexionDB.conexionDB();
                if ("".equals(User)) {
                    JOptionPane.showMessageDialog(null, "Favor ingresa el usuario ", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if ("".equals(Pass)) {
                    JOptionPane.showMessageDialog(null, "Favor ingresa la Contraseña ", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Statement stmt;
                stmt = con.createStatement();
                String sql1 = sqlSelect_Valor + User + "'";
                rs = stmt.executeQuery(sql1);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Usuario ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
                    User="";
                    
                    return;
                }
                //INSERT INTO `usuario`(`usuario`, `password`, `colaborador_empleado_id`) VALUES ('admin','12345', 1)
                String sql = "INSERT INTO `usuario`(`usuario`, `password`, `colaborador_empleado_id`) VALUES ('" + User+ "', '" + Pass + "','4');";
                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Guardado con Exito saved", "Tipo de Usuario", JOptionPane.INFORMATION_MESSAGE);
                User="";
                

            }
            if (P == 1) {
                String sql = "INSERT INTO `usuario`(`usuario`, `password`, `colaborador_empleado_id`) VALUES ('" + User + "', '" + Pass + "','4');";
                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Guardado con Exito saved", "Tipo de Usuario", JOptionPane.INFORMATION_MESSAGE);
                User="";
            }

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);

        }
    }
    
}
