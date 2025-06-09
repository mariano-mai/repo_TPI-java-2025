package com.informatorio.appligachad.domain;

import java.util.List;
import java.util.Map;

public class Partido {
	
	private List<Equipo> equipos;
	private String resultado;
	private Map<Jugador, Integer> golesPorJugador;
	
	public Partido(List<Equipo> equipos) {
		super();
		this.equipos = equipos;
	}

	public List<Equipo> getEquipos() {
		return equipos;
	}

	public String getResultado() {
		return resultado;
	}

	public Map<Jugador, Integer> getGolesPorJugador() {
		return golesPorJugador;
	}

	public void setGolesPorJugador(Map<Jugador, Integer> golesPorJugador) {
		this.golesPorJugador = golesPorJugador;
	}
	
	

}
