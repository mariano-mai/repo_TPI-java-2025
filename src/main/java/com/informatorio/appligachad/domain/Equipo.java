package com.informatorio.appligachad.domain;

import java.util.List;

public class Equipo {
	
	private String nombre;
	private List<Jugador> jugadores;
	
	public Equipo(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Equipo(String nombre, List<Jugador> jugadores) {
		super();
		this.nombre = nombre;
		this.jugadores = jugadores;
	}

	public String getNombre() {
		return nombre;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}	

}
