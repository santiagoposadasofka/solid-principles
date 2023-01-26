package org.example;

import org.example.dependecyInversion.DependencyInvesion;
import org.example.interfaceSegregation.InterfaceSegregation;
import org.example.liskovSubstitution.LiskovSubstitution;
import org.example.openClose.OpenClose;
import org.example.singleResponsibility.SingleResponsibility;

public class Main {
    public static void main(String[] args) {
        SingleResponsibility single = new SingleResponsibility();
        single.ejecutarCuentaBanco();

        OpenClose openClose = new OpenClose();
        openClose.ejecutarCalculadoraImpuestos();





        LiskovSubstitution liskovSubstitution = new LiskovSubstitution();
        liskovSubstitution.ejecutar();

        InterfaceSegregation interfaceSegregation= new InterfaceSegregation();
        interfaceSegregation.ejecutarInterfaceSegregation();

        DependencyInvesion dependencyInvesion = new DependencyInvesion();
        dependencyInvesion.ejecutarDependencyInvesion();
        dependencyInvesion.iniciarDesarrollo();
    }
}