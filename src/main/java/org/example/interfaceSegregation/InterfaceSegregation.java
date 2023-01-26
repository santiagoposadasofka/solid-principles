package org.example.interfaceSegregation;

import org.w3c.dom.ls.LSOutput;

public class InterfaceSegregation {
    /**
     * Se Sigue con la dinamica de los principios previos
     */

    //Método para ejecutar principio de segregación de interface
    public void ejecutarEjemplo() {
        Avion avion = new Avion();
        Helicoptero helicoptero = new Helicoptero();
        Barco barco = new Barco();

        System.out.println("Avión");
        avion.despegar();
        avion.aterrizar();
        avion.navegar();

        System.out.println("Helicoptero");
        helicoptero.aterrizar();
        helicoptero.despegar();

        System.out.println("Barco");
        barco.navegar();
    }
}


/*
 * Un ejemplo de aislamiento de interfaz en Java podría ser una interfaz "Volador" que tiene métodos
 * para volar y aterrizar. Sin embargo, no todos los objetos que implementan la interfaz "Volador"
 * tienen la capacidad de navegar. Por lo tanto, se crea una interfaz separada "Navegable" que solo tiene métodos para navegar.
 * En este ejemplo se puede ver cómo se han separado las interfaces Volador y Navegable, de esta forma solo se tiene que
 * implementar los métodos ne
 * */

interface Volador {
    void despegar();

    void aterrizar();
}

interface Navegable {
    void navegar();
}

class Avion implements Volador, Navegable {
    @Override
    public void despegar() {
        System.out.println("Despegando el avión");
    }

    @Override
    public void aterrizar() {
        System.out.println("Aterrizando el avión");
    }

    @Override
    public void navegar() {
        System.out.println("Warning!!! Este medio de transporte no puede navegar");
    }
}

class Helicoptero implements Volador {
    @Override
    public void despegar() {
        System.out.println("Despegando el helicoptero");
    }

    @Override
    public void aterrizar() {
        System.out.println("Aterrizando el helicoptero");
    }
}

class Barco implements Navegable {
    @Override
    public void navegar() {
        System.out.println("Navegando");
    }
}
