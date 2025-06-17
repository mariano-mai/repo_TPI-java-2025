package com.informatorio.appligachad.service.menu.impl.mostrarinfo.jugadoresinfo;

import com.informatorio.appligachad.input.IngresoPorTeclado;
import com.informatorio.appligachad.service.jugador.JugadorService;
import com.informatorio.appligachad.service.jugador.impl.JugadorServiceImpl;
import com.informatorio.appligachad.service.menu.MenuService;

public class MenuJugadoresInfoImpl implements MenuService{
	
	public static MenuService menuJugadores = new MenuJugadoresInfoImpl();
	
	private JugadorService jugadorService = new JugadorServiceImpl();

	@Override
	public void mostrarMenu() {
		int condicion;
		do {
			System.out.println("seleccione una opción:");
			System.out.println("1- Ver todos los jugadores.\n2- Ver jugadores titulares.\n3- Ver jugadores suplentes.\n4- Goleador de la liga.\n5- Volver");
			condicion=IngresoPorTeclado.ingresarEnteroPositivo();
			ejecutarOpciones(condicion);
		}while(condicion!=5);
		
	}
	
	private void ejecutarOpciones(int condicion) {
		switch(condicion) {
		case 1:
			System.out.println("Lista de todos los jugadores ordenados alfabéticamente. Acá se genera el .csv");
			jugadorService.mostrarTodos();
			break;
		case 2:
			System.out.println("Lista de los titulares ordenados por minutos jugados.");
			jugadorService.mostrarTitulares();
			break;
		case 3:
			System.out.println("Lista de suplentes ordenados por cantidad de partidos jugados.");
			jugadorService.mostrarSuplentes();
			break;
		case 4:
			System.out.println("cartel con información del goleador de la liga.");
			break;
		default:
			
		}
	}

}
