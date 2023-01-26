package org.example;

import org.example.liskovSubstitution.LiskovSubstitution;
import org.example.openClose.OpenClose;
import org.example.singleResponsibility.Database;
import org.example.singleResponsibility.SingleResponsibility;

public class Main {
    public static void main(String[] args) {
//        LiskovSubstitution liskovSubstitution = new LiskovSubstitution();
//        liskovSubstitution.ejecutar();


//        // Instancia de Single Responsibility y ejecucion de Cuenta Bancaria
//        SingleResponsibility single = new SingleResponsibility();
//        single.ejecutar();
//
//        //Anti Patron Sistema
//        single.ejecutarSistema();
//        //Nueva instancia de Student que aplica Single Responsibility
//        single.ejecutarStudent();

        // Instancia de Open Close
        OpenClose open =  new OpenClose();
        open.ejecutarPrincipio();
        open.ejecutarAntiPatron();
        open.ejecutarnuevoAntiPatron();
    }
}