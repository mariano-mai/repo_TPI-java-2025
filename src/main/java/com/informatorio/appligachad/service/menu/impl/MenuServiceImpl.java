package com.informatorio.appligachad.service.menu.impl;

import com.informatorio.appligachad.input.IngresoPorTeclado;
import com.informatorio.appligachad.service.menu.MenuService;
import com.informatorio.appligachad.service.menu.impl.mostrarinfo.MenuServiceMostrarInfoImpl;
import com.informatorio.appligachad.service.menu.impl.registro.MenuServiceRegistrarImpl;

public class MenuServiceImpl implements MenuService{

	@Override
	public void mostrarMenu() {
		int condicion;
		do {
			System.out.println("seleccione una opción:");
			System.out.println("1- REGISTRAR\n2- INGRESAR INFORMACIÓN\n3- MOSTRAR INFORMACIÓN\n4- SALIR DE LA APLICACIÓN");
			condicion=IngresoPorTeclado.ingresarEnteroPositivo();
			ejecutarOpciones(condicion);
		}while(condicion!=4);
		
	}
	
	private void ejecutarOpciones(int condicion) {		
		
		switch(condicion) {
		case 1:
			System.out.println("se está ejecutando la opción 1.\n");
			MenuServiceRegistrarImpl.menuRegistro.mostrarMenu();
			break;
		case 2:
			System.out.println("se está ejecutando la opción 2.\n");
			break;
		case 3:
			System.out.println("se está ejecutando la opción 3.\n");
			MenuServiceMostrarInfoImpl.menuInfo.mostrarMenu();
			break;
		default:
			System.out.println("fin del programa.");
		
		}
	
	}

	

}
