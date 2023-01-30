package org.example.singleResponsibility;

import java.util.ArrayList;
import java.util.List;

public class SingleResponsibility {
    /**
     * Van instanciar una cuenta bancaria y van a generar varios comportamientos en ella,
     * van a instanciar una clase sistema, revisando las otras clases de las cuales la clase sistema depende,
     * van a ejecutar sus comportamientos.
     * Van a establecer un ejemplo de una clase que sigue este patron o una clase que no lo sigue.
     * */

    public void ejecutar(){
        CuentaBancaria cuentica = new CuentaBancaria(2000);

        cuentica.depositar(1200.00);
        cuentica.retirar(395.00);


        double saldo = cuentica.getSaldo();

        Sistema miSistema = new Sistema();
        miSistema.depositar(1200.00);
        miSistema.retirar(395.00);
        miSistema.tranferir(115);

        //instancio mi ejemplo
        GestorTareas gestor = new GestorTareas();
        Tarea tarea1 = new Tarea("Hacer la tarea de programacion)");
        gestor.agregarTarea(tarea1);
        System.out.println(tarea1);

        Tarea tarea2 = new Tarea("Sacar la ropa de la lavadora");
        gestor.agregarTarea(tarea2);

        List<Tarea> todasLasTareas = gestor.obtenerTareas();
        System.out.println(todasLasTareas);

        List<Tarea> tareasCompletadas = gestor.obtenerTareasCompletadas();
        System.out.println(tareasCompletadas);

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

    public void tranferir(double cantidad){
    cuenta.retirar(cantidad);
    String receipt = "Tranferencia realizada por una cantidad  de: " + cantidad;
    printer.print(receipt);
    db.saveTransaction(receipt);
    emailSender.send("Transferencia realizada exitosamente", receipt);

    }
}


    //creacion del ejemplo correcto
    class Tarea {
        private String descripcion;
        private boolean estado;

        public Tarea(String descripcion) {
            this.descripcion = descripcion;
            this.estado = false;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public boolean getEstado() {
            return estado;
        }

        public void completar() {
            this.estado = true;
        }
    }
     class GestorTareas {
        private List<Tarea> tareas;
    //creo el constructor
        public GestorTareas() {
            tareas = new ArrayList<>();
        }
    //creo los metodos que necesito
        public void agregarTarea(Tarea tarea) {
            tareas.add(tarea);
        }

        public void eliminarTarea(Tarea tareita) {
            tareas.remove(tareita);
        }

        public List<Tarea> obtenerTareas() {
            return tareas;
        }

        public List<Tarea> obtenerTareasCompletadas() {
            List<Tarea> completadas = new ArrayList<>();
            //recorro mi lista
            for (Tarea t : tareas) {
                if (t.getEstado()) {
                    completadas.add(t);
                }
            }
            return completadas;
        }

    }

