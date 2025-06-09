package com.informatorio.appligachad.service.partido.impl;

import java.util.List;

import com.informatorio.appligachad.domain.Equipo;
import com.informatorio.appligachad.domain.Partido;
import com.informatorio.appligachad.service.partido.PartidoService;

public class PartidoServiceImpl implements PartidoService{

	@Override
	public Partido crearPartido(List<Equipo> equipos) {
		Partido partido = new Partido(equipos);
		return partido;
	}

}
