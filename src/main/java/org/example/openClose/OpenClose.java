package org.example.openClose;

import jdk.dynalink.Operation;

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
        /**
         * Instanciando Clase CalcularImpuestos principio OpenClose
         */
        System.out.println("---------Clase CalcularImpuestos---------");

        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(1500000));

        CalculadoraImpuestos calcularImpuesto = new CalculadoraImpuestos();

        System.out.println("Impuestos Calculados para pc HP: " + calcularImpuesto.calcularImpuestos(productos));

        /**
         * Instanciando Clase Antipatron
         */
        System.out.println("---------Clase CalcularImpuestosAntiPatron---------");
        Producto producto = new Producto(750000);
        producto.setTipo("Importado");

        List<Producto> nuevosProductos = new ArrayList<>();
        nuevosProductos.add(producto);

        CalculadoraImpuestosAntiPatron calcularImpuestoAntiPatron = new CalculadoraImpuestosAntiPatron();
        System.out.println("Calculo de Impuesto con antipatron " + calcularImpuestoAntiPatron.calcularImpuestosAtiPatron(nuevosProductos));

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

    /**
     *     Nueva regla de Impuesto Departamental
     */

class ImpuestoDepartamental extends Impuesto{
    double calcular(Producto producto){
        return producto.getPrecio() * 0.5;
    }
}

class CalculadoraImpuestos {
    private List<Impuesto> reglasImpuestos;

    public CalculadoraImpuestos() {
        this.reglasImpuestos = new ArrayList<>();
        reglasImpuestos.add(new ImpuestoNacional());
        reglasImpuestos.add(new ImpuestoImportacion());
        //Agragando regla de Impuesto Departamental
        reglasImpuestos.add(new ImpuestoDepartamental());
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
    public double calcularImpuestosAtiPatron(List<Producto> productos) {
        double totalImpuestos = 0;
        for (Producto producto : productos) {
            if (producto.getTipo() == "Nacional") {
                totalImpuestos += producto.getPrecio() * 0.15;
            } else if (producto.getTipo() == "Importado") {
                totalImpuestos += producto.getPrecio() * 0.25;
            }
        }
        return totalImpuestos;
    }
}

/**
 * Nueva Clase con principio OpenClose
 */

abstract class Operaciones{
    abstract double CalcularOperacion(int a, int b);
}

class Sumar extends Operaciones {

    int resultado = 0;
    @Override
    double CalcularOperacion(int a, int b) {
        return resultado = a + b;
    }
}

class Restar extends Operaciones {

    int resultado = 0;
    @Override
    double CalcularOperacion(int a, int b) {
        return resultado = a - b;
    }
}

class Multiplicar extends Operaciones {

    int resultado = 0;
    @Override
    double CalcularOperacion(int a, int b) {
        return resultado = a * b;
    }
}

class Operations {
    private String tipo;

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}

class Resultados {
    private List<Operaciones> results;

    public Resultados() {
        this.results = new ArrayList<>();
        results.add(new Sumar());
        results.add(new Multiplicar());

    }

    public void agregarOperaciones(Operaciones operaciones) {
        this.results.add(operaciones);
    }

    public double calcularOperaciones(List<Operations> operaciones) {
        double total = 0;
        for (Operations operacion : operaciones) {
            for (Operaciones resultado : this.results) {
                total += resultado.CalcularOperacion(20, 5);
            }
        }
        return total;
    }
}






