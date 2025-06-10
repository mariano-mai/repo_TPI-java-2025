package com.informatorio.appligachad.domain;

import java.util.List;

public class Liga {
	
	private List<Partido> partidos;
	private List<Equipo> equipos;

	public Liga() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Partido> getPartidos() {
		return partidos;
	}
	
	public List<Equipo> getEquipos() {
		return equipos;
	}

	public void setPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}
	
	

}
