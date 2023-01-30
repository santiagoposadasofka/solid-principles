package org.example.interfaceSegregation;

public class InterfaceSegregation {
    /**
     * Se Sigue con la dinamica de los principios previos
     * */

    public void Ejecutar(){
        Avion miAvion = new Avion();
        miAvion.despegar();
        miAvion.aterrizar();
        miAvion.navegar();
        System.out.println("mi avion esta despegando, mas tarde navegando y luego aterrizando");

        Helicoptero miHelicoptero = new Helicoptero();
        miHelicoptero.despegar();
        miHelicoptero.aterrizar();
        System.out.println("mi helicoptero esta despegando  y luego aterrizando");

        Barco miBarco = new Barco();
        miBarco.navegar();
        System.out.println("mi barco esta navengando ");

        motoAcuatica miMotoAcuatica = new motoAcuatica();
        miMotoAcuatica.navegar();
        miMotoAcuatica.saltarOlas();
        System.out.println("mi moto acuatica esta navegando y luego saltando las olas");

        cohete miCohete = new cohete();
        miCohete.despegar();
        miCohete.aterrizar();
        miCohete.acelerar();
        System.out.println("mi cohete esta acelerando, despegando y luego aterrizando en la luna");

        //instancio mi ejemplo

        MicrosoftWord doc = new MicrosoftWord();
        doc.abrir();
        doc.guardar();
        doc.imprimir();
        doc.CorrectorOrtografico();
        doc.chequeoDeGramatica();
        System.out.println("Estoy abriendo, guardando , imprimiendo, validando ortografia y gramatica en mi Documento :) ");

        AdobeAcrobat pdf = new AdobeAcrobat();
        pdf.abrir();
        pdf.guardar();
        pdf.imprimir();
        pdf.encriptar();
        pdf.desencriptar();
        System.out.println("Estoy abriendo, guardando , imprimiendo, encriptando y desencriptando mi PDF :)");
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

class motoAcuatica implements Navegable{

    @Override
    public void navegar() {

    }
    public void saltarOlas(){}
}

class cohete implements Volador{

    @Override
    public void despegar() {

    }

    @Override
    public void aterrizar() {

    }
    public void acelerar(){}
}

//creacion del ejemplo correcto

interface Documento {
    void abrir();
    void guardar();
    void imprimir();
}

interface WordDocumento extends Documento {
    void CorrectorOrtografico();
    void chequeoDeGramatica();
}

interface PDFDocumento extends Documento {
    void encriptar();
    void desencriptar();
}

class MicrosoftWord implements WordDocumento {
    public void abrir() {
        // Microsoft Word abrir codigo
    }
    public void guardar() {
        // Microsoft Word guardar codigo
    }
    public void imprimir() {
        // Microsoft Word imprimir codigo
    }
    public void CorrectorOrtografico() {
        // Microsoft Word chequea ortografia
    }
    public void chequeoDeGramatica() {
        // Microsoft Word chequeo de gramatica en el codigo
    }
}

class AdobeAcrobat implements PDFDocumento {
    public void abrir() {
        // Adobe Acrobat abrir codigo
    }
    public void guardar() {
        // Adobe Acrobat guardar codigo
    }
    public void imprimir() {
        // Adobe Acrobat imprimir codigo
    }
    public void encriptar() {
        // Adobe Acrobat encriptar codigo
    }
    public void desencriptar() {
        // Adobe Acrobat desencriptar codigo
    }
}


