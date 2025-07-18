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
import com.informatorio.appligachad.utils.busqueda.equipo.BuscarEquipoInt;
import com.informatorio.appligachad.utils.busqueda.equipo.impl.BuscarEquipoIntImpl;
import com.informatorio.appligachad.utils.busqueda.jugador.BuscarJugadorInt;
import com.informatorio.appligachad.utils.busqueda.jugador.impl.BuscarJugadorIntImpl;

public class EquipoServiceImpl implements EquipoService{
	
	Jugador nuevoJugador;
	Equipo nuevoEquipo;
	Equipo equipoOriginal;
	int ubicacion;
	
	BuscarJugadorInt buscarJugador = new BuscarJugadorIntImpl();
	BuscarEquipoInt buscarEquipo = new BuscarEquipoIntImpl();

	@Override
	public Equipo crearEquipo(String nombre) {
		Equipo equipo = new Equipo(nombre);
		return equipo;
	}

	@Override
	public Equipo crearEquipo(String nombre, List<Jugador> jugadores) {
		nuevoEquipo = new Equipo(nombre, jugadores);
		for(Jugador jugador : jugadores) {
			jugador.setEquipo(nuevoEquipo);
		}
		return nuevoEquipo;
	}

	@Override
	public void asignarJugadorAEquipo(Jugador jugador, Equipo equipo) {
		
		int contador = 0;
		for(Jugador jugador1 : equipo.getJugadores()) {
			if(jugador1.isEsTitular()) {
				contador++;
			}
		}
		if(!jugador.isEsTitular()) {
			equipo.getJugadores().add(jugador);
			jugador.setEquipo(equipo);
			System.out.println("Jugador "+jugador.getNombre()+" asignado con éxito al equipo "+equipo.getNombre());
			System.out.println("Cantidad de jugadores en el equipo: "+equipo.getJugadores().size());
		}else {
			if(contador<11) {
				equipo.getJugadores().add(jugador);
				jugador.setEquipo(equipo);
				System.out.println("Jugador "+jugador.getNombre()+" asignado con éxito al equipo "+equipo.getNombre());
				System.out.println("Cantidad de jugadores en el equipo: "+equipo.getJugadores().size());
			}else {
				System.out.println("No se pudo asignar al jugador. Se alcanzó el máximo de titulares en este equipo");
			}
		}
		
	}

	@Override
	public void transferirJugador(Jugador jugador, Equipo nuevoEquipo) {
		equipoOriginal = jugador.getEquipo();
		ubicacion = equipoOriginal.getJugadores().indexOf(jugador);
		if(equipoOriginal.equals(nuevoEquipo)) {
			System.out.println("No se pudo realizar la transferencia.\n");
		}else {
			nuevoEquipo.getJugadores().add(jugador);
			equipoOriginal.getJugadores().remove(ubicacion);
			jugador.setEquipo(nuevoEquipo);
			System.out.println("Jugador "+jugador.getNombre()+" transferido del equipo "+equipoOriginal.getNombre()+
					" al equipo "+jugador.getEquipo().getNombre()+" de manera exitosa.\n");
		}
		
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

	@Override
	public void totalDeGoles(Equipo equipo) {
		int goles = 0;
		for(Jugador jugador : equipo.getJugadores()) {
			goles+=jugador.getCantidadDeGoles();
		}
		equipo.setCantidadDeGoles(goles);
		
	}

}
