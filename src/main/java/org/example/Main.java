package org.example;

import org.example.dependecyInversion.DependencyInvesion;
import org.example.interfaceSegregation.InterfaceSegregation;
import org.example.liskovSubstitution.LiskovSubstitution;
import org.example.openClose.OpenClose;
import org.example.singleResponsibility.SingleResponsibility;

public class Main {
    public static void main(String[] args) {
        System.out.println("[ Ejecución ejercicios principio SOLID ]");

        //System.out.println("Responsabilidad única");
        SingleResponsibility single = new SingleResponsibility();
        //single.ejecutarCuenta();
        //single.ejecutarSistema();
        //single.ejecutarEjemplo();

        //System.out.println("Sustitución de Liskov");
        LiskovSubstitution liskovSubstitution = new LiskovSubstitution();
        //liskovSubstitution.ejecutar();

        //System.out.println("Abierto - Cerrado");
        OpenClose openClose = new OpenClose();
        //openClose.ejecutarImpuesto();
        //openClose.ejecutarEjemplo();

        //System.out.println("Segregación de interface");
        InterfaceSegregation interfaceSegregation = new InterfaceSegregation();
        //interfaceSegregation.ejecutarEjemplo();

        System.out.println("Inversión de dependencias");
        DependencyInvesion dependencyInvesion = new DependencyInvesion();
        dependencyInvesion.ejecutarServicio();
    }
}