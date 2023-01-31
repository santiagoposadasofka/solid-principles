package org.example.interfaceSegregation;
import java.util.ArrayList;
import java.util.List;

public class InterfaceSegregation {
    public static void ejecutar (){

        // Se crean las listas de los diferentes tipos de vehiculos
        List<Volador> vehiculosVoladores = new ArrayList<>();
        List <Navegable> vehiculosNavegables = new ArrayList<>();
        // Se agregan los vehiculos a las listas
        vehiculosVoladores.add(new Avion());
        vehiculosVoladores.add(new Helicoptero());
        vehiculosNavegables.add(new Barco());

        // Se recorren las listas para mostrar los tableros  de visualizacion de datos
        MostrandoDatos tableroPowerBi = new TableroPowerBi();
        List <MostrandoDatos> Tableros = new ArrayList<>();
        Tableros.add(new TableroPowerBi());
        Tableros.add(new TableroExcel());



         // Se agregan los vehiculos a la lista de impresion
        for (Volador vehiculoVolador : vehiculosVoladores) {
            vehiculoVolador.despegar();
            vehiculoVolador.aterrizar();

        }
         // Se agregan los vehiculos a la lista de impresion
        for (Navegable vehiculoNavegable : vehiculosNavegables) {
            vehiculoNavegable.navegar();
        }
        // Se recorren los tableros para mostrar los datos
        System.out.println("\n");
        for (MostrandoDatos tablero : Tableros) {
            tablero.mostrarDatos();
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



interface RecibiendoDatos{
    void recibirDatos();
}

interface MostrandoDatos{
    void mostrarDatos();
}

class TableroPowerBi implements RecibiendoDatos, MostrandoDatos{
    @Override
    public void recibirDatos(){
        System.out.println("Recibiendo datos de PowerBi");
    }
    @Override
    public void mostrarDatos(){
        System.out.println("Mostrando datos de PowerBi");
    }
}

class TableroExcel implements RecibiendoDatos, MostrandoDatos{
    @Override
    public void recibirDatos(){
        System.out.println("Recibiendo datos de Excel");
    }
    @Override
    public void mostrarDatos(){
        System.out.println("Mostrando datos de Excel");
    }
}


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
        System.out.println("Avion despegando con exito");
    }
    @Override
    public void aterrizar() {
        System.out.println("Avion aterrizando con exito");
    }
    @Override
    public void navegar() {
        System.out.println("Avion navegando con exito");
    }
}

class Helicoptero implements Volador {
    @Override
    public void despegar() {
        System.out.println("Despegue exitoso del helicoptero");
    }
    @Override
    public void aterrizar() {
        System.out.println("El Helicoptero aterrizo");
    }
}

class Barco implements Navegable {
    @Override
    public void navegar() {
        System.out.println("El barco zarpó");
    }
}
