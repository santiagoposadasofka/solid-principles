package org.example;

import org.example.dependecyInversion.DependencyInvesion;
import org.example.liskovSubstitution.LiskovSubstitution;
import org.example.openClose.OpenClose;
import org.example.singleResponsibility.SingleResponsibility;

public class Main {
    public static void main(String[] args) {
        LiskovSubstitution liskovSubstitution = new LiskovSubstitution();
        liskovSubstitution.Ejecutar();


        OpenClose openClose = new OpenClose();
        openClose.Ejecutar();


 SingleResponsibility single = new SingleResponsibility();
 single.Ejecutar();

 DependencyInvesion dependency = new DependencyInvesion();
 dependency.Ejecutar();
    }
}