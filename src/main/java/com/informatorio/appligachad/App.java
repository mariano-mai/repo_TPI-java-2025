package com.informatorio.appligachad;

import com.informatorio.appligachad.service.menu.MenuService;
import com.informatorio.appligachad.service.menu.impl.MenuServiceImpl;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("¡BIENVENIDO A LA LIGA GIGACHAD!");
        MenuService menu = new MenuServiceImpl();
        menu.mostrarMenu();
    }
}
