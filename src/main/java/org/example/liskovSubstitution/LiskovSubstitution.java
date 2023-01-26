package org.example.liskovSubstitution;

import java.util.ArrayList;
import java.util.List;

public class LiskovSubstitution {
    public void ejecutar() {
        System.out.println("Ejecutando ejemplos del patrón Liskov Substitution.");
        /*
         * Se añade una nueva figura "Rectangulo" que extiende de "FiguraGeometrica".
         * Se agrega un nuevo rectángulo a la lista existente de figuras.
         * Se utiliza el método sobreescrito para calcular el área de cada figura.
         */
        List<FiguraGeometrica> figuras = new ArrayList<>();
        figuras.add(new Cuadrado(10));
        figuras.add(new Triangulo(5, 10));
        figuras.add(new Circulo(2));
        figuras.add(new Rectangulo(12, 2));
        for (FiguraGeometrica figura : figuras) {
            System.out.println("Area: " + figura.area());
        }

        System.out.println("\nEjecutando anti-patrón de Liskov Substitution.");
        /*
         * Se añade un nuevo tipo de empleado "EmpleadoAseo" que puede barrer.
         * Se crea una lista de empleados.
         * Se agregan los diferentes tipos de empleados.
         * Se utiliza el método sobreescrito para realizar la tarea (en el caso del empleado ejecutivo, no se puede
         * hacer porque solo puede tomar decisiones, y no tomar acción).
         */
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(new EmpleadoEjecutivo());
        empleados.add(new EmpleadoOperativo());
        empleados.add(new EmpleadoTemporal());
        empleados.add(new EmpleadoAseo());
        for (Empleado empleado : empleados) {
            empleado.realizarTarea();
        }

        System.out.println("\n\nEjecutando nuevo ejemplo anti-patrón de Liskov Substitution.");
        /*
         * Instancia de una canasta y un balde.
         * Se trata de almacenar un líquido en ambos contenedores.
         * Se muestra el resultado de está acción.
         */
        Contenedor canasta = new Canasta();
        Contenedor balde = new Balde();
        canasta.almacenar("Liquido");
        balde.almacenar("Liquido");
    }
}

/*
 * Un ejemplo de sustitución de Liskov en Java podría ser una jerarquía de clases "FiguraGeometrica" que tiene una clase
 * base "FiguraGeometrica" y varias subclases que representan diferentes tipos de figuras geométricas, como "Cuadrado",
 * "Triangulo" y "Circulo". Todas las subclases tienen un método "area()" que devuelve el área de la figura geométrica.
 * La clase "FiguraGeometrica" es una superclase abstracta y no se puede instanciar.
 * En este ejemplo, se puede ver como todas las subclases de FiguraGeometrica tienen un método área, el cual tiene
 * un comportamiento diferente, pero con el mismo objetivo, calcular el área. Esto cumple con el principio de
 * sustitución de Liskov, ya que se puede utilizar cualquier objeto de una de las subclases en lugar de un objeto de la
 * superclase sin causar problemas en el funcionamiento del sistema.
 * En este ejemplo se puede ver como se utiliza una lista de objetos de la superclase FiguraGeometrica, pero se pueden
 * utilizar objetos de las subclases Cuadrado, Triangulo y Circulo sin causar problemas, esto cumple con el principio de
 * sustitución de Liskov.
 */

abstract class FiguraGeometrica {
    public abstract double area();
}

class Cuadrado extends FiguraGeometrica {
    private final double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double area() {
        return lado * lado;
    }
}

class Triangulo extends FiguraGeometrica {
    private final double base;
    private final double altura;

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
    private final double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double area() {
        return Math.PI * radio * radio;
    }
}

class Rectangulo extends FiguraGeometrica {
    private final double base;
    private final double altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double area() {
        return base * altura;
    }
}

/*
 * Un anti-patrón de sustitución de Liskov en Java podría ser una jerarquía de clases "Empleado" que tiene una clase
 * base "Empleado" y varias subclases que representan diferentes tipos de empleados, como "EmpleadoEjecutivo",
 * "EmpleadoOperativo" y "EmpleadoTemporal". La clase base "Empleado" tiene un método "realizarTarea()" que se espera
 * que sea implementado por todas las subclases. Sin embargo, la subclase "EmpleadoEjecutivo" no tiene un comportamiento
 * coherente con el método "realizarTarea()" de la superclase "Empleado", ya que en vez de realizar tareas, los
 * ejecutivos toman decisiones, lo que hace que no se pueda usar un objeto de la clase "EmpleadoEjecutivo" en cualquier
 * lugar donde se espera un objeto de la clase "Empleado" sin causar problemas en el funcionamiento del sistema.
 * En este ejemplo se puede ver como la clase EmpleadoEjecutivo no tiene un comportamiento coherente con el
 * método realizarTarea de la superclase Empleado, ya que los ejecutivos no realizan tareas, sino que toman
 * decisiones, esto hace que no se pueda usar un objeto de la clase "EmpleadoEjecutivo" en cualquier lugar donde se
 * espera un objeto de la clase "Empleado" sin causar problemas en el funcionamiento del sistema, violando el principio
 * de sustitución de Liskov.
 */

abstract class Empleado {
    public abstract void realizarTarea();
}

class EmpleadoEjecutivo extends Empleado {
    @Override
    public void realizarTarea() {
        tomarDecision();
    }

    public void tomarDecision() {
        System.out.println("Tomando una decisión, sin realizar tarea...");
    }
}

class EmpleadoOperativo extends Empleado {
    @Override
    public void realizarTarea() {
        realizarOperacion();
    }

    public void realizarOperacion() {
        System.out.println("Operando maquinaria pesada.");
    }
}

class EmpleadoTemporal extends Empleado {
    @Override
    public void realizarTarea() {
        realizarTareaTemporal();
    }

    public void realizarTareaTemporal() {
        System.out.println("Reparando agujero en la pared.");
    }
}

class EmpleadoAseo extends Empleado {
    @Override
    public void realizarTarea() {
        realizarTareaAseo();
    }
    public void realizarTareaAseo() {
        System.out.println("Barriendo.");
    }
}

/*
 * Un ejemplo de anti-patrón del principio de Liskov Substitution en Java podría ser una superclase "Contenedor" que es
 * responsable de almacenar cosas dentro, pero cuando creo una subclase "Canasta" que extiende de Contenedor y trato de
 * almacenar un líquido en esta, habrá un error, ya que este comportamiento no es posible para la subclase (el líquido
 * se escapa) por lo que se incumple el principio, debido a que la subclase no es capaz de implementar completamente el
 * comportamiento de la superclase. Mientras otra subclase "Balde" puede heredar completamente el comportamiento de su
 * superclase.
 */

abstract class Contenedor {
    public abstract void almacenar(String cosa);
}

class Canasta extends Contenedor {
    @Override
    public void almacenar(String cosa) {
        if (cosa.equals("Liquido")) {
            // throw new IllegalArgumentException("No es posible almacenar un líquido.");
            System.out.println("No es posible almacenar un líquido en una canasta.");
        } else {
            System.out.println("El objeto " + cosa + " se almacenó dentro de la canasta.");
        }
    }
}

class Balde extends Contenedor {
    @Override
    public void almacenar(String cosa) {
        System.out.println("El objeto " + cosa + " se almacenó dentro del balde.");
    }
}
