package org.example.singleResponsibility;

import java.util.ArrayList;

public class Factura {

    private String codigo;
    private double total;
    private ArrayList <Producto> productos;

    public Factura (String codigo){
        this.codigo=codigo;
        productos = new ArrayList<>();
    }

     public void agregarProducto (Producto miProducto){
        productos.add(miProducto);
     }
     private void calcularTotal (){
         for (Producto producto: productos ) {
             total= total+producto.getPrecio();
         }
     }
     public void mostrarFactura (){

         calcularTotal();
         System.out.println("Codigo: "+ codigo);
         for (Producto producto: productos ) {
             System.out.println("Producto: "+ producto.getNombre() + " Precio: "+ producto.getPrecio());
         }
         System.out.println("Total "+ this.total);
     }


}
