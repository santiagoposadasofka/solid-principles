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

        Humano humano = new Humano();
        Gato gato = new Gato();

        System.out.println("Humano");
        humano.hablar();
        humano.caminar();
        humano.hacerSonido();
        humano.volar();
        humano.nadar();

        System.out.println("Gato");
        gato.hacerSonido();
        gato.volar();
        gato.nadar();
    }
}

//Ejemplo de segregación de interfaces
interface SerHumano {
    void hablar();

    void caminar();
}

interface SerVivo {
    void hacerSonido();

    void volar();

    void nadar();
}

class Humano implements SerHumano, SerVivo {
    @Override
    public void hablar() {
        System.out.println("Hablando...");
    }

    @Override
    public void caminar() {
        System.out.println("Caminando...");
    }

    @Override
    public void hacerSonido() {
        System.out.println("Silvando...");
    }

    @Override
    public void volar() {
        System.out.println("Un humano no puede volar");
    }

    @Override
    public void nadar() {
        System.out.println("Nadando...");
    }
}

class Gato implements SerVivo {
    @Override
    public void hacerSonido() {
        System.out.println("Gato: miau");
    }

    @Override
    public void volar() {
        System.out.println("El gato no puede volar");
    }

    @Override
    public void nadar() {
        System.out.println("El gato no puede nadar");
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
