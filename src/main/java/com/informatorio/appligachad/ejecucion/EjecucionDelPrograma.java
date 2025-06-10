package com.informatorio.appligachad.ejecucion;

import com.informatorio.appligachad.database.domaindb.LigaDB;
import com.informatorio.appligachad.service.liga.LigaService;
import com.informatorio.appligachad.service.liga.impl.LigaServiceImpl;
import com.informatorio.appligachad.service.menu.MenuService;
import com.informatorio.appligachad.service.menu.impl.MenuServiceImpl;

public class EjecucionDelPrograma {
	
	private static LigaService ligaService = new LigaServiceImpl();
	
	public static void ejecutarPrograma() {
		LigaDB.ligaDB = ligaService.crearLiga();
		MenuService menu = new MenuServiceImpl();
        menu.mostrarMenu();
	}

}
