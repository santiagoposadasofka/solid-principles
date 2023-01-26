package org.example.dependecyInversion;

import java.util.ArrayList;
import java.util.List;

public class DependencyInvesion {
    public static void ejecutar(){
        Empleado empleado=new Empleado(new GmailService());
        empleado.enviarCorreo("idruizbe@gmail.com","Quinto Ejercicio","Ya terminé la actividad");
        System.out.println("\n");
        List<Auto> autos=new ArrayList<>();
        autos.add(new Auto(new MotorAGasolina()));
        autos.add(new Auto(new MotorADiesel()));
        for (Auto auto:autos){
            auto.encenderAuto();
        }
    }
}
interface Motor{
    void encender();
}
class MotorAGasolina implements Motor{
    @Override
    public void encender() {
        System.out.println("El suministro de gasolina hizo que el auto encendiera");
    }
}
class MotorADiesel implements Motor{
    @Override
    public void encender() {
        System.out.println("El suministro de diesel hizo que el auto encendiera");
    }
}
class Auto{
    private Motor motor;
    public Auto(Motor motor) {
        this.motor = motor;
    }
    public void encenderAuto(){
        motor.encender();
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
        System.out.println("Se le ha enviado un correo a: "+destinatario+", con " +
                "el asunto: "+asunto+", diciendo: "+mensaje);
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





