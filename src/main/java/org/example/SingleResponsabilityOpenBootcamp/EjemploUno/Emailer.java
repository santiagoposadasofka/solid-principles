package org.example.SingleResponsabilityOpenBootcamp.EjemploUno;

// se crea una clase dedicada a la gestion de correos, se puede comunicar con los objetos dentro de la clase
//Una clase de usuario no se va a dedidacar a enviar correos, se va a dedicar a gestionar usuarios
//Una clase de correos no se va a dedicar a gestionar usuarios, se va a dedicar a enviar correos
//Pero si va a existir una comuncacion entre ellos
public class Emailer {
    public void send(Usuario usuario) {
        System.out.println("Enviando email");

    }
}
