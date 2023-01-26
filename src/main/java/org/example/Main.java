package org.example;

import org.example.dependecyInversion.DependencyInvesion;
import org.example.interfaceSegregation.InterfaceSegregation;
import org.example.liskovSubstitution.LiskovSubstitution;
import org.example.openClose.OpenClose;
import org.example.singleResponsibility.SingleResponsibility;

public class Main {
    public static void main(String[] args) {
        SingleResponsibility.ejecutar();
        System.out.println("\n");
        OpenClose.ejecutar();
        System.out.println("\n");
        LiskovSubstitution.ejecutar();
        System.out.println("\n");
        InterfaceSegregation.ejecutar();
        System.out.println("\n");
        DependencyInvesion.ejecutar();
    }
}