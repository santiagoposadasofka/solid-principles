package org.example;

import org.example.liskovSubstitution.LiskovSubstitution;
import org.example.openClose.OpenClose;
import org.example.singleResponsibility.SingleResponsibility;

public class Main {
    public static void main(String[] args) {

        System.out.println("-----------LiskovSubstitution ----------------");
        LiskovSubstitution liskovSubstitution = new LiskovSubstitution();
        liskovSubstitution.ejecutar();
        System.out.println("\n");

        System.out.println("-----------SingleResponsibility ----------------");

        SingleResponsibility single = new SingleResponsibility();
        single.ejecutar();
        System.out.println("\n");

        System.out.println("-----------OpenClose ----------------");

        OpenClose openClose = new OpenClose();
        openClose.ejecutar();
        System.out.println("\n");
    }
}