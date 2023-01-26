package org.example;

import org.example.dependecyInversion.DependencyInvesion;
import org.example.interfaceSegregation.EjemploInterfaz;
import org.example.interfaceSegregation.InterfaceSegregation;
import org.example.liskovSubstitution.EjemploAntipatron;
import org.example.liskovSubstitution.LiskovSubstitution;
import org.example.openClose.OpenClose;
import org.example.singleResponsibility.SingleResponsibility;

public class Main {
    public static void main(String[] args) {
        System.out.println("------Patron SingleResponsability-----");
        SingleResponsibility single = new SingleResponsibility();
        single.ejecutar();
        System.out.println("----Anti patron sigle responsability---");
        single.ejecutarantipatron();
        System.out.println("");
        System.out.println("----------Patron Openclose-----------");
        OpenClose openClose = new OpenClose();
        openClose.ejecutar();
        System.out.println("-----------Patron liskov-------------");
        LiskovSubstitution liskovSubstitution = new LiskovSubstitution();
        liskovSubstitution.ejecutar();
        System.out.println("----------Antipatron liskov----------");
        EjemploAntipatron ejemploAntipatron = new EjemploAntipatron();
        ejemploAntipatron.ejecutar();
        System.out.println("-----------Patron interfaz-----------");
        InterfaceSegregation interfaceSegregation = new InterfaceSegregation();
        interfaceSegregation.ejecutar();
        System.out.println("-----------Ejemplo Interfaz-----------");
        EjemploInterfaz ejemploInterfaz = new EjemploInterfaz();
        ejemploInterfaz.ejecutar();
        System.out.println("----------Inversion de Denpencias-----");
        DependencyInvesion dependencyInvesion = new DependencyInvesion();
        dependencyInvesion.ejecutar();

    }
}