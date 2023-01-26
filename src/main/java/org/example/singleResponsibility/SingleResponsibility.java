package org.example.singleResponsibility;

public class SingleResponsibility {
    /**
     * Van instanciar una cuenta vancaria y van a generar varios comportamientos en ella,
     * van a instanciar una clase sistema, revisando las otras clases de las cuales la clase sistema depende,
     * van a ejecutar sus comportamientos.
     * Van a establecer un ejemplo de una clase que sigue este patron o una clase que no lo sigue.
     * */

    public void ejecutarCuentaBancaria(){
        System.out.println("\nComportamientos cuenta bancaria patron");
        CuentaBancaria cuentaBancaria=new CuentaBancaria(50000);
        cuentaBancaria.depositar(10000);
        //cuentaBancaria.retirar((500000));
        cuentaBancaria.retirar((5000));
    }

    public void ejecutarSistema(){

        System.out.println("\nComportamientos sistema antipatron");
        Sistema sistema=new Sistema();
        sistema.depositar(20000);
        sistema.retirar(10000);
    }

    public void ejecutarAnimal(){
        System.out.println("\nComportamiento ejemplo que sigue el patron");
        Animal animal=new Animal("Pedro","alas");
        animal.verAnimal();
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
        System.out.println("Saldo actual: "+saldo);
        this.saldo += cantidad;
        System.out.println("Usted deposito: "+cantidad+", saldo actual: "+saldo);
    }

    public void retirar(double cantidad) {
        if (cantidad > this.saldo) {
            throw new IllegalArgumentException("No hay suficientes fondos");
        }
        this.saldo -= cantidad;
        System.out.println("Usted retiro: "+cantidad+ ", su saldo actual es "+saldo);
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
        //printer.print(receipt);
        db.saveTransaction(receipt);
    }

    public void retirar(double cantidad) {
        cuenta.retirar(cantidad);
        String receipt = "Retiro de: " + cantidad;
        //printer.print(receipt);
        db.saveTransaction(receipt);
        emailSender.send("Retiro realizado", receipt);
    }

}

class Animal{
    private String nombre;
    private String movilidad;

    public Animal(String nombre, String movilidad) {
        this.nombre = nombre;
        this.movilidad = movilidad;
    }

    public void verAnimal(){
        String mov;
        if(movilidad=="patas"){
            mov="terrestre";
        }else if(movilidad=="aletas"){
            mov="acuatico";
        }else if(movilidad=="alas"){
            mov="volador";
        }else{
            mov="desconocida";
        }
        System.out.println("Este animal se llama "+nombre+", y es "+mov);
    }


}
