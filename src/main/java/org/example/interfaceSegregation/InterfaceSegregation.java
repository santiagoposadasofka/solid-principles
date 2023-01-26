package org.example.interfaceSegregation;

public class InterfaceSegregation {

    public void ejecutar(){
        Avion avion1 = new Avion();
        avion1.aterrizar();
        avion1.despegar();

        Barco barco1 = new Barco();
        barco1.navegar();

        Submarino submarino1 = new Submarino();
        submarino1.sumergir();
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

interface Sumerger {
    void sumergir();
    void flota();
}

class Avion implements Volador, Navegable {
    @Override
    public void despegar() {
        //...
        System.out.println("Despegando avión");
    }
    @Override
    public void aterrizar() {
        //...
        System.out.println("Aterrizando avión");
    }
    @Override
    public void navegar() {
        //...
        System.out.println("Aterrizó avión y navega en el mar");
    }
}

class Helicoptero implements Volador {
    @Override
    public void despegar() {
        //...
        System.out.println("Despegando helicoptero");

    }
    @Override
    public void aterrizar() {
        //...
        System.out.println("Aterrizando helicoptero");
    }
}

class Barco implements Navegable {
    @Override
    public void navegar() {
        System.out.println("Navegando barco");
    }
}

class Submarino implements Sumerger {
    @Override
    public void sumergir() {
        System.out.println("Sumergir submarino");
    }

    @Override
    public void flota() {
        System.out.println("Flotar submarino");
    }
}
