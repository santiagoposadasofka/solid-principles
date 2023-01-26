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
        System.out.println("--------------Cuenta bancaria------------------");
        System.out.println(" \n ");
        SingleResponsibility single = new SingleResponsibility();
        single.ejecutar();

        System.out.println(" \n ");
        System.out.println("--------------Antipatrón------------------");
        System.out.println(" \n ");

        single.ejecutar2();

        System.out.println(" \n ");
        System.out.println("--------------Productos------------------");
        OpenClose open = new OpenClose();
        open.ejecutar();

        System.out.println(" \n ");
        System.out.println("--------------AntiClose------------------");
        System.out.println(" \n ");
        open.ejecutarAnti();

        System.out.println(" \n ");
        System.out.println("--------------Interface Segregation------------------");
        System.out.println(" \n ");
        InterfaceSegregation inter = new InterfaceSegregation();
        inter.ejecutar();

        System.out.println(" \n ");
        System.out.println("--------------Interface Segregation------------------");
        System.out.println(" \n ");
        DependencyInvesion depend = new DependencyInvesion();
        depend.ejecutar();


    }
}