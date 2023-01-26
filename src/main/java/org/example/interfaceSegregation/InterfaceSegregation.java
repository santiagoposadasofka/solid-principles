package org.example.interfaceSegregation;

public class InterfaceSegregation {
    /**
     * Se Sigue con la dinamica de los principios previos
     */
    public void ejecutarInterfaceSegregation() {
        Avion avion = new Avion();
        Barco barco = new Barco();
        Helicoptero helicoptero = new Helicoptero();
        avion.navegar();
        avion.despegar();
        avion.aterrizar();
        barco.navegar();
        helicoptero.despegar();
        helicoptero.aterrizar();


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
        System.out.println("El avion despego con exito.");
    }

    @Override
    public void aterrizar() {
        System.out.println("El avion aterrizo con exito.");
    }

    @Override
    public void navegar() {
        System.out.println("El avion navega sin problemas.");
    }
}

class Helicoptero implements Volador {
    @Override
    public void despegar() {
        System.out.println("El helicoptero despego con exito.");
    }

    @Override
    public void aterrizar() {
        System.out.println("El helicoptero aterrizo sin problemas.");
    }
}

class Barco implements Navegable {
    @Override
    public void navegar() {
        System.out.println("El barco navega satisfactoriamente.");
    }
}
