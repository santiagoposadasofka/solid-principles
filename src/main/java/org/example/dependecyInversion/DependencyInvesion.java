package org.example.dependecyInversion;

public class DependencyInvesion {
    /**
     * Se Sigue con la dinamica de los principios previos
     * vamos a empezar con toda
     */
    public void ejecutar() {
        GmailService gmailService = new GmailService();
        OutlookService outlookService = new OutlookService();
        Empleado SantiagoPosada = new Empleado(gmailService);
        Empleado JesusMiguel = new Empleado(outlookService);
        Empleado Yeison = new Empleado(gmailService);


        TransporteBuseta transporteBuseta = new TransporteBuseta();
        transporteBuseta.realizarTransporte("Los Patios");
        Persona juan = new Persona(transporteBuseta);


        TransporteTaxi transporteTaxi = new TransporteTaxi();
        transporteTaxi.realizarTransporte("Carrera al centro");
        Persona ppito = new Persona(transporteTaxi);

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
        // Envia correo utilizando la API de Gmail
        System.out.println("Enviando email desde google " +
                "a " + destinatario + " con el asunto "
                + asunto + "diciendole: " + mensaje);
    }
}

class OutlookService implements ServicioDeCorreo {
    @Override
    public void enviarCorreo(String destinatario, String asunto, String mensaje) {
        // Envia correo utilizando la API de Outlook
        System.out.println("Enviando email desde outlook " +
                "a " + destinatario + " con el asunto "
                + asunto + "diciendole: " + mensaje);
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


/****
 * ejemplo de clase servicioDeTransporte que implenta el principio solid DependencyInversion
 */


interface ServicioDeTransporte {
    void realizarTransporte(String destino);
}

class TransporteTaxi implements ServicioDeTransporte {
    @Override
    public void realizarTransporte(String destino) {
// Realiza el transporte utilizando un taxi al destino especificado
        System.out.println("Llevando al pasajero al destino " + destino + " en un taxi");
    }
}

class TransporteBuseta implements ServicioDeTransporte {
    @Override
    public void realizarTransporte(String destino) {
// Realiza el transporte utilizando una buseta al destino especificado
        System.out.println("Llevando al pasajero al destino " + destino + " en una buseta");
    }
}


class Persona {
    private ServicioDeTransporte servicioDeTransporte;


    public Persona(ServicioDeTransporte servicioDeTransporte) {
        this.servicioDeTransporte = servicioDeTransporte;
    }

    public void setServicioDeTransporte(ServicioDeTransporte servicioDeTransporte) {
        this.servicioDeTransporte = servicioDeTransporte;
    }

    public void realizarTransporte(String destino) {
        servicioDeTransporte.realizarTransporte(destino);
    }

}