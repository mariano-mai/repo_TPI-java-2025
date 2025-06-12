package com.informatorio.appligachad.service.jugador.impl;

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
		Jugador jugador = new Jugador(nombre, apellido, edad, esTitular);
		return jugador;
	}

	@Override
	public Jugador crearJugadorV2() {
		System.out.println("Ingrese nombre del jugador:");
		String nombre = IngresoPorTeclado.ingresarTexto();
		System.out.println("Ingrese apellido del jugador:");
		String apellido = IngresoPorTeclado.ingresarTexto();
		System.out.println("Ingrese edad del jugador:");
		int edad = IngresoPorTeclado.ingresarEnteroPositivo();
		System.out.println("¿Es titular?\n1- SI\n2- NO");
		int opcion = IngresoPorTeclado.ingresarEnteroPositivo();
		boolean esTitular = opcion==1?true:false;
		Jugador nuevoJugador = new Jugador(nombre, apellido, edad, esTitular);
		return nuevoJugador;
	}
	
	

}
