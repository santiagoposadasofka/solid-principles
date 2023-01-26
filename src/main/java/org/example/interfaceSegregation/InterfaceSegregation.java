package org.example.interfaceSegregation;

public class InterfaceSegregation {
    /**
     * Se Sigue con la dinamica de los principios previos
     * */

    public void ejecucarAntipatron(){
        System.out.println("\nComportamientos antipatron");
        Avion avion=new Avion();
        avion.navegar();
    }
    public void ejecutarPatron(){
        System.out.println("\nComportamientos siguiendo el patron");
        Barco barco=new Barco();
        barco.navegar();
    }
    public void ejecutar(){
        System.out.println("\nComportamientos de un ejemplo siguiendo el patron");

        Celular celular=new Celular();
        Cuchara cuchara=new Cuchara();

        celular.contestar();
        celular.colgar();
        celular.responderMensaje();

        cuchara.cargarComida();
        cuchara.llevarALaBoca();
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
        System.out.println("El avion esta navegando");
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
        System.out.println("El barco esta navegando");
    }
}

interface Llamada{
    void contestar();
    void colgar();
}

interface Chatear{
    void responderMensaje();
}

interface Comer{
    void cargarComida();
    void llevarALaBoca();
}

class Celular implements Llamada,Chatear {
    @Override
    public void colgar() {
        System.out.println("El celular cuelga llamada");
    }

    @Override
    public void contestar() {
        System.out.println("El celular contesta llamada");
    }

    @Override
    public void responderMensaje() {
        System.out.println("El celular responde mensaje");
    }
}

class Cuchara implements Comer{
    @Override
    public void cargarComida() {
        System.out.println("La cuchara carga comida");
    }

    @Override
    public void llevarALaBoca() {
        System.out.println("La cuchara lleva comida a la boca");
    }
}
