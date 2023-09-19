package com.alura.hotel.principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CerrandoConeccion {

	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/hotel_alura?useTimeZone=true&serverTimeZone=UTC");
		
		System.out.println("Cerrando conección");
		connection.close();
	}
}
