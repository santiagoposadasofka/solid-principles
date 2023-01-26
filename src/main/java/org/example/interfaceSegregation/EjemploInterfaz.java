package org.example.interfaceSegregation;

public class EjemploInterfaz {

    public void ejecutar(){
        Pastel pastel = new Pastel();
        Empanada empanada = new Empanada();

        pastel.freir();
        pastel.hornear();
        empanada.freir();
    }

    interface horneado{
        void hornear();
    }

    interface freido{
        void freir();
    }

    class Pastel implements horneado, freido{

        @Override
        public void hornear() {
            System.out.println("Horneando pastel");
        }

        @Override
        public void freir() {
            System.out.println("Los pasteles no se frien");
        }
    }

    class Empanada implements freido{

        @Override
        public void freir() {
            System.out.println("Friendo empanadas");
        }
    }

}
