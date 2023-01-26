package org.example.interfaceSegregation;

public class InterfaceSegregation {
    /**
     * Se Sigue con la dinamica de los principios previos
     * */

    /**
     * El ejemplo que planteo para el patron InterfaceSegregation, se crean 3 interface con diferentes
     * comportamientos para implementar en las clases Portatil, Calculadora y Celular. Como los comportamientos
     * implementaor en la clases son iguales, se hace un aislamiento de interface.
     */

    interface Iprogramar{
        void programar();
        };

    interface Icalcular{
        void calcular();
    }

    interface Illamar{
        void llamar();
    }

    class Portatil implements Iprogramar, Icalcular{

        @Override
        public void programar() {
            System.out.println("El portatil esta desarrollando un software");
        }

        @Override
        public void calcular() {
            System.out.println("El portatil esta haciendo calculos");
        }

        class Celular implements Illamar,Icalcular{

            @Override
            public void calcular() {
                System.out.println("El celular esta haciendo calculos");
            }

            @Override
            public void llamar() {
                System.out.println("El celular esta haciendo una llamada");
            }
        }

        class Calculadora implements Icalcular{

            @Override
            public void calcular() {
                System.out.println("La calculadora esta haciendo calculos");
            }
        }
    }
    public void ejecutar() {
        /**
         * instancia de la clase avion, helicoptero y barco
         */
        Avion avion = new Avion();
        avion.aterrizar();
        avion.despegar();
        avion.navegar();

        Helicoptero helicoptero = new Helicoptero();
        helicoptero.aterrizar();
        helicoptero.despegar();

        Barco barco = new Barco();
        barco.navegar();

        /**
         * instancia de InterfaceSegregation
         */

        Portatil portatil = new Portatil();
        portatil.calcular();
        portatil.programar();
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
