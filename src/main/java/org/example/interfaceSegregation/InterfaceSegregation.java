package org.example.interfaceSegregation;

public class InterfaceSegregation {
    /**
     * Se Sigue con la dinamica de los principios previos
     */

    public void ejecutarInterfaceSegregation() {
        Avion avion = new Avion();
        avion.despegar();

        Helicoptero helicoptero = new Helicoptero();
        helicoptero.aterrizar();

        Barco barco = new Barco();
        barco.navegar();
    }

    public void ejecutarEjemploInterfaceSegregation() {
        Ballena ballena = new Ballena();
        ballena.comer();
        ballena.nadar();

        Perro perro = new Perro();
        perro.comer();
        perro.correr();
    }
}

//Ejemplo interfaceSegregation

    interface Animal {
        void comer();
    }

    interface AnimalesTerrestres extends Animal {
        void correr();
    }

    interface AnimalesAcuaticos extends Animal {
        void nadar();
    }

    class Perro implements AnimalesTerrestres {
        public void comer() {
            System.out.println("El perro esta comiendo un hueso");
        }

        public void correr() {
            System.out.println("El perro corre por el parque");
        }
    }

    class Ballena implements AnimalesAcuaticos {
        public void comer() {
            System.out.println("La ballena esta comiendo peces");
        }

        public void nadar() {
            System.out.println("La ballena nada por el oceano");
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
            System.out.println("Despegando avion...");
        }

        @Override
        public void aterrizar() {
            System.out.println("Aterrizando avion..");
        }

        @Override
        public void navegar() {
            System.out.println("Navegando avion...");
        }
    }

    class Helicoptero implements Volador {
        @Override
        public void despegar() {
            System.out.println("Despegando helicoptero...");
        }

        @Override
        public void aterrizar() {
            System.out.println("Aterrizando helicoptero...");
        }
    }

    class Barco implements Navegable {
        @Override
        public void navegar() {
            System.out.println("Navegando barco...");
        }
    }
