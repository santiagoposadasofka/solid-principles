package org.example.interfaceSegregation;

public class InterfaceSegregation {

    public void ejecutar(){
        System.out.println("INTERFACE SEGREGATION");
        System.out.println("================ Aereopuerto ================ ");
        Avion avion = new Avion();
        avion.despegar();

        Helicoptero helicoptero = new Helicoptero();
        helicoptero.despegar();

        System.out.println("================ Puerto ================ ");
        Avion avion1 = new Avion();
        avion1.navegar();

        Barco barco = new Barco();
        barco.navegar();
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
        System.out.println("Avion Despegando");
    }
    @Override
    public void aterrizar() {
        System.out.println("Avion Aterrizando ");
    }
    @Override
    public void navegar() {
        System.out.println("Avion Navegando ");
    }
}

class Helicoptero implements Volador {
    @Override
    public void despegar() {
        System.out.println("Helicoptero despegando");

    }
    @Override
    public void aterrizar() {
        System.out.println("Helicoptero aterrizando");
    }
}

class Barco implements Navegable {
    @Override
    public void navegar() {
        System.out.println("Barco navegando");
    }

}
/**
 * Ejemplo InterfaceSegregation
 */

interface destinosTuristicos{
    void mostrarInformacion();
}

class Playa implements  destinosTuristicos{
    private String nombre;
    private String ubicacion;

    public Playa(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Información sobre playa");
        System.out.println("Nombre: "+nombre);
        System.out.println("Ubicación: "+ubicacion);

    }
}

class Montaña implements destinosTuristicos{
    private String nombre;
    private String ubicacion;
    private int altura;

    @Override
    public void mostrarInformacion() {
        System.out.println("Información sobre playa");
        System.out.println("Nombre: "+nombre);
        System.out.println("Ubicación: "+ubicacion);
        System.out.println("Altura: "+altura);

    }
}

