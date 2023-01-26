package org.example;

import org.example.dependecyInversion.DependencyInvesion;
import org.example.interfaceSegregation.InterfaceSegregation;
import org.example.liskovSubstitution.LiskovSubstitution;
import org.example.openClose.OpenClose;
import org.example.singleResponsibility.SingleResponsibility;

public class Main {
    public static void main(String[] args) {
        SingleResponsibility single = new SingleResponsibility();
        //single.ejecutarSingleResponsibilityCuenta();
        //single.ejecutarSingleResponsibilitySistema();
        //||single.ejecutarSingleResponsibilityAntiPatron();


        OpenClose openClose = new OpenClose();
        //openClose.ejecutarImpuesto();
        //openClose.ejecutarAntiPatron();
        //openClose.ejecutarEjemploOpenClose();

        LiskovSubstitution liskovSubstitution = new LiskovSubstitution();
        //liskovSubstitution.ejecutarPatronliskov();
        //liskovSubstitution.ejecutarAntiPatronLiskov();

        InterfaceSegregation interfaceSegregation = new InterfaceSegregation();
        //interfaceSegregation.EjecutarInterfaceSegregation();
        //interfaceSegregation.ejecutarEjemploInterfaceSegregation();

        DependencyInvesion dependencyInvesion = new DependencyInvesion();
        //dependencyInvesion.ejecutarDependencyInversion();
        dependencyInvesion.ejecutarEjemploDependencyInversion();

    }
}