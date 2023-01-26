package org.example.singleResponsibility;

import java.util.Scanner;

public class SingleResponsibility {
    /**
     * Van instanciar una cuenta bancaria y van a generar varios comportamientos en ella,
     * van a instanciar una clase sistema, revisando las otras clases de las cuales la clase sistema depende,
     * van a ejecutar sus comportamientos.
     * Van a establecer un ejemplo de una clase que sigue este patron o una clase que no lo sigue.
     * */
    Scanner in = new Scanner(System.in);
    private double cantidad;
    private double saldo;
    int opc = 0;
    CuentaBancaria cuentaBancaria = new CuentaBancaria(saldo);
    public void ejecutarSingleResponsibilityCuenta(){
        do{
            System.out.println("Cuenta Bancaria");
            System.out.println("\nElige una opción");
            System.out.println("1. Depositar dinero. \n2. Retirar dinero. \n3. Ver saldo. \n4. Salir");
            opc = in.nextInt();

            switch (opc) {
                case 1:
                    System.out.println("Cuanto dinero desea depositar");
                    cantidad = in.nextDouble();
                    cuentaBancaria.depositar(cantidad);
                    break;
                case 2:
                   System.out.println("Cuanto dinero desea retirar");
                   cantidad = in.nextDouble();
                   cuentaBancaria.retirar(cantidad);
                   break;
                case 3:
                    System.out.println("Su saldo es de $:" + cuentaBancaria.getSaldo());
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción Incorrecta");
            }
        }while (opc!=4);

    }


    Sistema sistema = new Sistema();
    public void ejecutarSingleResponsibilitySistema() {
        do{
            System.out.println("Cuenta Bancaria");
            System.out.println("\nElige una opción");
            System.out.println("1. Depositar dinero. \n2. Retirar dinero. \n3. Salir");
            opc = in.nextInt();

            switch (opc) {
                case 1:
                    System.out.println("Cuanto dinero desea depositar");
                    cantidad = in.nextDouble();
                    sistema.depositar(cantidad);
                    break;
                case 2:
                    System.out.println("Cuanto dinero desea retirar");
                    cantidad = in.nextDouble();
                    sistema.retirar(cantidad);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción Incorrecta");
            }
        }while (opc!=4);
    }
    private String usuario;
    private String clave;

    RedSocial redSocial = new RedSocial(usuario, clave);

    public void ejecutarSingleResponsibilityAntiPatron() {
        do{
            System.out.println("Bienvenido a tu Red Social");
            System.out.println("1. Inicar Sesión \n2. Registrate \n3. Salir");
            opc = in.nextInt();

            switch (opc) {
                case 1:
                    in.nextLine();
                    System.out.println("Digite su nombre de usuario");
                    usuario = in.nextLine();
                    System.out.println("Digite su contraseña");
                    clave = in.nextLine();
                    redSocial.loguin(usuario,clave);
                    break;
                case 2:
                    in.nextLine();
                    System.out.println("Usuario que desea utilizar");
                    usuario = in.nextLine();
                    System.out.println("Digite una contraseña");
                    clave = in.nextLine();
                    redSocial.registro(usuario,clave);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción Incorrecta");
            }
        }while (opc!=3);
    }

}
class RedSocial {
    private String usuario;
    private String clave;

    public RedSocial(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    public void registro (String usuarioRegistro, String claveRegistro) {
        this.usuario = usuarioRegistro;
        this.clave = claveRegistro;
    }

    public void loguin (String usuarioLoguin, String claveLoguin) {
        if (this.usuario.equals(usuarioLoguin) && this.clave.equals(claveLoguin)) {
            System.out.println("Inicio de sesión exitosa");
        }else {
            System.out.println("Usuario o contraseña incorrecta");
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
