package com.informatorio.appligachad.input;

import java.util.Scanner;

public class IngresoPorTeclado {
	
	static Scanner entrada;
	
	public static int ingresarEnteroPositivo() {
		entrada = new Scanner(System.in);
		int valor = -1;
		while(valor<0) {
			try {
				valor = Integer.parseInt(entrada.nextLine());
			}catch(NumberFormatException e) {
				System.out.println("Entrada inválida. Ingrese un número entero.");
			}
		}
		return valor;
	}
	
	public static String ingresarTexto() {
		entrada = new Scanner(System.in);
		String texto = entrada.nextLine();
		return texto;
	}

}
