package com.informatorio.appligachad.service.menu.impl.registro;

import com.informatorio.appligachad.database.domaindb.JugadorDB;
import com.informatorio.appligachad.domain.Equipo;
import com.informatorio.appligachad.domain.Jugador;
import com.informatorio.appligachad.input.IngresoPorTeclado;
import com.informatorio.appligachad.service.equipo.EquipoService;
import com.informatorio.appligachad.service.equipo.impl.EquipoServiceImpl;
import com.informatorio.appligachad.service.jugador.JugadorService;
import com.informatorio.appligachad.service.jugador.impl.JugadorServiceImpl;
import com.informatorio.appligachad.service.menu.MenuService;
import com.informatorio.appligachad.utils.busqueda.equipo.BuscarEquipoInt;
import com.informatorio.appligachad.utils.busqueda.equipo.impl.BuscarEquipoIntImpl;
import com.informatorio.appligachad.utils.busqueda.jugador.BuscarJugadorInt;
import com.informatorio.appligachad.utils.busqueda.jugador.impl.BuscarJugadorIntImpl;

public class MenuServiceRegistroJugadorImpl implements MenuService{
	
	public static MenuService registroJugador = new MenuServiceRegistroJugadorImpl();
	
	Equipo nuevoEquipo;
	Jugador nuevoJugador;
	
	private JugadorService jugadorService = new JugadorServiceImpl();
	private EquipoService equipoService = new EquipoServiceImpl();
	private BuscarEquipoInt buscarEquipo = new BuscarEquipoIntImpl();
	private BuscarJugadorInt buscarJugador = new BuscarJugadorIntImpl();

	@Override
	public void mostrarMenu() {
		int condicion;
		do {
			System.out.println("Seleccione opción:");
			System.out.println("1- NUEVO JUGADOR\n2- ASIGNAR JUGADOR A UN EQUIPO\n3- CAMBIAR TITULARIDAD\n4- TRANSFERIR JUGADOR\n5- Volver");
			condicion = IngresoPorTeclado.ingresarEnteroPositivo();
			ejecutarOpciones(condicion);
		}while(condicion!=5);
		
	}
	
	private void ejecutarOpciones(int condicion) {
		
		switch(condicion) {
		case 1:
			System.out.println("\nAquí puede registrar un nuevo jugador.\n");
			Jugador newJugador = jugadorService.crearJugadorV2();
			JugadorDB.jugadoresMapDB.put(newJugador.getNombre(), newJugador);
			break;
		case 2:
			System.out.println("\nAquí puede asignar un jugador a un equipo.\n");
			nuevoEquipo = buscarEquipo.buscar();
			if(nuevoEquipo==null) {
				break;
			}else {
				nuevoJugador = buscarJugador.buscar();
				if(nuevoJugador==null) {
					break;
				}else {
					equipoService.asignarJugadorAEquipo(nuevoJugador, nuevoEquipo);
				}
			}
			break;
		case 3:
			System.out.println("\nAquí se puede cambiar la titularidad de un jugador.\n");
			nuevoEquipo = buscarEquipo.buscar();
			if(nuevoEquipo==null) {
				break;
			}else {
				int contador = 0;
				for(Jugador jugador : nuevoEquipo.getJugadores()) {
					if(jugador.isEsTitular()) {
						contador++;
					}
				}
				nuevoJugador = buscarJugador.buscar(nuevoEquipo);
				if(nuevoJugador==null) {
					break;
				}else {
					boolean esTitular = nuevoJugador.isEsTitular();
					if(!esTitular && contador==11) {
						System.out.println("No puede haber más de 11 titulares en el equipo."
								+ "\nPrimero cambie un jugador titular a suplente.");
					}else {
						nuevoJugador.setEsTitular(!esTitular);
						String estadoAnterior = nuevoJugador.isEsTitular()?"TITULAR":"SUPLENTE";
						String estadoActual = nuevoJugador.isEsTitular()?"SUPLENTE":"TITULAR";
						System.out.println("El jugador "+nuevoJugador.getNombre()+" pasó de ser "+
								estadoAnterior+" a ser "+estadoActual+".");
					}
				}
			}
			break;
		case 4:
			System.out.println("\nAquí se puede transferir un jugador de un equipo a otro.\n");
			nuevoJugador = buscarJugador.buscar();
			if(nuevoJugador==null) {
				break;
			}else {
				Equipo nuevoEquipo2 = buscarEquipo.buscar(nuevoJugador);
				if(nuevoEquipo==null) {
					break;
				}else {
					equipoService.transferirJugador(nuevoJugador, nuevoEquipo2);
				}
			}
			break;
		default:
		}
		
	}

}
