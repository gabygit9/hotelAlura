package com.alura.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.alura.hotel.modelo.Reserva;

public class ReservaDAO {
	private Connection con;

	public ReservaDAO(Connection con) {
		this.con = con;
	}
	
	public void guardarReserva(Reserva reserva) throws SQLException{
		String sql = "INSERT INTO reserva (fecha_entrada, fecha_salida, valor, forma_pago) VALUES(?,?,?,?)";
		try (PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			pst.setDate(1, reserva.getFecha_entrada());
			pst.setDate(2, reserva.getFecha_salida());
			pst.setInt(3, reserva.getValor());
			pst.setString(4, reserva.getForma_pago());
			
			pst.execute();
			
			try(ResultSet rst = pst.getGeneratedKeys()){
				while(rst.next()) {
					reserva.setId(rst.getInt(1));
				}
			}
		}
	}
	
	public List<Reserva> listarReservas() throws SQLException{
		String sql = "SELECT * FROM reserva";
		List<Reserva> listaReservas = new ArrayList<Reserva>();
		
		try(PreparedStatement pst = con.prepareStatement(sql, Statement.NO_GENERATED_KEYS)){
			ResultSet rst = pst.executeQuery();
			
			while(rst.next()) {
				Reserva reserva = new Reserva(rst.getInt("id"), rst.getDate("fecha_entrada"), rst.getDate("fecha_salida"), rst.getInt("valor"), rst.getString("forma_pago"));
				listaReservas.add(reserva);
			}
		}
		return listaReservas;
	}
	
	public List<Reserva> listarReservasPorNumero(int id) throws SQLException{
		String sql = "SELECT * FROM reserva WHERE id=?";
		List<Reserva> listaReservas = new ArrayList<Reserva>();
		
		try(PreparedStatement pst = con.prepareStatement(sql)){
			pst.setInt(1, id);
			ResultSet rst = pst.executeQuery();
			
			while(rst.next()) {
				Reserva reserva = new Reserva(rst.getInt("id"), rst.getDate("fecha_entrada"), rst.getDate("fecha_salida"), rst.getInt("valor"), rst.getString("forma_pago"));
				listaReservas.add(reserva);
			}
		}
		return listaReservas;
	}
}
