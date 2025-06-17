package com.informatorio.appligachad.service.partido.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.informatorio.appligachad.database.domaindb.EquipoDB;
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

}
