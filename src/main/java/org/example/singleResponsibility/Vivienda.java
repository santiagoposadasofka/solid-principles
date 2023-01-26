package org.example.singleResponsibility;

public class Vivienda extends Medida {

    private double valorMetro;
    public Vivienda(double frente, double largo, double valorMetro) {
        super(frente, largo);
        this.valorMetro = valorMetro;
    }

    public double valorMetro() {
        return valorMetro;
    }

    public Vivienda setValorMetro(double valorMetro) {
        this.valorMetro = valorMetro;
        return this;
    }

    public double calcularPrecio(){
        //;
        return calcularArea(frente(),largo()) * this.valorMetro;
    }


}
