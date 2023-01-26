package org.example.openClose;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class OpenClose {
    /**
     * Vamos a instanciar una clase calculadora de impuestos, vamos a añadir más reglas de cálculo de impuestos,
     * y vamos a ejecutar sus comportamientos.
     * Vamos a instanciar el antipatron, vamos a ejecutar sus comportamientos, vamos a añadir más reglas de impuestos,
     * ej. impuestoDepartamental ...
     * Añadir un ejemplo de un escenario en donde se siga este patron o uno en donde no.
     * */
    public static void ejecutar(){
        DecimalFormat formato=new DecimalFormat("#.####");
        CalculadoraImpuestosAntiPatron antiPatron=new CalculadoraImpuestosAntiPatron();
        CalculadoraImpuestos calculadoraImpuestos=new CalculadoraImpuestos();
        calculadoraImpuestos.agregarReglaImpuesto(new ImpuestoDepartamental());
        List<Producto> productos=new ArrayList<>();
        for(int i=0;i<3;i++){
            productos.add(new Producto(ThreadLocalRandom.current().nextDouble(1000.0,20001.0)));
        }
        System.out.println("El total de los impuestos a pagar es de: "+formato.format(calculadoraImpuestos.calcularImpuestos(productos)));
        productos.get(0).setTipo("Nacional");
        productos.get(1).setTipo("Importado");
        productos.get(2).setTipo("Departamental");
        System.out.println("El total de los impuestos a pagar es de: "+formato.format(antiPatron.calcularImpuestosAntiPatron(productos)));
    }


}
interface Perimetro{
    public double calcularPerimetro();
}
class circulo implements Perimetro{
    int radio;
    @Override
    public double calcularPerimetro() {
        return 2*Math.PI*radio;
    }
}
class triangulo implements Perimetro{
    int ladoUno,ladoDos,ladoTres;
    @Override
    public double calcularPerimetro() {
        return ladoUno+ladoDos+ladoTres;
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
        return producto.getPrecio() * 0.15;
    }
}

class ImpuestoImportacion extends Impuesto {
    @Override
    double calcular(Producto producto) {
        return producto.getPrecio() * 0.25;
    }
}
class ImpuestoDepartamental extends Impuesto{
    @Override
    double calcular(Producto producto) {
        return producto.getPrecio()*0.08;
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
        int i=0;
        for (Producto producto : productos) {
                totalImpuestos += this.reglasImpuestos.get(i).calcular(producto);
                i++;
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
            if (producto.getTipo().equals("Nacional")) {
                totalImpuestos += producto.getPrecio() * 0.15;
            } else if (producto.getTipo().equals("Importado")) {
                totalImpuestos += producto.getPrecio() * 0.25;
            } else if (producto.getTipo().equals("Departamental")) {
                totalImpuestos+= producto.getPrecio()*0.08;
            }
        }
        return totalImpuestos;
    }
}


