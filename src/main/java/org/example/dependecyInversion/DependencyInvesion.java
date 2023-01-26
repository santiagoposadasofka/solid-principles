package org.example.dependecyInversion;

public class DependencyInvesion {
    /**
     * Se Sigue con la dinamica de los principios previos
     * */
    public void ejecutar(){
        /**
         * Se Sigue con la dinamica de los principios previos
         * */
        System.out.println("-------------Principio Dependency Inversion----------\n");
        GmailService gmailService = new GmailService();
        OutlookService outlookService = new OutlookService();

        Empleado SantiagoPosada = new Empleado(gmailService);
        Empleado JesusMiguel = new Empleado(outlookService);
        SantiagoPosada.enviarCorreo("Julia", "Urgente", "Como sigues de Salud");
        JesusMiguel.enviarCorreo("Andrea", "Invitacion", "Te invito a mi fiesta de aniversario");
        }
    public void ejecutarEjemplo(){
        System.out.println("------Nuevo ejemplo de Dependency Inversion-------\n");
        LlamadaNacional nacional = new LlamadaNacional();
        LlamadaInternacional internacional = new LlamadaInternacional();

        PersonaQueLlama Juan = new PersonaQueLlama(nacional);
        PersonaQueLlama Daniela = new PersonaQueLlama(internacional);
        Juan.llamar(3214587);
        Daniela.llamar(3698541);
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
        System.out.println("Enviando correo de gmail a "+destinatario+" con asunto "+asunto+" diciendo "+mensaje);
    }
}

class OutlookService implements ServicioDeCorreo {
    @Override
    public void enviarCorreo(String destinatario, String asunto, String mensaje) {
        System.out.println("Enviando correo de Outlook a "+destinatario+" con asunto "+asunto+" diciendo "+mensaje);
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


//Creacion del nuevo ejemplo para hacer llamadas

interface ServiciodeLlamadas {
    void hacerllamada(int numero);
}


class LlamadaNacional implements ServiciodeLlamadas {
    @Override
    public void hacerllamada(int numero) {
        System.out.println("Haciendo una llamada Nacional a "+numero);
    }
}

class LlamadaInternacional implements ServiciodeLlamadas {
    @Override
    public void hacerllamada(int numero) {
        System.out.println("Haciendo una llamada internacional a "+numero);
    }
}

class PersonaQueLlama {
    private ServiciodeLlamadas serviciodeLlamadas;

    public PersonaQueLlama(ServiciodeLlamadas serviciodeLlamadas) {
        this.serviciodeLlamadas = serviciodeLlamadas;
    }

    public void setServiciodeLlamadas(ServiciodeLlamadas serviciodeLlamadas) {
        this.serviciodeLlamadas = serviciodeLlamadas;
    }
    public void llamar(int numero) {
        serviciodeLlamadas.hacerllamada(numero);
    }
}




