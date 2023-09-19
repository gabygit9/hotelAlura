package com.alura.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.alura.hotel.modelo.Huesped;

public class HuespedDAO {
	
	private Connection con;
	
	public HuespedDAO(Connection con) {
		this.con = con;
	}
	
	public void guardarHuesped(Huesped huesped) throws SQLException{
		String sql = "INSERT INTO huesped(nombre, apellido, fecha_nacimiento, nacionalidad, telefono) VALUES(?,?,?,?,?)";
		
		try(PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			pst.setString(1, huesped.getNombre());
			pst.setString(2, huesped.getApellido());
			pst.setDate(3, huesped.getFecha_nacimiento());
			pst.setString(4, huesped.getNacionalidad());
			pst.setString(5, huesped.getTelefono());
			
			pst.execute();
			
			try(ResultSet rst = pst.getGeneratedKeys()){
				while(rst.next()) {
					huesped.setId(rst.getInt(1));
				}
			}
		}	
	}
	
	public List<Huesped> listarHuespedes() throws SQLException{
		String sql = "SELECT * FROM huesped";
		List<Huesped> listaHuespedes = new ArrayList<Huesped>();
		
		try(PreparedStatement pst = con.prepareStatement(sql)){
			ResultSet rst = pst.executeQuery();
			
			while(rst.next()) {
				Huesped huesped = new Huesped(rst.getInt("id"), rst.getString("nombre"), rst.getString("apellido"),
						rst.getDate("fecha_nacimiento"), rst.getString("nacionalidad"), rst.getString("telefono"));
				listaHuespedes.add(huesped);
			}
		}
		return listaHuespedes;
	}
	
	public List<Huesped> listarHuespedPorNombre(String nombre) throws SQLException{
		String sql = "SELECT * FROM huesped WHERE nombre=?";
		List<Huesped> listaHuespedes = new ArrayList<Huesped>();
		
		try(PreparedStatement pst = con.prepareStatement(sql)){
			pst.setString(1, nombre);
			
			ResultSet rst = pst.executeQuery();
			
			while(rst.next()) {
				Huesped huesped = new Huesped(rst.getInt("id"), rst.getString("nombre"), rst.getString("apellido"),
						rst.getDate("fecha_nacimiento"), rst.getString("nacionalidad"), rst.getString("telefono"));
				listaHuespedes.add(huesped);
			}
		}
		return listaHuespedes;
	}
}
