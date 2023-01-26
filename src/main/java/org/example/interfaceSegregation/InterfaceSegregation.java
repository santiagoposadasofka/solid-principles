package org.example.interfaceSegregation;

public class InterfaceSegregation {
    /**
     * Se Sigue con la dinamica de los principios previos
     * */
    public void ejecutar(){
        Avion avion = new Avion();
        Helicoptero helicoptero = new Helicoptero();
        Barco barco = new Barco();

        avion.aterrizar();
        avion.navegar();
        barco.navegar();
        helicoptero.despegar();
    }
}


/*
* Un ejemplo de aislamiento de interfaz en Java podría ser una interfaz "Volador" que tiene métodos
* para volar y aterrizar. Sin embargo, no todos los objetos que implementan la interfaz "Volador"
* tienen la capacidad de navegar. Por lo tanto, se crea una interfaz separada "Navegable" que solo tiene métodos para navegar.
* En este ejemplo se puede ver cómo se han separado las interfaces Volador y Navegable, de esta forma solo se tiene que
* implementar los métodos nesarios
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
        System.out.println("Despegando el avion");
    }
    @Override
    public void aterrizar() {
        System.out.println("Aterrizando el avion");
    }
    @Override
    public void navegar() {
        System.out.println("No es posible navegar");
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
        System.out.println("Navegando el barco");
    }
}
