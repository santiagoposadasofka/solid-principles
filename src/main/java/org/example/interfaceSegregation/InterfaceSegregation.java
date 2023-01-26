package org.example.interfaceSegregation;

public class InterfaceSegregation {
    /**
     * Se Sigue con la dinamica de los principios previos
     * */

    public void Ejecutar (){

        Avion miAvion = new Avion();
        Helicoptero miHelicoptero = new Helicoptero();
        Barco miBarco = new Barco();

        miAvion.despegar();
        miAvion.aterrizar();
        miAvion.navegar();

        miHelicoptero.despegar();
        miHelicoptero.aterrizar();

        miBarco.navegar();
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

class Submarino implements Navegable {
    @Override
    public void navegar() {
        //...
    }
    public void sumergirse() {
        //...
    }
}

class AvionDeCombate extends Avion {
    public void lanzarMisil() {
        //...
    }
    public void activarEscudo() {
        //...
    }
}
