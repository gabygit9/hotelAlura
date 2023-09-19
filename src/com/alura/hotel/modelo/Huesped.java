package com.alura.hotel.modelo;

import java.sql.Date;

public class Huesped {
	private Integer id;
	private String nombre;
	private String apellido;
	private Date fecha_nacimiento;
	private String nacionalidad;
	private String telefono;
	
	public Huesped(Integer id, String nombre, String apellido, Date fecha_nacimiento, String nacionalidad, String telefono) {
		this.id=id;
		this.nombre=nombre;
		this.apellido=apellido;
		this.fecha_nacimiento=fecha_nacimiento;
		this.nacionalidad=nacionalidad;
		this.telefono=telefono;
	}
	
	public Huesped(String nombre, String apellido, Date fecha_nacimiento, String nacionalidad, String telefono) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.fecha_nacimiento=fecha_nacimiento;
		this.nacionalidad=nacionalidad;
		this.telefono=telefono;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	@Override
	public String toString() {
		return "Huesped [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", fecha_nacimiento="
				+ fecha_nacimiento + ", nacionalidad=" + nacionalidad + ", telefono=" + telefono + "]";
	}
}
