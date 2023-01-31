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

    public  static void ejecutar(){

        CalculadoraImpuestosAntiPatron antiPatron=new CalculadoraImpuestosAntiPatron();
        CalculadoraImpuestos calculadoraImpuestos=new CalculadoraImpuestos();
        calculadoraImpuestos.agregarReglaImpuesto(new ImpuestoGuerra());

        List<Producto> productos=new ArrayList<>();
       // Continuará



    }
}

/*En este ejemplo, la clase "Rectangle" está "cerrada" para modificaciones, pero "abierta"
para extensiones mediante la creación de la clase "Square", que hereda de "Rectangle" y
sobrescribe el método de cálculo del área para adaptarse a su forma específica. De esta manera,
se pueden añadir nuevas funcionalidades (como cálculo de área para un cuadrado) sin tener que modificar
 el código existente de la clase "Rectangle"*/
class Rectangle {
    private int width;
    private int height;
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public int getArea() {
        return width * height;
    }
    public int getPerimeter() {
        return 2 * (width + height);
    }

    protected int getWidth() {
        return 0;
    }

    protected int getHeight() {
        return 0;
    }
}

class Square extends Rectangle {
    public Square(int side) {
        super(side, side);
    }
    @Override
    public int getArea() {
        return super.getWidth() * super.getHeight();
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

class ImpuestoGuerra extends Impuesto {
    @Override
    double calcular(Producto producto) {
        return producto.getPrecio() * 0.30;
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
            }
        }
        return totalImpuestos;
    }
}


