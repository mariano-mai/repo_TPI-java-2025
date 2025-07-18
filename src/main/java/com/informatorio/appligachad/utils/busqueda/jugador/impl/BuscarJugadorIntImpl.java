package com.informatorio.appligachad.utils.busqueda.jugador.impl;

import java.util.HashMap;
import java.util.Map;

import com.informatorio.appligachad.database.domaindb.JugadorDB;
import com.informatorio.appligachad.domain.Equipo;
import com.informatorio.appligachad.domain.Jugador;
import com.informatorio.appligachad.input.IngresoPorTeclado;
import com.informatorio.appligachad.utils.busqueda.jugador.BuscarJugadorInt;

public class BuscarJugadorIntImpl implements BuscarJugadorInt{
	
	Jugador nuevoJugador;
	Map<Integer, Jugador> mapaTemporal;

	@Override
	public Jugador buscar() {
		return buscarJugador(JugadorDB.jugadoresMapDB);
	}

	
	private Jugador buscarJugador(Map<String, Jugador> jugadores) {
		mapaTemporal = new HashMap<>();
		System.out.println("\nSelección de Jugador");
		System.out.println("Ingrese la primer letra del APELLIDO del jugador: ");
		String letra = IngresoPorTeclado.ingresarTexto().toUpperCase();
		int i = 1;
		for(Map.Entry<String, Jugador> jugador1 : jugadores.entrySet()) {
			if(jugador1.getValue().getNombre().startsWith(letra)) {
				mapaTemporal.put(i, jugador1.getValue());
				i++;
			}
		}
		if(i!=1) {
			System.out.println("Seleccione el jugador: ");
			for(Map.Entry<Integer, Jugador> jugador2 : mapaTemporal.entrySet()) {
				System.out.println(jugador2.getKey()+"- "+jugador2.getValue().getNombre());
			}
			int valor = IngresoPorTeclado.ingresarEnteroPositivo();
			nuevoJugador = mapaTemporal.get(valor);
		}else if(i==1) {
			System.out.println("No se encontraron coincidencias.");
			System.out.println("Pruebe con otra inicial o registre un jugador nuevo.\n");
		}
		return nuevoJugador;
	}


	@Override
	public Jugador buscar(Equipo equipo) {
		return buscarJugador(equipo);
	}
	
	private Jugador buscarJugador(Equipo equipo) {
		mapaTemporal = new HashMap<>();
		int i = 1;
		for(Jugador jugador1 : equipo.getJugadores()) {
			mapaTemporal.put(i, jugador1);
			i++;
		}
		if(i!=1) {
			System.out.println("Seleccione el jugador: ");
			for(Map.Entry<Integer, Jugador> jugador2 : mapaTemporal.entrySet()) {
				System.out.println(jugador2.getKey()+"- "+jugador2.getValue().getNombre());
			}
			int valor = IngresoPorTeclado.ingresarEnteroPositivo();
			nuevoJugador = mapaTemporal.get(valor);
		}else if(i==1) {
			System.out.println("Este equipo no tiene jugadores.");
		}
		return nuevoJugador;
	}
	

}
