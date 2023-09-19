package com.alura.hotel.controller;

import java.sql.Connection;
import java.sql.SQLException;

import com.alura.hotel.dao.ReservaDAO;
import com.alura.hotel.modelo.Reserva;
import com.alura.hotel.principal.ConnectionFactory;

public class ReservaController {
	private ReservaDAO reservaDAO;
	
	public ReservaController() throws SQLException{
		ConnectionFactory con = new ConnectionFactory();
		Connection connection = con.estableConeccion();
		this.reservaDAO = new ReservaDAO(connection);
	}
	
	public void guardar(Reserva reserva) throws SQLException{
		this.reservaDAO.guardarReserva(reserva);
	}
}
