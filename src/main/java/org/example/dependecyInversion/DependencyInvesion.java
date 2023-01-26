package org.example.dependecyInversion;

public class DependencyInvesion {
    /**
     * Se Sigue con la dinamica de los principios previos
     */
    public void ejecutarDependencyInvesion() {
        Empleado empleado1 = new Empleado(new GmailService());
        Empleado empleado2 = new Empleado(new OutlookService());
        empleado1.enviarCorreo("Juan Perez", "Reunion urgente", "Ha sido programada una reunion urgente para el dia de mañana a las 10 Am, por favor confirmar su asistencia, gracias. Atentamente Ana Martinez");
        empleado2.enviarCorreo("Ana Martinez", "Reunion Importante", "Confirmo mi asistencia a la reunion del dia de mañana. Atentamente Juan Perez");
    }
    public void iniciarDesarrollo(){
        ProgramarJava programarjava=new ProgramarJava();
        ProgramarJavascript programarjavascript=new ProgramarJavascript();

        Developer dev1=new Developer(programarjava);
        Developer dev2=new Developer(programarjavascript);

        dev1.desarrolloSoftware("Calculadora de impuestos","Java",3.8);
        dev2.desarrolloSoftware("ingreso de empleados","Javascript",1.5);
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
        System.out.println("\nApreciado/a " + destinatario + " usted ha recibido un email con el asunto " + asunto + " en su cuenta de correo de Gmail, el mensaje es el siguiente: " + mensaje);
    }
}

class OutlookService implements ServicioDeCorreo {
    @Override
    public void enviarCorreo(String destinatario, String asunto, String mensaje) {
        System.out.println("\nApreciado/a " + destinatario + " usted ha recibido un email con el asunto " + asunto + " en su cuenta de correo de Outlook, el mensaje es el siguiente: " + mensaje);
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

interface Programar{
    void crearSoftware(String nombrePrograma,String lenguaje, double version);
}

class ProgramarJava implements Programar{

    @Override
    public void crearSoftware(String nombrePrograma,String lenguaje, double version) {
        System.out.println("\nEl software "+nombrePrograma+", fue desarrollado en "+lenguaje+" y su version actual es:"+version);
    }
}

class ProgramarJavascript implements Programar{
    @Override
    public void crearSoftware(String nombrePrograma,String lenguaje, double version) {
        System.out.println("\nEl software "+nombrePrograma+", fue desarrollado en "+lenguaje+" y su version actual es:"+version);
    }
}

class Developer{
    private Programar programar;

    public Developer(Programar programar) {
        this.programar = programar;
    }

    public void desarrolloSoftware(String nombrePrograma,String lenguaje, double version){
        programar.crearSoftware(nombrePrograma,lenguaje,version);
    }
}



