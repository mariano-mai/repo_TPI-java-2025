package com.informatorio.appligachad.service.menu.impl.ingresarinfo;

import com.informatorio.appligachad.domain.Equipo;
import com.informatorio.appligachad.domain.Jugador;
import com.informatorio.appligachad.domain.Partido;
import com.informatorio.appligachad.input.IngresoPorTeclado;
import com.informatorio.appligachad.service.jugador.JugadorService;
import com.informatorio.appligachad.service.jugador.impl.JugadorServiceImpl;
import com.informatorio.appligachad.service.menu.MenuService;
import com.informatorio.appligachad.utils.busqueda.equipo.BuscarEquipoInt;
import com.informatorio.appligachad.utils.busqueda.equipo.impl.BuscarEquipoIntImpl;
import com.informatorio.appligachad.utils.busqueda.jugador.BuscarJugadorInt;
import com.informatorio.appligachad.utils.busqueda.jugador.impl.BuscarJugadorIntImpl;
import com.informatorio.appligachad.utils.busqueda.partido.BuscarPartidoInt;
import com.informatorio.appligachad.utils.busqueda.partido.impl.BuscarPartidoIntImpl;

public class MenuServiceIngresarInformacionImpl implements MenuService{
	
	public static MenuService menuIngresar = new MenuServiceIngresarInformacionImpl();
	BuscarPartidoInt buscarPartido = new BuscarPartidoIntImpl();
	BuscarEquipoInt buscarEquipo = new BuscarEquipoIntImpl();
	BuscarJugadorInt buscarJugador = new BuscarJugadorIntImpl();
	JugadorService jugadorService = new JugadorServiceImpl();
	Partido nuevoPartido;
	Equipo nuevoEquipo;
	Jugador nuevoJugador;

	@Override
	public void mostrarMenu() {
		int condicion;
		do {
			nuevoPartido = buscarPartido.buscar();
			if(nuevoPartido==null) {
				condicion = 0;
			}
			System.out.println("Seleccione opción:");
			System.out.println("1- Seleccionar Partido\n0- Volver");
			condicion = IngresoPorTeclado.ingresarEnteroPositivo();
			ejecutarOpciones(condicion);
		}while(condicion!=0);
	}
	
	private void ejecutarOpciones(int condicion) {
		switch(condicion) {
		case 1:
			nuevoPartido = buscarPartido.buscar();
			if(nuevoPartido==null) {
				break;
			}else {
				nuevoEquipo = buscarEquipo.buscar(nuevoPartido);
				if(nuevoEquipo==null) {
					break;
				}else {
					nuevoJugador = buscarJugador.buscar(nuevoEquipo);
					if(nuevoJugador==null) {
						break;
					}
				}
			}
			jugadorService.agregarDatos(nuevoJugador);
			break;
		default:
		}
	}

}
