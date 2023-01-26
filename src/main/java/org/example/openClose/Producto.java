package org.example.openClose;

public class Producto {
    private double precio;
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Producto(double precio) {
        this.precio = precio;
    }

    public Producto(double precio, String tipo) {
        this.precio = precio;
        this.tipo = tipo;
    }



    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
