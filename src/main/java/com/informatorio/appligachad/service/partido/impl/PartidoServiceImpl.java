package com.informatorio.appligachad.service.partido.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.informatorio.appligachad.database.domaindb.PartidoDB;
import com.informatorio.appligachad.domain.Equipo;
import com.informatorio.appligachad.domain.Partido;
import com.informatorio.appligachad.service.partido.PartidoService;

public class PartidoServiceImpl implements PartidoService{

	@Override
	public Partido crearPartido(List<Equipo> listaDeEquipos) {
		Partido nuevoPartido = new Partido(UUID.randomUUID(), listaDeEquipos);
		return nuevoPartido;
	}

	@Override
	public void mostrarPartidos() {
		int i = 1;
		if(PartidoDB.partidoMapDB.isEmpty()) {
			System.out.println("Aún no hay partidos registrados.");
		}else {
			for(Map.Entry<UUID, Partido> partido1 : PartidoDB.partidoMapDB.entrySet()) {
				System.out.println("Partido #"+i);
				for(Equipo equipo : partido1.getValue().getEquipos()) {
					System.out.println("- "+equipo.getNombre());
				}
				i++;
			}
		}
		
	}

}
