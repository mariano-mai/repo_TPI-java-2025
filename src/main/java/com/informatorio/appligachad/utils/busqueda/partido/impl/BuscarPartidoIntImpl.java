package com.informatorio.appligachad.utils.busqueda.partido.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.informatorio.appligachad.database.domaindb.PartidoDB;
import com.informatorio.appligachad.domain.Partido;
import com.informatorio.appligachad.input.IngresoPorTeclado;
import com.informatorio.appligachad.utils.busqueda.partido.BuscarPartidoInt;

public class BuscarPartidoIntImpl implements BuscarPartidoInt{
	
	Partido nuevoPartido;

	@Override
	public Partido buscar() {
		return buscarPartido(PartidoDB.partidoMapDB);
	}
	
	private Partido buscarPartido(Map<UUID, Partido> partidos) {
		Map<Integer, Partido> mapaTemporal = new HashMap<>();
		int i = 1;
		for(Map.Entry<UUID, Partido> partido1: partidos.entrySet()) {
			mapaTemporal.put(i, partido1.getValue());
			i++;
		}
		if(i!=1) {
			for(Map.Entry<Integer, Partido> partido2: mapaTemporal.entrySet()) {
				System.out.println(partido2.getKey()+"- "+partido2.getValue().getResultado());
			}
			int valor = IngresoPorTeclado.ingresarEnteroPositivo();
			nuevoPartido = mapaTemporal.get(valor);
		}else if(i==1) {
			System.out.println("Aún no hay partidos registrados.");
		}
		return nuevoPartido;
	}

}
