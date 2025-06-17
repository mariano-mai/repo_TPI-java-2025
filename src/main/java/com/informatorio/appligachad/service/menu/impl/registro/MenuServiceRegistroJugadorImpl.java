package com.informatorio.appligachad.service.menu.impl.registro;

import com.informatorio.appligachad.database.domaindb.JugadorDB;
import com.informatorio.appligachad.domain.Jugador;
import com.informatorio.appligachad.input.IngresoPorTeclado;
import com.informatorio.appligachad.service.equipo.EquipoService;
import com.informatorio.appligachad.service.equipo.impl.EquipoServiceImpl;
import com.informatorio.appligachad.service.jugador.JugadorService;
import com.informatorio.appligachad.service.jugador.impl.JugadorServiceImpl;
import com.informatorio.appligachad.service.menu.MenuService;
import com.informatorio.appligachad.utils.busqueda.equipo.BuscarEquipoInt;
import com.informatorio.appligachad.utils.busqueda.jugador.BuscarJugadorInt;

public class MenuServiceRegistroJugadorImpl implements MenuService{
	
	public static MenuService registroJugador = new MenuServiceRegistroJugadorImpl();
	
	private JugadorService jugadorService = new JugadorServiceImpl();
	private EquipoService equipoService = new EquipoServiceImpl();
	private BuscarEquipoInt buscarEquipo;
	private BuscarJugadorInt buscarJugador;

	@Override
	public void mostrarMenu() {
		int condicion;
		do {
			System.out.println("Seleccione opción:");
			System.out.println("1- NUEVO JUGADOR\n2- ASIGNAR JUGADOR A UN EQUIPO\n3- TRANSFERIR JUGADOR\n4- Volver");
			condicion = IngresoPorTeclado.ingresarEnteroPositivo();
			ejecutarOpciones(condicion);
		}while(condicion!=4);
		
	}
	
	private void ejecutarOpciones(int condicion) {
		
		switch(condicion) {
		case 1:
			Jugador newJugador = jugadorService.crearJugadorV2();
			JugadorDB.jugadoresMapDB.put(newJugador.getNombre(), newJugador);
			break;
		case 2:
			System.out.println("se está ejecutando la opción de registrar jugador.\n");
			equipoService.asignarJugadorAEquipo(buscarEquipo.buscar(), buscarJugador.buscar());
			break;
		case 3:
			System.out.println("se está ejecutando la opción de registrar partido.\n");
			equipoService.transferirJugador(buscarJugador.buscar(), buscarEquipo.buscar());
			break;
		default:
		}
		
	}

}
