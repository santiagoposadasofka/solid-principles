package org.example;

import org.example.liskovSubstitution.LiskovSubstitution;

import org.example.openClose.OpenClose;
import org.example.singleResponsibility.SingleResponsibility;

public class Main {
    public static void main(String[] args) {

        System.out.println("---SINGLE RESPONSABILITY---");

        SingleResponsibility single = new SingleResponsibility();
        single.ejecutar();

        System.out.println("---LISKOV SUBSTITUTION---");

        LiskovSubstitution liskov = new LiskovSubstitution();
        liskov.ejecutar();

    }
}