package com.informatorio.appligachad.service.equipo.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.informatorio.appligachad.database.domaindb.EquipoDB;
import com.informatorio.appligachad.domain.Equipo;
import com.informatorio.appligachad.domain.Jugador;
import com.informatorio.appligachad.service.equipo.EquipoService;

public class EquipoServiceImpl implements EquipoService{

	@Override
	public Equipo crearEquipo(String nombre) {
		Equipo equipo = new Equipo(nombre);
		return equipo;
	}

	@Override
	public Equipo crearEquipo(String nombre, List<Jugador> jugadores) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void asignarJugadorAEquipo(Equipo equipo, Jugador jugador) {
		Equipo newEquipo = new Equipo();
		Jugador newJugador = new Jugador();
		int contador = 0;
		for(Jugador jugador1 : newEquipo.getJugadores()) {
			if(jugador1.isEsTitular()) {
				contador++;
			}
		}
		if(!newJugador.isEsTitular()) {
			newEquipo.getJugadores().add(newJugador);
			newJugador.setEquipo(newEquipo);
		}else {
			if(contador<11) {
				newEquipo.getJugadores().add(newJugador);
				newJugador.setEquipo(newEquipo);
				
			}else {
				System.out.println("Se llegó al límite de titulares.");
			}
		}
		
	}

	@Override
	public void transferirJugador(Jugador jugador, Equipo nuevoEquipo) {
		Jugador nuevoJugador = jugador;
		int ubicacion = jugador.getEquipo().getJugadores().indexOf(jugador);
		System.out.println(ubicacion);
		jugador.getEquipo().getJugadores().remove(ubicacion);
		nuevoEquipo.getJugadores().add(nuevoJugador);
	}

	@Override
	public void mostrarTodos() {
		System.out.println("\nLista de Equipos de la liga GigaChad");
		System.out.printf("%-40s%-30s%n", "NOMBRE","CANTIDAD DE GOLES");
		for(Equipo equipo : listadoDeEquipos(EquipoDB.equiposMapDB)) {
			System.out.printf("%-40s%-30d%n",
					equipo.getNombre(),
					equipo.getCantidadDeGoles());
		}
	}
	
	private List<Equipo> listadoDeEquipos(Map<String, Equipo> equipos){
		List<Equipo> listaGamma = new ArrayList<>();
		for(Map.Entry<String, Equipo> equipo1 : equipos.entrySet()) {
			listaGamma.add(equipo1.getValue());
		}
		Collections.sort(listaGamma, Comparator.comparingInt(equipo->equipo.getCantidadDeGoles()));
		Collections.reverse(listaGamma);
		return listaGamma;
	}

}
