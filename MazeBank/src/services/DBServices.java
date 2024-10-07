package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.User;

public class DBServices {
	
	public boolean userRegister(User user) throws SQLException {
		String select = "INSERT INTO users (nombre, correo, contrasena, telefono, saldo) VALUES (?, ?, ?, ?, ?)";
		
		Connection conn = DbConnection.getConnection();
		PreparedStatement statement = conn.prepareStatement(select);
		
		statement.setString(1, user.getUsername());
		statement.setString(2, user.getEmail());
		statement.setString(3, user.getPassword());
		statement.setString(4, user.getPhone());
		statement.setDouble(5, user.getMoney());
		
		int rowInserted = statement.executeUpdate();
		return rowInserted > 0;
	}

}
