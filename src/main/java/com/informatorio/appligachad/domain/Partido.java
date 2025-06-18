package com.informatorio.appligachad.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Partido {
	
	private UUID id;
	private List<Equipo> equipos = new ArrayList<>();
	private String resultado;
	private Map<Jugador, Integer> golesPorJugador = new HashMap<>();
	
	public Partido(UUID id, List<Equipo> equipos) {
		super();
		this.id = id;
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

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
	

}
