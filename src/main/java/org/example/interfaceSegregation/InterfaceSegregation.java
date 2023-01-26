package org.example.interfaceSegregation;

public class InterfaceSegregation {
    /**
     * Se Sigue con la dinamica de los principios previos
     * */
    public void ejecutar() {
        Avion avion = new Avion();
        avion.aterrizar();
        avion.aterrizar();
        avion.navegar();
        Navegable barco = new Barco();
        barco.navegar();
        Volador helicoptero = new Helicoptero();
        helicoptero.despegar();
        helicoptero.aterrizar();
        Programador programador = new QA();
        programador.codea();
        programador.tomaCafe();

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

interface Programador {
    void codea();
    void tomaCafe();

}

interface Navegable {
    void navegar();
}

class Avion implements Volador, Navegable {
    @Override
    public void despegar() {
        //...
    }
    @Override
    public void aterrizar() {
        //...
    }
    @Override
    public void navegar() {
        //...
    }
}

class Helicoptero implements Volador {
    @Override
    public void despegar() {
        //...
    }
    @Override
    public void aterrizar() {
        //...
    }
}

class Barco implements Navegable {
    @Override
    public void navegar() {
        //...
    }
}

class QA implements Programador {

    @Override
    public void codea() {
        System.out.println("Le aparecen muchos errores y no compila");
    }

    @Override
    public void tomaCafe() {
        System.out.println("Se toma un cafecito");
    }
}
