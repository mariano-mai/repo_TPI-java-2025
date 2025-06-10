package com.informatorio.appligachad.utils.busqueda.jugador.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.informatorio.appligachad.domain.Jugador;
import com.informatorio.appligachad.input.IngresoPorTeclado;
import com.informatorio.appligachad.utils.busqueda.jugador.BuscarJugadorInt;

public class BuscarJugadorIntImpl implements BuscarJugadorInt{

	@Override
	public Jugador buscar(List<Jugador> jugadores) {
		Map<Integer, Jugador> mapaTemporal = new HashMap<>();
		System.out.println("Ingrese primer letra del apellido del Jugador:");
		String letra = IngresoPorTeclado.ingresarTexto().toUpperCase();
		int i = 1;
		for(Jugador jugador : jugadores) {
			if(jugador.getApellido().startsWith(letra)) {
				mapaTemporal.put(i, jugador);
				i++;
			}
		}
		if(i!=1) {
			System.out.println("Seleccione Jugador:");
			for(Map.Entry<Integer, Jugador> jugador : mapaTemporal.entrySet()) {
				System.out.println(jugador.getKey()+"- "+jugador.getValue().getApellido()+", "+jugador.getValue().getNombre());
			}
		}else if(i==1) {
			System.out.println("No se encontraron coincidencias.");
		}
		if(mapaTemporal.isEmpty()) {
			return null;
		}
		Jugador newJugador = mapaTemporal.get(IngresoPorTeclado.ingresarEnteroPositivo());
		return newJugador;
	}

}
