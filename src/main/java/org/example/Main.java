package org.example;

import org.example.dependecyInversion.DependencyInvesion;
import org.example.interfaceSegregation.InterfaceSegregation;
import org.example.liskovSubstitution.LiskovSubstitution;
import org.example.openClose.OpenClose;
import org.example.singleResponsibility.Database;
import org.example.singleResponsibility.SingleResponsibility;

public class Main {
    public static void main(String[] args) {
        LiskovSubstitution liskovSubstitution = new LiskovSubstitution();
        liskovSubstitution.ejecutar();


        //Instancia de Single Responsibility y ejecucion de Cuenta Bancaria
        SingleResponsibility single = new SingleResponsibility();
        single.ejecutar();

        //Anti Patron Sistema
        single.ejecutarSistema();
        //Nueva instancia de Student que aplica Single Responsibility
        single.ejecutarStudent();

        /// Instancia de Open Close
        OpenClose open =  new OpenClose();
        open.ejecutarPrincipio();
        open.ejecutarAntiPatron();
        open.ejecutarnuevoAntiPatron();

        //Instancia de Interface Segregation
        InterfaceSegregation inter = new InterfaceSegregation();
        inter.ejecutar();
        inter.ejecutarEjemplo();

        //Instancia de Dependency inversion
        DependencyInvesion dependency = new DependencyInvesion();
        dependency.ejecutar();
        dependency.ejecutarEjemplo();
    }
}