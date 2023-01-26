package org.example;

import org.example.liskovSubstitution.EjemploAntipatron;
import org.example.liskovSubstitution.LiskovSubstitution;
import org.example.openClose.OpenClose;
import org.example.singleResponsibility.SingleResponsibility;

public class Main {
    public static void main(String[] args) {
        System.out.println("------Patron SingleResponsability-----");
        /**
        SingleResponsibility single = new SingleResponsibility();
        single.ejecutar();
        **/
        System.out.println("----------Patron Openclose-----------");
        OpenClose openClose = new OpenClose();
        openClose.ejecutar();
        System.out.println("-----------Patron liskov-------------");
        LiskovSubstitution liskovSubstitution = new LiskovSubstitution();
        liskovSubstitution.ejecutar();
        System.out.println("----------Antipatron liskov----------");
        EjemploAntipatron ejemploAntipatron = new EjemploAntipatron();
        ejemploAntipatron.ejecutar();
        System.out.println("-----------Patron interfaz-----------");

    }
}