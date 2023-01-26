package org.example.liskovSubstitution;

public class CarroJueguete implements ComportamientoVehiculo{

    @Override
    public void acelerar() {
        System.out.println("El auto necesita pilas para acelerar");

    }

    @Override
    public void frenar() {
        System.out.println("El auto frena con el control remoto");

    }
}
