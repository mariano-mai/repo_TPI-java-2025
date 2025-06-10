package com.informatorio.appligachad.utils.busqueda.equipo.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.informatorio.appligachad.domain.Equipo;
import com.informatorio.appligachad.input.IngresoPorTeclado;
import com.informatorio.appligachad.utils.busqueda.equipo.BuscarEquipoInt;

public class BuscarEquipoIntImpl implements BuscarEquipoInt{

	@Override
	public Equipo buscar(List<Equipo> equipos) {
		Map<Integer, Equipo> mapaTemporal = new HashMap<>();
		System.out.println("Ingrese la primer letra del nombre del Equipo:");
		String letra = IngresoPorTeclado.ingresarTexto().toUpperCase();
		int i = 1;
		for(Equipo equipo : equipos) {
			if(equipo.getNombre().startsWith(letra)) {
				mapaTemporal.put(i, equipo);
				i++;
			}
		}
		if(i!=1) {
			System.out.println("Seleccione el Equipo:");
			for(Map.Entry<Integer, Equipo> equipo : mapaTemporal.entrySet()) {
				System.out.println(equipo.getKey()+"- "+equipo.getValue().getNombre());
			}
		}else if(i==1) {
			System.out.println("No se encontraron conicidencias.");
		}
		if(mapaTemporal.isEmpty()) {
			return null;
		}
		Equipo newEquipo = mapaTemporal.get(IngresoPorTeclado.ingresarEnteroPositivo());
		return newEquipo;
	}

}
