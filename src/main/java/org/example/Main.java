package org.example;

import org.example.dependecyInversion.DependencyInvesion;
import org.example.interfaceSegregation.InterfaceSegregation;
import org.example.liskovSubstitution.LiskovSubstitution;
import org.example.openClose.OpenClose;
import org.example.singleResponsibility.SingleResponsibility;

public class Main {
    public static void main(String[] args) {
        LiskovSubstitution liskovSubstitution = new LiskovSubstitution();
        liskovSubstitution.ejecutar();

        SingleResponsibility singleResponsibility = new SingleResponsibility();
        singleResponsibility.ejecutar();

        OpenClose openClose = new OpenClose();
        openClose.ejecutar();

        DependencyInvesion dependencyInvesion = new DependencyInvesion();
        dependencyInvesion.ejecutar();

        InterfaceSegregation interfaceSegregation = new InterfaceSegregation();
        dependencyInvesion.ejecutar();
    }
}