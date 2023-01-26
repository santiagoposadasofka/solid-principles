package org.example;

import org.example.liskovSubstitution.LiskovSubstitution;
import org.example.singleResponsibility.SingleResponsibility;

public class Main {
    public static void main(String[] args) {
        SingleResponsibility single = new SingleResponsibility();
        single.ejecutar();
        LiskovSubstitution liskovSubstitution = new LiskovSubstitution();
        liskovSubstitution.ejecutar();


    }
}