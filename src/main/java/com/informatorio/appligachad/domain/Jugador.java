package com.informatorio.appligachad.domain;

import java.util.List;

public class Jugador {
	
	private String nombre;
	private String apellido;
	private int edad;
	private int cantidadDeGoles;
	private int minutosJugados;
	private List<Partido> partidosIngresadosDesdeBanco;
	private boolean esTitular;
	private Equipo equipo;
	
	public Jugador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Jugador(String nombre, String apellido, int edad, boolean esTitular) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.esTitular = esTitular;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getCantidadDeGoles() {
		return cantidadDeGoles;
	}

	public int getMinutosJugados() {
		return minutosJugados;
	}

	public List<Partido> getPartidosIngresadosDesdeBanco() {
		return partidosIngresadosDesdeBanco;
	}

	public boolean isEsTitular() {
		return esTitular;
	}

	public int getEdad() {
		return edad;
	}
	
	public Equipo getEquipo() {
		return equipo;
	}

	public void setCantidadDeGoles(int cantidadDeGoles) {
		this.cantidadDeGoles = cantidadDeGoles;
	}

	public void setMinutosJugados(int minutosJugados) {
		this.minutosJugados = minutosJugados;
	}

	public void setPartidosIngresadosDesdeBanco(List<Partido> partidosIngresadosDesdeBanco) {
		this.partidosIngresadosDesdeBanco = partidosIngresadosDesdeBanco;
	}	

}
