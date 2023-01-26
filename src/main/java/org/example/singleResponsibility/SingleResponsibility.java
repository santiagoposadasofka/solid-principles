package org.example.singleResponsibility;

import java.util.ArrayList;
import java.util.List;

public class SingleResponsibility {
    /**
     * Van instanciar una cuenta vancaria y van a generar varios comportamientos en ella,
     * van a instanciar una clase sistema, revisando las otras clases de las cuales la clase sistema depende,
     * van a ejecutar sus comportamientos.
     * Van a establecer un ejemplo de una clase que sigue este patron o una clase que no lo sigue.
     * */

    public void ejecutar(){


        List<CuentaBancaria> cuentasBancarias = new ArrayList<>();
        cuentasBancarias.add(new CuentaBancaria(10000));
        cuentasBancarias.add(new CuentaBancaria(19000));


        for(CuentaBancaria cuentaBancaria: cuentasBancarias){
            System.out.println( "==========================================");
            System.out.println("CUENTA BANCARIA");
            System.out.println( "==========================================");
            System.out.println( "Saldo cuenta bancaria: " + cuentaBancaria.getSaldo());


            cuentaBancaria.depositar(200);
            cuentaBancaria.retirar(2000);


            System.out.println( "Depositar: 200 ");
            System.out.println( "Retirar: 200 ");



            System.out.println( "Nuevo Saldo: " + cuentaBancaria.getSaldo());

        }
        System.out.println("");




        List<Sistema> sistemasList = new ArrayList<>();
        sistemasList.add(new Sistema());

        for(Sistema sistema: sistemasList){
            System.out.println( "==========================================");
            System.out.println("SISTEMA");
            System.out.println( "==========================================");

            sistema.depositar(890);
            sistema.retirar(89);


        }


    }
}


/*
 * Un ejemplo de patrón de responsabilidad única en Java podría ser una clase "CuentaBancaria" que solo se encarga de las operaciones
 * relacionadas con una cuenta bancaria, como depositar o retirar dinero. Esta clase solo tendría responsabilidades relacionadas con la cuenta
 * bancaria y no se preocuparía por otras tareas, como el envío de correos electrónicos o la impresión de recibos.
 * La clase tiene un solo método de negocio, depositar y retirar dinero, y un método de consulta, getSaldo, esto se asegura que la clase tenga
 * una sola responsabilidad, en este caso, administrar las transacciones de la cuenta bancaria y no hacer otra cosa.
 * */

class CuentaBancaria {
    private double saldo;

    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(double cantidad) {
        this.saldo += cantidad;
    }

    public void retirar(double cantidad) {
        if (cantidad > this.saldo) {
            throw new IllegalArgumentException("No hay suficientes fondos");
        }
        this.saldo -= cantidad;
    }

    public double getSaldo() {
        return this.saldo;
    }
}

/*
 * Un anti-patrón del principio de responsabilidad única en Java podría ser una clase "Sistema" que hace muchas cosas diferentes,
 * como manejar transacciones bancarias, enviar correos electrónicos, imprimir recibos, realizar cálculos y almacenar información en
 * una base de datos. Esta clase tendría muchas responsabilidades diferentes, lo que dificultaría su comprensión, su mantenimiento y su escalabilidad.
 * En este ejemplo se ve como la clase Sistema tiene varias responsabilidades, manejar transacciones bancarias, enviar correos, imprimir recibos,
 * almacenar información en una base de datos, esto dificulta su comprensión, su mantenimiento y escalabilidad. Es mejor crear varias clases diferentes
 * para cada responsabilidad.
 * */

class Sistema {
    private CuentaBancaria cuenta;
    private EmailSender emailSender;
    private Printer printer;
    private Database db;

    public Sistema() {
        cuenta = new CuentaBancaria(0);
        emailSender = new EmailSender();
        printer = new Printer();
        db = new Database();
    }

    public void depositar(double cantidad) {
        cuenta.depositar(cantidad);
        String receipt = "Deposito de: " + cantidad;
        printer.print(receipt);
        db.saveTransaction(receipt);
    }

    public void retirar(double cantidad) {
        cuenta.retirar(cantidad);
        String receipt = "Retiro de: " + cantidad;
        printer.print(receipt);
        db.saveTransaction(receipt);
        emailSender.send("Retiro realizado", receipt);
    }
}

/** Ejemplo de clase con patron de responsabilidad
 */
class AlquilerPelicula {
     private double saldo;
   private double costo;
   private String nombre;
   public AlquilerPelicula(double saldo, double costo, String nombre) {
        this.saldo = saldo;
      this.costo = costo;
       this.nombre = nombre;
    }
    public void saldo(double cantidad) {
         this.saldo += cantidad;
    }

    public void alquilar(double cantidad) {
         if (costo> this.saldo) {
             throw new IllegalArgumentException("Saldo insuficiente para alquilar");
        }
        this.saldo -= cantidad;
    }

    public double getSaldo() {
        return this.saldo;
     }

    public double getCosto() {
           return this.costo;
    }
  }

