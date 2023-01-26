package org.example.liskovSubstitution;

public class Carro implements ComportamientoVehiculo,TransportePersona{
    @Override
    public void acelerar() {
        System.out.println("Auto utiliza gasolina para acelerar");
    }

    @Override
    public void frenar() {
        System.out.println("El carro necesita pisar el freno para disminuir su velocidad");

    }

    @Override
    public void numeroPersonas(int cantidad) {
        System.out.println("El auto tiene capacidad para "+cantidad+" personas");

    }
}
