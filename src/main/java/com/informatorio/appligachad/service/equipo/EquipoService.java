package com.informatorio.appligachad.service.equipo;

import java.util.List;

import com.informatorio.appligachad.domain.Equipo;
import com.informatorio.appligachad.domain.Jugador;

public interface EquipoService {
	
	Equipo crearEquipo(String nombre);
	
	Equipo crearEquipo(String nombre, List<Jugador> jugadores);
	
	void asignarJugadorAEquipo(Jugador jugador, Equipo equipo);
	
	void transferirJugador(Jugador jugador, Equipo nuevoEquipo);
	
	void mostrarTodos();
	
	void totalDeGoles(Equipo equipo);

}
