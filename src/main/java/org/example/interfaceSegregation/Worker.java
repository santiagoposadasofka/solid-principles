package org.example.interfaceSegregation;

interface Worker {
    void work();
}

interface Feeder {
    void feed();
}

interface Cleaner {
    void clean();
}

class Janitor implements Worker, Cleaner {
    public void work() {
        System.out.println("Janitor is working");
    }
    public void clean() {
        System.out.println("Janitor is cleaning");
    }
}

class Chef implements Worker, Feeder {
    public void work() {
        System.out.println("Chef is working");
    }
    public void feed() {
        System.out.println("Chef is feeding");
    }
}