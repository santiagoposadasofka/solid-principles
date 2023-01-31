package org.example.SingleResponsabilityOpenBootcamp;
/*
public class Vehiculo {
    private int velocidad;


    public void acelerar(){
        velocidad ++;
        System.out.println("Acelerando");
    }

    public void frenar(){
        velocidad --;
        System.out.println("Frenando");
    }

    public void getVelocidad(){
        System.out.println("Velocidad: " + velocidad);
        return velocidad;
    }
// Aqui se rompe el principio de responsabilidad unica
    public echarGasolina(){
        System.out.println("Echando gasolina");
    }

}
*/
public class Usuario {
    public void crearUsuario(String username) {
        System.out.println("Creando usuario");
    }

    public void obtenerUsuario(String username) {
        System.out.println("Obteniendo usuario");
    }
    public void notificarUsuario(String username) {
        //System.out.println("Notificando usuario");
        Emailer emailer = new Emailer();
        emailer.send (this);
    }

    /* Se rompe nuevamente el principio de responsabilidad unica
    public void enviarEmail (String username){
        System.out.println("Enviando email");*/
}



