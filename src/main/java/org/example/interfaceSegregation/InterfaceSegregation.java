package org.example.interfaceSegregation;

public class InterfaceSegregation {


    /*
     * Se verifican comportamientos de las diferentes clases, para así verificar
     * que el programa funcione sin problemas, respetando el patron creando interfaces para diferentes metodos
     * esperando que las clases no dependan de una sola interface para ejecutar sus metodos correspondientes
     * */
    public void ejecutar(){

        Avion avion = new Avion();
        avion.despegar();
        System.out.println("El avión despegó");
        Helicoptero helicoptero = new Helicoptero();
        helicoptero.despegar();
        System.out.println("El helicoptero despegó");
        helicoptero.disparar();
        System.out.println("El helicopteró disparó");
        Submarino submarino = new Submarino();
        submarino.navegar();
        System.out.println("El submarino ya está navengando");
        submarino.disparar();
        System.out.println("El submarino disparó");

    }
}
/**
 * Se Sigue con la dinamica de los principios previos
 * */

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

/*
 * Se implementa otra interface para interactur
 * con nuevo metodo al agregar la clase de "submarino"
 * */

interface Ataque{
    void disparar();
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

class Helicoptero implements Volador, Ataque {
    @Override
    public void despegar() {
        //...
    }
    @Override
    public void aterrizar() {
        //...
    }

    @Override
    public void disparar() {

    }

}

/*
 * Se crea clase "submarino" la cual utiliza dos interfaces,
 * pero que no depende de niguna otra para ejecutar sus
 * metodos correspondientes
 * */

class Submarino implements Navegable, Ataque {

    @Override
    public void navegar() {

    }

    @Override
    public void disparar() {

    }

    class Barco implements Navegable {
        @Override
        public void navegar() {
            //...
        }
    }
}
