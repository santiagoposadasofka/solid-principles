package org.example.singleResponsibility;

public class Medida {
    private double frente;
    private double largo;

    public Medida(double frente, double largo) {
        this.frente = frente;
        this.largo = largo;
    }
    public double calcularArea(double frente, double largo){
        double area = this.frente * this.largo;
        return area;
    }

    public double frente() {
        return frente;
    }

    public Medida setFrente(double frente) {
        this.frente = frente;
        return this;
    }

    public double largo() {
        return largo;
    }

    public Medida setLargo(double largo) {
        this.largo = largo;
        return this;
    }
}
