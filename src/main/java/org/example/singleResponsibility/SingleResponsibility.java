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

        System.out.println("-----------Cuenta Bancaria ----------------");
        /**
         * Instanciando Cuenta Bancaria y sus comportamientos
         */

        CuentaBancaria transacciones = new CuentaBancaria(300.0);

        System.out.println("Saldo actual " + transacciones.getSaldo());

        transacciones.depositar(500.0);
        System.out.println("Saldo despues del depósito " + transacciones.getSaldo());

        transacciones.retirar(200);

        System.out.println("Saldo despues del retiro " + transacciones.getSaldo());

        System.out.println("-----------Sistema ----------------");

        /**
         * Instanciando Sistema y sus comportamientos
         */
        Sistema movimientos = new Sistema();

        movimientos.depositar(1000);
        movimientos.retirar(657);

        /**
         * Instanciando Clase Cliente como ejemplo de Single Responsability
         */
        System.out.println("\n");
        System.out.println("-----------Clase Cliente ----------------");

        List<Cliente> cliente = new ArrayList<>();
        cliente.add(new Cliente("Carlos", "San Diego av 30 calle 12 - 20"));
        cliente.add(new Cliente("Carla", "Cra 6 # 15 -17 Armenia"));

        for (Cliente client:cliente) {
            System.out.println("Nombre: " + client.getNombre());
            System.out.println("Direccion: " + client.getDireccion());

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

/**
 * Clase que cumple con el patron SingleResponsability puesto que solo se encarga de la informacion del Cliente, nombre y direccion
 */
class Cliente {
    private String nombre;
    private String direccion;

    public Cliente(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
}