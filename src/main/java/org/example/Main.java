package org.example;

import org.example.liskovSubstitution.LiskovSubstitution;
import org.example.singleResponsibility.SingleResponsibility;
import org.example.openClose.OpenClose;
import org.example.interfaceSegregation.InterfaceSegregation;
import org.example.dependecyInversion.DependencyInvesion;


public class Main {
    public static void main(String[] args) {

        //Principo de sustitucion de liskov
        LiskovSubstitution liskovSubstitution = new LiskovSubstitution();
        liskovSubstitution.ejecutar();
        System.out.println("\n");

        //Pirncipio de responsabilidad unica
        SingleResponsibility single = new SingleResponsibility();
        System.out.println("\n");

        //Principio de segregacion de interfaz
        InterfaceSegregation.ejecutar();
        System.out.println("\n");

        //Principio de inversion de dependencia
        System.out.println("\n");
        DependencyInvesion.ejecutar();

        //Principio de abierto y cerrado
        System.out.println("\n");
        OpenClose.ejecutar();









    }
}