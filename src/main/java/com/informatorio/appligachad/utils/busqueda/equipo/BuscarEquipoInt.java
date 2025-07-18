package com.informatorio.appligachad.utils.busqueda.equipo;

import com.informatorio.appligachad.domain.Equipo;
import com.informatorio.appligachad.domain.Jugador;
import com.informatorio.appligachad.domain.Partido;

public interface BuscarEquipoInt {
	
	Equipo buscar();
	
	Equipo buscar(Jugador jugador);
	
	Equipo buscar(Partido partido);

}
