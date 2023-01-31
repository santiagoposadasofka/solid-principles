package org.example.singleResponsibility;

public class SingleResponsibility {
    /**
     * Van instanciar una cuenta bancaria y van a generar varios comportamientos en ella,
     * van a instanciar una clase sistema, revisando las otras clases de las cuales la clase sistema depende,
     * van a ejecutar sus comportamientos.
     * Van a establecer un ejemplo de una clase que sigue este patron o una clase que no lo sigue.
     * */

    //Pantron de responsabilidad unica
    public void ejecutar(){
        CuentaBancaria cuentaBancaria1 = new CuentaBancaria(1000);
        System.out.println("Saldo incial  = " + cuentaBancaria1.getSaldo());
        cuentaBancaria1.depositar(1000);
        System.out.println("Este es tu nuevo saldo = " + cuentaBancaria1.getSaldo());
        cuentaBancaria1.retirar(500);
    }

    //Ejecutar el sistema
    public void EjecutarSistema (){
        System.out.println(" INSTANCIA ANTI PATRON " );
        Sistema sistema = new Sistema();
        sistema.depositar(2000);
        System.out.println("\n" );
        sistema.retirar(1000);
    }

    public void ejecutarTrabajador(){




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
        System.out.println("Tu saldo despues de retirar es " + saldo);
    }

    public double getSaldo() {
        return this.saldo;
    }
}


// Clase trabajador que tiene un metodo de consulta y un metodo de negocio
 class  Trabajador {
        private String nombre;
        private String apellido;


    public  Trabajador (String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void MostrarNombre(){
        String nombreCompleto = nombre + " " + apellido;
        System.out.println(" Su nombre completo es " );
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
