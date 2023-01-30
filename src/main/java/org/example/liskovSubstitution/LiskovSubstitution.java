package org.example.liskovSubstitution;

import java.util.ArrayList;
import java.util.List;

public class LiskovSubstitution {

    public void ejecutar(){
        /**List<FiguraGeometrica> figuras = new ArrayList<>();
        figuras.add(new Cuadrado(10));
        figuras.add(new Triangulo(5, 10));
        figuras.add(new Circulo(2));

        for(FiguraGeometrica figura: figuras) {
            System.out.println("Area: " + figura.area());
        }**/

        Cuadrado cuadrado = new Cuadrado(5);
        double areaCuadrado = cuadrado.area();

        Triangulo triangulo = new Triangulo(4, 6);
        double areaTriangulo = triangulo.area();

        Circulo circulo = new Circulo(3);
        double areaCirculo = circulo.area();
        System.out.println("Area cuadrado: " + cuadrado.area());
        System.out.println("Area triangulo: " + triangulo.area());
        System.out.println("Area circulo: " + circulo.area());

        //instancio mi ejemplo
        Perro miPerro = new Perro("El perro Felipe ");
        Serpiente miSerpiente = new Serpiente("La serpiente Cobra bonita");

        Cuidador miCuidador = new Cuidador();
        miCuidador.alimentarAnimal(miPerro);
        miCuidador.alimentarAnimal(miSerpiente);

    }
}


/*
* Un ejemplo de sustitución de Liskov en Java podría ser una jerarquía de clases "FiguraGeometrica"
* que tiene una clase base "FiguraGeometrica" y varias subclases que representan diferentes tipos
* de figuras geométricas, como "Cuadrado", "Triangulo" y "Circulo". Todas las subclases tienen un método
* "area()" que devuelve el área de la figura geométrica. La clase "FiguraGeometrica" es una superclase abstracta
* y no se puede instanciar.
* En este ejemplo, se puede ver como todas las subclases de FiguraGeometrica tienen un método area, el cual tiene
* un comportamiento diferente pero con el mismo objetivo, calcular el area, esto cumple con el principio de sustitución
* de Liskov, ya que se puede utilizar cualquier objeto de una de las subclases en lugar de un objeto de la superclase
* sin causar problemas en el funcionamiento del sistema.
* En este ejemplo se puede ver como se utiliza una lista de objetos de la superclase FiguraGeometrica pero se pueden
* utilizar objetos de las subclases Cuadrado, Triangulo y Circulo sin causar problemas, esto cumple con el principio de sustitución de Liskov
* */

abstract class FiguraGeometrica {
    public abstract double area();
}

class Cuadrado extends FiguraGeometrica {
    private double lado;
    public Cuadrado(double lado) {
        this.lado = lado;
    }
    @Override
    public double area() {
        return lado * lado;
    }
}

class Triangulo extends FiguraGeometrica {
    private double base;
    private double altura;
    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }
    @Override
    public double area() {
        return base * altura / 2;
    }
}

class Circulo extends FiguraGeometrica {
    private double radio;
    public Circulo(double radio) {
        this.radio = radio;
    }
    @Override
    public double area() {
        return Math.PI * radio * radio;
    }
}

/*
* Un anti-patrón de sustitución de Liskov en Java podría ser una jerarquía de clases "Empleado"
* que tiene una clase base "Empleado" y varias subclases que representan diferentes tipos de
* empleados, como "EmpleadoEjecutivo", "EmpleadoOperativo" y "EmpleadoTemporal". La clase base
* "Empleado" tiene un método "realizarTarea()" que se espera que sea implementado por todas las subclases.
* Sin embargo, la subclase "EmpleadoEjecutivo" no tiene un comportamiento coherente con el método "realizarTarea()"
* de la superclase "Empleado" ya que en vez de realizar tareas, los ejecutivos toman decisiones, lo que hace
* que no se pueda usar un objeto de la clase "EmpleadoEjecutivo" en cualquier lugar donde se espera un objeto
* de la clase "Empleado" sin causar problemas en el funcionamiento del sistema.
 *En este ejemplo se puede ver como la clase EmpleadoEjecutivo no tiene un comportamiento coherente con el
 * método realizarTarea de la superclase Empleado, ya que los ejecutivos no realizan tareas sino toman
 * decisiones, esto hace que no se pueda usar un objeto de la clase "EmpleadoEjecutivo" en cualquier lugar
 * donde se espera un objeto de la clase "Empleado" sin causar problemas en el funcionamiento del sistema,
 * violando el principio de sustitución de Liskov.
* */

abstract class Empleado {
    public abstract void realizarTarea();
}

class EmpleadoEjecutivo extends Empleado {
    @Override
    public void realizarTarea() {
        tomarDecision();
    }
    public void tomarDecision() {
        //...
    }
}

class EmpleadoOperativo extends Empleado {
    @Override
    public void realizarTarea() {
        realizarOperacion();
    }
    public void realizarOperacion() {
        //...
    }
}

class EmpleadoTemporal extends Empleado {
    @Override
    public void realizarTarea() {
        realizarTareaTemporal();
    }
    public void realizarTareaTemporal() {
        //...
    }
}

//creacion del ejemplo correcto

abstract class Animales{
    //creo mis atributos
    protected String nombre;
    protected int patas;
//creo el constructor
    public Animales(String nombre, int patas) {
        this.nombre = nombre;
        this.patas = patas;
    }
    //creo mi metodo de hacer sonido
    public abstract void makeSound();
}
//creo una clase perro que hereda de Animales
class Perro extends Animales {
    public Perro(String nombre) {
        super(nombre, 4);
    }

    @Override
    public void makeSound() {
        System.out.println("Woof woof");
    }
}
//creo una clase serpiente que hereda de Animales
class Serpiente extends Animales {
    public Serpiente(String nombre) {
        super(nombre, 0);
    }

    @Override
    public void makeSound() {
        System.out.println("Sissssssssss");
    }
}
//creo una clase cuidador
class Cuidador {
    public void alimentarAnimal(Animales animal) {
        System.out.println(animal.nombre + " esta comiendo muy rico");

}}

