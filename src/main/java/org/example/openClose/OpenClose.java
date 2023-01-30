package org.example.openClose;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OpenClose {
    /**
     * Vamos a instanciar una clase calculadora de impuestos, vamos a añadir mas reglas de calculos de impuestos,
     * y vamos a ejecutar sus comportamientos.
     * Vamos a instanciar el antipatron, vamos a ejecutar sus comportamientos, vamos añadir mas reglas de impuestos,
     * ej. impuestoDepartamental ...
     * añadir un ejmplo de un escenario en donde se siga este patron o uno en donde no.
     */

    public void Ejecutar() {
        /**
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(500));
        productos.add(new Producto(1000));
        productos.add(new Producto(1500));

        CalculadoraImpuestos calculation=new CalculadoraImpuestos();

        calculation.agregarReglaImpuesto(new ImpuestoMunicipal());


        double TotalImpuesto = calculation.calcularImpuestos(productos);
        System.out.println("" + ":" + TotalImpuesto);

        CalculadoraImpuestosAntiPatron calculadoraImpuestosAtiPatron = new CalculadoraImpuestosAntiPatron();
        double TotalImpuestoAntipatron = calculadoraImpuestosAtiPatron.calcularImpuestosAtiPatron(productos);
        System.out.println("" + ":" + TotalImpuestoAntipatron);**/



        CalculadoraImpuestos calculadora = new CalculadoraImpuestos();
        ImpuestoMunicipal impuestoMunicipal = new ImpuestoMunicipal();
        calculadora.agregarReglaImpuesto(impuestoMunicipal);
        List<Producto> productos = Arrays.asList(new Producto( 100.0),
                new Producto( 55.0));
        double totalImpuestos = calculadora.calcularImpuestos(productos);
        System.out.println("Total Impuestos: " + totalImpuestos);

        //instancio mi ejemplo

        Calculadora calculadoraSuma = new Calculadora(new Suma(5.0, 2.0));
        double resultadoSuma = calculadoraSuma.calcular();
        System.out.println("Resultado Suma: " + resultadoSuma);

        Calculadora calculadoraResta = new Calculadora(new Resta(5.0, 2.0));
        double resultadoResta = calculadoraResta.calcular();
        System.out.println("Resultado Resta: " + resultadoResta);
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
class ImpuestoMunicipal extends Impuesto{

    @Override
    double calcular(Producto producto) {
        return producto.getPrecio() * 0.015;
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
    public double calcularImpuestosAtiPatron(List<Producto> productos) {
        double totalImpuestos = 0;
        for (Producto producto : productos) {
            if (producto.getTipo() == "Nacional") {
                totalImpuestos += producto.getPrecio() * 0.15;
            } else if (producto.getTipo() == "Importado") {
                totalImpuestos += producto.getPrecio() * 0.25;
            } else if (producto.getTipo() == "ImpuestoMunicipal") {
                totalImpuestos += producto.getPrecio() * 0.015;
            }
        }
        return totalImpuestos;
    }
}


//creacion del ejemplo correcto
abstract class Operacion {
    protected double operando1;
    protected double operando2;

    //creo constructor de mi nueva clase
    public Operacion(double operando1, double operando2) {
        this.operando1 = operando1;
        this.operando2 = operando2;
    }
    //creo mi metodo
    public abstract double calcular();
}
//creo la clase SUMA que hereda de operacion
class Suma extends Operacion {
    public Suma(double operando1, double operando2) {
        super(operando1, operando2);
    }

    @Override
    public double calcular() {
        return operando1 + operando2;
    }
}
//clase resta que hereda de operacion
class Resta extends Operacion {
    public Resta(double operando1, double operando2) {
        super(operando1, operando2);
    }

    @Override
    public double calcular() {
        return operando1 - operando2;
    }
}

class Calculadora {
    private Operacion operacion;
    public Calculadora(Operacion operacion) {
        this.operacion = operacion;
    }
    public double calcular() {
        return operacion.calcular();
    }
}


