package org.example;

import org.example.dependecyInversion.DependencyInvesion;
import org.example.interfaceSegregation.InterfaceSegregation;
import org.example.liskovSubstitution.LiskovSubstitution;
import org.example.openClose.OpenClose;
import org.example.singleResponsibility.SingleResponsibility;

public class Main {
    public static void main(String[] args) {

        System.out.println("******* Dependency Invesion  *******");
        System.out.println(" ");
        DependencyInvesion dependencyInvesion = new DependencyInvesion();
        dependencyInvesion.ejecutar();
        System.out.println(" ");
        System.out.println("******* Interface Segregation  *******");
        System.out.println(" ");
        InterfaceSegregation interfaceSegregation = new InterfaceSegregation();
        interfaceSegregation.ejecutar();
        System.out.println(" ");
        System.out.println("******* Liskov Open Close  *******");
        System.out.println(" ");
        OpenClose openClose = new OpenClose();
        openClose.ejecutar();
        System.out.println(" ");
        System.out.println("******* Liskov Substitution  *******");
        System.out.println(" ");
        LiskovSubstitution liskovSubstitution = new LiskovSubstitution();
        liskovSubstitution.ejecutar();
        SingleResponsibility single = new SingleResponsibility();
        System.out.println(" ");
        System.out.println("******* Single Responsibility  *******");
        System.out.println("    ");
        single.ejecutar();
    }
}