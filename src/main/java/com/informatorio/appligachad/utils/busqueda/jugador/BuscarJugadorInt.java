package com.informatorio.appligachad.utils.busqueda.jugador;

import com.informatorio.appligachad.domain.Equipo;
import com.informatorio.appligachad.domain.Jugador;

public interface BuscarJugadorInt {
	
	Jugador buscar();
	
	Jugador buscar(Equipo equipo);

}
