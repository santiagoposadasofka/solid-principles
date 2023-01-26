package org.example.interfaceSegregation;

public class InterfaceSegregation {
    /**
     * Se Sigue con la dinamica de los principios previos
     * */

    /***
     * pregunta para mañana porque no puedo instanciar el objeto
     */

    public void Ejecutar() {
        Avion miAvion = new Avion();
        miAvion.despegar();
        miAvion.aterrizar();

        Helicoptero helicoptero = new Helicoptero();
        helicoptero.despegar();
        helicoptero.aterrizar();

        Barco barco = new Barco();
        barco.navegar();


        AutoElectrico autoElectrico = new AutoElectrico();
        autoElectrico.iniciarSistemaElectrico();
        autoElectrico.encender();


        AutoGasolina autoGasolina = new AutoGasolina();
        autoGasolina.iniciarSistemaGasolina();
        autoGasolina.encender();


        AutoHibrido autoHibrido = new AutoHibrido();
        autoHibrido.iniciarSistemaHibrido();
        autoHibrido.encender();


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


/**
 * Creamos otro ejemplo de antipatronpara para el principop InterfaceSegregation donde vemos que solo hay un
 * metodo generico para todos las demas clases que exteniende de ella, pero cada caso es diferentes tanto
 * para un auto electrico, gasolina e hibrido
 */

abstract class Auto {
    public abstract void encender();
}

class AutoElectrico extends Auto {
    @Override
    public void encender() {
        iniciarSistemaElectrico();
    }

    public void iniciarSistemaElectrico() {
//...
    }
}

class AutoGasolina extends Auto {
    @Override
    public void encender() {
        iniciarSistemaGasolina();
    }

    public void iniciarSistemaGasolina() {
//...
    }
}

class AutoHibrido extends Auto {
    @Override
    public void encender() {
        iniciarSistemaHibrido();
    }

    public void iniciarSistemaHibrido() {
//...
    }
}