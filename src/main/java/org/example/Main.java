package org.example;

// import org.example.liskovSubstitution.LiskovSubstitution;
import org.example.singleResponsibility.SingleResponsibility;

public class Main {
    public static void main(String[] args) {
        // Se ejecutan los ejemplos de uso de este principio
        SingleResponsibility single = new SingleResponsibility();
        single.ejecutar();

        // Se ejecutan los ejemplos de uso de este principio
        // LiskovSubstitution liskovSubstitution = new LiskovSubstitution();
        // liskovSubstitution.ejecutar();


    }
}