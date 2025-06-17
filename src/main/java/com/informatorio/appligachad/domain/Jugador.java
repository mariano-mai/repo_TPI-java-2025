package com.informatorio.appligachad.domain;

public class Jugador {
	
	private String nombre;
	private int edad;
	private int cantidadDeGoles;
	private int minutosJugados;
	private int partidosIngresados;
	private boolean esTitular;
	private Equipo equipo;
	
	public Jugador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Jugador(String nombre, int edad, boolean esTitular) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.esTitular = esTitular;
	}

	public String getNombre() {
		return nombre;
	}

	public int getCantidadDeGoles() {
		return cantidadDeGoles;
	}

	public int getMinutosJugados() {
		return minutosJugados;
	}

	public int getPartidosIngresados() {
		return partidosIngresados;
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

	public void setPartidosIngresadosDesdeBanco(int partidosIngresados) {
		this.partidosIngresados = partidosIngresados;
	}
	
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

}
