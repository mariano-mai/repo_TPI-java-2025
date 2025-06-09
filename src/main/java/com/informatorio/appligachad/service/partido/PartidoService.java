package com.informatorio.appligachad.service.partido;

import java.util.List;

import com.informatorio.appligachad.domain.Equipo;
import com.informatorio.appligachad.domain.Partido;

public interface PartidoService {
	
	Partido crearPartido(List<Equipo> equipos);

}
