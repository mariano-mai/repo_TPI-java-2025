package com.informatorio.appligachad.service.menu.impl.mostrarinfo;

import com.informatorio.appligachad.input.IngresoPorTeclado;
import com.informatorio.appligachad.service.equipo.EquipoService;
import com.informatorio.appligachad.service.equipo.impl.EquipoServiceImpl;
import com.informatorio.appligachad.service.menu.MenuService;
import com.informatorio.appligachad.service.menu.impl.mostrarinfo.jugadoresinfo.MenuJugadoresInfoImpl;

public class MenuServiceMostrarInfoImpl implements MenuService{
	
	public static MenuService menuInfo = new MenuServiceMostrarInfoImpl();
	
	private EquipoService equipoService = new EquipoServiceImpl();

	@Override
	public void mostrarMenu() {
		int condicion;
		do {
			System.out.println("seleccione una opción:");
			System.out.println("1- JUGADORES\n2- EQUIPOS\n3- REPORTES\n4- Volver");
			condicion=IngresoPorTeclado.ingresarEnteroPositivo();
			ejecutarOpciones(condicion);
		}while(condicion!=4);
		
	}
	
	private void ejecutarOpciones(int condicion) {
		switch(condicion) {
		case 1:
			System.out.println("Menú de información de jugadores.");
			MenuJugadoresInfoImpl.menuJugadores.mostrarMenu();
			break;
		case 2:
			System.out.println("Equipos ordenados por cantidad de goles.");
			equipoService.mostrarTodos();
			break;
		case 3:
			System.out.println("reportes.");
			break;
		default:
			
		}
	}

}
