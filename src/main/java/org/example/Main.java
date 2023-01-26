package org.example;



import org.example.singleResponsibility.SingleResponsibility;
import org.example.openClose.OpenClose;
import org.example.liskovSubstitution.LiskovSubstitution;
import org.example.interfaceSegregation.InterfaceSegregation;
import org.example.dependecyInversion.DependencyInversion;

public class Main {
    public static void main(String[] args) {
        // Se ejecutan los ejemplos de uso de este principio
        SingleResponsibility single = new SingleResponsibility();
        single.ejecutar();
        System.out.println("\n< - - - >");

        // Se ejecutan los ejemplos de uso de este principio
        OpenClose openClose = new OpenClose();
        openClose.ejecutar();
        System.out.println("\n< - - - >");

        // Se ejecutan los ejemplos de uso de este principio
        LiskovSubstitution liskovSubstitution = new LiskovSubstitution();
        liskovSubstitution.ejecutar();
        System.out.println("\n< - - - >");

        // Se ejecutan los ejemplos de uso de este principio
        InterfaceSegregation interfaceSegregation = new InterfaceSegregation();
        interfaceSegregation.ejecutar();
        System.out.println("\n< - - - >");

        // Se ejecutan los ejemplos de uso de este principio
        DependencyInversion dependencyInversion = new DependencyInversion();
        dependencyInversion.ejecutar();
    }
}