package org.example;

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

        var liskovSubstitution = new LiskovSubstitution();
        liskovSubstitution.ejecutar();

        OpenClose openClose = new OpenClose();
        openClose.ejecutar();




    }
}