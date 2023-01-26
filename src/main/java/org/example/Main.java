package org.example;

import org.example.liskovSubstitution.LiskovSubstitution;

import org.example.singleResponsibility.SingleResponsibility;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        SingleResponsibility vivienda = new SingleResponsibility();
        vivienda.ejecutar();

        var liskovSubstitution = new LiskovSubstitution();
        liskovSubstitution.ejecutar();



    }
}