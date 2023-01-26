package org.example;

import org.example.liskovSubstitution.LiskovSubstitution;
import org.example.singleResponsibility.SingleResponsibility;

public class Main {
    public static void main(String[] args) {
        SingleResponsibility single = new SingleResponsibility();
        //single.ejecutarSingleResponsibilityCuenta();
        single.ejecutarSingleResponsibilitySistema();
    }
}