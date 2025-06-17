package com.informatorio.appligachad.service.menu.impl.registro;

import com.informatorio.appligachad.database.domaindb.EquipoDB;
import com.informatorio.appligachad.database.domaindb.PartidoDB;
import com.informatorio.appligachad.domain.Equipo;
import com.informatorio.appligachad.domain.Partido;
import com.informatorio.appligachad.input.IngresoPorTeclado;
import com.informatorio.appligachad.service.equipo.EquipoService;
import com.informatorio.appligachad.service.menu.MenuService;
import com.informatorio.appligachad.service.partido.PartidoService;

public class MenuServiceRegistrarImpl implements MenuService{
	
	public static MenuService menuRegistro = new MenuServiceRegistrarImpl();
	
	private EquipoService equipoService;
	private PartidoService partidoService;

	@Override
	public void mostrarMenu() {
		int condicion;
		do {
			System.out.println("Seleccione opción:");
			System.out.println("1- REGISTRAR EQUIPO\n2- REGISTRAR JUGADOR\n3- REGISTRAR PARTIDO\n4- Volver");
			condicion = IngresoPorTeclado.ingresarEnteroPositivo();
			ejecutarOpciones(condicion);
		}while(condicion!=4);
		
	}
	
	private void ejecutarOpciones(int condicion) {		
		
		switch(condicion) {
		case 1:
			System.out.println("\nRegistro de Equipo sin Jugadores.\n\nIngrese nombre del Equipo:");
			Equipo newEquipo = equipoService.crearEquipo(IngresoPorTeclado.ingresarTexto().toUpperCase());
			EquipoDB.equiposMapDB.put(newEquipo.getNombre(), newEquipo);
			break;
		case 2:
			System.out.println("\nRegistro de Jugadores\n");
			MenuServiceRegistroJugadorImpl.registroJugador.mostrarMenu();
			break;
		case 3:
			System.out.println("se está ejecutando la opción de registrar partido.\n");
			Partido newPartido = partidoService.crearPartido();
			PartidoDB.partidoMapDB.put(newPartido.getId(), newPartido);
			break;
		default:
		
		}
	
	}

}
