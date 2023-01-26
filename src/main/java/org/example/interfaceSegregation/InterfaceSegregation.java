package org.example.interfaceSegregation;


import org.example.singleResponsibility.Vivienda;

public class InterfaceSegregation {
    public void ejecutar() {
        Dron dron = new Dron();
         dron.despegar();
         dron.recargar();
    }}


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

interface Electrico{
    void recargar();
}
class Dron implements Volador,Navegable,Electrico{

    @Override
    public void despegar() {
        System.out.println("El dron despegó con éxito");
    }

    @Override
    public void aterrizar() {
        System.out.println("El dron aterrizo con éxito");
    }

    @Override
    public void navegar() {
        System.out.println("Ell dron está navegando a control remoton ");
    }

    @Override
    public void recargar() {
        System.out.println("Nivel de batería 10%");
    }
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
