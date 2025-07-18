package com.informatorio.appligachad.service.menu.impl.registro;

import java.util.ArrayList;
import java.util.List;

import com.informatorio.appligachad.database.domaindb.EquipoDB;
import com.informatorio.appligachad.database.domaindb.PartidoDB;
import com.informatorio.appligachad.domain.Equipo;
import com.informatorio.appligachad.domain.Partido;
import com.informatorio.appligachad.input.IngresoPorTeclado;
import com.informatorio.appligachad.service.equipo.EquipoService;
import com.informatorio.appligachad.service.equipo.impl.EquipoServiceImpl;
import com.informatorio.appligachad.service.menu.MenuService;
import com.informatorio.appligachad.service.partido.PartidoService;
import com.informatorio.appligachad.service.partido.impl.PartidoServiceImpl;
import com.informatorio.appligachad.utils.busqueda.equipo.BuscarEquipoInt;
import com.informatorio.appligachad.utils.busqueda.equipo.impl.BuscarEquipoIntImpl;

public class MenuServiceRegistrarImpl implements MenuService{
	
	public static MenuService menuRegistro = new MenuServiceRegistrarImpl();
	
	Equipo nuevoEquipo;
	Partido nuevoPartido;
	List<Equipo> listaDeEquipos = new ArrayList<>();
	
	private EquipoService equipoService = new EquipoServiceImpl();
	private PartidoService partidoService = new PartidoServiceImpl();
	private BuscarEquipoInt buscarEquipo = new BuscarEquipoIntImpl();

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
			for(int i=0; i<2; i++) {
				nuevoEquipo = buscarEquipo.buscar();
				if(nuevoEquipo==null) {
					break;
				}else {
					listaDeEquipos.add(nuevoEquipo);
				}
			}
			if(listaDeEquipos.size()<2) {
				System.out.println("Equipos en lista: "+listaDeEquipos.size());
				System.out.println("Falta al menos un equipo.");
				System.out.println("No se pudo registrar el partido. Vuelva a intentar.");
				break;
			}else {
				nuevoPartido = partidoService.crearPartido(listaDeEquipos);
				PartidoDB.partidoMapDB.put(nuevoPartido.getId(), nuevoPartido);
				System.out.println("Partido entre los equipos "+nuevoPartido.getEquipos().get(0).getNombre()+" y "
						+nuevoPartido.getEquipos().get(1).getNombre()+" agregado con éxito.");
			}
			break;
		default:
		
		}
	
	}

}
