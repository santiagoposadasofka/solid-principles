package org.example.dependecyInversion;

import java.util.ArrayList;
import java.util.List;

public class DependencyInvesion {
    /**
     * Se Sigue con la dinamica de los principios previos
     * */

    public void ejecutar() {
        // Probando la interfaz servicio
        Empleado empleado = new Empleado(new GmailService());


        empleado.enviarCorreo("empleado@gmail.com", "Mensaje del empleado", "Hola mundo");
        System.out.println("\n");

        //Lista carros
        List<Carro> carros = new ArrayList<>();
        carros.add(new Carro(new Ford()));
        carros.add(new Carro(new Mustang()));
        for (Carro carrito : carros) {
            carrito.arrancar();
        }
    }
}





/*
* Un ejemplo de inversión de dependencia en Java podría ser una clase "Empleado" que depende de una
* interfaz "ServicioDeCorreo" para enviar correos electrónicos. En lugar de que "Empleado" dependa
* directamente de una implementación específica de "ServicioDeCorreo", como "GmailService" o "OutlookService",
* se proporciona una instancia de "ServicioDeCorreo" a través de un constructor o un setter. De esta forma,
* "Empleado" no tiene conocimiento de cómo se envían los correos electrónicos, sino que simplemente utiliza la interfaz.
 * */

interface MarcaAuto{
    void arrancar();
}

class Ford implements MarcaAuto{
    @Override
    public void arrancar() {
        System.out.println("Arrancando FORD");
    }
}

class Mustang implements MarcaAuto{
    @Override
    public void arrancar() {
        System.out.println("Arrancando MUSTANG");
    }
}

class Carro {
    private MarcaAuto marca;

    public Carro(MarcaAuto marca) {
        this.marca = marca;
    }

    public void arrancar() {
        marca.arrancar();
    }

}


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








