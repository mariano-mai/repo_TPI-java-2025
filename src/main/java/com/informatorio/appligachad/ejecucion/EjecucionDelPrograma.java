package com.informatorio.appligachad.ejecucion;

import com.informatorio.appligachad.service.menu.MenuService;
import com.informatorio.appligachad.service.menu.impl.MenuServiceImpl;

public class EjecucionDelPrograma {
	
	public static void ejecutarPrograma() {
		MenuService menu = new MenuServiceImpl();
        menu.mostrarMenu();
	}

}
