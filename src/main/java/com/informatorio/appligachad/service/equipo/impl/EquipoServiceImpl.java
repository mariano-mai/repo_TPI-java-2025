package com.informatorio.appligachad.service.equipo.impl;

import java.util.List;

import com.informatorio.appligachad.domain.Equipo;
import com.informatorio.appligachad.domain.Jugador;
import com.informatorio.appligachad.service.equipo.EquipoService;

public class EquipoServiceImpl implements EquipoService{

	@Override
	public Equipo crearEquipo(String nombre) {
		Equipo equipo = new Equipo(nombre);
		return equipo;
	}

	@Override
	public Equipo crearEquipo(String nombre, List<Jugador> jugadores) {
		// TODO Auto-generated method stub
		return null;
	}

}
