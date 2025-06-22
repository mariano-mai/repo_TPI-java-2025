package com.informatorio.appligachad.utils.busqueda.equipo;

import com.informatorio.appligachad.domain.Equipo;
import com.informatorio.appligachad.domain.Jugador;

public interface BuscarEquipoInt {
	
	Equipo buscar();
	
	Equipo buscar(Jugador jugador);

}
