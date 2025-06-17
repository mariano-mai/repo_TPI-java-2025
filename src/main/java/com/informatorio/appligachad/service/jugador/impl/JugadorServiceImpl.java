package com.informatorio.appligachad.service.jugador.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.informatorio.appligachad.database.domaindb.JugadorDB;
import com.informatorio.appligachad.domain.Jugador;
import com.informatorio.appligachad.input.IngresoPorTeclado;
import com.informatorio.appligachad.service.jugador.JugadorService;

public class JugadorServiceImpl implements JugadorService{

	@Override
	public Jugador crearJugador() {
		Jugador jugador = new Jugador();
		return jugador;
	}

	@Override
	public Jugador crearJugador(String nombre, String apellido, int edad, boolean esTitular) {
		Jugador jugador = new Jugador(nombre, edad, esTitular);
		return jugador;
	}

	@Override
	public Jugador crearJugadorV2() {
		String nombre = generarNombreCompleto();
		System.out.println("Ingrese edad del jugador:");
		int edad = IngresoPorTeclado.ingresarEnteroPositivo();
		System.out.println("¿Es titular?\n1- SI\n2- NO");
		int opcion = IngresoPorTeclado.ingresarEnteroPositivo();
		boolean esTitular = opcion==1?true:false;
		Jugador nuevoJugador = new Jugador(nombre, edad, esTitular);
		return nuevoJugador;
	}
	
	private String generarNombreCompleto() {
		System.out.println("Ingrese nombre del jugador:");
		String nombre = IngresoPorTeclado.ingresarTexto();
		System.out.println("Ingrese apellido del jugador:");
		String apellido = IngresoPorTeclado.ingresarTexto().toUpperCase();
		return apellido+", "+nombre;
	}

	@Override
	public void mostrarTodos() {
		System.out.println("\nLista de todos los jugadores de la liga GigaChad:");
		System.out.printf("%-40s%-30s%-30s%-30s%n", "NOMBRE","EDAD","ES TITULAR","CANTIDAD DE GOLES");
		for(Jugador jugador : listadoAlfabeticoDeJugadores(JugadorDB.jugadoresMapDB)) {
			System.out.printf("%-40s%-30d%-30s%-30d%n",
					jugador.getNombre(),
					jugador.getEdad(),
					jugador.isEsTitular()?"SI":"NO",
					jugador.getCantidadDeGoles());
		}
		
	}
	
	private List<Jugador> listadoAlfabeticoDeJugadores(Map<String, Jugador> jugadores){
		List<Jugador> listaAlfa = new ArrayList<>();
		for(Map.Entry<String, Jugador> jugador1 : jugadores.entrySet()) {
			listaAlfa.add(jugador1.getValue());
		}
		return listaAlfa;
	}
	
	

}
