package org.example;

import org.example.interfaceSegregation.InterfaceSegregation;
import org.example.liskovSubstitution.LiskovSubstitution;

import org.example.openClose.OpenClose;
import org.example.singleResponsibility.SingleResponsibility;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        SingleResponsibility vivienda = new SingleResponsibility();
        vivienda.ejecutar();
        SingleResponsibility cuentaBancaria = new SingleResponsibility();
        cuentaBancaria.ejecutar();
        System.out.println();

        var liskovSubstitution = new LiskovSubstitution();
        liskovSubstitution.ejecutar();
        System.out.println();

        InterfaceSegregation interfaceSegregation = new InterfaceSegregation();
        interfaceSegregation.ejecutar();
        System.out.println();

        OpenClose openClose = new OpenClose();
        openClose.ejecutar();




    }
}