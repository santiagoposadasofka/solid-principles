package org.example.singleResponsibility;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;

public class SingleResponsibility {
    /**
     * Van instanciar una cuenta bancaria y van a generar varios comportamientos en ella,
     * van a instanciar una clase sistema, revisando las otras clases de las cuales la clase sistema depende,
     * van a ejecutar sus comportamientos.
     * Van a establecer un ejemplo de una clase que sigue este patron o una clase que no lo sigue.
     * */

    /**
     * Atributos
     */
    public double cantidad;
    public double saldo = 50000;
    public int opcion = 0;

    //Instancia de la clase cuenta bancaria
    CuentaBancaria cuentaBancaria = new CuentaBancaria(saldo);

    //Método ejecutar cuenta
    public void ejecutarCuenta(){
        /**
         * Repetir el menú, hasta que el usuario presione la opción salir.
         */
        do {
            Scanner entrada = new Scanner(System.in);
            System.out.println("Bienvenido(a) a tu cuenta bancaria\n" +
                    "Por favor digita la opción que deseas: \n" +
                    "1. Depositar\n" +
                    "2. Retirar\n" +
                    "3. Consultar saldo\n" +
                    "4. Retirar tarjeta");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("¿Cuánto dinero desea depositar?");
                    cantidad = entrada.nextDouble();
                    cuentaBancaria.depositar(cantidad);
                    break;

                case 2:
                    System.out.println("¿Cuánto dinero desea retirar?");
                    cantidad = entrada.nextDouble();
                    cuentaBancaria.retirar(cantidad);
                    break;

                case 3:
                    System.out.println("Su saldo actual es: " + cuentaBancaria.getSaldo());
                    break;

                case 4:
                    System.exit(0);
                    break;
                /**
                 * Mensaje en caso de digitar un número que no esté en el menú
                 */
                default:
                    System.out.println("Número no valido");
            }
        } while (opcion!=4);
    }

    //Instancia de la clase sistema
    Sistema sistema = new Sistema();

    //Método ejecutar Sistema
    public void ejecutarSistema() {
        //Atributos
        saldo = 0;
        /**
         * Repetir el menú, hasta que el usuario presione la opción retirar tarjeta.
         */
        do {
            Scanner entrada = new Scanner(System.in);
            System.out.println("Bienvenido(a) a tu cuenta bancaria\n" +
                    "Por favor digita la opción que deseas: \n" +
                    "1. Depositar\n" +
                    "2. Retirar\n" +
                    "3. Retirar tarjeta");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("¿Cuánto dinero desea depositar?");
                    cantidad = entrada.nextDouble();
                    sistema.depositar(cantidad);
                    break;

                case 2:
                    System.out.println("¿Cuánto dinero desea retirar?");
                    cantidad = entrada.nextDouble();
                    sistema.retirar(cantidad);
                    System.out.println("Su saldo actual es de: " + saldo);
                    break;

                case 3:
                    System.exit(0);
                    break;
                /**
                 * Mensaje en caso de digitar un número que no esté en el menú
                 */
                default:
                    System.out.println("Número no valido");
            }
        } while (opcion!=3);
    }

    private int numDocumento;
    private String nombreAlumno;
    private int celular;
    private int edad;
    private String nombreCurso;

    //Instancia de la clase ejemplo de registro a un curso.
    EjemploRegistroCurso ejmRegistroCurso = new EjemploRegistroCurso();

    //Método ejecutar ejemplo sobre el principio de responsabilidad única.
    public void ejecutarEjemplo(){
        //Atributos
        saldo = 0;
        /**
         * Repetir el menú, hasta que el usuario presione la opción salir.
         */
        do {
            Scanner entrada = new Scanner(System.in);
            System.out.println("Bienvenido(a) al registro de cursos\n" +
                    "Por favor digita la opción que deseas: \n" +
                    "1. Registrarse\n" +
                    "2. Consultar cursos disponibles\n" +
                    "3. Salir");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Dígite su número de documento: ");
                    numDocumento = entrada.nextInt();

                    System.out.println("Dígite su nombre completo: ");
                    nombreAlumno = entrada.next();

                    System.out.println("Dígite su número de celular: ");
                    celular= entrada.nextInt();

                    System.out.println("Dígite su edad: ");
                    edad= entrada.nextInt();

                    System.out.println("Dígite el nombre del curso: ");
                    nombreCurso = entrada.next();

                    System.out.println("El usuario: " + nombreAlumno + " quedó registrado en el curso: " + nombreCurso + " satisfactoriamente.");
                    break;
                case 2:
                    System.out.println("En este momento están disponibles los siguientes cursos: \nInformática básica. \nExcel. \nRobótica.");
                    break;

                case 3:
                    System.exit(0);
                    break;
                /**
                 * Mensaje en caso de digitar un número que no esté en el menú
                 */
                default:
                    System.out.println("Número no valido");
            }
        } while (opcion!=3);
    }
}

/**
 * Ejemplo de una clase que sigue el patrón de responsabilidad única.
 */
class EjemploRegistroCurso{
    /**
     * Atributos
     */
    private int numDocumento;
    private String nombreAlumno;
    private int celular;
    private int edad;
    private String nombreCurso;

    //Este método permitirá a un usuario registrarse a un curso.
    public void registroCurso(int numDocumento, String nombreAlumno, int celular, int edad, String nombreCurso){
        this.numDocumento = numDocumento;
        this.nombreAlumno = nombreAlumno;
        this.celular = celular;
        this.edad = edad;
        this.nombreCurso = nombreCurso;
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
