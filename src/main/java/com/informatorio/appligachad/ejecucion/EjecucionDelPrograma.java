package com.informatorio.appligachad.ejecucion;

import com.informatorio.appligachad.database.bootstrap.impl.BootstrapDataImpl;
import com.informatorio.appligachad.service.menu.impl.MenuServiceImpl;

public class EjecucionDelPrograma {
	
	public static void ejecutarPrograma() {
		BootstrapDataImpl.bootstrap.crearEquipos();
		MenuServiceImpl.menuPrincipal.mostrarMenu();
	}

}
