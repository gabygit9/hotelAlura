package com.alura.hotel.principal;

import java.sql.Connection;
import java.sql.SQLException;

import com.alura.hotel.dao.ReservaDAO;

public class TestConeccion {
	
	public static void main(String[] args) throws SQLException {
		ConnectionFactory con = new ConnectionFactory();
		Connection connection = con.estableConeccion();
		
		ReservaDAO reservaDAO = new ReservaDAO(connection);
		System.out.println(reservaDAO.listarReservas());
		
		connection.close();
		System.out.println("Cerrando conección");
	}
}
