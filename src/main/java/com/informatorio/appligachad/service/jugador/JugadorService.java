package com.informatorio.appligachad.service.jugador;

import com.informatorio.appligachad.domain.Jugador;

public interface JugadorService {
	
	Jugador crearJugador();
	
	Jugador crearJugador(String nombre, String apellido, int edad, boolean esTitular);
	
	Jugador crearJugadorV2();
	
	void mostrarTodos();
	
	void mostrarTitulares();
	
	void mostrarSuplentes();
	
	void goleadorLiga();
	
	void agregarDatos();
	
	void agregarDatos(Jugador jugador1);

}
