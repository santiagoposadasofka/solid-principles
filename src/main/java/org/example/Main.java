package org.example;

import org.example.interfaceSegregation.InterfaceSegregation;
import org.example.liskovSubstitution.LiskovSubstitution;
import org.example.openClose.OpenClose;
import org.example.singleResponsibility.SingleResponsibility;

public class Main {
    public static void main(String[] args) {
        System.out.println("[ Ejecución ejercicios principio SOLID ]");

        System.out.println("Principio de responsabilidad única");
        SingleResponsibility single = new SingleResponsibility();
        single.ejecutarCuenta();
        single.ejecutarSistema();
        single.ejecutarEjemplo();

        System.out.println("");
        LiskovSubstitution liskovSubstitution = new LiskovSubstitution();
        liskovSubstitution.ejecutar();

        OpenClose openClose = new OpenClose();
        //openClose.ejecutarImpuesto();
        //openClose.ejecutarEjemplo();

        InterfaceSegregation interfaceSegregation = new InterfaceSegregation();
        //interfaceSegregation.ejecutarEjemplo();
    }
}