package org.example.dependecyInversion;

public class DependencyInvesion {
    /**
     * Se Sigue con la dinamica de los principios previos
     */

    public void ejecutar() {
        GmailService gmailService = new GmailService();

        OutlookService outlookService = new OutlookService();
        Empleado SantiagoPosada = new Empleado(gmailService);

        Empleado JesusMiguel = new Empleado(outlookService);
        // Ejemplo
        BatidoEnAgua batidoEnAgua = new BatidoEnAgua();
        batidoEnAgua.batido("Mango");

        BatidoEnLeche batidoEnLeche = new BatidoEnLeche();
        batidoEnLeche.batido("Papaya");
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

interface ServicioJugosNaturales {
    void batido(String fruta);
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

class BatidoEnAgua implements ServicioJugosNaturales {
    private String complemento = "Agua";


    public BatidoEnAgua() {
    }

    @Override
    public void batido(String fruta) {
        System.out.println("Haciendo Jugo de " + fruta +
                " en " + this.complemento);
    }
}

class BatidoEnLeche implements ServicioJugosNaturales {
    private String complemento = "Leche";

    @Override
    public void batido(String fruta) {
        System.out.println("Haciendo Jugo de " + fruta +
                " en " + this.complemento);
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





