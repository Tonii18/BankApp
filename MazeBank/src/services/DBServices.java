package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.User;

public class DBServices {
		
	//Metodo para registrar un nuevo usuario
	
	public static boolean createAccount(User user) throws SQLException {
		boolean created = true;
		
		 String sql = "INSERT INTO users (nombre, correo, contrasena, telefono, saldo) VALUES (?, ?, ?, ?, ?)";
		 Connection conn = DbConnection.getConnection();
		 
		 PreparedStatement ps = conn.prepareStatement(sql);
		 
		 ps.setString(1, user.getUsername());
		 ps.setString(2, user.getEmail());
		 ps.setString(3, user.getPassword());
		 ps.setString(4, user.getPhone());
		 ps.setFloat(5, user.getMoney());
		 
		 int rowsCreated = ps.executeUpdate();
		 
		 return created;
	}
	
	//Metodo para realizar el LogIn de un usuario
	
	public static boolean loginUser(User user) throws SQLException {
		boolean logged = false;
		
		String sql = "SELECT contrasena FROM users WHERE nombre = ?";
		Connection conn = DbConnection.getConnection();
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1,  user.getUsername());
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			String storedPassword = rs.getString("contrasena");
			
			if(user.getPassword().equals(storedPassword)) {
				logged = true;
			}
		}
		return logged;
	}
	
	//Metodo para ingresar dinero
	
	public static boolean depositMoney() {
		
	}
	
	

}
