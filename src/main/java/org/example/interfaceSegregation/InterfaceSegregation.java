package org.example.interfaceSegregation;

public class InterfaceSegregation {
    public void ejecutar() {
        System.out.println("Ejecutando ejemplos del patrón Interface Segregation.");
        /*
         * Instancia de diferentes transportes.
         * Uso de los comportamientos heredados.
         */
        Avion avion = new Avion();
        Volador helicoptero = new Helicoptero();
        Navegable barco = new Barco();
        avion.aterrizar();
        avion.despegar();
        avion.navegar();
        helicoptero.despegar();
        helicoptero.aterrizar();
        barco.navegar();

        System.out.println("\nEjecutando nuevo ejemplo patrón de Interface Segregation.");
        /*
         * Instancia de diferentes electrodomésticos.
         * Uso de los comportamientos heredados.
         */
        Televisor televisor = new Televisor();
        Reloj reloj = new Reloj();
        Horno horno = new Horno();
        televisor.reproducir();
        televisor.setAlarma();
        System.out.println("Temperatura: " + reloj.leerTemp());
        reloj.setAlarma();
        horno.inicioCocinar(reloj);
    }
}

/*
 * Un ejemplo de aislamiento de interfaz en Java podría ser una interfaz "Volador" que tiene métodos para volar y
 * aterrizar. Sin embargo, no todos los objetos que implementan la interfaz "Volador" tienen la capacidad de navegar.
 * Por lo tanto, se crea una interfaz separada "Navegable" que solo tiene métodos para navegar. En este ejemplo se puede
 * ver cómo se han separado las interfaces Volador y Navegable, de esta forma solo se tiene que implementar los métodos
 * necesarios.
 */

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
        System.out.println("El avión ha despegado.");
    }

    @Override
    public void aterrizar() {
        System.out.println("El avión ha aterrizado.");
    }

    @Override
    public void navegar() {
        System.out.println("El avión a desplegado flotadores. Listo para navegar.");
    }
}

class Helicoptero implements Volador {
    @Override
    public void despegar() {
        System.out.println("El helicóptero ha despegado.");
    }

    @Override
    public void aterrizar() {
        System.out.println("El helicóptero ha aterrizado.");
    }
}

class Barco implements Navegable {
    @Override
    public void navegar() {
        System.out.println("El barco ha iniciado a navegar.");
    }
}

/*
 * Un ejemplo de patrón del principio de Interface Segregation en Java podría ser varias interfaces que traen
 * funcionalidades para diferentes electrodomésticos, que las implementarán de acuerdo a las necesidades que estos
 * resuelven. Luego cada función será segregada al correspondiente electrodoméstico que implementará sus métodos.
 */

interface Termometro {
    double leerTemp();
}

interface Reproductor {
    void reproducir();
}

interface Alarma {
    void setAlarma();
}

class Televisor implements Reproductor, Alarma {
    @Override
    public void reproducir() {
        System.out.println("Reproduciendo imagen.");
    }
    @Override
    public void setAlarma() {
        System.out.println("Alarma activada.");
    }
}

class Reloj implements Termometro, Alarma {
    @Override
    public double leerTemp() {
        return 20;
    }
    @Override
    public void setAlarma() {
        System.out.println("Alarma activada.");
    }
}

class Horno {
    public void inicioCocinar(Alarma alarma) {
        alarma.setAlarma();
        System.out.println("Iniciando horno.");
    }
}