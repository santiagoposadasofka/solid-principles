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

        SingleResponsibility single = new SingleResponsibility();
        single.ejecutar();

        OpenClose openclose= new OpenClose();
        openclose.Ejecutar();

        DependencyInvesion dependencyInvesion =new DependencyInvesion();
        dependencyInvesion.Ejecutar();

        InterfaceSegregation interfaceSegregation=new InterfaceSegregation();
        interfaceSegregation.Ejecutar();
    }
}