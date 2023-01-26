package org.example;

import org.example.interfaceSegregation.InterfaceSegregation;
import org.example.liskovSubstitution.LiskovSubstitution;
import org.example.openClose.OpenClose;
import org.example.singleResponsibility.SingleResponsibility;

public class Main {
    public static void main(String[] args) {

        SingleResponsibility single = new SingleResponsibility();
        single.ejecutar();
        single.ejecutar2();
        single.ejecutar3();

        OpenClose open = new OpenClose();
        open.ejecutar();
        open.ejecutar1();
        open.ejecutar2();

        LiskovSubstitution liskov = new LiskovSubstitution();
        liskov.ejecutar();
        liskov.ejecutar1();
        liskov.ejecutar2();

        InterfaceSegregation interfaceSegregation = new InterfaceSegregation();
        interfaceSegregation.ejecutar();
        interfaceSegregation.ejecutar1();


    }
}