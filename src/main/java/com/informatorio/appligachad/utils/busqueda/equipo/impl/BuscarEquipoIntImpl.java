package com.informatorio.appligachad.utils.busqueda.equipo.impl;

import java.util.HashMap;
import java.util.Map;

import com.informatorio.appligachad.database.domaindb.EquipoDB;
import com.informatorio.appligachad.domain.Equipo;
import com.informatorio.appligachad.input.IngresoPorTeclado;
import com.informatorio.appligachad.utils.busqueda.equipo.BuscarEquipoInt;

public class BuscarEquipoIntImpl implements BuscarEquipoInt{
	
	Equipo nuevoEquipo;

	@Override
	public Equipo buscar() {
		return buscarEquipo(EquipoDB.equiposMapDB);
	}
	
	private Equipo buscarEquipo(Map<String, Equipo> equipos) {
		Map<Integer, Equipo> mapaTemporal = new HashMap<>();
		System.out.println("\nSelección de Equipo");
		System.out.println("Ingrese la primer letra del nombre del equipo: ");
		String letra = IngresoPorTeclado.ingresarTexto().toUpperCase();
		int i = 1;
		for(Map.Entry<String, Equipo> equipo1 : equipos.entrySet()) {
			if(equipo1.getValue().getNombre().startsWith(letra)) {
				mapaTemporal.put(i, equipo1.getValue());
				i++;
			}
		}
		if(i!=1) {
			System.out.println("Seleccione el equipo: ");
			for(Map.Entry<Integer, Equipo> equipo2 : mapaTemporal.entrySet()) {
				System.out.println(equipo2.getKey()+"- "+equipo2.getValue().getNombre());
			}
			int valor = IngresoPorTeclado.ingresarEnteroPositivo();
			nuevoEquipo = mapaTemporal.get(valor);
		}else if(i==1) {
			System.out.println("No se encontraron coincidencias.");
			System.out.println("Pruebe con otra inicial o registre un equipo nuevo.\n");
		}
		return nuevoEquipo;
	}
}
