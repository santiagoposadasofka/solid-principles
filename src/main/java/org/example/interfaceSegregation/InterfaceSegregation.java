package org.example.interfaceSegregation;

public class InterfaceSegregation {
    /**
     * Se Sigue con la dinamica de los principios previos
     * */

    public void Ejecutar(){
        Avion avioncito = new Avion();
        Helicoptero helicoptercito = new Helicoptero();
        Barco barquito = new Barco();
        motoAcuatica motico =new motoAcuatica();
        cohete Cohete =new cohete();

        avioncito.despegar();
        avioncito.aterrizar();
        avioncito.navegar();

        helicoptercito.despegar();
        helicoptercito.aterrizar();

        barquito.navegar();

        motico.saltarOlas();
        motico.navegar();

        Cohete.acelerar();
        Cohete.aterrizar();
        Cohete.despegar();
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

class motoAcuatica implements Navegable{

    @Override
    public void navegar() {

    }
    public void saltarOlas(){}
}

class cohete implements Volador{

    @Override
    public void despegar() {

    }

    @Override
    public void aterrizar() {

    }
    public void acelerar(){}
}


