package org.example.singleResponsibility;

public class SingleResponsibility {
    public void ejecutar() {
        System.out.println("Ejecutando ejemplos del patrón Single Responsibility.");
        /*
         * Instancia de una cuenta bancaria con un saldo inicial de $1'000.000.
         * Se añaden $100.000 a la cuenta.
         * Se retiran $50.000 de la cuenta.
         * Se consulta el saldo de la cuenta.
         */
        CuentaBancaria cuentaBancaria = new CuentaBancaria(1000000);
        cuentaBancaria.depositar(100000);
        cuentaBancaria.retirar(50000);
        System.out.println(cuentaBancaria.getSaldo());

        System.out.println("\nEjecutando anti-patrón de Single Responsibility.");
        /*
         * Instancia de un sistema.
         * Se añaden $100.000 a la cuenta del sistema, imprimiendo el recibo y guardándolo en la base de datos.
         * Se retiran $50.000 de la cuenta del sistema, imprimiendo el recibo, guardándolo en la base de datos y
         * enviando un correo al dueño de la cuenta.
         */
        Sistema sistema = new Sistema();
        sistema.depositar(100000);
        sistema.retirar(50000);

        System.out.println("\n\nEjecutando nuevo ejemplo anti-patrón de Single Responsibility.");
        /*
         * Instancia de un producto.
         * Se mira el nombre y precio del producto antes de impuestos.
         * Se calcula el IVA
         * Se mira el precio del producto después de IVA.
         */
        Producto producto = new Producto("Arepas", 3000);
        System.out.println(producto.getNombre() + " cuesta $" + producto.getPrecio() + " sin IVA.");
        producto.setNuevoPrecio();
        System.out.println("Nuevo precio $" + producto.getPrecio());
    }
}

/*
 * Un ejemplo de patrón de responsabilidad única en Java podría ser una clase "CuentaBancaria" que solo se encarga de
 * las operaciones relacionadas con una cuenta bancaria, como depositar o retirar dinero. Esta clase únicamente tendría
 * responsabilidades relacionadas con la cuenta bancaria y no se preocuparía por otras tareas, como el envío de correos
 * electrónicos o la impresión de recibos. La clase tiene un solo método de negocio, depositar y retirar dinero, y un
 * método de consulta, getSaldo, esto se asegura que la clase tenga una sola responsabilidad, en este caso, administrar
 * las transacciones de la cuenta bancaria y no hacer otra cosa.
 */

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
            throw new IllegalArgumentException("No hay suficientes fondos.");
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
 */

class Sistema {
    private final CuentaBancaria cuenta;
    private final EmailSender emailSender;
    private final Printer printer;
    private final Database db;

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

/*
 * Un ejemplo de anti-patrón del principio de Single Responsibility en Java podría ser una clase "Producto" que es
 * responsable de calcular su propio IVA además de tener sus atributos como producto en sí mismo, en lugar de tener otra
 * clase responsable de calcular el IVA de diferentes productos y que a su vez pueda modificar la tasa del impuesto.
 */

class Producto {
    private final String nombre;
    private double precio;

    public Producto(String nombreProducto, double precioProducto) {
        this.nombre = nombreProducto;
        this.precio = precioProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setNuevoPrecio() {
        double IVA = 1.19;
        this.precio *= IVA;
    }
}