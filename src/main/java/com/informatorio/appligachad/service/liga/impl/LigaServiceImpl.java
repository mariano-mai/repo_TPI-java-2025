package com.informatorio.appligachad.service.liga.impl;

import com.informatorio.appligachad.domain.Liga;
import com.informatorio.appligachad.service.liga.LigaService;

public class LigaServiceImpl implements LigaService{
	
	public static Liga nuevaLiga;

	@Override
	public Liga crearLiga() {
		nuevaLiga = new Liga();
		return nuevaLiga;
	}

}
