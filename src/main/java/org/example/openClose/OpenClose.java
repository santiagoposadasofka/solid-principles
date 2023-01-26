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
     */
    public void ejecutar() {

        List<Producto> productos = new ArrayList<>();

        productos.add(new Producto(10000));
        productos.add(new Producto(2000));
        productos.add(new Producto(4000));


        CalculadoraImpuestos calculadora = new CalculadoraImpuestos();
        /**
         * * le agregamos un impuesto a los productos
         */
        calculadora.calcularImpuestos(productos);
        calculadora.agregarReglaImpuesto(new ImpuestoDepartamental());
        double totalImpuesto = calculadora.calcularImpuestos(productos);
        System.out.println("total impuestos" + ":" + totalImpuesto);

        /****
         * creame objeto
         */


        List<Producto> productos1 = new ArrayList<>();
        productos1.add(new Producto(10000));
        productos1.add(new Producto(2000));
        productos1.add(new Producto(4000));

        CalculadoraImpuestosAntiPatron calculadoraAntiPatron = new CalculadoraImpuestosAntiPatron();
        double totalImpuestoAntipatron = calculadoraAntiPatron.calcularImpuestosAntiPatron(productos1);
        System.out.println("total impuestosAntipatron-->" + ":" + totalImpuestoAntipatron);


        List<Empleado> empleados = new ArrayList<>();
        empleados.add(new Empleado("yeison", 1000000, "Gerente"));
        empleados.add(new Empleado("pedro", 2000000, "Gerente"));
        empleados.add(new Empleado("yuli", 5000000, "Jefe de Departamento"));
        empleados.add(new Empleado("emerson", 800000, "Empleado"));


        for (Empleado empleado : empleados) {
            System.out.println("los empleados son: " + empleado.getNombre() + " " +
                    empleado.getSueldoBase() + " " + empleado.getCargo());
        }

        CalculadoraSalarios calculadoraSalarios = new CalculadoraSalarios();
        double totalSalario = calculadoraSalarios.calcularSalarios(empleados);
        System.out.println("el total del selario de los empleado es " + ":" + totalSalario);


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


class ImpuestoDepartamental extends Impuesto {
    @Override
    double calcular(Producto producto) {
        return producto.getPrecio() * 0.35;
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
            } else if (producto.getTipo() == "Importado") {
                totalImpuestos += producto.getPrecio() * 0.25;
            } else if (producto.getTipo() == "impuestoDepartamental") {
                totalImpuestos += producto.getPrecio() * 0.35;
            }

        }
        return totalImpuestos;
    }
}


/**
 * Creo otro antipatron de ejemplo donde calculo los impuestos donde si agrego otra regla de impuesto tendria que m
 * modificar todo el metodo nuevamente
 */
class CalculadoraSalarios {
    public double calcularSalarios(List<Empleado> empleados) {
        double totalSalarios = 0;
        for (Empleado empleado : empleados) {
            if (empleado.getCargo() == "Gerente") {
                totalSalarios += empleado.getSueldoBase() + empleado.getSueldoBase() * 0.15;
            } else if (empleado.getCargo() == "Jefe de Departamento") {
                totalSalarios += empleado.getSueldoBase() + empleado.getSueldoBase() * 0.10;
            } else if (empleado.getCargo() == "Empleado") {
                totalSalarios += empleado.getSueldoBase();
            }
        }
        return totalSalarios;
    }

}

/**
 * ++
 * <p>
 * la clase empleado
 */
class Empleado {
    private String nombre;
    private double sueldoBase;
    private String cargo;

    public Empleado(String nombre, double sueldoBase, String cargo) {
        this.nombre = nombre;
        this.sueldoBase = sueldoBase;
        this.cargo = cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}

