package org.example.singleResponsibility;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class SingleResponsibility {
    /**
     * Van instanciar una cuenta Bancaria y van a generar varios comportamientos en ella,
     * van a instanciar una clase sistema, revisando las otras clases de las cuales la clase sistema depende,
     * van a ejecutar sus comportamientos.
     * Van a establecer un ejemplo de una clase que sigue este patron o una clase que no lo sigue.
     * */
    public static void ejecutar(){
        ImprimirRecibo imprimirRecibo=new ImprimirRecibo();
        Printer imp=new Printer();
        Database db=new Database();
        CuentaBancaria cuenta=new CuentaBancaria(2100);
        cuenta.depositar(4400);
        imp.print("Se hizo un correcto depósito de 4400, su nuevo saldo es: "+cuenta.getSaldo());
        db.saveTransaction("Deposit. 00001");
        cuenta.retirar(3500);
        imp.print("Se realizó un retiro de 3500, su nuevo saldo es: "+cuenta.getSaldo());
        db.saveTransaction("Ret. 00002");
        System.out.println("\n");
        Sistema sistema=new Sistema();
        sistema.depositar(3500);
        sistema.retirar(1000);
        System.out.println("\n");
        imprimirRecibo.imprimirRecibo(db,"retiro");
    }
}
class ImprimirRecibo{
    Printer imp=new Printer();
    Fecha date=new Fecha();
    public void imprimirRecibo(Database database,String motivo){
        imp.print("Se ha creado el recibo No. "+ ThreadLocalRandom.current().nextInt(100,1001)
                +"\n\nCon fecha "+date.obtenerFecha(LocalDateTime.now()) +
                "\nrealizando un "+motivo+" exitosamente");
    }
}
class Fecha{
    public String obtenerFecha(LocalDateTime ahora){
        return ahora.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
}

/*
 * Un ejemplo de patrón de responsabilidad única en Java podría ser una clase "CuentaBancaria" que solo se encarga de
 * las operaciones relacionadas con una cuenta bancaria, como depositar o retirar dinero. Esta clase solo tendría
 * responsabilidades relacionadas con la cuenta bancaria y no se preocuparía por otras tareas, como el envío de correos
 * electrónicos o la impresión de recibos. La clase tiene un solo método de negocio, depositar y retirar dinero, y un
 * método de consulta, getSaldo, esto se asegura que la clase tenga una sola responsabilidad, en este caso, administrar
 * las transacciones de la cuenta bancaria y no hacer otra cosa.
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
 * Un anti-patrón del principio de responsabilidad única en Java podría ser una clase "Sistema" que hace muchas cosas
 * diferentes, como manejar transacciones bancarias, enviar correos electrónicos, imprimir recibos, realizar cálculos y
 * almacenar información en una base de datos. Esta clase tendría muchas responsabilidades diferentes, lo que
 * dificultaría su comprensión, su mantenimiento y su escalabilidad. En este ejemplo se ve como la clase Sistema tiene
 * varias responsabilidades, manejar transacciones bancarias, enviar correos, imprimir recibos, almacenar información en
 * una base de datos, esto dificulta su comprensión, su mantenimiento y escalabilidad. Es mejor crear varias clases
 * diferentes para cada responsabilidad.
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
