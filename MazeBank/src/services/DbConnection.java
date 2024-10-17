package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	private static String url = "jdbc:mysql://127.0.0.1:3306/mazebank?serverTimezone=Europe/Madrid&useSSL=false";
	private static String controllerName = "com.mysql.cj.jdbc.Driver";
	private static String username = "root";
	private static String password = "root";
	
	private static Connection cnx = null;
	
	public static Connection getConnection() throws SQLException {
		if(cnx == null || cnx.isClosed()) {
			try {
				Class.forName(controllerName);
				cnx = DriverManager.getConnection(url, username, password);
			} catch (Exception e) {
				throw new SQLException("No se pudo conectar", e);
			}
		}
		return cnx;
	}
	
	public static void closeConnection() throws SQLException {
		if(cnx !=  null) {
			cnx.close();
		}
	}

}
