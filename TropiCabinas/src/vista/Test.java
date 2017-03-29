/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Eisner López Acevedo <eisner.lopez at gmail.com>
 * @author Cesar Gonzalez Salas <cgonzalez816 at gmail.com>
 */
public class Test {
private static final String QUERY = "select * from usuario";

	public static void main(String[] args) {		
		//using try-with-resources to avoid closing resources (boiler plate code)
		try(Connection con = DBConnection.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY)) {	
			
			while(rs.next()){
				int id = rs.getInt("idusuario");
				String name = rs.getString("usuario");
				String email = rs.getString("password");
				String country = rs.getString("colaborador_empleado_id");
				
				System.out.println(id + "," +name+ "," +email+ "," +country);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}