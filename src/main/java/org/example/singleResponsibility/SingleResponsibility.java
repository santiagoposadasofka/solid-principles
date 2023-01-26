package org.example.singleResponsibility;

import java.util.ArrayList;
import java.util.List;

public class SingleResponsibility {
    /**
     * Van instanciar una cuenta bancaria y van a generar varios comportamientos en ella,
     * van a instanciar una clase sistema, revisando las otras clases de las cuales la clase sistema depende,
     * van a ejecutar sus comportamientos.
     * Van a establecer un ejemplo de una clase que sigue este patron o una clase que no lo sigue.
     */

    /****
     * creo solo un metodo para las dos clases o ejecutarCuentaBancaria o ejecutarSistema?
     */
    public void ejecutar() {

        List<CuentaBancaria> cuenta = new ArrayList<>();
        cuenta.add(new CuentaBancaria(1000));
        cuenta.add(new CuentaBancaria(5000000));
        cuenta.add(new CuentaBancaria(5000));
        /***
         * crear una nueva instancia de la clase y proporcionar un saldo inicial:
         */
        CuentaBancaria miCuentaBancaria = new CuentaBancaria(50000);
        /**
         * para modificar el saldo de la cuenta:
         */
        miCuentaBancaria.depositar(10000);
        miCuentaBancaria.retirar(500);

        /**
         * para obtener el saldo actual de la cuenta:
         */
        double saldoActual = miCuentaBancaria.getSaldo();
        // System.out.println("saldo actual" + ": " + saldoActual);


        /**
         * crear una nueva instancia de la clase sistema
         */

        Sistema miSistema = new Sistema();
        miSistema.depositar(50000);
        miSistema.retirar(1000);
        /***
         * probar si funcionan
         */
        EmailSender emailSender = new EmailSender();
        Printer printer = new Printer();
        Database db = new Database();


        TarjetaDeCredito tarjeta = new TarjetaDeCredito(50000);
        tarjeta.gastar(10000);
        tarjeta.gastar(40000);
        double tarjetaSaldo = tarjeta.getSaldo();
        System.out.println("el saldo de la tarjeta es-->" + "  " + tarjetaSaldo);


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

    /**
     * cree otro atributo a cuenta bancaria que es su numero
     * de cuenta correspondiente a la cuenta
     * <p>
     * private String numeroDeCuenta;
     * <p>
     * <p>
     * Le creo su correspiente metodo
     * <p>
     * <p>
     * public CuentaBancaria(String numeroDeCuenta, int saldo) {
     * this.numeroDeCuenta = numeroDeCuenta;
     * this.saldo = 0;
     * }
     */

    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(double cantidad) {
        this.saldo += cantidad;
    }

    public void retirar(double cantidad) {
        if (cantidad > this.saldo) {
            throw new IllegalArgumentException("No hay suficientes fondos para retirar esa cantidad");
        }
        this.saldo -= cantidad;
    }

    public double getSaldo() {
        return this.saldo;
    }
}


/****
 * el patron responsability un ejemplo de tarjeta de credito donde solo tiene las responsailidades de la tarjeta de credito
 *
 */
class TarjetaDeCredito {
    private double limite;
    private double saldo;


    public TarjetaDeCredito(double limiteInicial) {
        this.limite = limiteInicial;
        this.saldo = 0;
    }

    public void gastar(double cantidad) {
        if (cantidad > this.limite - this.saldo) {
            throw new IllegalArgumentException("Excediste el limite de la tarjeta");
        }
        this.saldo += cantidad;
    }

    public void pagar(double cantidad) {
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
 * Een este ejemplo se ve como la clase Sistema tiene varias responsabilidades, manejar transacciones bancarias, enviar correos, imprimir recibos,
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
