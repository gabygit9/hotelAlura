package com.alura.hotel.principal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class ConnectionFactory {
	private DataSource dataSource;
	
	public ConnectionFactory (){
		ComboPooledDataSource pooledDataSource = new ComboPooledDataSource();
		pooledDataSource.setJdbcUrl("jdbc:mysql://localhost/hotel_alura?useTimeZone=true&serverTimeZone=UTC");
		pooledDataSource.setUser("root");
		pooledDataSource.setPassword("Gc156605892?");
		
		this.dataSource=pooledDataSource;
	}
	
	public Connection estableConeccion() {
		try {
			return this.dataSource.getConnection();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
