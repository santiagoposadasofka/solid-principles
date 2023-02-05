package org.example.dependecyInversion;

import java.util.ArrayList;
import java.util.List;

public class DependencyInvesion {
    /**
     * * Vamos a instanciar una clase calculadora de impuestos, vamos a añadir mas reglas de calculos de impuestos,
     * * y vamos a ejecutar sus comportamientos.
     * * Vamos a instanciar el antipatron, vamos a ejecutar sus comportamientos, vamos añadir mas reglas de impuestos,
     * * ej. impuestoDepartamental ...
     * * añadir un ejmplo de un escenario en donde se siga este patron o uno en donde no.
     */
    public void ejecutar() {
        System.out.println("DEPENDENCY INVERSION");
        System.out.println(" ");
        System.out.println("Servicio de correo Gmail");
        GmailService gmailService = new GmailService();
        gmailService.enviarCorreo("July", "Saludo", "Prueba de mensaje por gmail.");

        System.out.println(" ");
        System.out.println("Servicio de correo OutlookService");
        OutlookService outlookService = new OutlookService();
        outlookService.enviarCorreo("July", "Saludo", "Prueba de mensaje por outlook.");


    }
}


/*
 * Un ejemplo de inversión de dependencia en Java podría ser una clase "Empleado" que depende de una
 * interfaz "ServicioDeCorreo" para enviar correos electrónicos. En lugar de que "Empleado" dependa
 * directamente de una implementación específica de "ServicioDeCorreo", como "GmailService" o "OutlookService",
 * se proporciona una instancia de "ServicioDeCorreo" a través de un constructor o un setter. De esta forma,
 * "Empleado" no tiene conocimiento de cómo se envían los correos electrónicos, sino que simplemente utiliza la interfaz.


 * */

interface ServicioDeCorreo {
    void enviarCorreo(String destinatario, String asunto, String mensaje);
}

class GmailService implements ServicioDeCorreo {
    @Override

    public void enviarCorreo(String destinatario, String asunto, String mensaje) {

        System.out.println("Destinatario: " + destinatario);
        System.out.println("Asunto: " + asunto);
        System.out.println("Mensaje: " + mensaje);
    }
}

class OutlookService implements ServicioDeCorreo {
    @Override
    public void enviarCorreo(String destinatario, String asunto, String mensaje) {
        // Envia correo utilizando la API de Outlook
        System.out.println("Destinatario: " + destinatario);
        System.out.println("Asunto: " + asunto);
        System.out.println("Mensaje: " + mensaje);
    }
}

/*
 * se puede ver como la clase Empleado tiene una dependencia de la interfaz ServicioDeCorreo,
 * pero no tiene conocimiento sobre como se envía el correo, sino que se le proporciona un
 * objeto que implementa la interfaz ServicioDeCorreo a través de un constructor o un setter,
 * de esta forma se cumple con el principio de inversión de dependencia, ya que la clase Empleado
 * no depende directamente de una implementación específica de ServicioDeCorreo.
 * */
class Empleado {
    private ServicioDeCorreo servicioDeCorreo;

    public Empleado(ServicioDeCorreo servicioDeCorreo) {
        this.servicioDeCorreo = servicioDeCorreo;
    }

    public void setServicioDeCorreo(ServicioDeCorreo servicioDeCorreo) {
        this.servicioDeCorreo = servicioDeCorreo;
    }

    public void enviarCorreo(String destinatario, String asunto, String mensaje) {
        servicioDeCorreo.enviarCorreo(destinatario, asunto, mensaje);
    }
}
/**
 * Ejemplo: Terminal de transportes
 * 1. Caso cuando no se cumple el principio DependencyInversion.
 */

class ServicioTransporte {

    private List<String> servicioDisponibles = new ArrayList<>();

    public ServicioTransporte(){
        servicioDisponibles.add("Servicio 1");
        servicioDisponibles.add("Servicio 2");
    }
    public List<String> obtenerServiciosDisponibles(){
        return servicioDisponibles;
    }

    public void compraTikets(String service, String pasajero){
        System.out.println("Servicio 1: " + service);
        System.out.println("Pasajero: " + pasajero);
    }
}

class Terminal{

    private ServicioTransporte servicioTransporte;

    public Terminal(ServicioTransporte servicioTransporte) {
        this.servicioTransporte = servicioTransporte;
    }

    public void mostrarSericiosDisponibles(){
        List<String> servicioDisponible = servicioTransporte.obtenerServiciosDisponibles();
    }

    public void compraTickets(String servicio, String pasajero){
        servicioTransporte.compraTikets(servicio, pasajero);
    }
}





