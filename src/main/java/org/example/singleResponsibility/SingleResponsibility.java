package org.example.singleResponsibility;

import java.sql.SQLOutput;

public class SingleResponsibility {
    /**
     * Van instanciar una cuenta bancaria y van a generar varios comportamientos en ella,
     * van a instanciar una clase sistema, revisando las otras clases de las cuales la clase sistema depende,
     * van a ejecutar sus comportamientos.
     * Van a establecer un ejemplo de una clase que sigue este patron o una clase que no lo sigue.
     * */

    /*
     * Se realiza ejemplos de cada clase, usando cada metodo correspondiente
     * para interactuar los comportamientos de cada una
     * */

    public void ejecutar()
    {
        CuentaBancaria cuenta = new CuentaBancaria(1000000);
        cuenta.depositar(50000);
        cuenta.retirar(25000);
        cuenta.getSaldo();

        System.out.println("------------------SISTEMA-----------------");

        Sistema sistema = new Sistema();
        sistema.depositar(1200);
        sistema.retirar(1000);

        System.out.println("------------------AUTOMOVIL-----------------");

        Automovil automovil = new Automovil("Chevrolet");
        automovil.cambiarMarca("Nissan");


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
        System.out.println("El saldo de la cuenta bancaria es: " + this.saldo);

        System.out.println("------------------------DEPOSITO----------------------------");
    }

    public void depositar(double cantidad) {
        this.saldo += cantidad;
        System.out.println("Usted ha depositado: " + cantidad);
        System.out.println("-----------------SALDO--------------------");
        System.out.println("El saldo actual es: " + getSaldo());

        System.out.println("------------------------RETIRO----------------------------");
    }

    public void retirar(double cantidad) {
        if (cantidad > this.saldo) {
            throw new IllegalArgumentException("No hay suficientes fondos");
        }
        this.saldo -= cantidad;
        System.out.println("Ha retirado de su cuenta: " + cantidad);
        System.out.println("-----------------SALDO--------------------");
        System.out.println("El saldo actual es: " + getSaldo());

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

        System.out.println("----------------Depositar-------------------");
    }

    public void depositar(double cantidad) {
        cuenta.depositar(cantidad);
        String receipt = "Deposito de: " + cantidad;
        printer.print(receipt);
        db.saveTransaction(receipt);


        System.out.println("----------------RETIRAR-------------------");
    }

    public void retirar(double cantidad) {
        cuenta.retirar(cantidad);
        String receipt = "Retiro de: " + cantidad;
        printer.print(receipt);
        db.saveTransaction(receipt);
        emailSender.send("Retiro realizado", receipt);

    }
}

/*
 * Se agrega la clase automovil, cumpliendo el patron Single Responsibility
 * debido a que solo se trata del cambio de marca y no depende de otras clases
 * para gestionar sus metodos
 * */

class Automovil{
    private String marca;

    public Automovil(String marca) {
        this.marca = marca;
        System.out.println("Marca del Automovil: " + this.marca);

        System.out.println("-----------CAMBIAR MARCA----------");
    }

    public void cambiarMarca(String marca){
        this.marca = marca;
        System.out.println("Haz cambiado la marca del automovil a: " + this.marca);
    }
}