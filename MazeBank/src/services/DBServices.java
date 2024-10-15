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
		 ps.setDouble(5, user.getMoney());
		 
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
	
	public static boolean depositMoney(User user, double amount) throws SQLException {
		boolean updated = false;
		
		String sql = "UPDATE users SET saldo = saldo + ? where nombre = ?";
		Connection conn = DbConnection.getConnection();
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setDouble(1,  amount);
		ps.setString(2, user.getUsername());
		
		int rowsUpdated = ps.executeUpdate();
		
		updated = true;
		
		return updated;
		
	}
	
	//Metodo para retirar dinero
	
	public static boolean withdrawMoney(User user, double amount) throws SQLException {
		boolean updated = false;
		
		String sql = "UPDATE users SET saldo = saldo - ? WHERE nombre = ?";
		Connection conn = DbConnection.getConnection();
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setDouble(1,  amount);
		ps.setString(2, user.getUsername());
		
		int rowsUpdated = ps.executeUpdate();
		
		updated = true;
		
		return updated;
	}
	
	//Metodo para obtener el saldo actualizado
	
	public static double getCurrentBalance(User user) throws SQLException {
	    String sql = "SELECT saldo FROM users WHERE nombre = ?";
	    Connection conn = DbConnection.getConnection();
	    
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setString(1, user.getUsername());
	    
	    ResultSet rs = ps.executeQuery();
	    if (rs.next()) {
	    	return rs.getDouble("saldo");
	    }
	    
	    return 0; // Devuelve 0 si no se encuentra el usuario
	}
	
	

}
