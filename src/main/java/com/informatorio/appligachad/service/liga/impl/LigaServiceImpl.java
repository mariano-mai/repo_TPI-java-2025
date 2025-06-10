package com.informatorio.appligachad.service.liga.impl;

import com.informatorio.appligachad.domain.Liga;
import com.informatorio.appligachad.service.liga.LigaService;

public class LigaServiceImpl implements LigaService{

	@Override
	public Liga crearLiga() {
		Liga nuevaLiga = new Liga();
		return nuevaLiga;
	}

}
