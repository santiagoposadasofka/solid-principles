package org.example.interfaceSegregation;

public class InterfaceSegregation {
    /**
     * Se Sigue con la dinamica de los principios previos
     */

    public void ejecutar() {
        {
            Helicoptero helicoptero = new Helicoptero();
            System.out.println("**Helicoptero acciones: ");
            helicoptero.despegar();
            helicoptero.aterrizar();
            System.out.println("**Barco acciones: ");
            Barco barco = new Barco();
            barco.navegar();

            Avion avion = new Avion();
            System.out.println("**Avión acciones: ");
            avion.aterrizar();
            avion.despegar();
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
            System.out.println("Despegando");
        }

        @Override
        public void aterrizar() {
            System.out.println("Aterrizando");
        }

        @Override
        public void navegar() {
            System.out.println("Navegando");
        }
    }

    class Helicoptero implements Volador {
        @Override
        public void despegar() {
            System.out.println("Despegando");
        }

        @Override
        public void aterrizar() {
            System.out.println("Aterrizando");
        }
    }

    class Barco implements Navegable {
        @Override
        public void navegar() {
            System.out.println("Barco navegando");
        }
    }
}