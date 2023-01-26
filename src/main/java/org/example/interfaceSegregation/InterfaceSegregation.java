package org.example.interfaceSegregation;

public class InterfaceSegregation {
    /**
     * Se Sigue con la dinamica de los principios previos
     * */

    public void ejecutar(){

        Avion miAvion = new Avion();
        Helicoptero miHelicoptero = new Helicoptero();
        Barco miBarco = new Barco();
        Pajaro miPajaro = new Pajaro();
        Submarino miSubmarino = new Submarino();

        miAvion.despegar();
        miAvion.aterrizar();
        miAvion.navegar();

        miHelicoptero.despegar();
        miHelicoptero.aterrizar();

        miBarco.navegar();

        miPajaro.despegar();
        miPajaro.aterrizar();

        miSubmarino.navegar();
        miSubmarino.sumergir();

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
interface Sumergible {
    void sumergir();
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

class Pajaro implements Volador {
    @Override
    public void despegar() {
        //...
    }
    @Override
    public void aterrizar() {
        //...
    }
}

class Submarino implements Navegable, Sumergible {
    @Override
    public void navegar() {
        //...
    }

    @Override
    public void sumergir() {

    }

}

// Ejemplo

interface Animal {
    void Comer();
    void Dormir();
}

interface Nadador {
    void nadar();
}

interface Vuela {
    void volar();
}

class Pez implements Animal, Nadador {
    public void Comer() {
        // implementación del método Comer
    }
    public void Dormir() {
        // implementación del método Dormir
    }
    public void nadar() {
        // implementación del método nadar
    }
}

class Pajaroo implements Animal, Vuela {
    public void Comer() {
        // implementación del método Comer
    }
    public void Dormir() {
        // implementación del método Dormir
    }
    public void volar() {
        // implementación del método volar
    }
}

