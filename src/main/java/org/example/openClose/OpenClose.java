package org.example.openClose;

import java.util.ArrayList;
import java.util.List;

public class OpenClose {
    public void ejecutar() {
        System.out.println("Ejecutando ejemplos del patrón Open Close.");
        /*
         * Modificación de reglas anteriores para concordar con la clase "Producto".
         * Creación de nueva clase "ImpuestoMunicipal".
         * Instancia de una calculadora de impuestos.
         * Se añade la nueva regla de impuestos a la calculadora.
         * Se crea una lista de productos.
         * Se calcula el impuesto total para la lista de productos.
         */
        CalculadoraImpuestos calc = new CalculadoraImpuestos();
        calc.agregarReglaImpuesto(new ImpuestoMunicipal());
        Producto gorra = new Producto(5000);
        gorra.setTipo("Nacional");
        Producto zapato = new Producto(150000);
        zapato.setTipo("Importado");
        Producto flor = new Producto(6000);
        flor.setTipo("Municipal");
        List<Producto> productos;
        productos = new ArrayList<>();
        productos.add(gorra);
        productos.add(zapato);
        productos.add(flor);
        System.out.println("El impuesto total es: " + calc.calcularImpuestos(productos));

        System.out.println("\nEjecutando anti-patrón de Open Close.");
        /*
         * Se añade una nueva regla dentro de la calculadora predefinida.
         * Instancia de la calculadora anti-patrón.
         * Uso de la misma lista de productos para el cálculo del patrón Open Close.
         * Se calcula el impuesto total con la función modificada de la calculadora.
         */
        CalculadoraImpuestosAntiPatron antiCalc = new CalculadoraImpuestosAntiPatron();
        System.out.println("El impuesto total es: " + antiCalc.calcularImpuestosAtiPatron(productos));

        System.out.println("\nEjecutando nuevo ejemplo patrón de Open Close.");
        /*
         * Instancia de dos tipos diferentes de datos.
         * Instancia de un controlador de tipos.
         * Ejecución del controlador sobre los dos tipos de datos creados previamente.
         */
        Tipo t1 = new Tipo1();
        Tipo t2 = new Tipo2();
        Driver controlador = new Driver();
        controlador.controlar(t1);
        controlador.controlar(t2);
    }
}

/*
 * Un ejemplo de patrón de abierto-cerrado en Java podría ser una clase "CalculadoraImpuestos" que se
 *  encarga de calcular los impuestos de una lista de objetos "Producto". La clase tiene un método
 * "calcularImpuestos" que toma una lista de productos y devuelve el total de impuestos calculados.
 * La clase es "abierta" para la extensión, ya que se pueden agregar nuevas reglas de impuestos sin
 * necesidad de modificar el código existente.
 * En este ejemplo se ve como la clase CalculadoraImpuestos se encarga de calcular los impuestos de una
 * lista de productos, pero esta clase no tiene conocimiento de cuáles son las reglas de impuestos, estas
 * reglas se encuentran en las clases ImpuestoNacional e ImpuestoImportacion, de esta forma se pueden agregar
 *  nuevas reglas de impuestos sin tener que modificar la clase CalculadoraImpuestos, cumpliendo con el principio
 * del patrón open close.
 */

abstract class Impuesto {
    abstract double calcular(Producto producto);
}

class ImpuestoNacional extends Impuesto {
    @Override
    double calcular(Producto producto) {
        if (producto.getTipo().equals("Nacional")) {
            return producto.getPrecio() * 0.15;
        } else {
            return 0;
        }
    }
}

class ImpuestoImportacion extends Impuesto {
    @Override
    double calcular(Producto producto) {
        if (producto.getTipo().equals("Importado")) {
            return producto.getPrecio() * 0.25;
        } else {
            return 0;
        }
    }
}

class ImpuestoMunicipal extends Impuesto {
    @Override
    double calcular(Producto producto) {
        if (producto.getTipo().equals("Municipal")) {
            return producto.getPrecio() * 0.1;
        } else {
            return 0;
        }
    }
}

class CalculadoraImpuestos {
    private final List<Impuesto> reglasImpuestos;

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
 * Un anti-patrón del principio de abierto-cerrado en Java podría ser una clase "CalculadoraImpuestos" que tiene un
 * método "calcularImpuestos" que toma una lista de objetos "Producto" y devuelve el total de impuestos calculados.
 * Sin embargo, este método contiene una serie de "if-else" o "switch-case" que determinan qué reglas de impuestos se
 * deben aplicar a cada producto. Cada vez que se agrega una nueva regla de impuestos, se debe modificar el código
 * existente en el método "calcularImpuestos" lo que viola el principio de abierto-cerrado. En este ejemplo se ve como
 * la clase CalculadoraImpuestos tiene conocimiento de las reglas de impuestos, esto hace que cada vez que se quiera
 * agregar una nueva regla de impuestos, se tenga que modificar el código de la clase, violando el principio de
 * abierto-cerrado. Es mejor separar las reglas de impuestos en clases diferentes y utilizar una estrategia de
 * delegación para aplicar las reglas de impuestos, de esta forma se pueden agregar nuevas reglas de impuestos sin
 * modificar el código existente.
 */

class CalculadoraImpuestosAntiPatron {
    public double calcularImpuestosAtiPatron(List<Producto> productos) {
        double totalImpuestos = 0;
        for (Producto producto : productos) {
            switch (producto.getTipo()) {
                case "Nacional":
                    totalImpuestos += producto.getPrecio() * 0.15;
                    break;
                case "Importado":
                    totalImpuestos += producto.getPrecio() * 0.25;
                    break;
                case "Municipal":
                    totalImpuestos += producto.getPrecio() * 0.1;
                    break;
            }
        }
        return totalImpuestos;
    }
}

/*
 * Un ejemplo de patrón del principio de Open Close en Java podría ser una clase "Driver" que es responsable de
 * controlar los tipos de datos que se le ingresan, siendo estos tipos clases externas que puedo añadir posteriormente.
 * Por el contrario, si fuese anti-patrón, la misma clase Driver tendría incorporados los tipos que puede controlar y
 * cada vez que necesite un nuevo tipo debo modificarla, violando el estado cerrado a cambios a pesar de estar abierto a
 * una extensión en funcionalidad.
 */

class Driver {
    public void controlar(Tipo tipo) {
        tipo.control();
    }
}

interface Tipo {
    void control();
}

class Tipo1 implements Tipo {
    @Override
    public void control() {
        System.out.println("Ejecutando acción para tipo 1.");
    }
}

class Tipo2 implements Tipo {
    @Override
    public void control() {
        System.out.println("Ejecutando acción para tipo 2.");
    }
}
