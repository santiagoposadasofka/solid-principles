package org.example.openClose;

import java.util.ArrayList;
import java.util.List;

public class OpenClose {
    /**
     * Vamos a instanciar una clase calculadora de impuestos, vamos a añadir mas reglas de calculos de impuestos,
     * y vamos a ejecutar sus comportamientos.
     * Vamos a instanciar el antipatron, vamos a ejecutar sus comportamientos, vamos añadir mas reglas de impuestos,
     * ej. impuestoDepartamental ...
     * añadir un ejmplo de un escenario en donde se siga este patron o uno en donde no.
     * */


    public void ejecutar(){
        CalculadoraImpuestos calculadora1 = new CalculadoraImpuestos();

        Producto pera = new Producto(1200);
        pera.setTipo("Nacional");
        Producto manzana = new Producto(500);
        manzana.setTipo("Nacional");

        List <Producto> productos;
        productos = new ArrayList<>();

        productos.add(pera);
        productos.add(manzana);

        Impuesto impuesto1 = new Impuesto() {
            @Override
            double calcular(Producto producto) {
                return producto.getPrecio() * 0.32;
            }
        };
        calculadora1.agregarReglaImpuesto(impuesto1);
        calculadora1.calcularImpuestos(productos);
    }

    public void ejecutarAnti(){
        CalculadoraImpuestosAntiPatron antiCalculadora = new CalculadoraImpuestosAntiPatron();
        Producto antiPera = new Producto(1200);
        antiPera.setTipo("Nacional");
        Producto antiManzana = new Producto(500);
        antiManzana.setTipo("Nacional");

        List <Producto> productos2;
        productos2 = new ArrayList<>();

        productos2.add(antiPera);
        productos2.add(antiManzana);
        antiCalculadora.calcularImpuestosAntiPatron(productos2);

    }
    public void ejemplo (){
        Electrodoméstico electro1 = new Electrodoméstico("nevera", 12);
        electro1.generarVoltaje();
    }

}


/*
* Un ejemplo de patrón de abierto-cerrado en Java podría ser una clase "CalculadoraImpuestos" que se
*  encarga de calcular los impuestos de una lista de objetos "Producto". La clase tiene un método
* "calcularImpuestos" que toma una lista de productos y devuelve el total de impuestos calculados.
* La clase es "abierta" para la extensión, ya que se pueden agregar nuevas reglas de impuestos sin
* necesidad de modificar el código existente.
* En este ejemplo se ve como la clase CalculadoraImpuestos se encarga de calcular los impuestos de una
* lista de productos, pero esta clase no tiene conocimiento de cuales son las reglas de impuestos, estas
* reglas se encuentran en las clases ImpuestoNacional e ImpuestoImportacion, de esta forma se pueden agregar
*  nuevas reglas de impuestos sin tener que modificar la clase CalculadoraImpuestos, cumpliendo con el principio
* del patrón open close.
* */
abstract class Impuesto {
    abstract double calcular(Producto producto);
}

class ImpuestoNacional extends Impuesto {
    @Override
    double calcular(Producto producto) {
        System.out.println("El valor a pagar del producto con impuesto incluido es "
                + producto.getPrecio()*0.15 + " debido al tipo de impuesto que es " +
                producto.getTipo());


        return producto.getPrecio() * 0.15;
    }
}

class ImpuestoImportacion extends Impuesto {
    @Override
    double calcular(Producto producto) {
        System.out.println("El valor a pagar del producto con impuesto incluido es " + producto.getPrecio()*0.25+
                " debido al tipo de impuesto que es " +
                producto.getTipo());
        return producto.getPrecio() * 0.25;
    }
}



class CalculadoraImpuestos {
    private List<Impuesto> reglasImpuestos;

    public CalculadoraImpuestos() {
        this.reglasImpuestos = new ArrayList<>();
        reglasImpuestos.add(new ImpuestoNacional());
        reglasImpuestos.add(new ImpuestoImportacion());
    }

    public void agregarReglaImpuesto(Impuesto impuesto) {
        this.reglasImpuestos.add(impuesto);
    }

    public double calcularImpuestos(List<Producto> productos) {
        double totalImpuestos = 0;
        for (Producto producto : productos) {
            for (Impuesto reglaImpuesto : this.reglasImpuestos) {
                totalImpuestos += reglaImpuesto.calcular(producto);
            }
        }
        return totalImpuestos;
    }
}


/*
* Un anti-patrón del principio de abierto-cerrado en Java podría ser una clase "CalculadoraImpuestos"
*  que tiene un método "calcularImpuestos" que toma una lista de objetos "Producto" y devuelve el total
* de impuestos calculados. Sin embargo, este método contiene una serie de "if-else" o "switch-case" que
* determinan qué reglas de impuestos se deben aplicar a cada producto. Cada vez que se agrega una nueva regla
* de impuestos, se debe modificar el código existente en el método "calcularImpuestos" lo que viola el principio de abierto-cerrado.
* En este ejemplo se ve como la clase CalculadoraImpuestos tiene conocimiento de las reglas de impuestos, esto hace que cada
* vez que se quiera agregar una nueva regla de impuestos, se tenga que modificar el código de la clase, violando el principio
*  de abierto-cerrado. Es mejor separar las reglas de impuestos en clases diferentes y utilizar una estrategia de delegación para
* aplicar las reglas de impuestos, de esta forma se pueden agregar nuevas reglas de impuestos sin modificar el código existente.
* */


class CalculadoraImpuestosAntiPatron {
    public double calcularImpuestosAntiPatron(List<Producto> productos) {
        double totalImpuestos = 0;
        for (Producto producto : productos) {
            if (producto.getTipo() == "Nacional") {
                totalImpuestos += producto.getPrecio() * 0.15;
                System.out.println("Debe pagar por el producto "+
                        producto.getPrecio() + " incluido el impuesto" + " porque su producto " +
                        "tiene el tipo " + producto.getTipo());
            } else if (producto.getTipo() == "Importado") {
                totalImpuestos += producto.getPrecio() * 0.25;
                System.out.println("Debe pagar por el producto "+
                        producto.getPrecio() + " incluido el impuesto" + " porque su producto " +
                        "tiene el tipo " + producto.getTipo());
            } else if (producto.getTipo()== "Municipal") {
                totalImpuestos += producto.getPrecio() * 0.12;
                System.out.println("Debe pagar por el producto "+
                        producto.getPrecio() + " incluido el impuesto" + " porque su producto " +
                        "tiene el tipo " + producto.getTipo());
            }
        }
        return totalImpuestos;
    }
}

//Ejemplo Antipatron OPENCLOSE

class Electrodoméstico{
    private String nombre;
    private double voltaje;

    public Electrodoméstico(String nombre, double voltaje) {
        this.nombre = nombre;
        this.voltaje = voltaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getVoltaje() {
        return voltaje;
    }

    public void setVoltaje(double voltaje) {
        this.voltaje = voltaje;
    }

    public void generarVoltaje (){
        if(this.voltaje == 120){
            this.nombre = "Nevera";
        } else if (this.voltaje == 13) {
            this.nombre = "Televisor";
        }//Debo seguir añadiendo electrodomésticos a partir de su voltaje, ya que este necesita de este
        //para saber el tipo de electrodoméstico
    }
}

