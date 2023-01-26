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

    /**
     * El ejemplo que planteo es  un patron de una clase abstracta embotellara en donde se le puedden agregar mas productos creando clase del producto
     * nuevo a embotellar
     */
    abstract class Embotelladora{

        public abstract Void llenarBotellas();
    }

    class BotellasTe extends Embotelladora{
        int numeroBotellas;

        public BotellasTe(int numeroBotellas) {
            this.numeroBotellas = numeroBotellas;
        }

        @Override
        public Void llenarBotellas(){
            System.out.println("Se llenaron:" + this.numeroBotellas+ "té");
            return null;
        };
    }

    class BotellasAguar extends Embotelladora{
        int numeroBotellas;

        public BotellasAguar(int numeroBotellas) {
            this.numeroBotellas = numeroBotellas;
        }

        @Override
        public Void llenarBotellas() {
            System.out.println("Se llenaron:" + this.numeroBotellas+ "agua");
            return null;
        }
    }


    public void ejecutar (){

        /**
         * instancia de la clase calculadoraImpuesto.
         */
        Producto producto1 = new Producto(20000);
        Iva iva = new Iva();
        ImpuestoImportacion impuestoImportacion = new ImpuestoImportacion();
        CalculadoraImpuestos calculadoraImpuestos = new CalculadoraImpuestos();
        calculadoraImpuestos.agregarReglaImpuesto(impuestoImportacion);
        List<Producto> productos = new ArrayList<Producto>();
        Producto producto2 = new Producto(24000);
        productos.add(producto1);
        calculadoraImpuestos.calcularImpuestos(productos);

        /**
         * instancia de la clase CalculaoraImpuestoAntiPatron
         */
        CalculadoraImpuestosAntiPatron calculadoraImpuestosAntiPatron = new CalculadoraImpuestosAntiPatron();

        productos.add(producto2);
        producto2.setTipo("Nacional");
        producto2.getTipo();
        calculadoraImpuestosAntiPatron.calcularImpuestosAtiPatron(productos);

        /*
        instancia clase BotellasAgua y Té
         */

        BotellasAguar botellasAguar = new BotellasAguar(11000);
        botellasAguar.llenarBotellas();

        BotellasTe botellasTe = new BotellasTe(2000000);
        botellasTe.llenarBotellas();


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
 * Se añadio
 */
class Iva extends Impuesto {
    @Override
    double calcular(Producto producto) {
        return producto.getPrecio() * 0.19;
    }
}

class CalculadoraImpuestos {
    private List<Impuesto> reglasImpuestos;

    public CalculadoraImpuestos() {
        this.reglasImpuestos = new ArrayList<>();
        reglasImpuestos.add(new ImpuestoNacional());
        reglasImpuestos.add(new ImpuestoImportacion());
        reglasImpuestos.add(new Iva());
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
        System.out.println("\nEl impueto total de los productos es: " + totalImpuestos);
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
            } else if (producto.getTipo() == "Iva"){
                totalImpuestos += producto.getPrecio() * 0.19;
            }
        }
        System.out.println("\nEl impueto total de los productos es: " + totalImpuestos);
        return totalImpuestos;
    }

    public static void main(String[] args) {

    }
};



