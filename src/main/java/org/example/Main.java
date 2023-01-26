package org.example;

import org.example.dependecyInversion.DependencyInvesion;
import org.example.interfaceSegregation.InterfaceSegregation;
import org.example.liskovSubstitution.LiskovSubstitution;
import org.example.openClose.OpenClose;
import org.example.singleResponsibility.SingleResponsabilityExample;
import org.example.singleResponsibility.SingleResponsibility;

public class Main {
    public static void main(String[] args) {
        System.out.println("LiskovSubstitution");
        LiskovSubstitution liskovSubstitution = new LiskovSubstitution();
        liskovSubstitution.ejecutar();
        System.out.println("--------------------------------------------------------");

        System.out.println("SingleResponsability");
        SingleResponsibility single = new SingleResponsibility();
        single.ejecutar();

        System.out.println("----------------------------------------------------------------");
        System.out.println("SingleResponsability Example...");
        SingleResponsabilityExample singleResponsabilityExample = new SingleResponsabilityExample();
        singleResponsabilityExample.ejecutar();
        System.out.println("---------------------------------------------------------");


        System.out.println("OpenClose");
        OpenClose openClose = new OpenClose();
        openClose.ejecutar();
        System.out.println("-----------------------------------------------------------");

        System.out.println("InterfaceSegregation");
        InterfaceSegregation interfaceSegregation = new InterfaceSegregation();
        interfaceSegregation.ejecutar();
        System.out.println("-------------------------------------------------------------");

        System.out.println("DependencyInversion");
        DependencyInvesion dependencyInvesion = new DependencyInvesion();
        dependencyInvesion.ejecutar();

    }
}