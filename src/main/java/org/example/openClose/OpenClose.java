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

    public void ejecutarCalculadoraImpuestos(){
        System.out.println("\nComportamientos calculadora de impuestos siguiendo el patron");

        Producto producto1=new Producto(2000);
        //producto1.setTipo("Nacional");
        Producto producto2=new Producto(3000);
        //producto1.setTipo("Importado");
        Producto producto3=new Producto(4000);
        //producto1.setTipo("Azucar");

        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);

        ImpuestoAlAzucar impuestoAlAzucar =new ImpuestoAlAzucar();


        CalculadoraImpuestos calculadoraImpuestos=new CalculadoraImpuestos();
        calculadoraImpuestos.agregarReglaImpuesto(impuestoAlAzucar);

        System.out.println(calculadoraImpuestos.calcularImpuestos(productos));
    }

    public void ejecutarAntipatronCalculadora(){
        System.out.println("\nComportamientos calculadora de impuestos antipatron");

        Producto producto1=new Producto(2000);
        producto1.setTipo("Nacional");
        Producto producto2=new Producto(3000);
        producto2.setTipo("Importado");
        Producto producto3=new Producto(4000);
        producto3.setTipo("Azucar");
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        CalculadoraImpuestosAntiPatron calculadoraImpuestos=new CalculadoraImpuestosAntiPatron();
        System.out.println(calculadoraImpuestos.calcularImpuestosAtiPatron(productos));
    }

    public void ejecutarAntipatronAnimal(){
        System.out.println("\nComportamientos ejemplo animal antipatron");

        Animal animal1=new Animal("Gato","Carnivoro");
        Animal animal2=new Animal("Tortuga","Herbivoro");
        ArrayList<Animal> animales = new ArrayList<>();
        animales.add(animal1);
        animales.add(animal2);
        DecirTipoAntipatron decirTipoAntipatron=new DecirTipoAntipatron();
        decirTipoAntipatron.DecirComida(animales);
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
    /*private String tipo="Nacional";
    private double porcentaje=0.15;

    public String getTipo() {
        return tipo;
    }

    public double getPorcentaje() {
        return porcentaje;
    }*/

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

class ImpuestoAlAzucar extends Impuesto {

    @Override
    double calcular(Producto producto) {
        return producto.getPrecio() * 0.20;
    }
}

class CalculadoraImpuestos {
    private List<Impuesto> reglasImpuestos;
    //private List<String> impuestosTipos;
    //private List<Double> impuestosPorcentaje;

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
            }else if (producto.getTipo()== "Azucar"){
                totalImpuestos += producto.getPrecio() * 0.20;
            }
        }
        return totalImpuestos;
    }
}

class Animal{

    private String nombre;
    private String tipo;

    public Animal(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }
}

abstract class TipoAnimal{
    abstract String decirTipo(Animal animal);
}
class Carnivoro extends TipoAnimal{

    @Override
    String decirTipo(Animal animal) {
        return animal.getTipo();
    }
}

class Herbivoro extends TipoAnimal{

    @Override
    String decirTipo(Animal animal) {
        return animal.getTipo();
    }
}

class DecirTipoAntipatron{

    public void DecirComida(List<Animal> animales) {
        for (Animal animal : animales) {
            if (animal.getTipo() == "Carnivoro") {
                System.out.println("El animal come carne");
            } else if (animal.getTipo() == "Herbivoro") {
                System.out.println("El animal come hirbas");
            }
        }
        /* return ""; */
    }




}


