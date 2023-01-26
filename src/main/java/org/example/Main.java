package org.example;

import org.example.liskovSubstitution.LiskovSubstitution;
import org.example.openClose.OpenClose;
import org.example.singleResponsibility.SingleResponsibility;

public class Main {
    public static void main(String[] args) {
       /**
        LiskovSubstitution liskovSubstitution = new LiskovSubstitution();
        liskovSubstitution.ejecutar();

        SingleResponsibility single = new SingleResponsibility();
        single.ejecutar();
        **/

        OpenClose openClose = new OpenClose();
        openClose.ejecutar();
    }
}