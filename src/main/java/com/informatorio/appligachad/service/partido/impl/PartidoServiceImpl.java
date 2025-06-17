package com.informatorio.appligachad.service.partido.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.informatorio.appligachad.database.domaindb.EquipoDB;
import com.informatorio.appligachad.database.domaindb.PartidoDB;
import com.informatorio.appligachad.domain.Equipo;
import com.informatorio.appligachad.domain.Partido;
import com.informatorio.appligachad.input.IngresoPorTeclado;
import com.informatorio.appligachad.service.partido.PartidoService;

public class PartidoServiceImpl implements PartidoService{

	@Override
	public Partido crearPartido() {
		Partido nuevoPartido = new Partido(UUID.randomUUID(), listaDeEquipos());
		return nuevoPartido;
	}
	
	private List<Equipo> listaDeEquipos(){
		Equipo nuevoEquipo = new Equipo();
		List<Equipo> lista = new ArrayList<>();
		
		for(int i=0; i<2; i++) {
			System.out.println("Ingrese el nombre del equipo:");
			nuevoEquipo = EquipoDB.equiposMapDB.get(IngresoPorTeclado.ingresarTexto());
			lista.add(nuevoEquipo);
		}
		return lista;
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
			}
		}
		
	}

}
