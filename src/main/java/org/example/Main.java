package org.example;

import org.example.liskovSubstitution.LiskovSubstitution;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        var liskovSubstitution = new LiskovSubstitution();
        liskovSubstitution.ejecutar();
    }
}