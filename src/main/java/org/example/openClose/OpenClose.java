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

    //Creando instancias y usando el principio Open Close
    public void ejecutarPrincipio(){
        //
        Producto yuca = new Producto(5000);
        Producto tomate = new Producto(3000);

        List<Producto> productos;
        productos = new ArrayList<>();

        productos.add(yuca);
        productos.add(tomate);
        System.out.println("\n------------------Principio Open Close-----------\n");
        CalculadoraImpuestos calculadora = new CalculadoraImpuestos();
        //Creando un Nuevo Tipo de Impuesto
        Impuesto impuestoExtra = new Impuesto() {
            @Override
            double calcular(Producto producto) {
                System.out.println("Impuesto Extra:  "+ producto.getPrecio());
                return producto.getPrecio() * 0.30;
            }
        };
        calculadora.agregarReglaImpuesto(impuestoExtra);
        calculadora.calcularImpuestos(productos);
    }

    public void ejecutarAntiPatron() {
        Producto papa = new Producto(6000);
        Producto harina = new Producto(2600);
        papa.setTipo("Nacional");
        papa.setTipo("Importado");

        List<Producto> productos;
        productos = new ArrayList<>();
        productos.add(papa);
        productos.add(harina);
        System.out.println("\n------------------Anti Patron de Open Close-----------\n");
        CalculadoraImpuestosAntiPatron calcu = new CalculadoraImpuestosAntiPatron();
        calcu.calcularImpuestosAntiPatron(productos);
    }

    public void ejecutarnuevoAntiPatron() {
        Persona persona1 = new Persona("Andrea", "Plata");
        Persona persona2 = new Persona("Paul", "Diamante");
        System.out.println("\n------------------Nuevo Anti Patron de Open Close-----------\n");
        CalcularadoraValorEntrada precio = new CalcularadoraValorEntrada();
        precio.calcularValor(persona1);
        precio.calcularValor(persona2);
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

class CalculadoraImpuestos {
    private List<Impuesto> reglasImpuestos;

    public CalculadoraImpuestos() {
        this.reglasImpuestos = new ArrayList<>();
        reglasImpuestos.add(new ImpuestoNacional());
        reglasImpuestos.add(new ImpuestoImportacion());
    }

    public void agregarReglaImpuesto(Impuesto impuesto) {
        this.reglasImpuestos.add(impuesto);
        System.out.println("Nueva Regla Agregada");
    }

    public double calcularImpuestos(List<Producto> productos) {
        double totalImpuestos = 0;
        for (Producto producto : productos) {
            for (Impuesto reglaImpuesto : this.reglasImpuestos) {
                totalImpuestos += reglaImpuesto.calcular(producto);
            }
        }
        System.out.println("El total de todos los impuestos es: "+totalImpuestos);
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
            } else if (producto.getTipo() == "Importado") {
                totalImpuestos += producto.getPrecio() * 0.25;
            } else if (producto.getTipo() == "Departamental") {//Nuevo else if para Impuesto Departamental
                totalImpuestos += producto.getPrecio() * 0.13;
            }
        }
        System.out.println("El total de impuestos usando antipatron es: "+totalImpuestos);
        return totalImpuestos;
    }
}

//Esta clase es un antipatron
class CalcularadoraValorEntrada{

    public double calcularValor(Persona persona){
        double valorGeneral = 50000;
        if (persona.getMembresia() == "Plata"){
            valorGeneral = valorGeneral - 5000;
        }else if(persona.getMembresia() == "Oro"){
            valorGeneral = valorGeneral - 10000;
        }else if(persona.getMembresia() == "Diamante"){
            valorGeneral = valorGeneral - 20000;
        }

        System.out.println("El valor de la entrada para "+persona.getNombre()+" es de "+valorGeneral);
        return valorGeneral;
    }

}


