package com.informatorio.appligachad.service.jugador.impl;

import java.util.ArrayList;
import java.util.List;

import com.informatorio.appligachad.domain.Jugador;
import com.informatorio.appligachad.service.jugador.JugadorService;

public class JugadorServiceImpl implements JugadorService{

	@Override
	public Jugador crearJugador() {
		Jugador jugador = new Jugador();
		return jugador;
	}

	@Override
	public Jugador crearJugador(String nombre, String apellido, int edad, boolean esTitular) {
		Jugador jugador = new Jugador(nombre, apellido, edad, esTitular);
		return jugador;
	}

}
