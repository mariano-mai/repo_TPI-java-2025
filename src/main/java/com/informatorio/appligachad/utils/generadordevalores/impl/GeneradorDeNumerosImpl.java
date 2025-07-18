package com.informatorio.appligachad.utils.generadordevalores.impl;

import com.informatorio.appligachad.utils.generadordevalores.GeneradorDeNumeros;

public class GeneradorDeNumerosImpl implements GeneradorDeNumeros{
	
	public static GeneradorDeNumeros generador = new GeneradorDeNumerosImpl();

	@Override
	public int numeroEnteroAlAzar(int min, int max) {
		return (int)(Math.random()*(max-min)+min);
	}

}
