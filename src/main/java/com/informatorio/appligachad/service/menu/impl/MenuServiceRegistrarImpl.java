package com.informatorio.appligachad.service.menu.impl;

import com.informatorio.appligachad.input.IngresoPorTeclado;
import com.informatorio.appligachad.service.menu.MenuService;

public class MenuServiceRegistrarImpl implements MenuService{

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
			System.out.println("se está ejecutando la opción de registrar equipo.\n");
			break;
		case 2:
			System.out.println("se está ejecutando la opción de registrar jugador.\n");
			break;
		case 3:
			System.out.println("se está ejecutando la opción de registrar partido.\n");
			break;
		default:
		
		}
	
	}

}
