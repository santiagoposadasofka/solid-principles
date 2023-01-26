package org.example.dependecyInversion;

import java.security.PublicKey;

public class DependencyInvesion {
    /**
     * Se Sigue con la dinamica de los principios previos
     *
     * */

    interface Ielectricidad{
        void pasaElectridad(boolean pasa);
    }

    class Boton implements Ielectricidad{
        boolean prende = false;

        public Boton() {
            this.prende = prende;
        }

        @Override
        public void pasaElectridad(boolean pasa) {
            if (pasa == true) {
                this.prende = pasa;
            }else {this.prende= false;
        }
    }

    class Lampara{

        }
    }





    public void  ejecutar() {
        /**
         * se instancia la clase GmailService y OutlookService.
          */
        GmailService gmailService = new GmailService();
        gmailService.enviarCorreo("efrain", "hola","hihioui");
        OutlookService outlookService = new OutlookService();
        outlookService.enviarCorreo("efrain", "hola","hih");

        /**
         * se instancia la clase empleao
         */

        Empleado empleado = new Empleado(gmailService);
        empleado.enviarCorreo("efrain", "hola","hih");
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





