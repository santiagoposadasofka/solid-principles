package org.example.dependecyInversion;

public class DependencyInvesion {
    /**
     * Se Sigue con la dinamica de los principios previos
     * */
    public void ejecutar()
    {
        System.out.println("\nComportamientos de enviar correo");
        GmailService gmailService = new GmailService();

        OutlookService outlookService = new OutlookService();
        Empleado SantiagoPosada = new Empleado(gmailService);

        Empleado JesusMiguel = new Empleado(outlookService);
        SantiagoPosada.enviarCorreo("Rauk","Pagar","Pagar mensualidad");
        JesusMiguel.enviarCorreo("Santiago","Saludo","Como estas?");
    }

    public void ejecutarDibujar(){
        System.out.println("\nComportamientos de un ejemplo siguiendo el patron");
        DibujoFisico dibujoFisico=new DibujoFisico();
        DibujoVirtual dibujoVirtual=new DibujoVirtual();

        Artista Pedro=new Artista(dibujoFisico);
        Artista Camilo=new Artista(dibujoVirtual);

        Pedro.crearDibujo("Perrito",10,"Color");
        Camilo.crearDibujo("Gatito",20,"Blanco y negro");
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

interface Dibujar{
    void crearDibujo(String imagen,double tamanio,String tipo);
}

class DibujoFisico implements Dibujar{

    @Override
    public void crearDibujo(String imagen, double tamanio, String tipo) {
        System.out.println("Dibujo en fisico de "+imagen+", de tamanio "+tamanio+" y de tipo"+tipo);
    }
}

class DibujoVirtual implements Dibujar{
    @Override
    public void crearDibujo(String imagen, double tamanio, String tipo) {
        System.out.println("Dibujar en digital de "+imagen+", de tamanio "+tamanio+" y de tipo"+tipo);
    }
}

class Artista{
    private Dibujar dibujar;

    public Artista(Dibujar dibujar) {
        this.dibujar = dibujar;
    }

    public void setDibujar(Dibujar dibujar) {
        this.dibujar = dibujar;
    }

    public void crearDibujo(String imagen,double tamanio,String tipo){
        dibujar.crearDibujo(imagen,tamanio,tipo);
    }
}





