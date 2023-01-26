package org.example.interfaceSegregation;

import java.util.ArrayList;
import java.util.List;

public class InterfaceSegregation {
    /**
     * Se Sigue con la dinamica de los principios previos
     * */
    public void ejecutar(){
        System.out.println("Voladores");
        List<Volador> volar = new ArrayList<>();
        volar.add(new Avion());
        volar.add(new Helicoptero());
        for (Volador vuela:volar) {
            vuela.aterrizar();
            vuela.despegar();
        }
        System.out.println(" Navegables");
        List<Navegable> listaNavegables = new ArrayList<>();
        listaNavegables.add(new Avion());
        listaNavegables.add(new Barco());
        for (Navegable navegable: listaNavegables) {
            navegable.navegar();
        }
    }

    public void ejecutar1(){
        System.out.println("   Modelo Antiguo");
        List<ImpresoraMultifuncional> listaImpresoras = new ArrayList<>();
        listaImpresoras.add(new ModeloAntigup());
        for (ImpresoraMultifuncional impresoras: listaImpresoras) {
            System.out.println(impresoras.Cancelar());
            System.out.println(impresoras.Escanear());
            System.out.println(impresoras.Imprimir());
        }
        System.out.println("    Modelo Actual");
        List<ModeloActual> listaImpresoras2 = new ArrayList<>();
        listaImpresoras2.add(new ModeloActual());
        for (ModeloActual impresoras2: listaImpresoras2) {
            System.out.println(impresoras2.Cancelar());
            System.out.println(impresoras2.Escanear());
            System.out.println(impresoras2.Imprimir());
            System.out.println(impresoras2.Fotocopiar());
        }

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
        System.out.println("El avion esta despegando");
        //...
    }
    @Override
    public void aterrizar() {
        System.out.println("El avion esta por aterrizar");
        //...
    }
    @Override
    public void navegar() {
        System.out.println("El avion esta navegando");
        //...
    }
}

class Helicoptero implements Volador {
    @Override
    public void despegar() {
        System.out.println("El helicoptero esta despegando");
        //...
    }
    @Override
    public void aterrizar() {
        System.out.println("El helicoptero esta por aterrizar");
        //...
    }
}

class Barco implements Navegable {
    @Override
    public void navegar() {
        System.out.println("El barco esta navegando");
        //...
    }
}
