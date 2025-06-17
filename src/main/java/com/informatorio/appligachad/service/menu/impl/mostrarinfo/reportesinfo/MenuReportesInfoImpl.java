package com.informatorio.appligachad.service.menu.impl.mostrarinfo.reportesinfo;

import com.informatorio.appligachad.input.IngresoPorTeclado;
import com.informatorio.appligachad.service.menu.MenuService;

public class MenuReportesInfoImpl implements MenuService{
	
	public static MenuService menuReportes = new MenuReportesInfoImpl();

	@Override
	public void mostrarMenu() {
		int condicion;
		do {
			System.out.println("seleccione una opción:");
			System.out.println("1- Ver reporte de liga.\n2- Ver reporte de equipo.\n3- Volver");
			condicion=IngresoPorTeclado.ingresarEnteroPositivo();
			ejecutarOpciones(condicion);
		}while(condicion!=4);
		
	}
	
	private void ejecutarOpciones(int condicion) {
		switch(condicion) {
		case 1:
			System.out.println("reporte de liga");
			break;
		case 2:
			System.out.println("reporte de equipo");
			break;
		default:
			
		}
	}

}
