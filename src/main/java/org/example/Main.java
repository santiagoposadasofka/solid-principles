package org.example;

import org.example.dependecyInversion.DependencyInvesion;
import org.example.liskovSubstitution.LiskovSubstitution;
import org.example.openClose.OpenClose;
import org.example.singleResponsibility.SingleResponsibility;

public class Main {
    public static void main(String[] args) {


        LiskovSubstitution liskovSubstitution = new LiskovSubstitution();
        liskovSubstitution.ejecutar();


        OpenClose openClose = new OpenClose();
        openClose.ejecutar();


        SingleResponsibility single = new SingleResponsibility();
        single.ejecutar();

        DependencyInvesion dependency = new DependencyInvesion();
        dependency.ejecutar();

    }
}