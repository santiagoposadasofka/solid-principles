package org.example.interfaceSegregation;

public class InterfaceSegregation {
    /**
     * Se Sigue con la dinamica de los principios previos
     * */
    public void ejecutar() {
        System.out.println("\n--------Principio Interface Segregation--------\n");
        Avion avion = new Avion();
        Helicoptero heli = new Helicoptero();
        Barco barco = new Barco();
        avion.despegar();
        avion.aterrizar();
        avion.navegar();
        heli.despegar();
        heli.aterrizar();
        barco.navegar();
    }
    public void ejecutarEjemplo() {
        System.out.println("---------Nuevo ejemplo de Interface Segregation\n");
        Perro perro = new Perro();
        Gato gato = new Gato();
        Pez pez = new Pez();
        perro.correr();
        perro.hablar();
        gato.correr();
        gato.hablar();
        pez.nadar();
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
        System.out.println("Soy un avion despegando--");
    }
    @Override
    public void aterrizar() {
        System.out.println("Soy un avion y estoy aterrizando---");
    }
    @Override
    public void navegar() {
        System.out.println("Soy un avion navegando ");
    }
}

class Helicoptero implements Volador {
    @Override
    public void despegar() {
        System.out.println("Soy un Helicoptero y estoy despegando---");
    }
    @Override
    public void aterrizar() {
        System.out.println("Soy un Helicoptero y estoy aterrizando--");
    }
}

class Barco implements Navegable {
    @Override
    public void navegar() {
        System.out.println("Soy un Barco y estoy navegando");
    }
}



//Creacion de interfaces

interface Corredor{
    void correr();
}

interface Hablador{
    void hablar();
}

interface Nadador{
    void nadar();
}


class Perro implements Corredor, Hablador {
    @Override
    public void correr() {
        System.out.println("Soy un perro y estoy corriendo");
    }
    @Override
    public void hablar() {
        System.out.println("Gua Gua Guau....");
    }
}

class Gato implements Corredor, Hablador {
    @Override
    public void correr() {
        System.out.println("Soy un gato y estoy corriendo");
    }
    @Override
    public void hablar() {
        System.out.println("Miau Miau Miau....");
    }
}

class Pez implements Nadador {
    @Override
    public void nadar() {
        System.out.println("Soy un pez y estoy nadando");
    }
}