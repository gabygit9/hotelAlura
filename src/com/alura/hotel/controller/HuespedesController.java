package com.alura.hotel.controller;

import java.sql.Connection;
import java.sql.SQLException;

import com.alura.hotel.dao.HuespedDAO;
import com.alura.hotel.modelo.Huesped;
import com.alura.hotel.principal.ConnectionFactory;

public class HuespedesController {
	private HuespedDAO huespedDAO;
	
	public HuespedesController() throws SQLException{
		ConnectionFactory con = new ConnectionFactory();
		Connection connection = con.estableConeccion();
		this.huespedDAO = new HuespedDAO(connection);
	}
	
	public void guardar(Huesped huespedes) throws SQLException {
		this.huespedDAO.guardarHuesped(huespedes);
	}
}
