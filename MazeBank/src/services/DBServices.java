package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Contact;
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
	
	//Metodo para devolver un usuario
	
	public static User getUser(String username) throws SQLException {
		String sql = "SELECT * FROM users WHERE nombre = ?";
		Connection conn = DbConnection.getConnection();
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, username);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			String email = rs.getString("correo");
			String telefono = rs.getString("telefono");
			Double saldo = rs.getDouble("saldo");
			String contraseña = rs.getString("contrasena");
			
			return new User(username, email, contraseña, telefono);
		}
		return null;
	}
	
	//Metodo para obtener el ID de un usuario
	
	public static int obtenerUserIdPorNombre(String nombre) {
	    int userId = 0;
	    String query = "SELECT id FROM users WHERE nombre = ?";
	    
	    try (Connection conn = DbConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(query)) {
	        
	        stmt.setString(1, nombre);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                userId = rs.getInt("id"); // Obtiene el ID del usuario
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return userId;
	}

	
	//Metodo que devuelve una lista de contactos
	
	public static List<Contact> getUserContacts(int users_id) throws SQLException {
	    List<Contact> contacts = new ArrayList<>();
	    String query = "SELECT * FROM contacts WHERE users_id = ?";
	    
	    try (Connection conn = DbConnection.getConnection();
	        PreparedStatement statement = conn.prepareStatement(query)) {
	        statement.setInt(1, users_id);
	        ResultSet resultSet = statement.executeQuery();
	        
	        while (resultSet.next()) {
	            Contact contact = new Contact();
	            contact.setNombre(resultSet.getString("nombre"));
	            contact.setApellido(resultSet.getString("apellido"));
	            contact.setTelefono(resultSet.getString("telefono"));
	            contacts.add(contact);
	        }
	    }
	    
	    return contacts;
	}
	
	//Metodo para añadir un nuevo contacto
	
	public static boolean insertarContacto(int userId, String nombre, String apellido, String telefono) {
	    String query = "INSERT INTO contacts (users_id, nombre, apellido, telefono) VALUES (?, ?, ?, ?)";
	    
	    try (Connection conn = DbConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(query)) {
	        
	        stmt.setInt(1, userId); // Aquí usas el userId obtenido
	        stmt.setString(2, nombre);
	        stmt.setString(3, apellido);
	        stmt.setString(4, telefono);
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return true;
	}



}
