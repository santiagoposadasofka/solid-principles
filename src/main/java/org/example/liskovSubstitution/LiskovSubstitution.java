package org.example.liskovSubstitution;

import java.util.ArrayList;
import java.util.List;

public class LiskovSubstitution {

    public void ejecutar(){
        System.out.println("\nComportamientos figuras siguiendo el patron");
        List<FiguraGeometrica> figuras = new ArrayList<>();
        figuras.add(new Cuadrado(10));
        figuras.add(new Triangulo(5, 10));
        figuras.add(new Circulo(2));
        figuras.add(new Cubo(3));

        for(FiguraGeometrica figura: figuras) {
            System.out.println("Area: " + figura.area());
        }
    }

    public void antipatronEmpleado(){
        System.out.println("\nComportamientos antipatron empleado");
        EmpleadoEjecutivo empleadoEjecutivo=new EmpleadoEjecutivo();
        EmpleadoOperativo empleadoOperativo=new EmpleadoOperativo();
        EmpleadoTemporal empleadoTemporal=new EmpleadoTemporal();
        empleadoEjecutivo.realizarTarea();
        empleadoOperativo.realizarTarea();
        empleadoTemporal.realizarTarea();
    }

    public void patronServivo(){
        System.out.println("\nComportamientos de ejemplo siguiendo el patron (Servivo)");

        Planta planta=new Planta();
        Humano humano=new Humano();
        Animales animales=new Animales();

        planta.alimentarse();
        humano.alimentarse();
        animales.alimentarse();
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

class Cubo extends FiguraGeometrica{
    private double lado;

    public Cubo(double lado) {
        this.lado = lado;
    }

    @Override
    public double area() {
        return lado*lado*6;
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
        System.out.println("Este empleado no esta realizando tareas, esta tomando una decision");
    }
}

class EmpleadoOperativo extends Empleado {
    @Override
    public void realizarTarea() {
        realizarOperacion();
    }
    public void realizarOperacion() {
        System.out.println("Este empleado realiza una operacion");
        //...
    }
}

class EmpleadoTemporal extends Empleado {
    @Override
    public void realizarTarea() {
        realizarTareaTemporal();
    }
    public void realizarTareaTemporal() {
        System.out.println("Este empleado esta realizando una tarea");
        //...
    }
}

abstract class SerVivo{
    public abstract void alimentarse();
}

class Planta extends SerVivo{
    @Override
    public void alimentarse() {
        System.out.println("La planta se alimenta por la fotosintesis");
    }
}

class Humano extends SerVivo{
    @Override
    public void alimentarse() {
        System.out.println("Los seres vivos se alimentan de plantas y animales");
    }
}

class Animales extends SerVivo{
    @Override
    public void alimentarse() {
        System.out.println("los animales se alimentan de animales y plantas");
    }
}
