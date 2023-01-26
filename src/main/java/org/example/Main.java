package org.example;

import org.example.dependecyInversion.DependencyInvesion;
import org.example.interfaceSegregation.InterfaceSegregation;
import org.example.liskovSubstitution.LiskovSubstitution;
import org.example.openClose.OpenClose;
import org.example.singleResponsibility.SingleResponsibility;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DependencyInvesion dependencyInvesion=new DependencyInvesion();
        InterfaceSegregation interfaceSegregation=new InterfaceSegregation();
        LiskovSubstitution liskovSubstitution = new LiskovSubstitution();
        OpenClose openClose=new OpenClose();
        SingleResponsibility single = new SingleResponsibility();

        int opcion=1;
        Scanner S=new Scanner(System.in);

        do{
            System.out.println("1: DependencyInvension");
            System.out.println("2: InterfaceSegregation");
            System.out.println("3: LiskovSubstitution");
            System.out.println("4: OpenClose");
            System.out.println("5: SingleResponsability");
            System.out.print("Introduce la opcion:");
            opcion=S.nextInt();
        }while(opcion>5 || opcion<1);

        switch (opcion){
            case 1:
                dependencyInvesion.ejecutar();
                dependencyInvesion.ejecutarDibujar();
                break;
            case 2:
                interfaceSegregation.ejecutarPatron();
                interfaceSegregation.ejecucarAntipatron();
                interfaceSegregation.ejecutar();
                break;
            case 3:
                liskovSubstitution.ejecutar();
                liskovSubstitution.antipatronEmpleado();
                liskovSubstitution.patronServivo();
                break;
            case 4:
                openClose.ejecutarCalculadoraImpuestos();
                openClose.ejecutarAntipatronCalculadora();
                openClose.ejecutarAntipatronAnimal();
                break;
            case 5:
                single.ejecutarCuentaBancaria();
                single.ejecutarSistema();
                single.ejecutarAnimal();
                break;

        }

    }
}