package org.example.dependecyInversion;

public class DependencyInvesion {

    public void ejecutar(){

        Empleado empleado = new Empleado();
        empleado.enviarCorreo("Carlos Gomez", "Trabajo", "Trabajo listo");
        empleado.llamar("Liliana Perez", "Nos encontramos en la salida");
    }

    /**
     * Se Sigue con la dinamica de los principios previos
     * */
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

/*
 * Se implementa la interface "Telefono" para que el empleado pueda
 * realizar la acción de acceder al telefono, pero la accion de llamar no la hace el.
 * */
interface Telefono {
    void llamar(String destinatario, String mensaje);
}

class GmailService implements ServicioDeCorreo {
    @Override
    public void enviarCorreo(String destinatario, String asunto, String mensaje) {
        // Envia correo utilizando la API de Gmail
    }
}

class OutlookService implements ServicioDeCorreo {
    @Override
    public void enviarCorreo(String destinatario, String asunto, String mensaje) {
        // Envia correo utilizando la API de Outlook
    }
}

/*
* se puede ver como la clase Empleado tiene una dependencia de la interfaz ServicioDeCorreo,
* pero no tiene conocimiento sobre como se envía el correo, sino que se le proporciona un
* objeto que implementa la interfaz ServicioDeCorreo a través de un constructor o un setter,
* de esta forma se cumple con el principio de inversión de dependencia, ya que la clase Empleado
* no depende directamente de una implementación específica de ServicioDeCorreo.
* */
class Empleado  implements ServicioDeCorreo, Telefono {
    private ServicioDeCorreo servicioDeCorreo;
    private Telefono telefono;

    public Empleado() {
        this.servicioDeCorreo = servicioDeCorreo;
    }

    public Empleado(Telefono telefono) {
        this.telefono = telefono;
    }
    public void setServicioDeCorreo(ServicioDeCorreo servicioDeCorreo) {
        this.servicioDeCorreo = servicioDeCorreo;
    }

    public void enviarCorreo(String destinatario, String asunto, String mensaje) {

        System.out.println("Correo enviado a " + destinatario);
        System.out.println("Asunto " + asunto);
        System.out.println("mensaje " + mensaje);
    }

    public void setTelefono(Telefono telefono){
        this.telefono = telefono;

    }

    public void llamar(String destinatario, String mensaje){
        System.out.println("Llamada realizada a: " + destinatario);
        System.out.println("Mensaje " + mensaje);
    }
}





