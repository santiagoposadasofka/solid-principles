package org.example.openClose;

public interface Vehiculo {
    void acelerar();
    void frenar();

}

class Carro implements Vehiculo{

    @Override
    public void acelerar() {
        System.out.println("El carro esta acelerando");
    }

    @Override
    public void frenar() {
        System.out.println("El carro va frenar");

    }
}
class Moto implements Vehiculo{

    @Override
    public void acelerar() {
        System.out.println("La moto esta acelerando");
    }

    @Override
    public void frenar() {
        System.out.println("La moto va frenar");
    }
}