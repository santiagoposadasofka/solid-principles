package org.example.liskovSubstitution;

import java.util.ArrayList;
import java.util.List;

public class EjemploAntipatron {

    abstract class Animal {
        public abstract void hablar();
    }

    class Perro extends Animal {
        @Override
        public void hablar() {
            ladrar();
        }

        public void ladrar() {
            System.out.println("Guau guau");
        }
    }

    class Gato extends Animal {
        @Override
        public void hablar() {
            maullar();
        }

        public void maullar() {
            System.out.println("Miau miau");
        }
    }

    class Pajaro extends Animal {
        @Override
        public void hablar() {
            cantar();
        }

        public void cantar() {
            System.out.println("Pio pio");
        }
    }

    class Loro extends Animal {
        @Override
        public void hablar() {
            repetir();
        }

        public void repetir() {
            System.out.println("Hola, ¿cómo estás?");
        }
    }


    public void ejecutar() {
        List<Animal> animales = new ArrayList<>();
        animales.add(new Gato());
        animales.add(new Loro());
        animales.add(new Pajaro());

        for (Animal animal : animales) {
            if (animal instanceof Loro) {
                ((Loro) animal).repetir();
            } else {
                animal.hablar();
            }
        }
    }

}