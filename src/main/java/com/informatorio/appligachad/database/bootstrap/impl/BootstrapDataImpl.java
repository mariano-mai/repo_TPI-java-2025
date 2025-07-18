package com.informatorio.appligachad.database.bootstrap.impl;

import java.util.ArrayList;
import java.util.List;

import com.informatorio.appligachad.database.bootstrap.BootstrapData;
import com.informatorio.appligachad.database.domaindb.EquipoDB;
import com.informatorio.appligachad.database.domaindb.JugadorDB;
import com.informatorio.appligachad.domain.Equipo;
import com.informatorio.appligachad.domain.Jugador;
import com.informatorio.appligachad.service.equipo.EquipoService;
import com.informatorio.appligachad.service.equipo.impl.EquipoServiceImpl;
import com.informatorio.appligachad.service.jugador.JugadorService;
import com.informatorio.appligachad.service.jugador.impl.JugadorServiceImpl;
import com.informatorio.appligachad.utils.generadordevalores.impl.GeneradorDeNumerosImpl;

public class BootstrapDataImpl implements BootstrapData{
	
	public static BootstrapData bootstrap = new BootstrapDataImpl();
	
	EquipoService equipoService = new EquipoServiceImpl();
	JugadorService jugadorService = new JugadorServiceImpl();
	
	Equipo nuevoEquipo;
	Jugador nuevoJugador;
	List<Jugador> listaDeJugadores;
	List<Jugador> nuevaLista;
	String nombreDeEquipo;
	String nombreDeJugador;
	int edad;

	@Override
	public void crearEquipos() {
		for(int i=0; i<7; i++) {
			nombreDeEquipo = BootstrapData.NOMBRES_DE_EQUIPO[GeneradorDeNumerosImpl.generador.numeroEnteroAlAzar(0, 49)];
			listaDeJugadores = crearListaDeJugadores();
			nuevoEquipo = equipoService.crearEquipo(nombreDeEquipo, listaDeJugadores);
			EquipoDB.equiposMapDB.put(nuevoEquipo.getNombre(), nuevoEquipo);
		}
	}
	
	private List<Jugador> crearListaDeJugadores(){
		nuevaLista = new ArrayList<>();
		for(int i=0; i<11; i++) {
			nombreDeJugador = BootstrapData.APELLIDOS_DE_JUGADORES[GeneradorDeNumerosImpl.generador.numeroEnteroAlAzar(0, 94)]+
					", "+BootstrapData.NOMBRES_DE_JUGADORES[GeneradorDeNumerosImpl.generador.numeroEnteroAlAzar(0, 99)];
			edad = GeneradorDeNumerosImpl.generador.numeroEnteroAlAzar(20, 35);
			nuevoJugador = jugadorService.crearJugador(nombreDeJugador, edad, true);
			JugadorDB.jugadoresMapDB.put(nuevoJugador.getNombre(), nuevoJugador);
			nuevaLista.add(nuevoJugador);
		}
		
		for(int i=0; i<4; i++) {
			nombreDeJugador = BootstrapData.APELLIDOS_DE_JUGADORES[GeneradorDeNumerosImpl.generador.numeroEnteroAlAzar(0, 94)]+
					", "+BootstrapData.NOMBRES_DE_JUGADORES[GeneradorDeNumerosImpl.generador.numeroEnteroAlAzar(0, 99)];
			edad = GeneradorDeNumerosImpl.generador.numeroEnteroAlAzar(20, 35);
			nuevoJugador = jugadorService.crearJugador(nombreDeJugador, edad, false);
			JugadorDB.jugadoresMapDB.put(nuevoJugador.getNombre(), nuevoJugador);
			nuevaLista.add(nuevoJugador);
		}
		return nuevaLista;
	}

}
