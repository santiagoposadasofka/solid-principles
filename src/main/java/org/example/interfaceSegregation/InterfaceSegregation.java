package org.example.interfaceSegregation;

import java.util.ArrayList;
import java.util.List;

public class InterfaceSegregation {
    public static void ejecutar(){
        List<Volador>navesVoladoras=new ArrayList<>();
        List<Navegable>navesNavegables=new ArrayList<>();
        List<Imprimir>impresoras=new ArrayList<>();
        Escanear impresoraCasa=new ImpresoraDeCasa();
        impresoras.add(new ImpresoraDeCasa());
        impresoras.add(new ImpresoraPortatil());
        navesVoladoras.add(new Helicoptero());
        navesVoladoras.add(new Avion());
        navesNavegables.add(new Avion());
        navesNavegables.add(new Barco());
        for(Volador naveVoladora:navesVoladoras){
            naveVoladora.despegar();
            naveVoladora.aterrizar();
        }
        System.out.println("\n");
        for (Navegable naveNavegable:navesNavegables){
            naveNavegable.navegar();
        }
        System.out.println("\n");
        for (Imprimir impresora:impresoras){
            impresora.imprimir();
        }
        System.out.println("\n");
        impresoraCasa.escanear();
    }
}
interface Escanear{
    public void escanear();
}
interface Imprimir{
    public void imprimir();
}
class ImpresoraDeCasa implements Imprimir,Escanear{
    @Override
    public void imprimir() {
        System.out.println("Imprimiendo...");
    }

    @Override
    public void escanear() {
        System.out.println("Archivo escaneado...");
    }
}
class ImpresoraPortatil implements Imprimir{
    @Override
    public void imprimir() {
        System.out.println("Imprimiendo los documentos");
    }
}
/*
* Un ejemplo de aislamiento de interfaz en Java podría ser una interfaz "Volador" que tiene métodos
* para volar y aterrizar. Sin embargo, no todos los objetos que implementan la interfaz "Volador"
* tienen la capacidad de navegar. Por lo tanto, se crea una interfaz separada "Navegable" que solo tiene métodos para
* navegar. En este ejemplo se puede ver cómo se han separado las interfaces Volador y Navegable, de esta forma solo se
* tiene que implementar los métodos necesarios
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
        System.out.println("El avión ha despegado con éxito");
    }
    @Override
    public void aterrizar() {
        System.out.println("El avión ha aterrizado con éxito");
    }
    @Override
    public void navegar() {
        System.out.println("El avión va planeado en la dirección indicada");
    }
}

class Helicoptero implements Volador {
    @Override
    public void despegar() {
        System.out.println("El Helicoptero hizo su levantamiento correctamente");
    }
    @Override
    public void aterrizar() {
        System.out.println("El Helicoptero descendió correctamente");
    }
}

class Barco implements Navegable {
    @Override
    public void navegar() {
        System.out.println("El barco ha tomado curso a la dirección indicada");
    }
}
