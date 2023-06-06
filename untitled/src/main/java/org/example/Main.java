package org.example;

import Vista.Ventana;
import controlador.controladorTablaNasa;

public class Main {
    public static void main(String[] args) {
        Ventana ven=new Ventana("Nasa");
        controladorTablaNasa controlador=new controladorTablaNasa(ven);
    }
}