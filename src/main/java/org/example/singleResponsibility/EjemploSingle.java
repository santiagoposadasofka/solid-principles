package org.example.singleResponsibility;

public class EjemploSingle {

    public void ejecutar() {
        Rectangulo rectangulo = new Rectangulo(10, 20);
        RectanguloAreaCalculator areaCalculator = new RectanguloAreaCalculator();
        RectanguloPerimetroCalculator perimetroCalculator = new RectanguloPerimetroCalculator();

        double area = areaCalculator.calcularArea(rectangulo);
        double perimetro = perimetroCalculator.calcularPerimetro(rectangulo);

        System.out.println("Area del rectangulo: " + area);
        System.out.println("Perimetro del rectangulo: " + perimetro);
    }

    class Rectangulo {
        private double ancho;
        private double alto;

        public Rectangulo(double ancho, double alto) {
            this.ancho = ancho;
            this.alto = alto;
        }

        public double getArea() {
            return ancho * alto;
        }

        public double getPerimetro() {
            return 2 * (ancho + alto);
        }
    }

    class RectanguloAreaCalculator {
        public double calcularArea(Rectangulo rectangulo) {
            return rectangulo.getArea();
        }
    }

    class RectanguloPerimetroCalculator {
        public double calcularPerimetro(Rectangulo rectangulo) {
            return rectangulo.getPerimetro();
        }
    }
}
