package com.informatorio.appligachad.service.menu.impl.registro;

import com.informatorio.appligachad.database.domaindb.EquipoDB;
import com.informatorio.appligachad.input.IngresoPorTeclado;
import com.informatorio.appligachad.service.equipo.EquipoService;
import com.informatorio.appligachad.service.menu.MenuService;

public class MenuServiceRegistrarImpl implements MenuService{
	
	private EquipoService equipoService;

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
			EquipoDB.equiposDB.add(equipoService.crearEquipo(IngresoPorTeclado.ingresarTexto()));
			break;
		case 2:
			System.out.println("\nRegistro de Jugadores\n");
			MenuServiceRegistroJugadorImpl.registroJugador.mostrarMenu();
			break;
		case 3:
			System.out.println("se está ejecutando la opción de registrar partido.\n");
			break;
		default:
		
		}
	
	}

}
